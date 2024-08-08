package Users;

import DAO.resourceDAO;
import DAO.userDAO;
import Resources.Resource;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User extends userDAO {
    private int id;
    private String username;
    private String password;
    private resourceDAO resourceDao;
    private userDAO userDao;
    private Map<Integer, String> allocations;

    public User() {
        this.resourceDao = new resourceDAO();
        this.userDao = new userDAO();
        this.allocations = new TreeMap<>();
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.resourceDao = new resourceDAO();
        this.userDao = new userDAO();
        this.allocations = new TreeMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Funcionalidades especificas
    public void getAllResources() throws SQLException {
        List<Resource> resources = resourceDao.getAllResources();
        for (Resource resource : resources) {
            System.out.println(resource.getId() + ": " + resource.getName());
        }
    }

    public void allocateResource(int resourceId, Date startDate, Date endDate) throws SQLException {
        Resource resource = resourceDao.readResources(resourceId);
        String allocationInfo = "Allocated to user " + this.id + this.getUsername() + " from " + startDate + " to " + endDate;
        allocations.put(resourceId, allocationInfo);
    }
}
