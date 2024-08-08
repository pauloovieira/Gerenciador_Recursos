package Main;
import Users.User;
import java.sql.SQLException;
import java.util.Date;
public class Main {

    public static void main(String[] args) {

        try {
            Database.databaseConnection.getCon();

            //Criando um novo usuario
            User user1 = new User(1, "user", "password");
            user1.createUser(user1);
            System.out.println("User created: " + user1.getUsername());

            //Usuario encontrado
            User fetchedUser = user1.readUser(1);
            if (fetchedUser != null) {
                System.out.println("User: " + fetchedUser.getUsername());

                fetchedUser.setPassword("newpassword");
                user1.updateUser(fetchedUser);
                System.out.println("User updated: " + fetchedUser.getPassword());
            } else {
                System.out.println("User not found");
            }

            //Lista usuarios existentes
            System.out.println("Users:");
            for (User user : user1.getAllUsers()) {
                System.out.println(user.getId() + ": " + user.getUsername());
            }

            user1.getAllResources();
            user1.allocateResource(1, new Date(), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));
            user1.getAllResources();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}