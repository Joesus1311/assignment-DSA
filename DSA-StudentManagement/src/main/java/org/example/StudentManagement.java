package org.example;
import java.util.*;

public class StudentManagement {
    private StudentStack studentStack;

    // Constructor
    public StudentManagement() {
        studentStack = new StudentStack();
    }

    // Add a new student to the stack
    public void addStudent(Student student) {
        studentStack.push(student);
    }

    // Edit a student's marks based on ID
    public void editStudent(int id, double newMarks) {
        StudentStack tempStack = new StudentStack();  // Temporary stack
        boolean found = false;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);  // Move others to temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack();  // Temporary stack
        boolean found = false;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                found = true;
                System.out.println("Student deleted: " + student);
                continue;  // Skip pushing this student back to the stack
            }
            tempStack.push(student);  // Move others to temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID
    public Student searchStudentById(int id) {
        StudentStack tempStack = new StudentStack();  // Temporary stack
        Student foundStudent = null;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            tempStack.push(student);  // Move to temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return foundStudent;
    }

    // Display all students
    public void displayAllStudents() {
        studentStack.displayStudents();  // Use the display method from StudentStack
    }

    // Sort students by marks (in descending order)
    public void sortStudentsByMarks() {
        // Convert stack to array for sorting
        Student[] students = new Student[studentStack.size()];
        int i = 0;

        while (!studentStack.isEmpty()) {
            students[i++] = studentStack.pop();
        }

        // Sort the array by marks in descending order
        Arrays.sort(students, (s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));

        // Push sorted students back to the stack
        for (Student student : students) {
            studentStack.push(student);
        }

        System.out.println("Students sorted by marks.");
    }



}
