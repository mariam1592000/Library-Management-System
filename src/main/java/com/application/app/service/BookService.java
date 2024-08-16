package com.application.app.service;
import java.util.List;

import com.application.app.model.Book;

public interface BookService {

    public List<Book> getAllBooks();
    public Book getById(Long id);
    public Book insert(Book book);
    public Book save(Book book);
    public void deleteById(Long id);
}
