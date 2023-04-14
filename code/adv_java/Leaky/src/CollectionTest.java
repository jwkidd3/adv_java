
import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        final int counter = 100000;
        int result = 0;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            result = list.get(i);
        }
        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            list.remove(0);
        }
        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
