package project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BLOG")
public class Blog {

	@Id
	@Column(name="BLOG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="BLOG_TITLE")
    private String title;
	
	@Column(name="BLOG_DESCRIPTION")
    private String description;
	
	@Column(name="BLOG_IMAGE")
    private String image;
	
	@Column(name="BLOG_TIMESTAMP")
    private String timestamp;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private long userId;
    
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", timestamp=" + timestamp + ", userId=" + userId + "]";
	}
	
}
