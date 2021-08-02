package home.work.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import home.work.domain.AccountRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//ToDo: make this class a servlet
@WebServlet("/balance")
public class AccountBalanceServlet extends HttpServlet {

  private AccountRepository accountRepository;
  private ObjectMapper objectMapper;

  //ToDo: initialize servlet's dependencies
  public void init() {
    accountRepository = new AccountRepository();
  }

  //ToDo: implement "get" method that will return all available user balances.
  // Check accountRepository to see what DB communication methods can be used
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String responseBody = accountRepository.getAllAccountDetails().toString();
    resp.getWriter().write(responseBody);
  }

  //ToDo: implement "post" method that will update account balance.
  // Check accountRepository to see what DB communication methods can be used
  public void doPost(HttpServletRequest req, HttpServletResponse resp) {
  }

}