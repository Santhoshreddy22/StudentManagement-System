import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentService studentService =
            new StudentService();

    static StudentFileService fileService =
            new StudentFileService();

    public static void main(String[] args) {

        // Load existing students
        HashMap<Integer, Student> loadedStudents =
                fileService.loadStudents();

        studentService.setStudents(loadedStudents);

        while (true) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            try {

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        studentService.displayAllStudents();
                        break;

                    case 3:
                        searchById();
                        break;

                    case 4:
                        searchByName();
                        break;

                    case 5:
                        updateMarks();
                        break;

                    case 6:
                        updateAttendance();
                        break;

                    case 7:
                        removeStudent();
                        break;

                    case 8:
                        studentService.displayTopper();
                        break;

                    case 9:
                        saveData();
                        break;

                    case 10:
                        saveData();

                        System.out.println(
                                "Thank you for using Student Management System!"
                        );

                        scanner.close();

                        return;

                    default:
                        System.out.println(
                                "Invalid choice!"
                        );
                }

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }
    }

    // =========================
    // Display Menu
    // =========================

    static void displayMenu() {

        System.out.println("\n======================================");
        System.out.println("      STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");

        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search By Student ID");
        System.out.println("4. Search By Name");
        System.out.println("5. Update Student Marks");
        System.out.println("6. Update Attendance");
        System.out.println("7. Remove Student");
        System.out.println("8. Display Topper");
        System.out.println("9. Save Student Data");
        System.out.println("10. Exit");

        System.out.println("======================================");
    }

    // =========================
    // Add Student
    // =========================

    static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        int id = readInt("Enter Student ID: ");

        System.out.print("Enter Name: ");

        String name = scanner.nextLine();

        System.out.print("Enter Email: ");

        String email = scanner.nextLine();

        double marks =
                readDouble("Enter Marks: ");

        studentService.validateMarks(marks);

        int attendance =
                readInt("Enter Attendance (%): ");

        studentService.validateAttendance(attendance);

        System.out.println("\nSelect Status:");

        System.out.println("1. ACTIVE");
        System.out.println("2. INACTIVE");
        System.out.println("3. COMPLETED");

        int statusChoice =
                readInt("Enter status: ");

        StudentStatus status;

        switch (statusChoice) {

            case 1:
                status = StudentStatus.ACTIVE;
                break;

            case 2:
                status = StudentStatus.INACTIVE;
                break;

            case 3:
                status = StudentStatus.COMPLETED;
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid status!"
                );
        }

        System.out.println("\n========== COURSE ==========");

        int courseId =
                readInt("Enter Course ID: ");

        System.out.print("Enter Course Name: ");

        String courseName =
                scanner.nextLine();

        Course course =
                new Course(
                        courseId,
                        courseName
                );

        Student student =
                new Student(
                        id,
                        name,
                        email,
                        marks,
                        attendance,
                        status,
                        course
                );

        studentService.addStudent(student);

        // Automatically save
        fileService.saveStudents(
                studentService.getStudents()
        );
    }

    // =========================
    // Search By ID
    // =========================

    static void searchById() {

        System.out.println(
                "\n========== SEARCH BY ID =========="
        );

        int id =
                readInt("Enter Student ID: ");

        Student student =
                studentService.searchById(id);

        if (student == null) {

            System.out.println(
                    "Student not found!"
            );

        } else {

            student.displayStudent();
        }
    }

    // =========================
    // Search By Name
    // =========================

    static void searchByName() {

        System.out.println(
                "\n========== SEARCH BY NAME =========="
        );

        System.out.print("Enter Student Name: ");

        String name =
                scanner.nextLine();

        studentService.searchByName(name);
    }

    // =========================
    // Update Marks
    // =========================

    static void updateMarks() {

        System.out.println(
                "\n========== UPDATE MARKS =========="
        );

        int id =
                readInt("Enter Student ID: ");

        double marks =
                readDouble("Enter New Marks: ");

        studentService.updateMarks(
                id,
                marks
        );

        fileService.saveStudents(
                studentService.getStudents()
        );
    }

    // =========================
    // Update Attendance
    // =========================

    static void updateAttendance() {

        System.out.println(
                "\n========== UPDATE ATTENDANCE =========="
        );

        int id =
                readInt("Enter Student ID: ");

        int attendance =
                readInt("Enter New Attendance: ");

        studentService.updateAttendance(
                id,
                attendance
        );

        fileService.saveStudents(
                studentService.getStudents()
        );
    }

    // =========================
    // Remove Student
    // =========================

    static void removeStudent() {

        System.out.println(
                "\n========== REMOVE STUDENT =========="
        );

        int id =
                readInt("Enter Student ID: ");

        studentService.removeStudent(id);

        fileService.saveStudents(
                studentService.getStudents()
        );
    }

    // =========================
    // Save Data
    // =========================

    static void saveData() {

        fileService.saveStudents(
                studentService.getStudents()
        );
    }

    // =========================
    // Read Integer
    // =========================

    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // =========================
    // Read Double
    // =========================

    static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}