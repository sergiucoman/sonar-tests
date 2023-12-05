public class WorkerThread extends Thread {
  @Override 
  public void run() {
    while (true) {
      System.out.println('working');
    }
  }

  public static void main(String[] args) {
    new WorkerThread().run();
  }
}
