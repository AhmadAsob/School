package com.example.school.Service;

import com.example.school.Dto.responseDataObj;
import com.example.school.Dto.responseOutput;
import com.example.school.Model.Student;
import com.example.school.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private HttpStatus StatusResponse;

    public ResponseEntity getAllStudents() {

        responseDataObj response = new responseDataObj();

        try {
            response.setRespHttpCode("200");
            response.setRespHttpMessage("Sucessfully");
            response.setData(studentRepository.findAll());
            StatusResponse = HttpStatus.OK;

        } catch (Exception e){

            response.setRespHttpCode("400");
            response.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(response, StatusResponse);
    }

    public ResponseEntity getStudentById(Long id) {

        responseDataObj response = new responseDataObj();

        try {
            response.setRespHttpCode("200");
            response.setRespHttpMessage("Sucessfully");
            response.setData(studentRepository.findById(id).orElse(null));
            StatusResponse = HttpStatus.OK;

        } catch (Exception e){

            response.setRespHttpCode("400");
            response.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(response, StatusResponse);
    }

    public ResponseEntity saveStudent(Student student) {

        responseOutput response = new responseOutput();

        try {

            studentRepository.save(student);

            response.setRespHttpCode("200");
            response.setRespHttpMessage("Sucessfully");
            StatusResponse = HttpStatus.OK;

        } catch (Exception e){

            response.setRespHttpCode("400");
            response.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(response, StatusResponse);
    }

    public ResponseEntity deleteStudent(Long id) {

        responseOutput response = new responseOutput();

        try {

            studentRepository.deleteById(id);

            response.setRespHttpCode("200");
            response.setRespHttpMessage("Sucessfully");
            StatusResponse = HttpStatus.OK;

        } catch (Exception e){

            response.setRespHttpCode("400");
            response.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(response, StatusResponse);
    }
}
