package com.application.app.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.app.model.Patron;
import com.application.app.repository.PatronRepository;
import com.application.app.service.PatronService;
@Service
public class PatronServiceImpl implements PatronService{

     @Autowired 
     PatronRepository patronRepository;

     public List<Patron> getAllPatron(){
      
        return patronRepository.findAll();
     }

     @Override
     public Patron getById(Long id) {
        return patronRepository.findById(id).orElse(null);
     }

     @Override
     public Patron insert(Patron patron){
        return patronRepository.save(patron);
     }
     @Override
     public Patron save(Patron patron) {
        return patronRepository.save(patron);
     }
     @Override
     public void deleteById(Long id) {
        patronRepository.deleteById(id);
     }
 
 }
 
