package com.application.app.service;
import java.util.List;
import com.application.app.model.Patron;

public interface PatronService{

    public List<Patron> getAllPatron();
    public Patron getById(Long id);
        public Patron insert(Patron patron);
    public Patron save(Patron patron);
    public void deleteById(Long id);
}
