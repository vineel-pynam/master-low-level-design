package stack_overflow;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class StackOverflowService {

    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<Integer, Tag> tags;

    // We set a search strategy
    // We also set a notification (Using singleton & Observer pattern)

    public static class SingletonHelper{
        public static final StackOverflowService INSTANCE = new StackOverflowService();
    }

    private StackOverflowService(){
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    public static StackOverflowService getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public User createUser(String username){
        User user = new User(username);
        this.users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(User user, String content, List<String> tags){
        Question question = user.postQuestion(content, tags);
        this.questions.put(question.getId(), question);

        question.getTags().stream()
            .forEach( tag -> this.tags.put(tag.getId(), tag));

        return question;
    }

    public Answer postAnswer(User user, String content, Question question){
        Answer answer = user.postAnswer(question, content);
        this.answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment postComment(User user, String content, Commentable commentable){
        return user.postComment(commentable, content);
    }

    public void search(String query){
        System.out.println();
        System.out.println("[SEARCHED QUESTIONS]: ");
        this.questions.values().stream()
            .filter( q -> 
                q.get().toLowerCase().contains(query.toLowerCase()) ||
                q.getUser().getName().toLowerCase().contains(query.toLowerCase()) ||
                q.getTags().stream().anyMatch(t -> t.get().equalsIgnoreCase(query))
              ).forEach( q -> System.out.println(q.get()) );
    }

    public void display(){
        this.users.values().stream()
            .forEach( user -> user.display() );
    }


}
