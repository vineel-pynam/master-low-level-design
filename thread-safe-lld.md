## How to make LLD design thread safe

- Use concurrent collection - ConcurrentHashmap, CopyOnWriteArrayList, BlockingQueue
- Use Atomic Variables
- Lock all critical sections - using any of Synchronized | ReentrantLocks | Semaphores.
- Use Singleton pattern for shared resources
- Try to make objects immutable whereever possible (helps in reducing synchronization)
- Use tryLock instead of Lock, to handle deadlocks. (tryLock has some timeout)
- Use Read-Write Locks for High Read & Low Write Scenarios