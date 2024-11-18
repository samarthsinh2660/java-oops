import java.util.Scanner;

abstract class Employee {
    String name;
    int employeeId;
    double baseSalary;

    Employee(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();
    abstract void displayInfo();
}

class Manager extends Employee {

    Manager(String name, int employeeId, double baseSalary) {
        super(name, employeeId, baseSalary);
    }


    double calculateSalary() {
        return baseSalary;  
    }

    void displayInfo() {
        System.out.println("Manager Info:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class Programmer extends Employee {
    double incentive;


    Programmer(String name, int employeeId, double baseSalary, double incentive) {
        super(name, employeeId, baseSalary);
        this.incentive = incentive;
    }

    double calculateSalary() {
        return baseSalary + incentive; 
    }

    void displayInfo() {
        System.out.println("Programmer Info:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Incentive: " + incentive);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

public class l6q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Manager:");
        System.out.print("Name: ");
        String managerName = scanner.nextLine();
        System.out.print("Employee ID: ");
        int managerId = scanner.nextInt();
        System.out.print("Base Salary: ");
        double managerBaseSalary = scanner.nextDouble();

        Manager manager = new Manager(managerName, managerId, managerBaseSalary);

        scanner.nextLine(); 
        System.out.println("\nEnter details for Programmer:");
        System.out.print("Name: ");
        String programmerName = scanner.nextLine();
        System.out.print("Employee ID: ");
        int programmerId = scanner.nextInt();
        System.out.print("Base Salary: ");
        double programmerBaseSalary = scanner.nextDouble();
        System.out.print("Incentive: ");
        double programmerIncentive = scanner.nextDouble();

        Programmer programmer = new Programmer(programmerName, programmerId, programmerBaseSalary, programmerIncentive);

        System.out.println("\n========================");
        manager.displayInfo();
        System.out.println("\n========================");
        programmer.displayInfo();

    }
}
