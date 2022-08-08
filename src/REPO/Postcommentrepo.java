package REPO;

import org.springframework.data.jpa.repository.JpaRepository;

import basati.model.PostDetails;


public interface Postcommentrepo extends JpaRepository<PostDetails,Long> {

}
