package Users;

import DAO.resourceDAO;
import Resources.Resource;

import java.sql.SQLException;
import DAO.userDAO;
public class Admin {
    private int id;
    private String username;
    private String password;
    private resourceDAO resourceDao;
    private userDAO userDAO;

    public Admin() {
        this.resourceDao = new resourceDAO();
        this.userDAO = new userDAO();
    }

    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.resourceDao = new resourceDAO();
        this.userDAO = new userDAO();
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
    public void registerResource(String name) throws SQLException {
        Resource resource = new Resource();
        resource.setName(name);
        resourceDao.createResource(resource);
    }

    public void updateResource(int id, String name) throws SQLException {
        Resource resource = new Resource(id, name);
        resourceDao.updateResource(resource);
    }

    public void deleteResource(int id) throws SQLException {
        resourceDao.deleteResource(id);
    }

    public void deleteUser(int id) throws SQLException {
        userDAO.deleteUser(id);
    }
}
