package examples.osgi.impl;

public class HelloWorldService {

  static {
    System.out.println("examples.osgi.impl.HelloWorldService class loaded");
  }

  public HelloWorldService() {}

  public String sayHello() {
    return "Hello OSGi World";
  }

}

