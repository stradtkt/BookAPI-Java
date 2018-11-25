package com.codingdojo.springmysql.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 200)
    private String title;
    @Size(min = 5, max = 200)
    private String description;
    @Size(min = 3, max = 40)
    private String language;
    @Min(100)
    private Integer numberOfPages;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    public Book() {

    }
    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
