package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.entity.Blog;
import project.entity.Comment;
import project.entity.User;
import project.repository.BlogRepository;
import project.repository.CommentRepository;
import project.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CommentRepository commentRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{email}")
    public User getUser(@PathVariable String email) {
        return (User) userRepository.findUserByEmail(email);
    }
    
    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    @PostMapping("/blog")
    void addBlog(@RequestBody Blog blog) {
        blogRepository.save(blog);
    }
    
    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }
    
    @PostMapping("/comment")
    void addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
    }
    @GetMapping("/comments/{blogId}")
    public List<Comment> getComments(@PathVariable long blogId) {
        return (List<Comment >) commentRepository.findCommentsByBlog(blogId);
    }
    
}
