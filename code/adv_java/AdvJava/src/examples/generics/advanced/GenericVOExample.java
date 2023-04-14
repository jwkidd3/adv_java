package examples.generics.advanced;

public class GenericVOExample {

  public static void main(String[] args) {
    //create instances of the GenericVO
    GenericVO<String, String> name =
            new GenericVO<String,String>("John", "Doe");
    
    GenericVO<String, Integer> user =
            new GenericVO<String,Integer>("john_doe123", 123457);

    //get name field <B>
    String lastName = name.getFieldB();
    System.out.println("name's field <B> is: " + lastName);

    //get user field <B>
    Integer userId = user.getFieldB();
    System.out.println("users's field <B> is: " + userId);
  }

}
