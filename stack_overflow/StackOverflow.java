package stack_overflow;
import java.util.*;

class StackOverflow {
    public static void main(String[] args) {
        StackOverflowService sof = StackOverflowService.getInstance();
        
        User vineel = sof.createUser("vineel");
        User suneel = sof.createUser("suneel");
        User rahul = sof.createUser("rahul");

        
        Question question1 = sof.postQuestion(suneel, "What is Python", Arrays.asList("Java", "Programming"));

        Question question = sof.postQuestion(vineel, "What is java", Arrays.asList("Java", "Programming"));
        Answer suneelAsnwer = sof.postAnswer(suneel, "Java is programming language", question);
        Answer rahulAnswer = sof.postAnswer(rahul, "Java is a soup bro.", question);

        sof.postComment(vineel, "Please help with question, asap", question);
        sof.postComment(vineel, "Thank you bro", suneelAsnwer);
        sof.postComment(vineel, "Bro i thought is a juice bro", rahulAnswer);

        sof.display();

        sof.search("suneel");



    }
}
