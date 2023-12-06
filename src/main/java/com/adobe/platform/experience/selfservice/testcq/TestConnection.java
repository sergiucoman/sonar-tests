import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TestConnection extends Thread {

    private static Map map = new HashMap();

    private static Connection conn = null;


    @Override
    public void run() {
        System.out.println("Thread is running.");
        while(true) {
            try {
                Statement statement = conn.createStatement();
                // execute a query
                statement.executeQuery("SELECT * FROM table");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try {

            TestThread t1 = new TestThread();
            t1.run();
        } catch (Throwable e) {
        }
    }
}
