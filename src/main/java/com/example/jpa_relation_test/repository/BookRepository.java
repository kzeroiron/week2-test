package com.example.jpa_relation_test.repository;

import com.example.jpa_relation_test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookStoreIdAndId(Long bookStoreId, Long bookId);
}
