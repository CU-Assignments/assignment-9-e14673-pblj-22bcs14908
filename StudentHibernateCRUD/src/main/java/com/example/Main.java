package com.example;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Create
        Student s1 = new Student("Alice", 22);
        dao.createStudent(s1);
        System.out.println("Created: " + s1);
        Student s2 = new Student("Bob", 20);
        dao.createStudent(s2);
        System.out.println("Created: " + s2);

        // Read
        Student fetched = dao.getStudent(s1.getId());
        System.out.println("Fetched: " + fetched);

        // Update
        fetched.setAge(23);
        dao.updateStudent(fetched);
        System.out.println("Updated: " + dao.getStudent(fetched.getId()));

        // Delete
//        dao.deleteStudent(fetched.getId());
//        System.out.println("Deleted student with ID: " + fetched.getId());
    }
}

