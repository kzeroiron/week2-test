package com.example.jpa_relation_test.controller;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/member")
    public void signup(@RequestBody Member member) {
        testService.signup(member);
    }

    @PutMapping("/bookstore/{bookStoreId}/book/{bookId}")
    public void updateBook(@RequestBody Book book,
                           @PathVariable("bookStoreId") Long bookStoreId,
                           @PathVariable("bookId") Long bookId) {
        testService.updateBook(book, bookStoreId, bookId);
    }

    @GetMapping("/bookstore/{bookStoreId}/book/{bookId}")
    public Book getBook(@PathVariable("bookStoreId") Long bookStoreId,
                        @PathVariable("bookId") Long bookId) {
        return testService.getBook(bookStoreId, bookId);
    }

    @PostMapping("/bookstore/{bookStoreId}/book/{bookId}")
    public void transferBook(@PathVariable("bookId") Long bookId,
                             @PathVariable("bookStoreId") Long bookStoreId) {
        testService.transferBook(bookId, bookStoreId);
    }


}
