package task_management_system;

import java.util.*;

// used builder pattern
class Task {
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;
    private User assignedUser;
    private User createdUser;

    private Task(Builder builder){
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.priority = builder.priority;
        this.createdUser = builder.createdUser;
        this.id = builder.id;
        this.status = Status.PENDING;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Status getStatus() {
        return this.status;
    }

    public void assignUser(User user){
        this.assignedUser = user;
    }

    public User getAssignedUser(){
        return this.assignedUser;
    }

    public User getCreatedUser(){
        return this.createdUser;
    }

    public String getId(){
        return this.id;
    }

    // mutable fields
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static class Builder{
        private String title;
        private String description;
        private Date dueDate;
        private Priority priority;
        private User createdUser;
        private String id;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder setCreatedUser(User user) {
            this.createdUser = user;
            return this;
        }

        public Task build(){
            return new Task(this);
        }

    }

}
