package com.application.app.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.application.app.Common.CommonConstants.APIPathMapping;
import com.application.app.model.Patron;
import com.application.app.service.PatronService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(APIPathMapping.Patrons)
public class PatronController {
    @Autowired
    private PatronService patronService; 
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping( method = RequestMethod.GET)
    public List<Patron> getAllPatron() {
        return patronService.getAllPatron();
    }

    @RequestMapping(value = APIPathMapping.GetById, method = RequestMethod.GET)
    public Patron getById(@PathVariable(value = "id") Long id) {

        return patronService.getById(id);
    }
 @RequestMapping(method = RequestMethod.POST)
	public Patron create(@RequestBody Patron entity) {
		logger.debug("Saving EmployeeSurvey.");
		Patron result = patronService.insert(entity);
		return result;
	}
    

    @RequestMapping(value = APIPathMapping.GetById,method = RequestMethod.PUT)
	public Patron update(@PathVariable(value = "id") Long id, @RequestBody Patron entityUpdate) {

		Patron entity = patronService.getById(id);
		if (entity == null)
        throw new EntityNotFoundException("This object does not exist");

        Patron result = patronService.save(entityUpdate);
		return result;
	}
@RequestMapping(value = APIPathMapping.GetById, method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		logger.debug("Deleting Patron with id= {}.", id);
		Patron entity = patronService.getById(id);
		if (entity == null)
			throw new EntityNotFoundException("The deleted Patron is not found");
    
        patronService.deleteById(id);
		return"Patron record for id= " + id + " deleted.";
	}
    
}