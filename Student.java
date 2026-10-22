import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Represents a student with an identifier, a name and a list of grades.
 */
public class Student {

  private static final double MIN_GRADE = 0.0;
  private static final double MAX_GRADE = 100.0;
  private static final double PASSING_AVERAGE = 60.0;
  private static final double HONOR_ROLL_AVERAGE = 90.0;

  private final String id;
  private final String name;
  private final List<Double> grades;

  /**
   * Creates a student record.
   *
   * @param id the student identifier; must not be empty
   * @param name the student name; must not be empty
   * @throws IllegalArgumentException if the id or the name is empty
   */
  public Student(String id, String name) {
    if (isBlank(id)) {
      throw new IllegalArgumentException("Student ID must not be empty.");
    }
    if (isBlank(name)) {
      throw new IllegalArgumentException("Student name must not be empty.");
    }
    this.id = id.trim();
    this.name = name.trim();
    this.grades = new ArrayList<>();
  }

  /**
   * Returns the student identifier.
   *
   * @return the student identifier
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the student name.
   *
   * @return the student name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns a read-only view of the student's grades.
   *
   * @return the list of grades
   */
  public List<Double> getGrades() {
    return Collections.unmodifiableList(grades);
  }

  /**
   * Adds a numeric grade to the student.
   *
   * @param grade the grade to add; must be between 0 and 100
   * @throws IllegalArgumentException if the grade is outside the valid range
   */
  public void addGrade(double grade) {
    if (Double.isNaN(grade) || grade < MIN_GRADE || grade > MAX_GRADE) {
      throw new IllegalArgumentException(
          "Grade must be between 0 and 100, but was " + grade + ".");
    }
    grades.add(grade);
  }

  /**
   * Parses a grade from text and adds it to the student.
   *
   * @param gradeText the grade as text, for example "95.5"
   * @throws IllegalArgumentException if the text is empty, not numeric or out of range
   */
  public void addGrade(String gradeText) {
    if (isBlank(gradeText)) {
      throw new IllegalArgumentException("Grade must not be empty.");
    }
    double grade;
    try {
      grade = Double.parseDouble(gradeText.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Grade must be numeric: \"" + gradeText + "\".", e);
    }
    addGrade(grade);
  }

  /**
   * Calculates the average of all grades.
   *
   * @return the average grade, or 0.0 if the student has no grades
   */
  public double calculateAverage() {
    if (grades.isEmpty()) {
      return 0.0;
    }
    double total = 0.0;
    for (double grade : grades) {
      total += grade;
    }
    return total / grades.size();
  }

  /**
   * Converts the average grade into a letter grade.
   *
   * <p>Scale: A (90-100), B (80-89), C (70-79), D (60-69), F (below 60).
   *
   * @return the letter grade
   */
  public String getLetterGrade() {
    double average = calculateAverage();
    if (average >= 90.0) {
      return "A";
    } else if (average >= 80.0) {
      return "B";
    } else if (average >= 70.0) {
      return "C";
    } else if (average >= 60.0) {
      return "D";
    }
    return "F";
  }

  /**
   * Indicates whether the student passed, that is, whether the average is 60 or higher.
   *
   * @return true if the student passed
   */
  public boolean isPassed() {
    return calculateAverage() >= PASSING_AVERAGE;
  }

  /**
   * Returns the pass or fail status as text.
   *
   * @return "Passed" or "Failed"
   */
  public String getPassStatus() {
    return isPassed() ? "Passed" : "Failed";
  }

  /**
   * Indicates whether the student is on the honor roll, that is, whether the average is 90 or
   * higher.
   *
   * @return true if the student is on the honor roll
   */
  public boolean isOnHonorRoll() {
    return calculateAverage() >= HONOR_ROLL_AVERAGE;
  }

  /**
   * Removes the grade at the given position.
   *
   * @param index the zero-based position of the grade
   * @return the removed grade
   * @throws IllegalArgumentException if there are no grades or the index is out of range
   */
  public double removeGradeByIndex(int index) {
    if (grades.isEmpty()) {
      throw new IllegalArgumentException("There are no grades to remove.");
    }
    if (index < 0 || index >= grades.size()) {
      throw new IllegalArgumentException(
          "Index " + index + " is out of range. Valid indexes: 0 to " + (grades.size() - 1) + ".");
    }
    return grades.remove(index);
  }

  /**
   * Removes the first grade equal to the given value.
   *
   * @param value the grade value to remove
   * @throws IllegalArgumentException if the value is not found
   */
  public void removeGradeByValue(double value) {
    boolean removed = grades.remove(Double.valueOf(value));
    if (!removed) {
      throw new IllegalArgumentException("Grade " + value + " was not found.");
    }
  }

  /**
   * Generates a formatted summary report for the student.
   *
   * @return the summary report
   */
  public String generateReport() {
    StringBuilder report = new StringBuilder();
    report.append(String.format("===== Student Summary Report =====%n"));
    appendLine(report, "Student ID:", id);
    appendLine(report, "Student Name:", name);
    appendLine(report, "Number of Grades:", String.valueOf(grades.size()));
    appendLine(report, "Average Grade:", String.format(Locale.US, "%.2f", calculateAverage()));
    appendLine(report, "Letter Grade:", getLetterGrade());
    appendLine(report, "Status:", getPassStatus());
    appendLine(report, "Honor Roll:", isOnHonorRoll() ? "Yes" : "No");
    return report.toString();
  }

  private static void appendLine(StringBuilder report, String label, String value) {
    report.append(String.format(Locale.US, "%-18s%s%n", label, value));
  }

  private static boolean isBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}