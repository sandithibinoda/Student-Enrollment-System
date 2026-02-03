import java.util.*;


/* This is the Student class

 * It contains the attributes of the student
  
 * It contains the constructor of the student
 
 * It contains getters and setters of the student
 */



class Student{
    private String studentId;
    private String studentName;
    private List<Course> enrolledCourses;
    public Course getEnrolledCourses;
    
    

    //Constructor

    public Student(String studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }
    
    
    //Getter methods
    public String getStudentId()
    {
        return studentId;
    }
    public String getStudentName()
    {
        return studentName;
    }
    public List<Course> getEnrolledCourses()
    {
        return enrolledCourses;
    }
    public int getSize()
    {
        return enrolledCourses.size();
    }
    
    
    //Setter methods
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }
    public void setEnrolledCourses(ArrayList<Course> enrolledCourses)
    {
        this.enrolledCourses = enrolledCourses;
    }
    

    //Method to enroll students in courses

    public void enroll(Course course)
    {
        enrolledCourses.add(course);
        System.out.println(studentName+" enrolled to "+course.getCourseName());
    }



    //Method to calculate total credits for student

    public int calculateTotalCredits()
     {
        int totalCredits = 0;
        for (Course course : enrolledCourses) {
            totalCredits += course.getNoOfCredits();
        }
        return totalCredits;
    }
    
}
