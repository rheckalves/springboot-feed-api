package com.segware.javabackendtest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "\"upvote\"")
public class Upvote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
