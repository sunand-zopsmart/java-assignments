package me.sunand.assignment9.core;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    TestingUsingMockito.StudentDao studentDao;

    @Test
    public void testCreate() {
        assertNotNull(studentDao);

        TestingUsingMockito.Student expectedStudent = new TestingUsingMockito.Student();
        expectedStudent.setFirstName("Darshan");
        expectedStudent.setLastName("Mehta");

        Mockito.when(studentDao.save(Mockito.any(TestingUsingMockito.Student.class))).thenReturn(expectedStudent);

        TestingUsingMockito.StudentService studentService = new TestingUsingMockito.StudentService(studentDao);
        TestingUsingMockito.Student resultStudent = studentService.createStudent("S", "A");
        assertEquals(expectedStudent, resultStudent);

        TestingUsingMockito.Student expectedId=new TestingUsingMockito.Student();
        expectedId.setId(1);

       // Mockito.when(studentDao.getById(Mockito.any(TestingUsingMockito.Student.class))).thenReturn(expectedId);
        TestingUsingMockito.StudentService idService = new TestingUsingMockito.StudentService(studentDao);
        TestingUsingMockito.Student resultId = studentService.getStudent(1);
        assertEquals(expectedId, resultId);
    }
}