package com.example.jpa_relation_test.service;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookStoreRepository bookStoreRepository;

    @Transactional
    public void signup(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public void updateBook(Book book, Long bookStoreId, Long bookId) {
        // 구현
    }
    @Transactional
    public List<Book> findBook(Long bookStoreId) {
        return bookRepository.findByBookStoreId(bookStoreId);
    }

    public void transferBook(Long bookId, Long bookStoreId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow();
        BookStore bookStore = bookStoreRepository.findById(bookStoreId)
                .orElseThrow();
        bookStore.addBook(book);
    }
}
