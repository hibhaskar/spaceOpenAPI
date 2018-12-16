package cust.bill.mgmt.bus.model;

import java.util.Objects;

public class CustomerBillUpdate {
	
  private StateValue state = null;

  public CustomerBillUpdate state(StateValue state) {
    this.state = state;
    return this;
  }

  /**
   * @return state
  **/
  public StateValue getState() {
    return state;
  }

  public void setState(StateValue state) {
    this.state = state;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerBillUpdate customerBillUpdate = (CustomerBillUpdate) o;
    return Objects.equals(this.state, customerBillUpdate.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerBillUpdate {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
  
    return o.toString().replace("\n", "\n    ");
  }
  
}