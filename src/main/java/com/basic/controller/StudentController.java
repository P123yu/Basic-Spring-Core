

package com.basic.controller;


import com.basic.model.StudentModel;
import com.basic.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/post")
    public ResponseEntity<String>insert(@RequestBody StudentModel studentModel){
        StudentModel student=studentServiceImpl.insert(studentModel);
        if(student !=null){
            return ResponseEntity.ok("inserted");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not inserted");
        }
    }



    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<StudentModel> student=studentServiceImpl.getAll();
        if(!student.isEmpty()){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched getAll");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        StudentModel student=studentServiceImpl.getById(id);
        if(student!=null){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("given id is not present");
        }
    }


    @PostMapping("/postAll")
    public ResponseEntity<?>insertAll(@RequestBody List<StudentModel> studentModel){
        List<StudentModel>student=studentServiceImpl.insertAll(studentModel);
        if (!student.isEmpty()) {
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not inserted all");
        }
    }


    @DeleteMapping("/del")
    public ResponseEntity<?>deleteByJson(@RequestBody StudentModel studentModel){
        try {
            studentServiceImpl.deleteByJson(studentModel);
            return ResponseEntity.ok("deleted");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted by giving json");
        }
    }



    @DeleteMapping("/delById/{id}")
    public ResponseEntity<?>deleteByGivenId(@PathVariable Long id){
        try {
            studentServiceImpl.deleteByGivenId(id);
            return ResponseEntity.ok("deleted by given id");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted by giving id");
        }
    }



    @DeleteMapping("/delByCity/{city}")
    public ResponseEntity<?>deleteByCity(@PathVariable String city){
        try {
            studentServiceImpl.deleteByCity(city);
            return ResponseEntity.ok("deleted by given city");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted by giving city");
        }
    }


    @GetMapping("/sortByCity")
    public ResponseEntity<?>sortedByCity(){
        List<StudentModel>student=studentServiceImpl.sortedByCity();
        if(!student.isEmpty()){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sort by city not happen");
        }
    }













}

