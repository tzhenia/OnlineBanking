package main.persistence.dao.impl;

import main.persistence.dao.UserDAO;
import main.persistence.dao.impl.enums.SQLUser;
import main.persistence.entities.User;
import main.persistence.entities.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connection connection;

    public UserDAOImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setInt(2, user.getPhone());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getFatherName());
            statement.setString(7, user.getBirthday().toString());
            statement.setLong(8, user.getUserRole().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findById(Long id){
        final User user = new User();
        user.setId(-1L);

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getInt("phone"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setFatherName(rs.getString("father_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setUserRole(new UserRole(rs.getLong("id_user_role"), rs.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.SELECT_ALL.QUERY)) {
                final ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getInt("phone"));
                    user.setPassword(rs.getString("password"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setFatherName(rs.getString("father_name"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setUserRole(new UserRole(rs.getLong("id_user_role"), rs.getString("role")));
                    users.add(user);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return users;
        }

    public void update(Long id, User user){
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setInt(2, user.getPhone());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getFatherName());
            statement.setString(7, user.getBirthday().toString());
            statement.setLong(8, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id){
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}