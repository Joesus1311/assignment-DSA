package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        // Add students
        studentManagement.addStudent(new Student(1, "Alice", 5.0));
        studentManagement.addStudent(new Student(2, "Bob", 7.5));
        studentManagement.addStudent(new Student(3, "Charlie", 9.0));

        // Display all students
        studentManagement.displayAllStudents();

        // Edit a student's marks
        studentManagement.editStudent(2, 8.0);

        // Display after editing
        studentManagement.displayAllStudents();

        // Delete a student
        studentManagement.deleteStudent(1);

        // Display after deleting
        studentManagement.displayAllStudents();

        // Sort students by marks
        studentManagement.sortStudentsByMarks();

        // Display after sorting
        studentManagement.displayAllStudents();
    }
}