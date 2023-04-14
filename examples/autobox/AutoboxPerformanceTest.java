package examples.autobox;

/**
 * This simple example illustrates,
 * in a non-scientific manner, the
 * performance implication of using autoboxing.
 */
public class AutoboxPerformanceTest {

  public static void main(String[] args) {
    int iterationCount = 1000000;
    //first lets time the autoboxing
    long currentTime = System.currentTimeMillis();
    for(int j=1;j<iterationCount;j++) {
      Integer x = 32;
      int y = x * j;
    }
    long nowTime = System.currentTimeMillis();
    System.out.println(iterationCount + " autobox iterations took " + (nowTime-currentTime) + " ms");

    //now lets time the primitive
    currentTime = System.currentTimeMillis();
    for(int j=1;j<iterationCount;j++) {
      int x = 32;
      int y = x * j;
    }
    nowTime = System.currentTimeMillis();

    System.out.println(iterationCount + " primitive iterations took " + (nowTime-currentTime) + " ms");

  }

}
