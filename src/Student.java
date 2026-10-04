public class Student {

    private int id;
    private String name;
    private String email;
    private double marks;
    private int attendance;
    private StudentStatus status;
    private Course course;

    public Student(int id, String name, String email,
                   double marks, int attendance,
                   StudentStatus status, Course course) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.attendance = attendance;
        this.status = status;
        this.course = course;
    }

    // =========================
    // Getters and Setters
    // =========================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // =========================
    // Calculate Grade
    // =========================

    public String calculateGrade() {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // =========================
    // Display Student
    // =========================

    public void displayStudent() {

        System.out.println("----------------------------------------");

        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("Attendance  : " + attendance + "%");
        System.out.println("Status     : " + status);
        System.out.println("Course     : " + course);

        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {

        return id + "," +
               name + "," +
               email + "," +
               marks + "," +
               attendance + "," +
               status + "," +
               course.getCourseId() + "," +
               course.getCourseName();
    }
}