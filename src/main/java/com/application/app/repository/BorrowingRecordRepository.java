package com.application.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application.app.model.BorrowingRecord;

@Repository
public interface BorrowingRecordRepository extends JpaRepository <BorrowingRecord , Long> , BorrowingRecordRepositoryCustom{

}
