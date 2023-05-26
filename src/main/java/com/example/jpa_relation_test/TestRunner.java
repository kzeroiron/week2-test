package com.example.jpa_relation_test;


import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.entity.Purchase;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {

    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book1 = Book.builder().author("저자").name("첫 번째 책").price(10000).quantity(1L).build();
        Book book2 = Book.builder().author("저자").name("두 번째 책").price(20000).quantity(1L).build();
        BookStore bs = BookStore.builder().name("서점").location("서울").build();
        Member member1 = Member.builder().address("주소1").email("이메일").nickname("닉네임1").password("비밀번호").phoneNumber("전화번호").build();
        Member member2 = Member.builder().address("주소2").email("이메일").nickname("닉네임2").password("비밀번호").phoneNumber("전화번호").build();

        bookRepository.save(book1);
        bookRepository.save(book2);

        bookStoreRepository.save(bs);

        memberRepository.save(member1);
        memberRepository.save(member2);

        book1.updateBookStore(bs);

        bs.addBook(book2);

        member1.updateBookStore(bs);
        member2.updateBookStore(bs);
    }
}
