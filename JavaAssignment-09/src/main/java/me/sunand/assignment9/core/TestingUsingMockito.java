package me.sunand.assignment9.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;


public class TestingUsingMockito {

    private static Logger logger = LogManager.getLogger(TestingUsingMockito.class);

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        StudentService studentService = new StudentService(studentDao);

        Student sunand = studentService.createStudent("sunand", "sharma");
        Student sahil = studentService.createStudent("sahil",null);
        Student sanjay = studentService.createStudent(null,"kumar");
        Student aman = studentService.createStudent(null,null);

    }

    static class StudentService {

        private static Logger logger = LogManager.getLogger(StudentService.class);

        private StudentDao studentDao;

        StudentService(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        Student createStudent(String firstName, String lastName) {
            if(null == firstName) {
                throw new IllegalArgumentException("firstName shouldn't be null");
            }
            Student student = new Student();
            student.setFirstName(firstName.trim());
            if(null != lastName) {
                student.setLastName(lastName.trim());
            }
            Student result = studentDao.save(student);
            logger.debug("created " + result);
            return result;
        }

        Student getStudent(Integer id) {
            Student student = studentDao.getById(id);
            return student;
        }

    }


    static class StudentDao {
        private AtomicInteger studentIdSequence;

        StudentDao() {
            studentIdSequence = new AtomicInteger();
        }


        Student save(Student student) {
            student.setId(studentIdSequence.incrementAndGet());
            throw new UnsupportedOperationException();
        }
        Student getById(Integer id) {
            Student s=new Student();
            s.setFirstName("sunand");
            s.setLastName("sharma");
            s.setId(id);
            return s;
            //throw new UnsupportedOperationException();
        }
    }

  //  @Data
    static class Student {
        private Integer id;
        private String firstName;
        private String lastName;

      public void setFirstName(String s) {
          this.firstName=s;
      }
      public void setLastName(String s){
          this.lastName=s;
      }
      public void setId(int s){this.id=s;}
  }
}
