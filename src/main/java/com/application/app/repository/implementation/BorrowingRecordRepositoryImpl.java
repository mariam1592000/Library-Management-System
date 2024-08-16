package com.application.app.repository.implementation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.app.model.BorrowingRecord;
import com.application.app.repository.BorrowingRecordRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class BorrowingRecordRepositoryImpl implements BorrowingRecordRepositoryCustom{

     @PersistenceContext
    private EntityManager entityManager;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Optional<BorrowingRecord> findByBookIdAndPatronId(Long bookId, Long patronId) {
        
        logger.debug("Book ID with id= {}.", bookId);
        String jpql = "SELECT br FROM BorrowingRecord br WHERE br.bookId = :bookId AND br.patronId = :patronId";
        TypedQuery<BorrowingRecord> query = entityManager.createQuery(jpql, BorrowingRecord.class);
        query.setParameter("bookId", bookId);
        query.setParameter("patronId", patronId);
        logger.debug("query.getResultList()", query.getResultList());
        return query.getResultList().stream().findFirst();
    }

}
