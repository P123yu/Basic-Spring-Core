

package com.basic.service;


import com.basic.model.StudentModel;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

    // insert (save)
    StudentModel insert(StudentModel studentModel);

    // saveAll
    List<StudentModel>insertAll(List<StudentModel> studentModel);

    // getAll
    List<StudentModel> getAll();

    // getById
    StudentModel getById(Long id);

    // delete By Json
    void deleteByJson(StudentModel studentModel);

    // deleteById
    void deleteByGivenId(Long id);


    // deleteByCity
    void deleteByCity(String city);

    // sortByCity
    List<StudentModel> sortedByCity();


    // deleteAll


    // print the name after every 5 second using scheduling in spring
    void printAnything();






}


