package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An applied billing rate has dynamic characteristics according to the its type 
 * (characteristics are based on the service type, line of business or on others parameters)
 */
@ApiModel(description = "An applied billing rate has dynamic characteristics according to the its type "
		+ "(characteristics are based on the service type, line of business or on others parameters)")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")

public class AppliedBillingRateCharacteristic implements Serializable {

	public AppliedBillingRateCharacteristic() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param name
	 * @param value
	 * @param type
	 * @param schemaLocation
	 */
	public AppliedBillingRateCharacteristic(String name, String value, String type, String schemaLocation) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
		this.schemaLocation = schemaLocation;
	}

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public AppliedBillingRateCharacteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Characteristic name
   * @return name
  **/
  @ApiModelProperty(value = "Characteristic name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppliedBillingRateCharacteristic value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value affected to the characteristic
   * @return value
  **/
  @ApiModelProperty(value = "Value affected to the characteristic")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public AppliedBillingRateCharacteristic type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the (class) type of the characteristic
   * @return type
  **/
  @ApiModelProperty(value = "Indicates the (class) type of the characteristic")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AppliedBillingRateCharacteristic schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * Link to the schema describing the REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "Link to the schema describing the REST resource")
  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppliedBillingRateCharacteristic appliedBillingRateCharacteristic = (AppliedBillingRateCharacteristic) o;
    return Objects.equals(this.name, appliedBillingRateCharacteristic.name) &&
        Objects.equals(this.value, appliedBillingRateCharacteristic.value) &&
        Objects.equals(this.type, appliedBillingRateCharacteristic.type) &&
        Objects.equals(this.schemaLocation, appliedBillingRateCharacteristic.schemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, type, schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppliedBillingRateCharacteristic {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

