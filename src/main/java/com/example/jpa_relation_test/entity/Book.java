package com.example.jpa_relation_test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    private Integer stock;

    @ManyToOne
    private BookStore bookStore;

    // 2번문제 답
    public void update(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.stock = book.getStock();
    }

    // 3번문제 답
    public void updateBookStore(BookStore bookStore){
        this.bookStore = bookStore;
    }
}
