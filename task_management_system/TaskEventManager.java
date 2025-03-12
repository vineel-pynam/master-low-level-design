package task_management_system;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class TaskEventManager {
    private List<TaskObserver> observers;

    public static final class SingletonHelper{
        public static final TaskEventManager INSTACE = new TaskEventManager();
    }

    TaskEventManager(){
        this.observers = new CopyOnWriteArrayList<>();
    }

    public static TaskEventManager getInstance(){
        return SingletonHelper.INSTACE;
    }

    public void subscribe(TaskObserver taskObserver){
        this.observers.add(taskObserver);
    }

    public void notifyEveryone(Task task){
        this.observers.stream().forEach(e -> e.onTaskUpdate(task));
    }
}
