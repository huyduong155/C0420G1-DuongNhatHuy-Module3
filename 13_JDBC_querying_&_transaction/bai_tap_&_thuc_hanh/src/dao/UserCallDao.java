package dao;

import model.User;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCallDao implements IUserDao{
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_USERS ="{call get_all_user()}";
    private static final String UPDATE_USERS_SQL ="{call update_user(?,?,?,?)}";
    private static final String DELETE_USERS_SQL ="{call delete_user(?)}";
    @Override
    public void insertUser(User user) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(SELECT_ALL_USERS);
            ResultSet rs =callableStatement.executeQuery();
            User user = null;
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(DELETE_USERS_SQL);
        callableStatement.setInt(1,id);
        rowDelete = callableStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(UPDATE_USERS_SQL);
        callableStatement.setString(1,user.getName());
        callableStatement.setString(2,user.getEmail());
        callableStatement.setString(3,user.getCountry());
        callableStatement.setInt(4,user.getId());
        rowUpdate = callableStatement.executeUpdate() > 0;
        return rowUpdate;
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        return null;
    }
}
