package bo;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBO implements IUserBO{
    private UserDao userDao = new UserDao();
    @Override
    public void insertUser(User user) throws SQLException {
        this.userDao.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.userDao.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userDao.updateUser(user);
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        return this.userDao.selectUserByCountry(country);
    }
}
