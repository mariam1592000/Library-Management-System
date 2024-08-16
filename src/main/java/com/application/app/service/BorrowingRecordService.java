package com.application.app.service;

import java.util.Optional;

import com.application.app.model.BorrowingRecord;

public interface BorrowingRecordService {

   public BorrowingRecord borrowingRecord(Long bookId, Long patronId);
   public Optional<BorrowingRecord> returningRecord(Long bookId, Long patronId);
   
}
