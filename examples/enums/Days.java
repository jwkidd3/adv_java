package examples.enums;

/**
 * Days is a basic illustration of an
 * enumerated type within the Java language.
 */
enum Days {
  SUNDAY, MONDAY, TUESDAY,
  WEDNESDAY, THURSDAY, FRIDAY,
  SATURDAY { //treat saturday different
    public String getReadableName() {
      return name();
    }
  };

  public String getReadableName() {
    //get name as String
    String nameValue = name();
    
    //convert it to correct capitalization
    return nameValue.substring(0, 1) +
           nameValue.substring(1).toLowerCase();
  }
  
//  public String toString() {
//    return getReadableName();
//  }
}
