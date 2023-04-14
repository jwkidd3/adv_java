package labs.solutions.javabeans;

import examples.javabeans.NameBean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This application illustrates the
 * creation and persistence of a JavaBean
 * using an XMLEncoder. It also
 * illustrates the restoration of a JavaBean
 * using an XMLDecoder.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class NameBeanXMLSerializationExample {

  public static void main(String[] args)
                throws IOException, ClassNotFoundException {

    List<NameBean> family = null;

    File file = new File("/tmp/me.xml");
    examples.javabeans.NameBean me = null;

    if(args.length == 0 || "write".equals(args[0])) {
      family = new ArrayList<NameBean>(5);
      family.add(new NameBean("Mr.", "Kelby", "Zorgdrager"));
      family.add(new NameBean("Mrs.", "Beth", "Zorgdrager"));
      family.add(new NameBean("Ms.", "Aubreigh", "Zorgdrager"));
      family.add(new NameBean("Mr.", "Owen", "Zorgdrager"));
      family.add(new NameBean("Ms.", "Annabelle", "Zorgdrager"));
      FileOutputStream fos = new FileOutputStream(file);
      java.beans.XMLEncoder output = new XMLEncoder(fos);
      output.writeObject(family);
      output.close();
    } else {
      FileInputStream fis = new FileInputStream(file);
      XMLDecoder input = new XMLDecoder(fis);
      family = (List<NameBean>) input.readObject();
      input.close();
    }
    System.out.println("My full family: " + Arrays.toString(family.toArray()));
  }

}
