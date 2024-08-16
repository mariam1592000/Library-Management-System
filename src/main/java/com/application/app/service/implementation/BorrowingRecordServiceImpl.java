package com.application.app.service.implementation;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.app.Common.CommonConstants.BookStatus;
import com.application.app.model.Book;
import com.application.app.model.BorrowingRecord;
import com.application.app.model.Patron;
import com.application.app.repository.BorrowingRecordRepository;
import com.application.app.service.BookService;
import com.application.app.service.BorrowingRecordService;
import com.application.app.service.PatronService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService{

    @Autowired 
    BorrowingRecordRepository borrowingRecordRepository;

    @Autowired 
    BookService bookService;

    @Autowired 
    PatronService patronService;
    @Override
    public BorrowingRecord borrowingRecord(Long bookId, Long patronId) {
        validateTransaction(bookId, patronId);

        BorrowingRecord borrow = new BorrowingRecord();
        borrow.setBookId(bookId);
        borrow.setPatronId(patronId);
        borrow.setBorrowingDate(LocalDate.now());
        borrow.setReturnDate(null);

        return borrowingRecordRepository.save(borrow);
    }

    @Override
    public Optional<BorrowingRecord> returningRecord(Long bookId, Long patronId) {

        validateTransaction(bookId, patronId);

        Optional<BorrowingRecord> borrow = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);
        BorrowingRecord borrowTmp = borrow.get();
        if(borrow.isPresent())
        {
            borrowTmp.setStatus(BookStatus.returned);
            borrowTmp.setReturnDate(LocalDate.now());
            borrowingRecordRepository.save(borrowTmp);
        }
        
        return borrow;
    }

    public void validateTransaction(Long bookId, Long patronId) {
        Book book = bookService.getById(bookId);
        if(book == null)
            throw new EntityNotFoundException("Book not found");
        Patron patron = patronService.getById(patronId);
        if(patron == null)
            throw new EntityNotFoundException("Patron not found");

    }
}
