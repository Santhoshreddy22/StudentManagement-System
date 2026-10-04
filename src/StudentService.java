import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private HashMap<Integer, Student> students;

    public StudentService() {

        students = new HashMap<>();
    }

    // =========================
    // Add Student
    // =========================

    public void addStudent(Student student) {

        if (students.containsKey(student.getId())) {

            throw new IllegalArgumentException(
                    "Student ID already exists!"
            );
        }

        students.put(student.getId(), student);

        System.out.println("Student added successfully!");
    }

    // =========================
    // Display All Students
    // =========================

    public void displayAllStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (Student student : students.values()) {

            student.displayStudent();
        }
    }

    // =========================
    // Search By ID
    // =========================

    public Student searchById(int id) {

        return students.get(id);
    }

    // =========================
    // Search By Name
    // =========================

    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students.values()) {

            if (student.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                student.displayStudent();

                found = true;
            }
        }

        if (!found) {

            System.out.println("No student found with that name.");
        }
    }

    // =========================
    // Update Marks
    // =========================

    public void updateMarks(int id, double marks) {

        Student student = students.get(id);

        if (student == null) {

            throw new IllegalArgumentException(
                    "Student not found!"
            );
        }

        validateMarks(marks);

        student.setMarks(marks);

        System.out.println("Marks updated successfully!");
    }

    // =========================
    // Update Attendance
    // =========================

    public void updateAttendance(int id, int attendance) {

        Student student = students.get(id);

        if (student == null) {

            throw new IllegalArgumentException(
                    "Student not found!"
            );
        }

        validateAttendance(attendance);

        student.setAttendance(attendance);

        System.out.println(
                "Attendance updated successfully!"
        );
    }

    // =========================
    // Remove Student
    // =========================

    public void removeStudent(int id) {

        Student removedStudent = students.remove(id);

        if (removedStudent == null) {

            System.out.println("Student not found!");

        } else {

            System.out.println(
                    "Student removed successfully!"
            );
        }
    }

    // =========================
    // Display Topper
    // =========================

    public void displayTopper() {

        if (students.isEmpty()) {

            System.out.println("No students available.");
            return;
        }

        Student topper = null;

        for (Student student : students.values()) {

            if (topper == null ||
                    student.getMarks() > topper.getMarks()) {

                topper = student;
            }
        }

        System.out.println("\n========== TOPPER ==========");

        topper.displayStudent();
    }

    // =========================
    // Validate Marks
    // =========================

    public void validateMarks(double marks) {

        if (marks < 0 || marks > 100) {

            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100."
            );
        }
    }

    // =========================
    // Validate Attendance
    // =========================

    public void validateAttendance(int attendance) {

        if (attendance < 0 || attendance > 100) {

            throw new IllegalArgumentException(
                    "Attendance must be between 0 and 100."
            );
        }
    }

    // =========================
    // Get Students
    // =========================

    public HashMap<Integer, Student> getStudents() {

        return students;
    }

    // =========================
    // Set Students
    // =========================

    public void setStudents(
            HashMap<Integer, Student> students) {

        this.students = students;
    }
}