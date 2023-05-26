package com.example.jpa_relation_test.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "bookStoreId")
    private BookStore bookStore;

    @OneToMany(mappedBy = "book")
    private List<Purchase> purchases = new ArrayList<>();


    @Builder
    public Book(String author, String name, Integer price, Long quantity) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void updateBookStore(BookStore bookStore){
        this.bookStore = bookStore;
    }
}
