import java.io.*;
import java.util.HashMap;

public class StudentFileService {

    private static final String FILE_NAME = "students.txt";

    // =========================
    // Save Students
    // =========================

    public void saveStudents(HashMap<Integer, Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Student student : students.values()) {

                writer.write(student.toString());

                writer.newLine();
            }

            System.out.println(
                    "Student data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving student data."
            );

            System.out.println(e.getMessage());
        }
    }

    // =========================
    // Load Students
    // =========================

    public HashMap<Integer, Student> loadStudents() {

        HashMap<Integer, Student> students =
                new HashMap<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {

                    String[] data = line.split(",");

                    int id = Integer.parseInt(data[0]);

                    String name = data[1];

                    String email = data[2];

                    double marks =
                            Double.parseDouble(data[3]);

                    int attendance =
                            Integer.parseInt(data[4]);

                    StudentStatus status =
                            StudentStatus.valueOf(data[5]);

                    int courseId =
                            Integer.parseInt(data[6]);

                    String courseName = data[7];

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

                    students.put(id, student);

                } catch (Exception e) {

                    System.out.println(
                            "Invalid record skipped: " + line
                    );
                }
            }

            System.out.println(
                    "Student data loaded successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while loading student data."
            );

            System.out.println(e.getMessage());
        }

        return students;
    }
}