package cust.bill.mgmt.bus.model;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A business entity used to represent a period between a start and an end date and time
 */
public class TimePeriod {
	
	private OffsetDateTime startDateTime = null;
  
  	private OffsetDateTime endDateTime = null;
  
	/**
	 * @param startDateTime
	 * @param endDateTime
	 *//*
	public TimePeriod(cust.bill.mgmt.dao.model.TimePeriod oTimePeriod) {
		super();
		this.startDateTime = OffsetDateTime.parse(oTimePeriod.getStartDateTime()+"");
		this.endDateTime = OffsetDateTime.parse(oTimePeriod.getEndDateTime()+"");
	}*/
	
  	/**
	 * @param startDateTime
	 * @param endDateTime
	 */
	public TimePeriod(OffsetDateTime startDateTime, OffsetDateTime endDateTime) {
		super();
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}
		
	public TimePeriod startDateTime(OffsetDateTime startDateTime) {
	    this.startDateTime = startDateTime;
	    return this;
	}

	/**
	 * Start date and time of the period
	 * @return startDateTime
	 **/
	public OffsetDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public TimePeriod endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	/**
	 * End date and time of the period
	 * @return endDateTime
	 **/
	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TimePeriod timePeriod = (TimePeriod) o;
		return Objects.equals(this.startDateTime, timePeriod.startDateTime) &&
				Objects.equals(this.endDateTime, timePeriod.endDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startDateTime, endDateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TimePeriod {\n");
    
	    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
	    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
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