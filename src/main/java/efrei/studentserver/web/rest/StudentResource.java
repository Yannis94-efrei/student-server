package efrei.studentserver.web.rest;

import efrei.studentserver.domain.Student;
import efrei.studentserver.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findWithId(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
    }
}
