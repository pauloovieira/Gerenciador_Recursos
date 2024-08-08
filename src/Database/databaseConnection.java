package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DBresource";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    public databaseConnection() throws SQLException {
    }
    public static Connection getCon() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws Exception {

        Connection con = createConnection();

        if(con!=null) {
            System.out.println("Conexao obtida com sucesso.");
            con.close();
        }
    }
}
