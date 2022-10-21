import java.util.Scanner;

/**
 * Write a description of class Registrar here.
 *
 * @author (Tushar)
 * @version (11/25/21)
 */

public class Registrar {
  // static variable, so we can use the same keyboard for all input
  static Scanner keyboard = new Scanner(System.in);

  // prompt user for integer and return it
  private static int getChoice(String prompt) {
    System.out.print(prompt);
    int choice = keyboard.nextInt();
    return choice;
  }

  // prompt user for String and return it
  private static String getString(String prompt) {
    System.out.print(prompt);
    String str = keyboard.next();
    return str;
  }

  /**
   * Main menu for program, asks university name. Creates university object and
   * calls universityMenu
   */
  public static void mainMenu() {
    System.out.println("Welcome to the Registrar program");
    newUniversity();
  }

  // Main university menu with registrar functions
  private static void universityMenu(University uni) {
    System.out.println("Welcome to the " + uni + " menu");
    System.out.println("1. Display information about the university");
    System.out.println("2. List all courses");
    System.out.println("3. Add a course");
    System.out.println("4. Enroll a new student");
    System.out.println("5. List all students");
    System.out.println("6. Register a student for a course");
    System.out.println("7. List all students enrolled in a course");
    System.out.println("8. Drop a Course that a student is registered for");
    System.out.println("9. Create new University");
    System.out.println("10. Exit");
    int choice = getChoice("Enter command: ");
    System.out.println("Choice is " + choice);
    switch (choice) {
      case 1:
        uni.information();
        break;
      case 2:
        uni.listCourses();
        break;
      case 3:
        addCourse(uni);
        break;
      case 4:
        enrollAStudent(uni);
        break;
      case 5:
        uni.listStudents();
        break;
      case 6:
        registerStudentForCourse(uni);
        break;
      case 7:
        listStudentsInCourse(uni);
        break;
      case 8:
        dropCourse(uni);
        break;
      case 9:
        newUniversity();
        break;
      case 10:
        System.out.println("Thank you for using the Registrar program");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice " + choice);
    }
    System.out.println();
    universityMenu(uni);
  }

  // checks if the course is already offered at university
  // if course is not offered, adds course

  private static void newUniversity() {
    String uniName = getString("Enter a name for University: ");
    University university = new University(uniName);
    universityMenu(university);
  }

  private static void addCourse(University uni) {
    // TODO
    System.out.println("What course do you want to add?");
    String courseName = keyboard.next();
    if (!uni.hasCourse(courseName)) {
      uni.addCourse(courseName);
      System.out.println("Added new course");
    } else {
      // Error to print:
      System.out.println("Already have a course named " + courseName);
    }
  }

  private static void dropCourse(University uni) {
    System.out.println("Student name?");
    String studentName = keyboard.next();
    Student stud = new Student(studentName, uni);
    System.out.println("Course name?");
    String courseName = keyboard.next();
    if (stud.isRegisteredFor(courseName)) {
      stud.drop(courseName);
    }
    System.out.println(studentName + " is no longer in " + courseName);
  }

  // gets name from user, creates Student object and
  // enrolls the new student at university
  private static void enrollAStudent(University uni) {
    // TODO
    System.out.println("What is the Student's name?");
    String studentName = keyboard.next();
    Student stud = new Student(studentName, uni);
    uni.enroll(stud);
    System.out.println("Enrolled student");
  }

  // gets name from user, checks if the student with that name
  // can be found at university.
  // If student is found, gets course name
  // if course is offered at university and student is not
  // already registered for the course, add student to that course
  private static void registerStudentForCourse(University uni) {
    System.out.println("Student Name?");
    String studentName = keyboard.next();
    Student stud = uni.getStudent(studentName);
    System.out.println("Course name?");
    String courseName = keyboard.next();
    if (uni.getStudent(studentName) == null) {
      System.out.println("Could not find student with name " + studentName);
    }
    if (uni.getStudent(studentName) != null) {
      if (!uni.hasCourse(courseName)) {
        System.out.println(courseName + " is not one of the courses offered ");
      }
      if (uni.hasCourse(courseName)) {
        if (stud.isRegisteredFor(courseName)) {
          System.out.println(studentName + " is already registered in " + courseName);
        } else if (!stud.isRegisteredFor(courseName)) {
          stud.add(courseName);
          // uni.getStudent(studentName).add(courseName);
          System.out.println("Registered student for a course");
        }
      }
    }
  }

  // gets course name from user, if course is offered
  // prints all students taking that course
  private static void listStudentsInCourse(University uni) {
    // TODO
    System.out.println("What course?");
    String courseName = keyboard.next();
    if (uni.hasCourse(courseName)) {
      uni.listStudentsInCourse(courseName);
    } else if (!uni.hasCourse(courseName)) {
      System.out.println(courseName + " is not one of the courses offered ");
    }
    // Error to print:
    // System.out.println(courseName + " is not one of the courses offered ");
  }

}