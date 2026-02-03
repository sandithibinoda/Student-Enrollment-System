import java.util.*;


/* This class is the main class of this LMS application

 * "LMS" is the very simple text-based student enrollment system
 
 */

public class StudentEnrollmentSystem {
        
    
    //The main method
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Enrollment> enrollmentList = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        int choice;

        
        
        do{
            System.out.println("\t\t\t===========================================================================================");
            System.out.println();
            System.out.println("\t\t\t===================================  MAIN MENU  ============================================");
            System.out.println();
            System.out.println("\t\t\t============================================================================================");
            System.out.println();
            System.out.println("1. Enroll Student in a Course");
            System.out.println("2. Calculate Total Credits for a Student");
            System.out.println("3. Calculate the course fee for a specific course");
            System.out.println("4. Calculate the total cost of enrolling a student for courses");
            System.out.println("5. Display enrollment details and generate reports");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = userInput.nextInt();
            System.out.println();
            

             try{
            
            
            switch(choice){
                case 1:
                    enlistNewStudent(userInput,studentList);
                    addingCourses(userInput,courseList);
                    enrollStudentForCourses(userInput, studentList, courseList, enrollmentList);
                    break;

                case 2:
                    sumCredits(userInput, studentList,courseList,enrollmentList);
                    break;

                case 3:
                    calculateCourseFee(userInput,studentList, courseList, enrollmentList);
                    break;

                case 4:
                    CalculateEnrollmentCost(userInput, studentList, enrollmentList);
                    break;

                case 5:
                    displayEnrollmentDetails(userInput, studentList, enrollmentList);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("   Exiting the program");
                    System.out.println("..........................");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invaid choice. Please enter a valid option");
                    break;
                 }
        
             
            }
             catch (InputMismatchException exc)
             {
                 System.out.println(exc);
                 System.out.println("Enter a valid option");
                 choice = userInput.nextInt();
             }
            
            
        
        }while(choice != 6);
    }


    //This method is used to enlist new students to the LMS

    public static void enlistNewStudent(Scanner userInput,List<Student>studentList)
    {
        char response;
        do{
                    
                    System.out.print("Enter Student ID: ");
                    String studentID = userInput.next();
                    System.out.print("Enter Student Name: ");
                    String studentName = userInput.next();
                    Student newStudent = new Student(studentID, studentName);
                    studentList.add(newStudent);
                    System.out.println("Student enlisted to the LMS!");
                    System.out.println();
                    System.out.print("Do you want to register more students to the LMS ?(y/n) ");
                    response = userInput.next().charAt(0);
                    System.out.println();

           }while(response =='y');

    }

    //This method is used to add new course curriculums  to the LMS

    public static void addingCourses(Scanner userInput,List<Course>courseList)
    {
        char response;
        do{         System.out.print("Enter Course ID: ");
                    String courseID = userInput.next();
                    System.out.print("Enter Course Name: ");
                    String courseName = userInput.next();
                    System.out.print("Enter Course Credits: ");
                    int courseCredits = userInput.nextInt();
                    System.out.print("Enter cost per credit: Rs ");
                    double creditRate = userInput.nextDouble();
                    Course newCourse = new Course(courseID, courseName, courseCredits, creditRate);
                    courseList.add(newCourse);
                    System.out.println("Course addition complete!");
                    System.out.println();
                    System.out.print("Do you want to add more courses to the LMS ?(y/n) ");
                    response = userInput.next().charAt(0);
                    System.out.println();

        }while(response =='y');
                    
    }




    //This method is used to enroll students in courses by using their IDs

    public static void enrollStudentForCourses(Scanner userInput,List<Student>studentList,List<Course>courseList,List<Enrollment>enrollmentList)
    {
        
        char response;
                do{
        
                        displayAvailableCourses(courseList);
                        
                        System.out.print("Enter the Student's ID for enrollment: ");
                        String enrollStudentID = userInput.next();
                        do{
                            System.out.print("Enter Course ID: ");
                            String enrollCourseID = userInput.next();
                            System.out.println();
                            Student enrollStudent = retrieveStudent(studentList, enrollStudentID);
                            Course enrollCourse = retrieveCourse(courseList, enrollCourseID);
                            if (enrollStudent != null && enrollCourse != null) {
                                enrollStudent.enroll(enrollCourse);
                                Enrollment newEnrollment = new Enrollment(enrollStudent, enrollCourse);
                                enrollmentList.add(newEnrollment);
                                
                            }
                            else if (enrollStudent != null && enrollCourse == null) {
                                System.out.print("Entered course ID is not in the LMS. ");
                                System.out.print("Do you want to add new courses? (y/n) ");

                                response = userInput.next().charAt(0);
                                if (response == 'y'){
                                    addingCourses(userInput, courseList);
                                }

                            }
                            else if (enrollStudent == null && enrollCourse != null) {
                                System.out.print("Entered student ID is not regestered in the LMS.");
                                System.out.print("Do you want to enlist new student into the system? (y/n) ");

                                response = userInput.next().charAt(0);
                                if (response == 'y'){
                                    enlistNewStudent(userInput, studentList);
                                }
                                
                            }
                             else {
                                System.out.println("Student or Course not found!");
                                
                            }
                            System.out.println();
                            System.out.print("Do you want to enroll the same student in more courses? (y/n) ");
                            response = userInput.next().charAt(0);
                            

                        }while(response == 'y');

                        if (response != 'y')
                        {
                            System.out.print("Do you want to enroll another student in course? (y/n) ");
                            response = userInput.next().charAt(0);
                            System.out.println();
                            
                        }
                }while(response == 'y');

    }




    //Method to calculate total credits for a student

    public static void sumCredits(Scanner userInput,List<Student>studentList, List<Course>courseList, List<Enrollment>enrollmentList)
    {
                    System.out.print("Enter Student ID: ");
                    String totalCreditsStudentID = userInput.next();
                    Student totalCreditsStudent = retrieveStudent(studentList, totalCreditsStudentID);
                    if (totalCreditsStudent != null) {
                        int totalCredits = totalCreditsStudent.calculateTotalCredits();
                        if (totalCredits != 0)
                            System.out.println("Total Credits for student " + totalCreditsStudent.getStudentName()+": " + totalCredits);
                        else{
                            System.out.println("Student is not enrolled in any courses");

                            System.out.print("Do you want to enroll the sudent in courses? (y/n) ");
                            char response;
                            response =userInput.next().charAt(0);

                            if (response == 'y')
                            {
                                enrollStudentForCourses(userInput, studentList, courseList,enrollmentList);
                            }

                            
                        }
                    } else {
                        System.out.println("Student not found!");
                        System.out.println();
                    }
    }





    //Method to calculate the course fee for a specific course

    public static void calculateCourseFee(Scanner userInput,List<Student> studentList, List<Course> courseList, List<Enrollment> enrollmentList) {
    
                    System.out.print("Enter Student ID: ");
                    String studentID = userInput.next();
                    Student student = retrieveStudent(studentList, studentID);
                    if (student == null) {
                        System.out.println("No such student!");
                        return;
                    }

                    System.out.print("Enter Course ID: ");
                    String courseID = userInput.next();
                    Course course = retrieveCourse(courseList, courseID);
                    if (course == null) {
                        System.out.println("Course unavailable!");
                        return;
                    }

                    

                    System.out.println("Course Fee: Rs " + course.calculateCourseFee());
                    System.out.println();
                    
    }




    //Method to calculate the total cost of enrolling in every courses

    public static void CalculateEnrollmentCost (Scanner userInput, List<Student> studentList, List<Enrollment> enrollmentList)
    {
                    System.out.print("Enter Student ID: ");
                    String studentID = userInput.next();
                    Student student = retrieveStudent(studentList, studentID);
                    if (student == null) {
                        System.out.println("No such student!");
                        return;
                    }

                    Enrollment enrollment = fetchEnrollment(enrollmentList, studentID );
                    if (enrollment == null) {
                        System.out.println("Student not registered!");
                        return;
                    }

                    System.out.println("Total enrollment Cost: Rs " + enrollment.calculateEnrollmentCost());
                    System.out.println();
    }





    //Method to get the students' data from the student array 

     public static Student retrieveStudent(List<Student> studentList, String studentId) {
                    for (Student student : studentList) {
                        if (student.getStudentId().equals(studentId)) {
                            return student;
                        }
                    }
                    return null;
    }


    //Method to get the students' data from the course array 

    public static Course retrieveCourse(List<Course> courseList, String courseId) {
                    for (Course course : courseList) {
                        if (course.getCourseId().equals(courseId)) {
                            return course;
                        }
                    }
                    return null;
    }
    
    
    
    

    
    //Method to get the students' data from the enrollment array 

    public static Enrollment fetchEnrollment(List<Enrollment> enrollmentList, String studentID) {
                    for (Enrollment enrollment : enrollmentList) {
                        if (enrollment.getStudent().getStudentId().equals(studentID) ) {
                            return enrollment;
                        }
                    }
                    return null;
    }




    //Method to display available courses in the LMS
    
    public static void displayAvailableCourses(List<Course>courseList)
    {
                    System.out.println("\t\t\t\t\t\t\t\t\t*<< Available Courses >>*");
                    System.out.println();
                    System.out.println("Course name\t\tCourse ID");
                    for(int i=0; i<courseList.size(); i++)
                    {
                        System.out.println(courseList.get(i).getCourseName() + "\t\t" + courseList.get(i).getCourseId());
                        System.out.println();
                    }
                    
    }



    //Method to display enrollment details for a student

     public static void displayEnrollmentDetails(Scanner userInput,List<Student>studentList,List<Enrollment>enrollmentList)
     {
                    System.out.print("Enter student ID: ");
                    String studentID = userInput.next();

                    System.out.println();
                    
                    
                    
                    Student student = retrieveStudent(studentList, studentID);
                    if (student == null) 
                    {
                        System.out.println("No such student!");
                        return;
                    }
                    Enrollment enrollment = fetchEnrollment(enrollmentList, studentID );
                        if (enrollment == null) {
                            System.out.println("Student not registered!");
                            return;
                        }else{
                            System.out.println("\t\t\t\t\t\t\t\t\t*<< Enrollment Details >>*");
                            System.out.println();
                            System.out.println("Student name: " + student.getStudentName());
                            System.out.println();

                            System.out.print("Enrolled courses: ");

                            for(Course course: student.getEnrolledCourses())
                            {
                                System.out.println(course.getCourseName());
                                System.out.print("\t\t"+" ");
                                
                            }
                            System.out.println();
                            System.out.println("Total enrollment cost: Rs "+ enrollment.calculateEnrollmentCost());
                            
                            
                        }

          

        
     }
    

   
    
}