package com.example.jpa_relation_test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 문제 1번 해답
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String nickname;

    // 문제 5번 해답
    @ManyToOne
    @JoinColumn(name = "sparta_store_id")
    private BookStore bookStore;

//    @ManyToMany
//    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases = new ArrayList<>();
}
