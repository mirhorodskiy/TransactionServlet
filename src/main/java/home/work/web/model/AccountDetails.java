package home.work.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;
@JsonDeserialize(using = Transaction.class)
public class AccountDetails {

  private String userId;
  private int balance;

  public AccountDetails(String userId, int balance) {
    this.userId = userId;
    this.balance = balance;
  }

  public AccountDetails() {
  }

  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  @JsonProperty("balance")
  public int getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountDetails that = (AccountDetails) o;
    return balance == that.balance && Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, balance);
  }

}