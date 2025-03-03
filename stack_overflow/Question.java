package stack_overflow;
import java.util.*;

class Question implements Commentable{
    private Integer id;
    private String content;
    private List<Answer> answers;
    List<Comment> comments;
    private List<Tag> tags;
    private User user;

    Question(User user, String content, List<String> tags){
        this.id = this.generateId();
        this.user = user;
        this.content = content;
        this.comments = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.tags = new ArrayList<>();

        // Adding all tags passed by user
        tags.stream()
            .forEach(tag -> this.tags.add(new Tag(tag)));
    }

    private Integer generateId(){
        Random random = new Random();
        return (int) ((System.nanoTime() + random.nextInt(10000) ) % 10000);
    }

    public Integer getId(){
        return this.id;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public String get(){
        return this.content;
    }

    public List<Answer> getAnswers(){
        return this.answers;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public List<Tag> getTags(){
        return this.tags;
    }

    public User getUser(){
        return this.user;
    }

    public void display(){
        System.out.println("[QUESTION]: ");
        System.out.println(" - " + this.content);
        System.out.println(" - " + this.user.getName());
        
        System.out.println("[ANWERS]: ");
        this.answers.stream()
            .forEach( answer -> answer.display());

        System.out.println("[COMMENTS]: ");
        this.comments.stream()
            .forEach(comment -> System.out.println(" - " + comment.get()));
    }
}
