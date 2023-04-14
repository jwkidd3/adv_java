package examples.generics.advanced;

public class GenericVO<A,B> {

  A fieldA;
  B fieldB;

  GenericVO(A a, B b) {
    fieldA = a;
    fieldB = b;
  }

  public void setFieldA(A a) {
    this.fieldA = a;
  }

  public A getFieldA() {
    return fieldA;
  }

  public void setFieldB(B b) {
    this.fieldB = b;
  }
  public B getFieldB() {
    return fieldB;
  }
}
