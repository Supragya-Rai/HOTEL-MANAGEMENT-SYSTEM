import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class hotelManagement {
    public static final String url = "jdbc:mysql://localhost:3306/hotel_data";
    public static final String username = "root";
    public static final String password = "Supragya2006";

    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected!!!");
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Welcome to Hotel Management System!!!");
                System.out.println("1.New Reservation");
                System.out.println("2.View Reservations");
                System.out.println("3.Update Reservations");
                System.out.println("4.Delete Reservations");
                System.out.println("5.Get Details");
                System.out.println("0.Exit");
                System.out.println("Enter Your Choice:");
                int choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        newReservation(con,scanner);
                        break;
                    case 2:
                        viewReservations(con);
                        break;
                    case 3:
                        updateReservations(con,scanner);
                        break;
                    case 4:
                        deleteReservations(con,scanner);
                        break;
                    case 5:
                        getDetails(con,scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        con.close();
                        return;
                    default:
                        System.out.println("Invalid Input!!!");

                }
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void newReservation(Connection connection,Scanner scanner) throws SQLException{
        System.out.println("Enter the name:");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("Enter Room Number:");
        int room_no = scanner.nextInt();
        System.out.println("Enter the mobile number:");
        String mob_no = scanner.next();
        System.out.println("Enter the aadhaar number:");
        String aadhaar_no = scanner.next();

        String query = "INSERT INTO reservations(cust_Name, room_no, mob_No, aadhaar_No) VALUES('" +name+ "'," +room_no+ ",'" +mob_no+ "','" +aadhaar_no+"');";
        try{
            Statement stmt = connection.createStatement();

            int affectedRows = stmt.executeUpdate(query);

            if (affectedRows > 0) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Reservation failed.");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static  void viewReservations(Connection connection) throws SQLException{
        String query = "Select * from reservations;";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Current Reservations:");

            while(rs.next()){
                int Reservation_ID = rs.getInt("reservation_Id");
                int Room_No = rs.getInt("room_no");
                String Customer_Name = rs.getString("cust_Name");
                String Mobile_No = rs.getString("mob_No");
                String Aadhaar_No = rs.getString("aadhaar_No");
                String Reservation_Date = rs.getTimestamp("reservation_Date").toString();

                System.out.printf("%d %d %s %s %s %s%n", Reservation_ID, Room_No, Customer_Name, Mobile_No, Aadhaar_No, Reservation_Date);
            }
            return;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void updateReservations(Connection connection, Scanner scanner) throws SQLException{
        System.out.println("Enter Reservation Id");
        int id = scanner.nextInt();
        if (!reservationExists(connection, id)) {
            System.out.println("Reservation not found for the given ID.");
            return;
        }
        System.out.println("Enter name:");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("Enter the room no:");
        int room_no = scanner.nextInt();
        System.out.println("Enter the mobile number:");
        String mobno = scanner.next();
        System.out.println("Enter the aadhaar number:");
        String aadhaarno = scanner.next();
        String query = "UPDATE reservations SET room_No=" +room_no+ ", cust_Name='"+name+"',mob_No='"+mobno+"',aadhaar_No='"+aadhaarno+"' WHERE reservation_Id="+id+";";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Updated!!!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static boolean reservationExists(Connection connection, int reservationId) {
        try {
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                return resultSet.next(); // If there's a result, the reservation exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle database errors as needed
        }
    }
    private static void deleteReservations(Connection connection,Scanner scanner) throws SQLException{
        System.out.println("Enter the Reservation ID:");
        int id = scanner.nextInt();
        String query = "DELETE FROM reservations WHERE reservation_Id="+id+";";
        try{
            if (!reservationExists(connection, id)) {
                System.out.println("Reservation not found for the given ID.");
                return;
            }
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("RESERVATION DELETED!!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void getDetails(Connection connection,Scanner scanner) throws SQLException{
        System.out.println("Enter Reservation Id:");
        int id = scanner.nextInt();
        String query = "SELECT * FROM reservations WHERE reservation_Id="+id+";";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                int Reservation_ID = rs.getInt("reservation_Id");
                int Room_No = rs.getInt("room_no");
                String Customer_Name = rs.getString("cust_Name");
                String Mobile_No = rs.getString("mob_No");
                String Aadhaar_No = rs.getString("aadhaar_No");
                String Reservation_Date = rs.getTimestamp("reservation_Date").toString();

                System.out.printf("%d %d %s %s %s %s%n", Reservation_ID, Room_No, Customer_Name, Mobile_No, Aadhaar_No, Reservation_Date);
            }
            else{
                System.out.println("No reservation found!");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void exit() throws InterruptedException{
        System.out.print("Exiting System");
        int i = 5;
        while(i!=0){
            System.out.print(".");
            Thread.sleep(250);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel Reservation System!!!");

    }
}
