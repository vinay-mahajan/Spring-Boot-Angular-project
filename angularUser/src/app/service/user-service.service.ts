import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Blog } from '../model/blog';
import { Comment } from '../model/comment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080';
   }

  // User services
  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}/users`);
  }
  public saveUser(user: User) {
    return this.http.post<User>(`${this.baseUrl}/user`, user).toPromise();
  }
  public findUser(user: User): Observable<User> {
    return this.http.get<User>(this.baseUrl+`/users/${user.email}`);
  }

  // Blog services
  public saveBlog(blog: Blog) {
    return this.http.post<User>(`${this.baseUrl}/blog`, blog).toPromise();
  }
  public findAllBlogs(): Observable<Blog[]> {
    return this.http.get<Blog[]>(`${this.baseUrl}/blogs`);
  }

  // Comment services
  public saveComment(comment: Comment) {
    return this.http.post<User>(`${this.baseUrl}/comment`, comment).toPromise();
  }
  public findComments(blog: Blog): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.baseUrl}/comments/${blog.id}`);
  }
}
