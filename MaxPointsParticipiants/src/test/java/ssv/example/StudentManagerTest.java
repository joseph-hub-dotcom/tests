package ssv.example;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Unit test and Java implementation for StudentManager.
 */
public class StudentManagerTest extends TestCase {

    private class StudentManager {
        private List<String> students = new ArrayList<String>();

        public void addStudent(String firstName, String lastName) {
            String fullName = (firstName + " " + lastName).trim();

            if (fullName == null || fullName.trim().length() == 0){
                throw new IllegalArgumentException("Student name cannot be empty");
            }

            if (students.contains(fullName)) {
                throw new IllegalArgumentException("Student already exists");
            }

            students.add(fullName);
        }

        public int getStudentCount() {
            return students.size();
        }

        public List<String> getStudents() {
            return students;
        }
    }

    public void testAddStudent() {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John", "Doe");
        studentManager.addStudent("Jane", "Doe");

        assertEquals(2, studentManager.getStudentCount());
    }

    public void testAddDuplicateStudent() {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John", "Doe");

        try {
            studentManager.addStudent("John", "Doe");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Exception expected
        }

        assertEquals(1, studentManager.getStudentCount());
    }

    public void testAddStudentWithEmptyName() {
        StudentManager studentManager = new StudentManager();

        try {
            studentManager.addStudent("", "");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Exception expected
        }

        assertEquals(0, studentManager.getStudentCount());
    }

}


