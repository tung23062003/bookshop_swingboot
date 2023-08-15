package com.group7.bookshopwebsite.entity;

<<<<<<< HEAD
public class User {

}
=======
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToMany
    @JoinTable(name = "favorite_items",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> favoriteBooks;


    public void addFavoriteBook(Book book) {
        Set<Book> favoriteBooks = this.getFavoriteBooks();
        if (favoriteBooks == null) {
            favoriteBooks = new HashSet<>();
        }
        favoriteBooks.add(book);
        this.setFavoriteBooks(favoriteBooks);
    }

    public  void removeFavoriteBook( Book book) {
        if (this.favoriteBooks != null) {
            this.favoriteBooks.remove(book);
        }
    }
}

>>>>>>> e515bdc9a7d1e99d69b8dc9701f4b60d8765487b
