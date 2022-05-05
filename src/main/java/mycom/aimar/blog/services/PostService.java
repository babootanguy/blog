package mycom.aimar.blog.services;

import lombok.RequiredArgsConstructor;
import mycom.aimar.blog.entities.Post;
import mycom.aimar.blog.entities.User;
import mycom.aimar.blog.repos.PostRepo;
import mycom.aimar.blog.repos.UserRepo;
import mycom.aimar.blog.services.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public void addPost(Post post) {
        // test
        post.setUser(userRepo.findByEmail("testtest@gmail.com"));
        postRepo.save(post);
    }
}
