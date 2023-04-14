package examples.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * This example illustrates
 * the use of the @SupressWarnings
 * annotation.
 */

public class SupressWarningsExample {

  @SuppressWarnings({"unchecked"})
  public List buildList() {
    List intList = new ArrayList();
    intList.add(1);
    return intList;
  }

}
