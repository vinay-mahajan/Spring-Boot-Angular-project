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
@Table(name="COMMENT")
public class Comment {

	@Id
	@Column(name="COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@Column(name="COMMENT_TEXT")
	private String text;
    
    @Column(name="COMMENT_TIMESTAMP")
    private String timestamp;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "BLOG_ID")
    private Blog blogId;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User userId;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Blog getBlogId() {
		return blogId;
	}
	public void setBlogId(Blog blogId) {
		this.blogId = blogId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", timestamp=" + timestamp + ", blogId=" + blogId + ", userId="
				+ userId + "]";
	}
}
