import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Blog } from '../model/blog';
import { Comment } from '../model/comment';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-user-blog',
  templateUrl: './user-blog.component.html',
  styleUrls: ['./user-blog.component.css']
})
export class UserBlogComponent implements OnInit {

  blog: Blog;
  blogs: Blog[];
  comment: Comment;
  comments: Comment[];
  blogsExist: boolean;
  commentsExist: boolean;
  loggedOut: boolean;

  constructor(
    private userService: UserService,
    private router: Router
  ) {
    this.blog = new Blog();
    this.blogs = [];
    this.comment = new Comment();
    this.comments = [];
    this.blogsExist = false;
    this.commentsExist = false;
    this.loggedOut = false;
  }

  ngOnInit(): void {
  }

  getBlogs(): boolean {
    this.userService.findAllBlogs().toPromise().then(v => this.blogs = v);
    if (this.blogs.length !== 0)
      this.blogsExist = true;
    return this.blogsExist;
  }

  getComments(): boolean {
    this.userService.findComments(this.blog).toPromise().then(v => this.comments = v);
    if (this.comments.length !== 0)
      this.commentsExist = true;
    return this.commentsExist;
  }

  onBlog(): void {
    this.blog.timestamp = new Date().toLocaleDateString();
    this.blog.userId = Number(sessionStorage.getItem('userId'));
    this.userService.saveBlog(this.blog);
    this.getBlogs();
  }

  onComment(blogId: any): void {
    this.comment.timestamp = new Date().toLocaleDateString();
    this.comment.blogId = blogId;
    this.comment.userId = Number(sessionStorage.getItem('userId'));
    this.userService.saveComment(this.comment);
  }

  logout(): void {
    this.loggedOut = true;
    this.router.navigate(['../login']);
    sessionStorage.clear();
  }

}
