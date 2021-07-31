package home.work.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import home.work.domain.AccountRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ToDo: make this class a servlet
public class AccountBalanceServlet {

  private AccountRepository accountRepository;
  private ObjectMapper objectMapper;

  //ToDo: initialize servlet's dependencies
  public void init() {
  }

  //ToDo: implement "get" method that will return all available user balances.
  // Check accountRepository to see what DB communication methods can be used
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
  }

  //ToDo: implement "post" method that will update account balance.
  // Check accountRepository to see what DB communication methods can be used
  public void doPost(HttpServletRequest req, HttpServletResponse resp) {
  }

}