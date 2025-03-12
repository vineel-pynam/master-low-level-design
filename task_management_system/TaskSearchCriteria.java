package task_management_system;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;

class TaskSearchCriteria {
    private Map<FilterType, Object> filters;

    TaskSearchCriteria(){
        this.filters = new ConcurrentHashMap<>();
    }

    public void addFilter(FilterType filterType, Object filter){
        if( filterType.isValid(filter) ){
            this.filters.put(filterType, filter);
        } else {
            throw new RuntimeException("INVALID FILTER");
        }
    }

    public boolean matches(Task task){
        return this.filters.entrySet().stream()
            .allMatch(e -> e.getKey().isMatch(task, e.getValue()));
    }
    
}

enum FilterType{
    TITLE(String.class, (task, value) -> task.getTitle().equals(value) ),
    ASSIGNED_USER(User.class, (task, value) -> task.getAssignedUser() != null && task.getAssignedUser().equals(value)),
    PRIORITY(Priority.class, (task, value) -> task.getPriority() == (value)),
    Status(Status.class, (task, value) -> task.getStatus() == (value)),
    DUE_DATE(Date.class, (task, value) -> task.getDueDate().equals(value)),
    CREATED_USER(User.class, (task, value) -> task.getCreatedUser().equals(value));

    private final Class<?> expectedType;
    private final BiPredicate<Task, Object> matcher;

    FilterType(Class<?> expectedType, BiPredicate<Task, Object> matcher){
        this.expectedType = expectedType;
        this.matcher = matcher;
    }

    public Boolean isValid(Object obj){
        return expectedType.isInstance(obj);
    }

    public boolean isMatch(Task task, Object value){
        return matcher.test(task, value);
    }

}

