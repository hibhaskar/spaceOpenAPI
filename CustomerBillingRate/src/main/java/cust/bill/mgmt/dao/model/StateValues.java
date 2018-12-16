package cust.bill.mgmt.dao.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public enum StateValues {
  
  INPROGRESS("inProgress"),
  
  REJECTED("rejected"),
  
  DONE("done"),
  
  TERMINATEDWITHERROR("terminatedWithError");

  private String value;

  StateValues(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static StateValues fromValue(String text) {
    for (StateValues b : StateValues.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

