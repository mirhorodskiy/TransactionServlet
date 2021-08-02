package home.work.domain;

import home.work.web.model.AccountDetails;
import home.work.web.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

  //ToDo: use these credentials to access the embedded in-memory database. No additional configuration required.
  private static final String JDBC_DRIVER = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:~/test";
  private static final String USERNAME = "sa";
  private static final String PASSWORD = "";

  private static final String PREPARED_STATEMENT = "INSERT INTO accounts(userId, balance) VALUES (?, ?)";

  public AccountRepository() {
    this.init();
  }

  //ToDo: add implementation to create DB table on application startup
  private void init() {
    String createTableScript = "CREATE TABLE IF NOT EXISTS accounts " +
        "(userId VARCHAR(255) not NULL, " +
        "balance INTEGER, " +
        "PRIMARY KEY ( userId ))";
    Connection connection = getConnection();
    try {
      connection.createStatement().execute("DROP ALL OBJECTS");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    executeQuery(connection, createTableScript);
  }

  private void executeQuery(Connection connection, String sql) {
    try {
      connection.createStatement().execute(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  private Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//      if (connection == null) {
//        throw new SQLException("Connection error");
//      }
//      else {
//        return connection;
//      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return connection;
  }

  @Deprecated
  public void checkConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
      if (connection == null) {
        System.out.println("Error connection");
      }
      else
        System.out.println("Connection");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  //ToDo: add implementation to retrieve all available account balances from DB (or empty list if there are no entries)
  public List<AccountDetails> getAllAccountDetails() {
    List<AccountDetails> accountDetails = new ArrayList<>();
    try {
      Connection connection = getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
      while (resultSet.next()) {
        String userId = resultSet.getString("userId");
        int balance = resultSet.getInt("balance");
        accountDetails.add(new AccountDetails(userId, balance));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return accountDetails;
  }

  @Deprecated
  public void addAccount(String userId, int balance) {
    try {
      Connection conn = getConnection();
      //Statement statement = conn.createStatement();
      PreparedStatement preparedStatement = conn.prepareStatement(PREPARED_STATEMENT);
      preparedStatement.setString(1, userId);
      preparedStatement.setInt(2, balance);
      preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //ToDo: add implementation to add amount from transactionRequest to player balance, or create a new DB entry if
  // userId from transactionRequest not exists in the DB. It should return AccountDetails with updated balance
  public AccountDetails updateBalance(Transaction transactionRequest) {
    int tmpBalance = 0;

    return null;
  }

}