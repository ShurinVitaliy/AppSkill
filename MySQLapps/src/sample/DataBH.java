package sample;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02.06.2018.
 */
public class DataBH extends Configs{
    public Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?verifyServerCertificate=false" + "&useSSL=false" +
                "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void siginUpUser(User user){
        String insert = "INSERT INTO " + ConstUser.USER_TABLE + "(" + ConstUser.USER_SURNAME + "," + ConstUser.USER_LASTNAME
                + "," + ConstUser.USER_LOGIN + "," + ConstUser.USER_PASSWORD + ")" + "VALUES(?,?,?,?)";
        PreparedStatement prst = null;

        try {
            prst = getDbConnection().prepareStatement(insert);
            System.out.println(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prst.setString(1, user.getSurname());
            prst.setString(2, user.getLastname());
            prst.setString(3, user.getLogin());
            prst.setString(4, user.getPassword());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        String select = "SELECT * FROM " + ConstUser.USER_TABLE;
        try {
            statement = getDbConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                String surname = resultSet.getString(1);
                String lastname = resultSet.getString(2);
                String login = resultSet.getString(3);
                String password = resultSet.getString(4);
                User user = new User(surname, lastname, login, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
