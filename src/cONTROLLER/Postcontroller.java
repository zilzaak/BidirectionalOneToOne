package cONTROLLER;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import basati.model.Post;
import basati.model.PostDetails;
import basati.repo.Postcommentrepo;
import basati.repo.Postrepo;

@Controller
@RequestMapping("/post")
public class Postcontroller {

	@Autowired
	private Postrepo prr;
	@Autowired
	private Postcommentrepo pcr;
	
	
	@RequestMapping("/add")	
	public String addpost() {
		
Post k=new Post();
PostDetails pd = new PostDetails();
pd.setCreatedBy("tevez");
pd.setCreatedOn(new Date());
k.setTitle("title 1");
k.setDetails(pd);
pd.setPost(k);
prr.save(k);
	return "post";
	}
	
		
@GetMapping("/allpost")	
	public ResponseEntity<List<Post>> allpost() {
	List<Post> posts=prr.findAll();
	return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);

	}


	
	
}
