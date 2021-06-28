package com.segware.javabackendtest.repository;

import com.segware.javabackendtest.entity.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpvoteRepository extends JpaRepository<Upvote, Long> {
}
