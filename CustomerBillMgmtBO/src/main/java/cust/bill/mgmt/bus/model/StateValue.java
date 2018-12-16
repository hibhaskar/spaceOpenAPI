package cust.bill.mgmt.bus.model;

/**
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
  public String toString() {
    return String.valueOf(value);
  }

  public static StateValue fromValue(String text) {
    for (StateValue b : StateValue.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    
    return null;
  }
  
}