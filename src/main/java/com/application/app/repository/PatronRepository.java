package com.application.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application.app.model.Patron;

@Repository
public interface PatronRepository extends JpaRepository <Patron , Long>{

}
