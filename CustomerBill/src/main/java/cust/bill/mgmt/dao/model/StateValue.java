package cust.bill.mgmt.dao.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public enum StateValue {
  
  NEW("new"),
  
  ONHOLD("onHold"),
  
  VALIDATED("validated"),
  
  SENT("sent"),
  
  PARTIALLYPAID("partiallyPaid"),
  
  SETTLED("settled");

  private String value;

  StateValue(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static StateValue fromValue(String text) {
    for (StateValue b : StateValue.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

