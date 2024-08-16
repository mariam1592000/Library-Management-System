package com.application.app.controller;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.application.app.Common.CommonConstants.APIPathMapping;
import com.application.app.model.Book;
import com.application.app.service.BookService;

import jakarta.persistence.EntityNotFoundException;

import org.slf4j.Logger;

@RestController
@RequestMapping(APIPathMapping.Books)
public class BookController  {
    @Autowired
    private BookService bookService; 
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @RequestMapping( method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        
        return bookService.getAllBooks();
    }
    @RequestMapping(value = APIPathMapping.GetById,method = RequestMethod.GET)
    public Book getById(@PathVariable(value = "id") Long id) {
        
        return bookService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
	public Book create(@RequestBody Book entity) {
		logger.debug("Saving Book.");

		Book result = bookService.insert(entity);
		return result;
	}
    @RequestMapping(value = APIPathMapping.GetById,method = RequestMethod.PUT)
	public Book update(@PathVariable(value = "id") Long id, @RequestBody Book entityUpdate) {

		Book entity = bookService.getById(entityUpdate.getId());
		if (entity==null)
        	throw new UnsupportedOperationException("This Book does not exist");

        Book result = bookService.save(entityUpdate);
		return result;
	}
@RequestMapping(value = APIPathMapping.GetById, method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		logger.debug("Deleting Book with id= {}.", id);
		Book entity = bookService.getById(id);
		if (entity == null)
			throw new EntityNotFoundException("The Book entity is not found");
        
        bookService.deleteById(id);
		return"Book record for id= " + id + " deleted.";
	}
    
}