package examples.javabeans;

import java.io.*;

/**
 * This application illustrates the
 * creation and persistence of a JavaBean
 * using an ObjectOutputStream. It also
 * illustrates the restoration of a JavaBean
 * using an ObjectInputStream.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class NameBeanSerializationExample {

  public static void main(String[] args)
                throws IOException, ClassNotFoundException {
    
    File file = new File("/tmp/me.ser");
    NameBean me = null;

    if(args.length == 0 || "write".equals(args[0])) {
      me = new NameBean("Mr.", "John", "Kidd");
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream output = new ObjectOutputStream(fos);
      output.writeObject(me);
    } else {
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fis);
      me = (NameBean) input.readObject();
    }
    System.out.println("My full name: " + me.getFullName());
  }

}
