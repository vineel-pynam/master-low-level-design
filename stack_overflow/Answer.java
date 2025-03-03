package stack_overflow;
import java.util.*;

class Answer implements Commentable{
    private Integer id;
    private String content;
    List<Comment> comments;
    private User user;
    private Question question;

    Answer(User user, String content, Question question){
        this.id = this.generateId();
        this.user = user;
        this.content = content;
        this.comments = new ArrayList<>();
        this.question = question;
    }

    private Integer generateId(){
        Random random = new Random();
        return (int) ((System.nanoTime() + random.nextInt(10000) ) % 10000);
    }

    public Integer getId(){
        return this.id;
    }
    
    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public String get(){
        return this.content;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public void display(){
        System.out.println("\t[ANSWER]: ");
        System.out.println("\t [" + this.user.getName() + "] " + this.content);

        System.out.println("\t[COMMENTS]: ");
        this.comments.stream()
            .forEach(comment -> System.out.println("\t - [" + comment.getUser().getName() + "] " + comment.get()));
    }
    
}
