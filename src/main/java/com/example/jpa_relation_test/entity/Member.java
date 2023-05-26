package com.example.jpa_relation_test.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "bookStoreId")
    private BookStore bookStore;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases = new ArrayList<>();

    @Builder
    public Member(String address, String email, String nickname, String password, String phoneNumber) {
        this.address = address;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void updateBookStore(BookStore bookStore){
        this.bookStore = bookStore;
    }
}
