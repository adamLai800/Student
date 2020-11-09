package com.adam.repository;

import com.adam.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET name = ? WHERE id = ? ", nativeQuery = true)
    void setFixedNameFor(String name, int id);

}