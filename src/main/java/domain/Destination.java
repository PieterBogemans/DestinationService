package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Destination {
	private String City; 
	private int postcode;
	private String description;
	public String getCity() {
		return City;
	}
	
	public Destination(String name, int postcode, String description) {
		setCity(name);
		setPostcode(postcode);
		setDescription(description);
	}
	public void setCity(String city) {
		City = city;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
