class Enrollment{
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    
    
     
    public double calculateEnrollmentCost()
    {
        double totCost=0.0;
        for(Course course : student.getEnrolledCourses())
        {
           
           totCost+= course.calculateCourseFee();
          
        }
         return totCost;
    }

    
    
    //Getters and setters
    public Student getStudent()
    {
        return student;
    }
    public Course getCourse()
    {
        return course;
    }
    
}
