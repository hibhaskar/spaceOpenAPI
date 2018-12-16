package cust.bill.mgmt.bus.model;

/**
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
  public String toString() {
    return String.valueOf(value);
  }

  public static StateValues fromValue(String text) {
    for (StateValues b : StateValues.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

}