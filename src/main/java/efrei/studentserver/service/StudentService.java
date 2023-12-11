package efrei.studentserver.service;

import efrei.studentserver.domain.Student;
import efrei.studentserver.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findWithId(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
}
