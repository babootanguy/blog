package mycom.aimar.blog.services.interfaces;

import mycom.aimar.blog.entities.Post;

import java.util.List;

public interface IPostService {

    List<Post> getPosts();

    void addPost(Post post);
}
