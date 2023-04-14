
public class StringPerformance {

    public static void main(String[] args) {

        long startTime, endTime;

        String string = new String("");
        StringBuffer stringBuffer = new StringBuffer(1000);
        StringBuilder stringBuilder = new StringBuilder(1000);

        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            string += i;
        }

        endTime = System.nanoTime();

        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            stringBuffer.append(i);
        }
        endTime = System.nanoTime();

        System.out.println((endTime - startTime));


        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            stringBuilder.append(i);
        }
        endTime = System.nanoTime();

        System.out.println((endTime - startTime));

    }
}
