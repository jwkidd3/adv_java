package labs.starter.javabeans;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 * NameBean is a basic representation of a JavaBean.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class NameBean implements Serializable {

  //property fields
  private String salutation;
  private String firstName;
  private String lastName;

  //event support
  PropertyChangeSupport boundPropertySupport;

  public NameBean() {
    this("","","");
  }

  public NameBean(String salutation, String firstName, String lastName) {
    this.salutation = salutation;
    this.firstName = firstName;
    this.lastName = lastName;

    //initialize PropertyChangeSupport
    boundPropertySupport = new PropertyChangeSupport(this);
  }

  //properties
  /**
   * getter for salutation property
   *
   * @return
   */
  public String getSalutation() {
    return salutation;
  }

  /**
   * setter for salutation property
   *
   * @param salutation
   */
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  /**
   * getter for firstName property
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Setter for firstName property.
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * getLastName is the getter for the
   * lastName property.
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * setLastName is the setter for the
   * lastName property.
   *
   * lastName is a bounded property. Any
   * time the lastName is changed, a
   * PropertyChangeEvent is delivered to
   * all registered PropertyChangeListeners.
   * @param lastName
   */
  public void setLastName(String lastName) {
    if(!this.lastName.equals(lastName)) {
      String oldLastName = this.lastName;
      this.lastName = lastName;
      //fire event to listeners
      boundPropertySupport.firePropertyChange("lastName", oldLastName, lastName);
    }
  }

  /**
   * returns the full name comprised of
   * salutation, first name, last name
   * @return
   */
  public String getFullName() {
    return salutation + " " + firstName + " " + lastName;
  }

   //event source operations
  /**
   * Adds a property change listener. Only bounded property
   * in NameBean is lastName.
   *
   * @param listener
   */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    boundPropertySupport.addPropertyChangeListener(listener);
  }

  /**
   * Removes property change listener. Only bounded property
   * in NameBean is lastName.
   * @param listener
   */
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    boundPropertySupport.removePropertyChangeListener(listener);
  }

  //operations
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NameBean that = (NameBean) o;

    if (!firstName.equals(that.firstName)) return false;
    if (!lastName.equals(that.lastName)) return false;
    if (!salutation.equals(that.salutation)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    result = salutation.hashCode();
    result = 31 * result + firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "NameBean{" +
           "salutation='" + salutation + '\'' +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           '}';
  }
}
