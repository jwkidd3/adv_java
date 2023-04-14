package examples.metadata;

/**
 * This example illustrates the
 * use of the @Override annotation
 */
public class OverrideExample {
  private String myValue;

  @MyAnnotation("MyNew Annotation")
  public String toString() {
    return myValue;
  }
}
