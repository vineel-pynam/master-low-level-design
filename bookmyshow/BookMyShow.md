# 🎬 BookMyShow Low-Level Design (LLD)

This repository contains a modular and thread-safe low-level design of a movie ticket booking system similar to BookMyShow. It covers entity modeling, seat booking logic, concurrency handling, and system extensibility.

---

## ✅ Features

- 🎥 Add Movies, assign to Theatres and Screens
- 🪑 Book Seats with real-time availability
- 🪙 Normal vs Premium Seats (Different pricing)
- 🔐 Thread safety in booking using synchronization
- 🔁 Singleton Pattern for central manager
- 📦 Booking history and display
- ⏳ Seat Booking Timeout Design (Discussed)
- 💡 Extensible for Payments, Notifications, etc.

---

## 🕒 1-Hour Interview Strategy

### 🔧 How to Answer in a 1-Hour Interview

> ⏱️ **Suggested Time Split:**

| Section | Time |
|--------|------|
| Problem understanding & constraints | 5 min |
| Class & Relationship design | 15 min |
| Booking Flow + Code Walkthrough | 20 min |
| Thread Safety & Concurrency | 10 min |
| Scaling & Trade-offs | 5 min |
| Final wrap-up & questions | 5 min |

---

### 👇 Interview Questions with Answers

#### ❓**Q1: What are the main entities and relationships?**

✅ **Answer**:
- `Movie` → Identified by `id` and `name`
- `Theatre` → Contains `List<Screen>`, identified by `id`
- `Screen` → Plays shows of a `Movie`, contains `List<Show>`
- `Show` → Has `time`, `List<Seat>`; specific to a movie and screen
- `Seat` → Normal or Premium; can be `BOOKED` or `UN_BOOKED`
- `Booking` → Stores booking summary for a user
- `User` → Books seats for a show

> Shows a clear entity-relationship model that’s scalable and modular.

---

#### ❓**Q2: Walk me through the booking flow.**

✅ **Answer**:
1. User selects a movie → theatre → screen → show
2. Calls `MovieManager.bookSeats(...)`
3. The method finds the right `Theatre`, `Screen`, and `Show`
4. It delegates to `Show.bookSeats(...)` with selected seat numbers
5. Inside `Show.bookSeats`, synchronized block ensures no race condition
6. If seats are available, mark them `BOOKED`, calculate price
7. Create and store a `Booking` object

---

#### ❓**Q3: How is concurrency handled?**

✅ **Answer**:
- Booking logic is **thread-safe** via `synchronized` block in `Show.bookSeats`
- Data structures like `CopyOnWriteArrayList` and `ConcurrentHashMap` are used for thread-safe collections
- Mention: In production, use `ReentrantLock` or distributed locking (e.g., Redis, Zookeeper)

---

#### ❓**Q4: What are your scalability ideas?**

✅ **Answer**:
- Use persistent DB (PostgreSQL) instead of in-memory
- Introduce caching for available seats (Redis)
- Microservice separation: MovieService, BookingService, PaymentService
- Use Redis-based distributed lock (`SETNX` with expiry) for seat hold
- Horizontal scaling of services behind a Load Balancer

---

#### ❓**Q5: What happens if the user selects seats but doesn’t pay?**

✅ **Answer**:
- Ideally, seats should be "held" temporarily and released after timeout
- Implement hold logic by adding a timestamp to each seat
- Run a background scheduler to release seats if hold not confirmed in X minutes
- In real systems, use Redis TTL or message queues with delay

---

### 🌟 Stand-out Tips for 1-Hour Round

- Use `UML` or draw class relationships
- Keep code clean, modular, and extensible
- Clearly explain concurrency and edge cases
- Bring up production trade-offs proactively
- Mention "If I had more time, I would..." to show depth

---

## 🕒 2-Hour Interview Strategy

> ⏱️ **Suggested Time Split:**

| Section | Time |
|--------|------|
| Clarify and diagram class relationships | 15 min |
| Implement core logic (Theatre, Screen, Show, Booking) | 40 min |
| Add seat locking + timeout mechanism | 20 min |
| Discuss system scalability (distributed systems) | 20 min |
| REST API design / Testing strategy | 15 min |
| Final wrap-up and QA | 10 min |

---

### 👇 Advanced Questions with Sample Answers

#### ❓**Q1: Can you implement seat hold with timeout?**

✅ **Answer**:
- Add a `heldByUser` + `holdTimestamp` to `Seat`
- Change `BOOKED` to `HELD` state before final confirmation
- Use `ScheduledExecutorService` or a timer to release after timeout
- In production, move this to Redis with TTL and Redis pub/sub or message queues

---

#### ❓**Q2: When would you use `ReentrantLock` vs `synchronized`?**

✅ **Answer**:
- `synchronized` is simple, sufficient for single-JVM simulation
- `ReentrantLock` allows:
    - Timeout via `tryLock(timeout)`
    - Manual lock release (`unlock`)
    - Fair locking
- If designing for large-scale concurrency, prefer `ReentrantLock` with timeout

---

#### ❓**Q3: How would you persist data?**

✅ **Answer**:
- Use RDBMS for transactional data (movies, bookings, users)
- Use Redis for caching available seats or locks
- Wrap booking flow in DB transactions to maintain consistency
- Add retry logic for failures (via retry queues)

---

#### ❓**Q4: Can you support a million users concurrently?**

✅ **Answer**:
- Use microservices (BookingService, TheatreService)
- Horizontal scaling + caching
- Use distributed locks
- Load-balanced API gateway
- Use Kafka to process bookings asynchronously

---

### 🌟 Stand-out Tips for 2-Hour Round

- Show full class modeling + booking implementation
- Add timeout-based seat hold
- Discuss DB schema & caching
- Sketch REST API or Postman flows
- Talk about test cases (unit + concurrency)
- Mention CI/CD or deployment if relevant

---

## 🚀 Extensions You Can Propose

- Payment gateway integration
- Refunds, cancellation, and seat rebooking
- Promotions & coupons
- Notifications (SMS/Email)
- Admin panel to manage movies and shows
- Frontend (React) or API layer with Swagger

---

## 📌 Final Tips to Wrap Up Strong

- Summarize your clean design
- Explain key decisions (why singleton, why thread-safe)
- Suggest how it can evolve into a full production system
- Ask thoughtful questions:
  - “Should I focus more on concurrency or distributed flow?”
  - “Would you like me to sketch an API layer?”

---

## 🧪 Want More?

- [ ] UML diagrams and class diagram
- [ ] REST API spec (OpenAPI/Swagger)
- [ ] Dockerized Microservice version
- [ ] PDF Export for offline interviews

> Let me know if you'd like any of the above generated!

