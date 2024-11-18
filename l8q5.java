import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

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
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
        }
    }

    public void removeStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                saveStudents();
                System.out.println("Removed student with ID: " + id);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void updateStudent(int id, String newName, int newAge) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setAge(newAge);
                saveStudents();
                System.out.println("Updated student with ID: " + id);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving student data.");
            e.printStackTrace();
        }
    }

    private void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
            System.out.println("Student data loaded successfully from " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("No previous student data found. Starting with an empty list.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading student data.");
            e.printStackTrace();
        }
    }
}

public class l8q5{
    public static void main(String[] args) {
        String filePath = "student.txt";
        StudentManager manager = new StudentManager(filePath);

        manager.addStudent(new Student(1, "Alice", 25));
        manager.addStudent(new Student(2, "Bob", 26));
        manager.addStudent(new Student(3, "Charlie", 19));

        System.out.println("All Students:");
        manager.displayStudents();

        manager.removeStudent(2);

        manager.updateStudent(3, "Charlie Brown", 20);

        System.out.println("Updated Student List:");
        manager.displayStudents();
    }
}
