package examples.generics.advanced;

import java.util.List;

/**
 * The following class represents
 * a Third-party API that can
 * maintains a type-safe collection
 */
public class TypeSafeThirdPartyAPI {

  public static void addElement(List<String> list) {
    list.add("Hello Typesafety");
  }
}
