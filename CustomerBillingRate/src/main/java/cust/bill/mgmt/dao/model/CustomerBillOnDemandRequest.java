package cust.bill.mgmt.dao.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")

public class CustomerBillOnDemandRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("billingAccount")
  private BillingAccountRef billingAccount = null;

  @JsonProperty("relatedParty")
  private RelatedPartyRef relatedParty = null;

  public CustomerBillOnDemandRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Friendly name to identify the customer bill on demand request
   * @return name
  **/
  @ApiModelProperty(value = "Friendly name to identify the customer bill on demand request")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerBillOnDemandRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Additional data describing the customer bill on demand request
   * @return description
  **/
  @ApiModelProperty(value = "Additional data describing the customer bill on demand request")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CustomerBillOnDemandRequest billingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Reference of the billing account that produces the customer bill on demand
   * @return billingAccount
  **/
  @ApiModelProperty(value = "Reference of the billing account that produces the customer bill on demand")

  @Valid

  public BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  public CustomerBillOnDemandRequest relatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  /**
   * A related party for which the customer bill on demand is requested
   * @return relatedParty
  **/
  @ApiModelProperty(value = "A related party for which the customer bill on demand is requested")

  @Valid

  public RelatedPartyRef getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerBillOnDemandRequest customerBillOnDemandRequest = (CustomerBillOnDemandRequest) o;
    return Objects.equals(this.name, customerBillOnDemandRequest.name) &&
        Objects.equals(this.description, customerBillOnDemandRequest.description) &&
        Objects.equals(this.billingAccount, customerBillOnDemandRequest.billingAccount) &&
        Objects.equals(this.relatedParty, customerBillOnDemandRequest.relatedParty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, billingAccount, relatedParty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerBillOnDemandRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

