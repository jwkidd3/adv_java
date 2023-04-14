package examples.generics.advanced;

import java.util.List;

/**
 * The following class represents
 * a Third-party API that can
 * maintains a bounded type-safe collection
 */
public class BoundedTypeSafeThirdPartyAPI {

  public static void addElement(List<? super Number > list) {
    list.add(729);
    list.add(Math.PI);
  }
}
