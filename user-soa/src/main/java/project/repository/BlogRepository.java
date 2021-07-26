package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{ }
