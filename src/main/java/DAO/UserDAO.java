package DAO;

import Database.DatabaseConnection;
import POJO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> GetAllUsers()
    {
        List<User> users = new ArrayList<User>();
        String query = "Select * from users";

        try(Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query))
        {
            while(resultSet.next())
            {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("email"));
                users.add(user);
            }
        }
        catch (SQLException exception)
            {
                exception.printStackTrace();
            }
        return users;
    }

    public boolean AddUser(User user)
    {
        String query = "Insert into users (name, email) values (?, ?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return false;
    }

    public  boolean UpdateUser(User user)
    {
        String query = "Update users set name = ?, email = ? where id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return false;
    }

    public boolean DeleteUser(User user)
    {
        String query = "Delete from users where id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setInt(1, user.getId());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return false;
    }
}
