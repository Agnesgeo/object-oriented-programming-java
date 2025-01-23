class Employee {
    String name;
    int age;
    long phoneNumber;
    String address;
    double salary;

    public Employee(String name, int age, long phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: $" + salary);
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}

class Officer extends Employee {
    String specialization;

    public Officer(String name, int age, long phoneNumber, String address, double salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
        printSalary();
    }
}

class Manager extends Employee {
    String department;

    public Manager(String name, int age, long phoneNumber, String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
        printSalary();
    }
}

public class EmployeeInheritanceExample {
    public static void main(String[] args) {
        Officer officer = new Officer("John Doe", 30, 1234567890L, "123 Main St", 50000, "Finance");
        Manager manager = new Manager("Jane Smith", 35, 9876543210L, "456 Elm St", 70000, "HR");

        System.out.println("Officer Details:");
        officer.displayDetails();

        System.out.println("\nManager Details:");
        manager.displayDetails();
    }
}
