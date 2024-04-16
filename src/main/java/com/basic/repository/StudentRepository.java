


package com.basic.repository;

import com.basic.model.StudentModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    void deleteBystuCity(String city);

    boolean existsBystuCity(String city);


    // sort by city

    //    @Query(value="SELECT * FROM student ORDER BY stu_city", nativeQuery = true)
    //   List<StudentModel> sortByCity();


    @Query("SELECT s FROM StudentModel s ORDER BY s.stuCity")
    List<StudentModel> sortByCity();




}



