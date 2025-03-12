# Search Functionality Design - Addressing OCP Violations

## Introduction
This document outlines the thought process, design evolution, and final implementation of a **search functionality** that adheres to the **Open-Closed Principle (OCP)**. It covers the challenges faced, different approaches attempted, and the solutions implemented.

## Initial Problem Statement
The requirement was to implement a flexible search functionality that allows filtering tasks based on multiple parameters. The function needed to support different combinations of parameters like:

```java
search(user);
search(user, priority);
search(user, priority, status);
search(user, priority, status, title);
search(user, priority, status, title, description);
search(user, priority, status, title, description, createdUser);
```

The naive approach of creating multiple overloaded methods was not scalable. Hence, a more flexible **SearchCriteria** class was introduced.

---

## Initial Implementation of SearchCriteria
```java
class SearchCriteria {
    private Map<String, Object> filters = new HashMap<>();

    public void addFilter(String key, Object value) {
        filters.put(key, value);
    }

    public Object getFilter(String key) {
        return filters.get(key);
    }

    public Map<String, Object> getAllFilters() {
        return filters;
    }
}
```
### Issues:
1. **No Type Safety**: Any arbitrary key-value pair could be added, leading to potential runtime errors.
2. **OCP Violation**: Filtering logic was not extensible without modifying core code.

---

## Introducing FilterKey Enum for Type Safety
To ensure **type safety**, we introduced an **enum** for predefined filter keys:
```java
enum FilterKey {
    USER, CREATED_USER, PRIORITY, STATUS, TITLE, DESCRIPTION;
}
```

Updated **SearchCriteria**:
```java
class SearchCriteria {
    private Map<FilterKey, Object> filters = new HashMap<>();

    public void addFilter(FilterKey key, Object value) {
        filters.put(key, value);
    }

    public Object getFilter(FilterKey key) {
        return filters.get(key);
    }

    public Map<FilterKey, Object> getAllFilters() {
        return filters;
    }
}
```
### Issues:
1. **Still No Type Validation**: Users could add incorrect data types (e.g., `FilterKey.PRIORITY, "High"` instead of `Priority.HIGH`).

---

## Adding Type Validation (First Attempt - Switch Case)
To enforce type checking, we introduced an **isValidType** method using a switch case:

```java
private boolean isValidType(FilterKey key, Object value) {
    switch (key) {
        case USER:
        case CREATED_USER: return value instanceof User;
        case PRIORITY: return value instanceof Priority;
        case STATUS: return value instanceof Status;
        case TITLE:
        case DESCRIPTION: return value instanceof String;
        default: return false;
    }
}
```

### Issues:
1. **OCP Violation**: Adding a new filter key required modifying this method, violating OCP.

---

## Solution 1 - Using a Static Type Map
To make the design **open for extension but closed for modification**, we replaced the **switch case** with a **static type map**:

```java
class SearchCriteria {
    private static final Map<FilterKey, Class<?>> expectedTypes = new HashMap<>();

    static {
        expectedTypes.put(FilterKey.USER, User.class);
        expectedTypes.put(FilterKey.CREATED_USER, User.class);
        expectedTypes.put(FilterKey.PRIORITY, Priority.class);
        expectedTypes.put(FilterKey.STATUS, Status.class);
        expectedTypes.put(FilterKey.TITLE, String.class);
        expectedTypes.put(FilterKey.DESCRIPTION, String.class);
    }

    private Map<FilterKey, Object> filters = new HashMap<>();

    public void addFilter(FilterKey key, Object value) {
        if (!isValidType(key, value)) {
            throw new IllegalArgumentException("Invalid value type for " + key + ". Expected " + expectedTypes.get(key));
        }
        filters.put(key, value);
    }

    private boolean isValidType(FilterKey key, Object value) {
        return expectedTypes.getOrDefault(key, Object.class).isInstance(value);
    }
}
```

### Advantages:
- **OCP Compliant**: New filters can be added by modifying the `expectedTypes` map instead of changing core logic.
- **Type-Safe**: Prevents incorrect value types at runtime.
- **Extensible**: Supports dynamic addition of new filters.

---

## Solution 2 - Enum Itself Handles Validation (Most Compliant to OCP)
To fully comply with OCP, we made the **enum itself responsible for validation**:

```java
enum FilterKey {
    USER(User.class),
    CREATED_USER(User.class),
    PRIORITY(Priority.class),
    STATUS(Status.class),
    TITLE(String.class),
    DESCRIPTION(String.class);

    private final Class<?> expectedType;

    FilterKey(Class<?> expectedType) {
        this.expectedType = expectedType;
    }

    public boolean isValid(Object value) {
        return expectedType.isInstance(value);
    }
}
```

Updated **SearchCriteria**:

```java
class SearchCriteria {
    private Map<FilterKey, Object> filters = new HashMap<>();

    public void addFilter(FilterKey key, Object value) {
        if (!key.isValid(value)) {
            throw new IllegalArgumentException("Invalid value type for " + key + ". Expected " + key.getExpectedType());
        }
        filters.put(key, value);
    }
}
```

### Advantages:
- **Fully OCP-Compliant**: No modification is required in SearchCriteria when adding new filters.
- **Encapsulated Validation**: Each filter key knows its own validation rules.
- **Improved Readability & Maintainability**: The logic is now self-contained within the enum.

---

## Conclusion
The final design adheres to the Open-Closed Principle by ensuring:
1. **Encapsulation of filter logic** within a flexible, reusable `SearchCriteria` class.
2. **Type Safety** using a predefined mapping of expected data types.
3. **Extensibility** without modifying core search logic.
4. **Enum-Driven Validation** to ensure each filter key enforces its own constraints.

This approach ensures a **scalable, maintainable, and robust** search functionality for task management systems.

