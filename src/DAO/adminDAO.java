package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Users.Admin;
public class adminDAO {

    public void createAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
        }
    }

    public Admin readAdmin(int id) throws SQLException {
        String sql = "SELECT * FROM admins WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
            return null;
        }
    }

    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "UPDATE admins SET username = ?, password = ? WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.setInt(3, admin.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteAdmin(int id) throws SQLException {
        String sql = "DELETE FROM admins WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Admin> getAllAdmin() throws SQLException {
        String sql = "SELECT * FROM admins";
        List<Admin> Admins = new ArrayList<>();
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                Admins.add(admin);
            }
        }
        return Admins;
    }
}
