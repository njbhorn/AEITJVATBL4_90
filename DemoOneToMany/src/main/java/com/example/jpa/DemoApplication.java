package com.example.jpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of categories
        final BookCategory categoryA = new BookCategory("Category A");
        Set<Book> bookAs = new HashSet<>();
        bookAs.add(new Book("Book A1", categoryA));
        bookAs.add(new Book("Book A2", categoryA));
        bookAs.add(new Book("Book A3", categoryA));
        categoryA.setBooks(bookAs);

        final BookCategory categoryB = new BookCategory("Category B");
        Set<Book> bookBs = new HashSet<>();
        bookBs.add(new Book("Book B1", categoryB));
        bookBs.add(new Book("Book B2", categoryB));
        bookBs.add(new Book("Book B3", categoryB));
        categoryB.setBooks(bookBs);

        bookCategoryRepository.saveAll(Arrays.asList(categoryA, categoryB));

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            logger.info(bookCategory.toString());
        }
    }
}
