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

    public Student create(Student student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        return studentRepository.save(newStudent);
    }

    public Student update(Integer id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            return studentRepository.save(student);
        } else {
            return null;
        }
    }
    public void delete(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
        }
    }
}
