package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * Attachment refers to extensions or additional parts that is or may be attached to something 
 * (agreements, contracts, appointments) to perform a particular function. 
 * They can be communication attachments, documents and other.
 */

public class Attachment {

	private String id = null;

	private String href = null;

	private String name = null;

	private String description = null;

	private String mimeType = null;

	private String sizeUnit = null;

	private Float size = null;

	private String url = null;

	private String type = null;

	private String schemaLocation = null;
	
	/**
	 * @param oDAOAttachment
	 *//*
	public Attachment(cust.bill.mgmt.dao.model.Attachment oDAOAttachment) {
		super();
		this.id = new String(oDAOAttachment.getId());
		this.href = new String(oDAOAttachment.getHref());
		this.name = new String(oDAOAttachment.getName());
		this.description = new String(oDAOAttachment.getDescription());
		this.mimeType = new String(oDAOAttachment.getMimeType());
		this.sizeUnit = new String(oDAOAttachment.getSizeUnit());
		this.size = new Float(oDAOAttachment.getSize());
		this.url = new String(oDAOAttachment.getUrl());
		this.type = new String(oDAOAttachment.getType());
		this.schemaLocation = new String(oDAOAttachment.getSchemaLocation());
	}*/

	/**
	 * @param id
	 * @param href
	 * @param name
	 * @param description
	 * @param mimeType
	 * @param sizeUnit
	 * @param size
	 * @param url
	 * @param type
	 * @param schemaLocation
	 */
	public Attachment(String id, String href, String name, String description, String mimeType, String sizeUnit,
			Float size, String url, String type, String schemaLocation) {
		super();
		this.id = id;
		this.href = href;
		this.name = name;
		this.description = description;
		this.mimeType = mimeType;
		this.sizeUnit = sizeUnit;
		this.size = size;
		this.url = url;
		this.type = type;
		this.schemaLocation = schemaLocation;
	}

	public Attachment id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the attachment
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Attachment href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the attachment
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Attachment name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the attachment
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attachment description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Free short description of the attachment
	 * @return description
	 **/
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Attachment mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Mime type of the attachment
	 * @return mimeType
	 **/
	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Attachment sizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
		return this;
	}

	/**
	 * Size unit (in bytes by default)
	 * @return sizeUnit
	 **/
	public String getSizeUnit() {
		return sizeUnit;
	}

	public void setSizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
	}

	public Attachment size(Float size) {
		this.size = size;
		return this;
	}

	/**
	 * The size  in Bytes of the document or attachment
	 * @return size
	 **/
	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public Attachment url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * URL of the attachment
	 * @return url
	 **/
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Attachment type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of attachment
	 * @return type
	 **/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Attachment schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * Link to the schema describing the REST resource
	 * @return schemaLocation
	 **/
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
		Attachment attachment = (Attachment) o;
		
		return Objects.equals(this.id, attachment.id) &&
				Objects.equals(this.href, attachment.href) &&
				Objects.equals(this.name, attachment.name) &&
				Objects.equals(this.description, attachment.description) &&
				Objects.equals(this.mimeType, attachment.mimeType) &&
				Objects.equals(this.sizeUnit, attachment.sizeUnit) &&
				Objects.equals(this.size, attachment.size) &&
				Objects.equals(this.url, attachment.url) &&
				Objects.equals(this.type, attachment.type) &&
				Objects.equals(this.schemaLocation, attachment.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, description, mimeType, sizeUnit, size, url, type, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Attachment {\n");
    
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("    sizeUnit: ").append(toIndentedString(sizeUnit)).append("\n");
		sb.append("    size: ").append(toIndentedString(size)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
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