import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[2].trim());
        return new Student(id, name, age);
    }
}

class StudentManager {
    private List<Student> students;
    private String filePath;

    public StudentManager(String filePath) {
        this.filePath = filePath;
        this.students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
        }
    }

    private void saveStudents() {
        try (Writer writer = new FileWriter(filePath)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving student data.");
            e.printStackTrace();
        }
    }

    private void loadStudents() {
        try (Reader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
            System.out.println("Student data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous student data found. Starting with an empty list.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading student data.");
            e.printStackTrace();
        }
    }
}

public class l8q6 {
    public static void main(String[] args) {
        String filePath = "students.txt"; 
        StudentManager manager = new StudentManager(filePath);
        manager.addStudent(new Student(1, "Alice", 20));
        manager.addStudent(new Student(2, "Bob", 22));
        manager.addStudent(new Student(3, "Charlie", 19));
        System.out.println("All Students:");
        manager.displayStudents();
    }
}
