
public class PrimitivesTest {

    private static void testPrimitive(int n) {
        int[] primitiveArray = new int[n];
        long primitiveSum = 0;

        for (int i = 0; i < n; i++) {
            primitiveArray[i] = i;
            primitiveSum += primitiveArray[i];
        }
    }

    private static void testObject(int n) {
        Integer[] objectArray = new Integer[n];
        Long objectSum = 0L;

        for (int i = 0; i < n; i++) {
            objectArray[i] = i;
            objectSum += objectArray[i];
        }
    }

    public static void main(String[] args) {

            long startTime = System.nanoTime();
            testPrimitive(10000000);
            long endTime = System.nanoTime();

            System.out.println(endTime - startTime);

            startTime = System.nanoTime();
            testObject(10000000);
            endTime = System.nanoTime();

            System.out.println(endTime - startTime);
        }
}
