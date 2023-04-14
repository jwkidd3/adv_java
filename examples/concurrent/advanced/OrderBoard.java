package examples.concurrent.advanced;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public interface OrderBoard {

  void postOrder(Order toBeProcessed);

  Order cookOrder();
}
