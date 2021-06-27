package com.segware.javabackendtest.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer upvotes;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Long userId;
}
