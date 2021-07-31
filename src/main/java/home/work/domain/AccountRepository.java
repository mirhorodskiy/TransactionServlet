package home.work.domain;

import home.work.web.model.AccountDetails;
import home.work.web.model.Transaction;

import java.util.List;

public class AccountRepository {

  //ToDo: use these credentials to access the embedded in-memory database. No additional configuration required.
  private static final String JDBC_DRIVER = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:~/test";
  private static final String USERNAME = "sa";
  private static final String PASSWORD = "";

  //ToDo: add implementation to create DB table on application startup
  private void init() {
    String createTableScript = "CREATE TABLE accounts " +
        "(userId VARCHAR(255) not NULL, " +
        "balance INTEGER, " +
        "PRIMARY KEY ( userId ))";
  }

  //ToDo: add implementation to retrieve all available account balances from DB (or empty list if there are no entries)
  public List<AccountDetails> getAllAccountDetails() {
    return null;
  }

  //ToDo: add implementation to add amount from transactionRequest to player balance, or create a new DB entry if
  // userId from transactionRequest not exists in the DB. It should return AccountDetails with updated balance
  public AccountDetails updateBalance(Transaction transactionRequest) {
    return null;
  }

}