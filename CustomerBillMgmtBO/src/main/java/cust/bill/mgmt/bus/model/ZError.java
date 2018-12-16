package cust.bill.mgmt.bus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 */
public class ZError   {

  private Integer code = null;

  private String message = null;

  private String description = null;

  private String infoURL = null;

  private List<ZErrorDetail> details = null;

  public ZError code(Integer code) {
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

  public ZError message(String message) {
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

  public ZError description(String description) {
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

  public ZError infoURL(String infoURL) {
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

  public ZError details(List<ZErrorDetail> details) {
    this.details = details;
    return this;
  }

  public ZError addDetailsItem(ZErrorDetail detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * @return details
  **/
  public List<ZErrorDetail> getDetails() {
    return details;
  }

  public void setDetails(List<ZErrorDetail> details) {
    this.details = details;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZError zerror = (ZError) o;
    return Objects.equals(this.code, zerror.code) &&
        Objects.equals(this.message, zerror.message) &&
        Objects.equals(this.description, zerror.description) &&
        Objects.equals(this.infoURL, zerror.infoURL) &&
        Objects.equals(this.details, zerror.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, description, infoURL, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    infoURL: ").append(toIndentedString(infoURL)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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