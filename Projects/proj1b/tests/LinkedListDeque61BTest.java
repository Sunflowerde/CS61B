import deque.LinkedListDeque61B;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

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
        LinkedListDeque61B<Integer> lld1 = new LinkedListDeque61B<>();
        LinkedListDeque61B<Integer> lld2 = new LinkedListDeque61B<>();
        for (int i = 0; i < 20; ++i) {
            lld1.addLast(i);
            lld2.addLast(i);
        }
        assertThat(lld1).isEqualTo(lld2);
    }
}
