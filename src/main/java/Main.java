import DAO.UserDAO;
import POJO.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // 1. Додавання нового користувача
        User newUser = new User(0, "John Doe", "john.doe@example.com");
        boolean isCreated = userDAO.createUser(newUser);
        System.out.println("User created: " + isCreated);

        // 2. Отримання всіх користувачів
        List<User> users = userDAO.getAllUsers();
        System.out.println("All users:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }

        // 3. Оновлення користувача (припустимо, ми оновимо першого користувача)
        if (!users.isEmpty()) {
            User firstUser = users.get(0);
            firstUser.setUsername("John Updated");
            firstUser.setEmail("john.updated@example.com");

            boolean isUpdated = userDAO.updateUser(firstUser);
            System.out.println("User updated: " + isUpdated);
        }

        // 4. Видалення користувача (видаляємо першого користувача у списку)
        if (!users.isEmpty()) {
            int userIdToDelete = users.get(0).getId();
            boolean isDeleted = userDAO.deleteUser(userIdToDelete);
            System.out.println("User deleted: " + isDeleted);
        }

        // 5. Вивід оновленого списку користувачів
        users = userDAO.getAllUsers();
        System.out.println("Users after deletion:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
