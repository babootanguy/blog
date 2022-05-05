package mycom.aimar.blog.controllers;

import lombok.RequiredArgsConstructor;
import mycom.aimar.blog.entities.Post;
import mycom.aimar.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller @RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(path = "/")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping(path = "/addpost")
    public String getAddPostPage() {
        return "addpost";
    }

    @PostMapping(path = "/addpost")
    public String addPost(@RequestParam String title, String category, String content, String date) throws ParseException {
        Post post = new Post();
        post.setTitle(title);
        post.setCategory(category);
        post.setContent(content);

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dd = formatter.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(dd.getTime());
        post.setDate(sqlDate);
        postService.addPost(post);
        return "redirect:/";
    }
}
