package stack_overflow;
import java.util.*;

class User {
    private int id;
    private String name;
    private Integer reputationScore = 0;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private final Integer QUESTION_REPUTAION_SCORE = 2;
    private final Integer ANSWER_REPUTAION_SCORE = 3;
    private final Integer COMMENT_REPUTAION_SCORE = 1;

    User(String name){
        this.name = name;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.id = this.generateId();
    }

    private Integer generateId(){
        Random random = new Random();
        return (int) ((System.nanoTime() + random.nextInt(10000) ) % 10000);
    }

    public Integer getId(){
        return this.id;
    }

    public Question postQuestion(String content, List<String> tags){
        Question question = new Question(this, content, tags);
        this.questions.add(question);
        this.increaseReputationScore(QUESTION_REPUTAION_SCORE);
        return question;
    }

    public Answer postAnswer(Question question, String content){
        Answer answer = new Answer(this, content, question);
        question.addAnswer(answer);
        this.answers.add(answer);
        this.increaseReputationScore(ANSWER_REPUTAION_SCORE);
        return answer;
    }


    public Comment postComment(Commentable commentable, String content){
        Comment comment = new Comment(this, content);
        this.comments.add(comment);
        commentable.addComment(comment);
        this.increaseReputationScore(COMMENT_REPUTAION_SCORE);
        return comment;
    }


    public void increaseReputationScore(Integer value){
        this.reputationScore += value;
    }

    public Integer getReputationScore(){
        return this.reputationScore;
    }

    public String getName(){
        return this.name;
    }

    public void display(){
        System.out.println("[NAME]: " + this.name);
        System.out.println("[REPUTATION_SCORE]: " + this.reputationScore);

        this.questions.stream()
            .forEach( question ->  question.display() );
    }
}
