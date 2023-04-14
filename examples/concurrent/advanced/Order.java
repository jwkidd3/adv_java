package examples.concurrent.advanced;

/**
 * Order represent a restaraunt order.
 * An Order is created by a waiter,
 * initialized with a menu item, and then
 * posted to the order board. Once the
 * order has been posted to the board,
 * the cook can take the order and cook it.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class Order {

  private static int TAB_NUMBER = 0;
  private int orderNumber;
  private String menuItem;

  /**
   * creates a new order with a specific
   * tab number.
   *
   */
  public Order() {
    orderNumber = ++TAB_NUMBER;
  }

  /**
   * returns the menu item associated with the order
   * @return
   */
  public String getMenuItem() {
    return menuItem;
  }

  /**
   * returns the order number
   * associated with the order.
   * @return
   */
  public int getOrderNumber() {
    return orderNumber;
  }

  /**
   * set's the menu item associated
   * with the order
   * @param menuItem
   */
  public void setMenuItem(String menuItem) {
    this.menuItem = menuItem;
  }
}
