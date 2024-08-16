package com.application.app.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.application.app.Common.CommonConstants.APIPathMapping;
import com.application.app.model.BorrowingRecord;
import com.application.app.service.BorrowingRecordService;

@RestController
//@RequestMapping(APIPathMapping.APIV1)
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService; 

    @RequestMapping(value = APIPathMapping.BorrowingRecord, method = RequestMethod.POST)
    BorrowingRecord borrowingRecord(@PathVariable(value = "bookId") Long bookId , 
                                    @PathVariable(value = "patronId") Long patronId) {
        
        return borrowingRecordService.borrowingRecord(bookId,patronId);
    }

    @RequestMapping(value = APIPathMapping.ReturningRecord, method = RequestMethod.PUT)
    Optional<BorrowingRecord> returnRecord(@PathVariable(value = "bookId") Long bookId , 
                                 @PathVariable(value = "patronId") Long patronId) {
        
        return borrowingRecordService.returningRecord(bookId,patronId);
    }
}
