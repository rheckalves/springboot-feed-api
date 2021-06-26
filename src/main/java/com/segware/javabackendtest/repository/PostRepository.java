package com.segware.javabackendtest.repository;
import com.segware.javabackendtest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}
