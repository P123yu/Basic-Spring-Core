package com.basic.service;

import com.basic.model.StudentModel;
import com.basic.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
@Service
public class StudentServiceImpl implements StudentService{


    @Autowired   // used for dependency injection
    private StudentRepository studentRepository;

    // insert uses save() of repo that will return EntityClass (StudentModel)
    @Override
    public StudentModel insert(StudentModel studentModel) {
        StudentModel student=studentRepository.save(studentModel);
        return student;
    }

    @Override
    public List<StudentModel> insertAll(List<StudentModel> studentModel) {
        List<StudentModel>student= (List<StudentModel>) studentRepository.saveAll(studentModel);
        return student;
    }

    @Override
    public List<StudentModel> getAll() {
        List<StudentModel> student= (List<StudentModel>) studentRepository.findAll();
        return student;
    }

    @Override
    public StudentModel getById(Long id) {
        StudentModel student=studentRepository.findById(id).orElse(null);
        return student;

    }

    @Override
    public void deleteByJson(StudentModel studentModel) {
        studentRepository.delete(studentModel);
    }

    @Override
    public void deleteByGivenId(Long id) {
        studentRepository.deleteById(id);
    }


    @Transactional
    @Override
    public void deleteByCity(String city) {
        boolean result=studentRepository.existsBystuCity(city);
        if(result){

        }
        studentRepository.deleteBystuCity(city);
    }

    @Override
    public List<StudentModel> sortedByCity() {
        List<StudentModel>student=studentRepository.sortByCity();
        return student;
    }


    @Scheduled(fixedRate=5000)
    @Override
    public void printAnything() {
        System.out.print("hello");
    }

//    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
//    @Scheduled(fixedRate=5000)
//    @Override
//    public void printAnything() {
//        logger.info("Scheduled task executed: hello");
//    }


}





