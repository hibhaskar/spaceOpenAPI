package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 */
public class ZErrorDetail   {

  private Integer code = null;

  private String message = null;

  private String description = null;

  private String infoURL = null;

  public ZErrorDetail code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * @return code
  **/
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ZErrorDetail message(String message) {
    this.message = message;
    return this;
  }

  /**
   * @return message
  **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ZErrorDetail description(String description) {
    this.description = description;
    return this;
  }

  /**
   * @return description
  **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ZErrorDetail infoURL(String infoURL) {
    this.infoURL = infoURL;
    return this;
  }

  /**
   * @return infoURL
  **/
  public String getInfoURL() {
    return infoURL;
  }

  public void setInfoURL(String infoURL) {
    this.infoURL = infoURL;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZErrorDetail zerrorDetail = (ZErrorDetail) o;
    return Objects.equals(this.code, zerrorDetail.code) &&
        Objects.equals(this.message, zerrorDetail.message) &&
        Objects.equals(this.description, zerrorDetail.description) &&
        Objects.equals(this.infoURL, zerrorDetail.infoURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, description, infoURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZErrorDetail {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    infoURL: ").append(toIndentedString(infoURL)).append("\n");
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