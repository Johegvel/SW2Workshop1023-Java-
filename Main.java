/**
 * Demonstrates the Student Grade Management System, including invalid inputs.
 */
public class Main {

  /**
   * Runs the demonstration.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Student student = createStudent("S001", "Ana Torres");
    if (student == null) {
      return;
    }

    addGrade(student, "100");
    addGrade(student, "95.5");
    addGrade(student, "88");
    // Invalid grades: not numeric and out of range.
    addGrade(student, "Fifty");
    addGrade(student, "150");

    // Invalid removals: index out of bounds and value not found.
    removeGradeByIndex(student, 5);
    removeGradeByValue(student, 70.0);
    // Valid removal by value.
    removeGradeByValue(student, 88.0);

    System.out.println();
    System.out.println(student.generateReport());

    // Invalid student data: empty ID and empty name.
    createStudent("", "Carlos Ruiz");
    createStudent("S002", "   ");
  }

  private static Student createStudent(String id, String name) {
    try {
      Student student = new Student(id, name);
      System.out.println("Student created: " + student.getName());
      return student;
    } catch (IllegalArgumentException e) {
      System.out.println("Error creating student: " + e.getMessage());
      return null;
    }
  }

  private static void addGrade(Student student, String grade) {
    try {
      student.addGrade(grade);
      System.out.println("Grade added: " + grade);
    } catch (IllegalArgumentException e) {
      System.out.println("Error adding grade: " + e.getMessage());
    }
  }

  private static void removeGradeByIndex(Student student, int index) {
    try {
      double removed = student.removeGradeByIndex(index);
      System.out.println("Removed grade at index " + index + ": " + removed);
    } catch (IllegalArgumentException e) {
      System.out.println("Error removing grade: " + e.getMessage());
    }
  }

  private static void removeGradeByValue(Student student, double value) {
    try {
      student.removeGradeByValue(value);
      System.out.println("Removed grade: " + value);
    } catch (IllegalArgumentException e) {
      System.out.println("Error removing grade: " + e.getMessage());
    }
  }
}