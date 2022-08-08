package MODEL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Post")
@Table(name = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post implements java.io.Serializable{
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String title;
 
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
              fetch = FetchType.EAGER, optional = false)
    @JsonManagedReference
    private PostDetails details;
 
  
    public Post(String title) {
		super();
		this.title = title;
	}


	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id; 
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post(String title, PostDetails details) {
		super();
		this.title = title;
		this.details = details;
	}

    public String getTitle() {
		return title;
	}


public void setTitle(String title) {
		this.title = title;
	}

public PostDetails getDetails() {
		return details;
	}

	public void setDetails(PostDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setPost(null);
            }
        }
        else {
            details.setPost(this);
        }
        this.details = details;
    }
}