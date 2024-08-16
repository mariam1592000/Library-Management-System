package com.application.app.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.application.app.model.BorrowingRecord;

@Repository
public interface BorrowingRecordRepositoryCustom{

    public Optional<BorrowingRecord> findByBookIdAndPatronId(Long bookId , Long PatronId);

}
