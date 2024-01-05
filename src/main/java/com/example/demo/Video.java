package com.example.demo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    private String tag;

    private String url;
    private Date uploadDate;

    @OneToMany
    private List<Comment> comments;
}
