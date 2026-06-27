import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class testing_class {

    public static final String URL =
            "jdbc:mysql://localhost:3306/hotel_data";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Supragya2006";

    public static void main(String[] args) throws Exception {

        int totalUsers = 100000;
        int threadPoolSize = 500;

        ExecutorService pool =
                Executors.newFixedThreadPool(threadPoolSize);

        long start = System.currentTimeMillis();

        for (int i = 1; i <= totalUsers; i++) {

            final int userId = i;

            pool.submit(() -> {

                try (
                        Connection con = DriverManager.getConnection(
                                URL, USERNAME, PASSWORD);
                        Statement stmt = con.createStatement()
                ) {

                    String query =
                            "INSERT INTO reservations" +
                                    "(cust_Name, room_no, mob_No, aadhaar_No) " +
                                    "VALUES(" +
                                    "'User" + userId + "'," +
                                    (100 + userId % 50) + "," +
                                    "'9999999999'," +
                                    "'123456789012'" +
                                    ")";

                    stmt.executeUpdate(query);

                } catch (Exception e) {
                    System.out.println(
                            "User " + userId +
                                    " failed: " + e.getMessage());
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);

        long end = System.currentTimeMillis();

        System.out.println(
                "Finished " + totalUsers +
                        " users in " +
                        (end - start) + " ms");
    }
}
