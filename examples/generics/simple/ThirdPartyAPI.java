package examples.generics.simple;

import java.util.List;

/**
 * The following class represents
 * a Third-party API that can
 * corrupt a type-safe collection
 * at run-time
 */
public class ThirdPartyAPI {

  public static void addElement(List list) {
    list.add(new Integer(32));
  }
}
