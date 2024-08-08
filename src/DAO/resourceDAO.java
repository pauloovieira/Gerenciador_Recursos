package DAO;
import Resources.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class resourceDAO {

    public void createResource(Resource resource) throws SQLException {
        String sql = "INSERT INTO resources (name) VALUES (?)";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resource.getName());
            stmt.executeUpdate();
        }
    }

    public Resource readResources(int id) throws SQLException {
        String sql = "SELECT * FROM resources WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Resource(rs.getInt("id"), rs.getString("name"));
            }
            return null;
        }
    }

    public void updateResource(Resource resource) throws SQLException {
        String sql = "UPDATE resources SET name = ? WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resource.getName());
            stmt.setInt(2, resource.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteResource(int id) throws SQLException {
        String sql = "DELETE FROM resources WHERE id = ?";
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Resource> getAllResources() throws SQLException {
        String sql = "SELECT * FROM resources";
        List<Resource> books = new ArrayList<>();
        try (Connection conn = Database.databaseConnection.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(new Resource(rs.getInt("id"), rs.getString("name")));
            }
        }
        return books;
    }
}
