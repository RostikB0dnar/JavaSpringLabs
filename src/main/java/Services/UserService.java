package Services;

import DAO.UserDAO;
import POJO.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void registerUser(User user) {
        if(user.getUsername() != null && user.getEmail() != null)
            userDAO.createUser(user);
    }
}
