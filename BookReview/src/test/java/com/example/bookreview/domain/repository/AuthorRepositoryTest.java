package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Author;
import com.example.bookreview.domain.entity.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book saveBook(String name) {
        Book book = new Book();
        book.setName(name);
        return bookRepository.save(book);
    }

    private Author saveAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @Test
    void manyToManyTest() {
        Book[] books = {saveBook("B1"), saveBook("B2"), saveBook("B3")};
        Author chan = saveAuthor("Chan");
        Author jong = saveAuthor("jong");


        books[0].addAuthor(chan);
        books[1].addAuthor(jong);
        books[2].addAuthor(chan, jong);

        chan.addBook(books[0], books[1], books[2]);
        jong.addBook(books[1], books[2]);

        bookRepository.saveAll(Arrays.asList(books));
        authorRepository.saveAll(Lists.newArrayList(chan, jong));

        bookRepository.findAll().forEach(book ->
                System.out.println(book.getAuthors())
        );

        authorRepository.findAll().forEach(author ->
                System.out.println(author.getBooks())
        );
    }

}