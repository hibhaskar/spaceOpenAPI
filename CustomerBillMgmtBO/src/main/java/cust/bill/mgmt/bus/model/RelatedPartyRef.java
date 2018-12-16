package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * RelatedParty reference. A related party defines party or party role linked to a specific entity.
 */
public class RelatedPartyRef {
	
	private String id = null;
	
	private String href = null;
	
	private String name = null;
	
	private String role = null;
	
	private String type = null;

	/**
	 * @param id
	 * @param href
	 * @param name
	 * @param role
	 * @param type
	 */
	public RelatedPartyRef(String id, String href, String name, String role, String type) {
		super();
		this.id = id;
		this.href = href;
		this.name = name;
		this.role = role;
		this.type = type;
	}
	
	/**
	 * @param oRelatedPartyRef
	 *//*
	public RelatedPartyRef(cust.bill.mgmt.dao.model.RelatedPartyRef oRelatedPartyRef) {
		super();
		this.id = new String(oRelatedPartyRef.getId());
		this.href = new String(oRelatedPartyRef.getHref());
		this.name = new String(oRelatedPartyRef.getName());
		this.role = new String(oRelatedPartyRef.getRole());
		this.type = new String(oRelatedPartyRef.getType());
	}*/

	public RelatedPartyRef id(String id) {
	   this.id = id;
	   return this;
	}

	/**
	 * Unique identifier of a related party
	 * @return id
	**/
	public String getId() {
	  return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RelatedPartyRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the related party
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public RelatedPartyRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Related party name
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RelatedPartyRef role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Role played by the related party
	 * @return role
	 **/
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RelatedPartyRef type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of related party
	 * @return type
	 **/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
	
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RelatedPartyRef relatedPartyRef = (RelatedPartyRef) o;
		
		return Objects.equals(this.id, relatedPartyRef.id) &&
	        Objects.equals(this.href, relatedPartyRef.href) &&
	        Objects.equals(this.name, relatedPartyRef.name) &&
	        Objects.equals(this.role, relatedPartyRef.role) &&
	        Objects.equals(this.type, relatedPartyRef.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, role, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RelatedPartyRef {\n");
    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    href: ").append(toIndentedString(href)).append("\n");
	    sb.append("    name: ").append(toIndentedString(name)).append("\n");
	    sb.append("    role: ").append(toIndentedString(role)).append("\n");
	    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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