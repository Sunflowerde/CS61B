import deque.LinkedListDeque61B;
import org.junit.jupiter.api.Test;

public class LinkedListDeque61BTest {
    @Test
    public void iterableTest() {
        LinkedListDeque61B<Integer> lld = new LinkedListDeque61B<>();
        for (int i = 0; i < 20; ++i) {
            lld.addLast(i);
        }
        for (int x : lld) {
            System.out.println(x);
        }
    }

    @Test
    public void equalsTest() {

    }
}
