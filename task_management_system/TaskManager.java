package task_management_system;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;;

class TaskManager {
    private Map<String, Task> taksMap;
    private TaskEventManager taskEventManager;
    

    public static final class SingletonHelper{
        public static final TaskManager INSTACE = new TaskManager();
    }

    TaskManager(){
        this.taksMap = new ConcurrentHashMap<>();
        this.taskEventManager = TaskEventManager.getInstance();
    }

    public static TaskManager getInstance(){
        return SingletonHelper.INSTACE;
    }

    public void createTask(Task task){
        this.taksMap.put(task.getId(), task);
    }

    public void updateTask(Task task){
        Task existingTask = this.taksMap.getOrDefault(task.getId(), null);
        if( existingTask == null ) throw new RuntimeException("Invalid task id");

        existingTask.setDescription(task.getDescription());
        existingTask.setTitle(task.getTitle());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.assignUser(task.getAssignedUser());

        taskEventManager.notifyEveryone(existingTask);
    }

    public void deleteTask(String id){
        this.taksMap.remove(id);
    }

    public void search(TaskSearchCriteria criteria){
        List<Task> filteredTasks = this.taksMap.values().stream().filter(criteria::matches).collect(Collectors.toList());

        System.out.println("[SEARCH_RESULTS]: ");
        filteredTasks.stream()
            .forEach(   e -> 
                System.out.println("[TITLE]: " + e.getTitle() + ", [PRIORITY]: " + e.getPriority().toString() + ", [STATUS]: " + e.getStatus().toString())
            );
    }
}
