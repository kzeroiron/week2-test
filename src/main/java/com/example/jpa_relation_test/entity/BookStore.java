package com.example.jpa_relation_test.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String location;

    @Column
    private String name;

    @OneToMany(mappedBy = "bookStore")
    private List<Book> bookList = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "bookStoreId")
//    private List<Member> memberList = new ArrayList<>();

    @Builder
    public BookStore(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

//    public void addMember(Member member){
//        memberList.add(member);
//    }
}
