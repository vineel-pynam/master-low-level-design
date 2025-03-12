package task_management_system;

interface TaskObserver {
    void onTaskUpdate(Task task);
}

class UserNotifier implements TaskObserver{
    public void onTaskUpdate(Task task){
        System.out.println("[Notified]: Task -> "+ task.getId() +", updated to user -> " + task.getAssignedUser().getName() + ", and it is created by User -> " + task.getCreatedUser().getName() );
    }
}
