import deque.ArrayDeque61B;

import edu.princeton.cs.algs4.In;
import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }


     @Test
     public void addFirstTest() {
         ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
         ad.addFirst(1);
         ad.addFirst(2);
         assertThat(ad.size()).isEqualTo(2);
     }

     @Test
     public void getTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3);
        assertThat(ad.get(4)).isNull();
        assertThat(ad.get(-1)).isNull();
        assertThat(ad.get(1)).isEqualTo(1);
        assertThat(ad.get(2)).isEqualTo(3);
     }

     @Test
     public void sizeAndIsEmptyTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        assertThat(ad.isEmpty()).isTrue();
        ad.addLast(1);
        ad.addLast(2);
        assertThat(ad.size()).isEqualTo(2);
     }

     @Test
     public void toListTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(3);
        ad.addFirst(2);
        assertThat(ad.toList()).containsExactly(2, 1, 3).inOrder();
     }
}
