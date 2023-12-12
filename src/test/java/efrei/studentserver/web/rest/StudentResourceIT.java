package efrei.studentserver.web.rest;

import efrei.studentserver.domain.Student;
import efrei.studentserver.service.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class StudentResourceIT {
    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    void findStudentById() {

        Student student = new Student();
        student.setName("Bob");
        student.setAge(24);
        Student createdStudent = studentService.create(student);
        Student foundStudent = studentService.findWithId(createdStudent.getId());

        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getId()).isEqualTo(createdStudent.getId());
        assertThat(foundStudent.getName()).isEqualTo(createdStudent.getName());
        assertThat(foundStudent.getAge()).isEqualTo(createdStudent.getAge());
    }

    @Test
    @Transactional
    void createStudent() {
        int databaseSizeBeforeCreate = studentService.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setName("Yannis");
        student.setAge(22);
        studentService.create(student);

        List<Student> studentList = studentService.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate + 1);
    }

    @Test
    @Transactional
    void updateStudent() {
        Student existingStudent = studentService.create(new Student("Yannis", 22));

        existingStudent.setName("NewYannis");
        studentService.create(existingStudent);

        Student updatedStudent = studentService.findWithId(existingStudent.getId());
        assertThat(updatedStudent).isNotNull();
        assertThat(updatedStudent.getName()).isEqualTo("NewYannis");
    }


    @Test
    @Transactional
    void deleteStudent() {
        Student existingStudent = studentService.create(new Student("Yannis", 22));
        assertThat(studentService.findWithId(existingStudent.getId())).isNotNull();
        int databaseSizeBeforeDelete = studentService.findAll().size();
        studentService.delete(existingStudent.getId());

        assertThat(studentService.findWithId(existingStudent.getId())).isNull();
        List<Student> studentList = studentService.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
