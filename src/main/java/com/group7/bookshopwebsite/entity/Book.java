package com.group7.bookshopwebsite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;

    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "original_price")
    private Double originalPrice;

    @Column(name = "sale_price")
    private Double salePrice;

    private Integer qty;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Lob
    @Column(nullable = false, length = 1000)
    private String description;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "buy_count")
    private Integer buyCount;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToMany(mappedBy = "favoriteBooks")
    private Set<User> usersWhoFavorited;

    public void addUser(User user) {
        Set<User> users = this.getUsersWhoFavorited();
        if (usersWhoFavorited == null) {
            usersWhoFavorited = new HashSet<>();
        }
        usersWhoFavorited.add(user);
        this.setUsersWhoFavorited(users);
    }

    public  void removeUserWhoFavorited( User user) {
        if (this.usersWhoFavorited != null) {
            this.usersWhoFavorited.remove(user);
        }
    }
}