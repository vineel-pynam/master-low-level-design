package task_management_system;

import java.util.Date;

class TaskManagement {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();
        User vineel = new User("Vineel");
        User suneel = new User("Suneel");

        TaskEventManager taskEventManager = TaskEventManager.getInstance();
        taskEventManager.subscribe(new UserNotifier());

        Task t1 = new Task.Builder()
            .setTitle("Java")
            .setDescription("Complete Java")
            .setDueDate(new Date())
            .setPriority(Priority.HIGH)
            .setId("1")
            .setCreatedUser(vineel)
            .build();


        Task t2 = new Task.Builder()
            .setTitle("Python")
            .setDescription("Complete Python")
            .setDueDate(new Date())
            .setPriority(Priority.MEDIUM)
            .setId("2")
            .setCreatedUser(suneel)
            .build();

        taskManager.createTask(t1);
        taskManager.createTask(t2);

        t2.assignUser(vineel);
        taskManager.updateTask(t2);
        t1.assignUser(suneel);
        taskManager.updateTask(t1);

        TaskSearchCriteria taskSearchCriteria = new TaskSearchCriteria();
        taskSearchCriteria.addFilter(FilterType.PRIORITY, Priority.HIGH);
        taskManager.search(taskSearchCriteria);
    }
}
