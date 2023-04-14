package examples.reflection.performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 11, 2010
 * Time: 10:44:59 AM
 */
public class DataStructure {

  private List<String> list;

  public DataStructure() {

    String s = "a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    String [] args = s.split(" ");
    list = new ArrayList<String>(Arrays.asList(args));
    //System.out.println("list size: " + list.size());
  }

  
  public List<String> reversedList() {
    Collections.reverse(list);
    //System.out.println("called");
    return list;
  }
}
