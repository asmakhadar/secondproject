package com.niit.collaboration.model;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;
	import org.springframework.stereotype.Component;



	@Entity
	@Component
	@Table(name="c_forum")
	public class Forum extends BaseDomain
	{
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String name;
	
	private String userID;
	
	private String dateTime;	

	private String status;
	
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
