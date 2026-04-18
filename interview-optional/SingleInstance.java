package com.strands.spf;

/**
 * <p>
 * Single instance in a multi threading environment
 * </p>
 * 
 * @author strands
 * 
 */
public class SingleInstance {

  private static volatile SingleInstance instance;

  private SingleInstance() {}

  public static SingleInstance getInstance() {
    if (instance == null) {
      synchronized (SingleInstance.class) {
        if (instance == null) {
          instance = new SingleInstance();
        }
      }
    }
    return instance;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // To run this example, move the file to interview-eventmanager/src/main/java/com/strands/interviews
    // and update the package name to 'package com.strands.interviews;'
    Runnable task = () -> {
      SingleInstance instance = SingleInstance.getInstance();
      System.out.println("Instance used " + instance);
    };

    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
  }
}
