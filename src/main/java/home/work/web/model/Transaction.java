package home.work.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Objects;

public class Transaction extends JsonDeserializer {

  private String userId;
  private int amount;

  public Transaction(String userId, int amount) {
    this.userId = userId;
    this.amount = amount;
  }

  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  @JsonProperty("amount")
  public int getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return amount == that.amount && Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, amount);
  }

  @Override
  public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    String userId = node.get("userId").textValue();
    int amount = node.get("amount").intValue();
    return new AccountDetails(userId, amount );
  }
}