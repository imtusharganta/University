/**
 * Write a description of class Student here.
 *
 * @author (Tushar)
 * @version (11/23/21)
 */
public class Student {
  private static int MAX_REGISTERED_COURSES = 4; // max number of courses a student can enroll

  private String name; // name of student
  private String[] registeredCourses; // list of currently registered courses
  private int numberOfRegisteredCourses; // number of courses currently registered
  private University university; // university student belongs to

  /**
   * This creates a student object, which can be referenced in other classes.
   * It is the constructor.
   * 
   */
  public Student(String newName, University uni) {
    name = newName;
    university = uni;
    numberOfRegisteredCourses = 0;
    registeredCourses = new String[MAX_REGISTERED_COURSES];
  }

  /**
   * return the name of student name is a private variable, so need getter method.
   * return the name of student name is a private variable, so need getter method
   * 
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // return true if student is registered for the given course
  /**
   * This checks if the Student is registered for the given course.
   *
   */
  public boolean isRegisteredFor(String courseName) {
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i] != null) {
        if (registeredCourses[i].equalsIgnoreCase(courseName)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Add the course to the list of registeredCourses. Display message if
   * University does not offer this course. Display message if student already
   * registered for this course.
   */
  public void add(String courseName) {
    if (!university.hasCourse(courseName)) {
      System.out.println("There is no course named " + courseName);
    }
    if (numberOfRegisteredCourses < MAX_REGISTERED_COURSES) {
      if (isRegisteredFor(courseName)) {
        System.out.println("Already registered for " + courseName);
      } else if (!isRegisteredFor(courseName)) {
        registeredCourses[numberOfRegisteredCourses] = courseName;
        System.out.println(name + " is now registered for " + courseName);
        numberOfRegisteredCourses++;
      }
    }
  }

  /**
   * This lists all the courses for the object that calls it.
   */
  private void listCourses() {
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i] != null) {
        System.out.println(registeredCourses[i]);
      }
    }
  }

  /**
   * This method drops the course if it is called.
   * 
   * 
   */
  public void drop(String courseName) {
    // Bonus question
    int classIndex = 0;
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i].equals(courseName)) {
        classIndex = i;
      }
    }
    String temp = registeredCourses[4];
    registeredCourses[classIndex] = temp;
    registeredCourses[4] = "";
    numberOfRegisteredCourses--;
  }
}
