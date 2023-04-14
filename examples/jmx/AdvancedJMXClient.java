package examples.jmx;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class AdvancedJMXClient {

  public static void main(String[] args) {
//    instance.
//            Object mBeanProxy = MBeanServerInvocationHandler.newProxyInstance(serverConnection,
//                                                                              mBeanName,
//                                                                              examples.jmx.CacheManagerMBean.class,
//                                                                              false);
//    MBeanServerInvocationHandler invoker = new MBeanServerInvocationHandler(serverConnection, mBeanName);
//
//    Method create = examples.jmx.CacheManagerMBean.class.getMethod("createNewCache", null);
//
//    invoker.invoke(mBeanProxy, create, null);
//    */
//
//    //String [] operationSignature = {"void"};
//    //String [] operationSignature = {"public", "void", "createNewCache()" };
//    String operationName = "createNewCache";
//    Object[] operationParameters = null;
//    String[] operationSignature = null;
//    Object result = serverConnection.invoke(mBeanName, operationName, operationParameters, operationSignature);
//
//    /*
//    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
//    ObjectName mBeanName = new ObjectName("examples.jmx:type=CacheManager");
//    ObjectInstance mgr = server.getObjectInstance(mBeanName);
//    */
//    //System.out.println("mgr: " + mgr);
  }
}
