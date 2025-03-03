package stack_overflow;
import java.util.*;

interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();
}
