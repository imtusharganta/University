/**
 * Write a description of class University here.
 *
 * @author (Tushar)
 * @version (11/23/21)
 */
public class University {
  private static int MAX_COURSES = 100; // max courses at university
  private static int MAX_STUDENTS = 1000; // max students at university

  private String[] courses; // courses currently offered
  private int numberOfCourses; // number of courses currently on offer
  private Student[] students; // students enrolled at university
  private int numberOfStudents; // number of students currently enrolled
  private String name; // name of university

  // constructor -- set name of university
  // initialize courses array,
  // initialize students array
  // initialize numberOfCourses, numberOfStudents
  /**
   * This is the constructor for the class.
   * 
   * 
   */
  public University(String newName) {
    // TODO
    courses = new String[MAX_COURSES];
    students = new Student[MAX_STUDENTS];
    numberOfCourses = 0;
    numberOfStudents = 0;
    name = newName;
  }

  // return true if a course with the given name is offered
  /**
   * Here, we are returning whether or not the university has a course.
   * 
   * 
   */
  public boolean hasCourse(String courseName) {
    for (int i = 0; i < courses.length; i++) {
      if (courses[i] != null) {
        if (courses[i].equalsIgnoreCase(courseName)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * This lists all the courses.
   */
  public void listCourses() {
    System.out.println("Courses are: ");
    for (int i = 0; i < courses.length; i++) {
      if (courses[i] != null) {
        System.out.println(courses[i]);
      }
    }
  }

  /**
   * Here, we take in the course name and add it to the array of courses for the
   * University.
   * 
   * 
   * 
   */
  public void addCourse(String courseName) {
    courses[numberOfCourses] = courseName;
    numberOfCourses++;
  }

  // print out all students enrolled at university
  /**
   * list all the students in the student array.
   */
  public void listStudents() {
    System.out.println("Students are:");
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        System.out.println(students[i].getName());
      }
    }
  }

  // print out all students enrolled in this course
  /**
   * Lists all the students that are enrolled in the course.
   * 
   * 
   */
  public void listStudentsInCourse(String courseName) {
    System.out.println("Students in " + courseName + " are:");
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        if (students[i].isRegisteredFor(courseName)) {
          System.out.println(students[i].getName());
        }
      }
    }
  }

  // return a Student object based on name
  // if no student with that name found, return null
  /**
   * the student at that index of the array, if they are not found, then you
   * return null.
   * 
   * 
   */
  public Student getStudent(String name) {
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        if (students[i].getName().equalsIgnoreCase(name)) {
          return students[i];
        }
      }
    }
    return null;
  }

  // enroll a student at university
  /**
   * This enrolls the student into the University.
   * 
   * 
   */
  public void enroll(Student student) {
    if (numberOfStudents <= MAX_STUDENTS) {
      students[numberOfStudents] = student;
      numberOfStudents++;
    } else {
      System.out.println("Maximum Students enrolled");
    }
  }

  // display information about university
  public void information() {
    System.out.print(name + " has " + numberOfCourses + " courses and " + numberOfStudents);
    System.out.println(" students");
  }

  // short string when university object is printed
  public String toString() {
    return "<" + name + ">";
  }

}
