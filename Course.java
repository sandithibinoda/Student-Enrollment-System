

/* This is the Course class

 * It contains the attributes of the course
  
 * It contains the constructor of the course
 
 * It contains getters and setters of the course
 */


class Course{
    private String courseId;
    private String courseName;
    private int noOfCredits;
    private double creditRate;
    


    //Constructor

    public Course(String courseId, String courseName, int noOfCredits,double creditRate){
        this.courseId = courseId;
        this.courseName = courseName;
        this.noOfCredits = noOfCredits;
        this.creditRate = creditRate;
    }
    
    
    //Getter methods
    public String getCourseId()
    {
        return courseId;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public int getNoOfCredits()
    {
        return noOfCredits;
    }
    public double getCreditRate()
    {
        return creditRate;
    }
    
    
    
    //Setter methods
    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    public void setNoOfCredits(int noOfCredits)
    {
        this.noOfCredits = noOfCredits;
    }
    public void setCreditRate(double creditRate)
    {
        this.creditRate = creditRate;
    }
    
    public double calculateCourseFee(){
        //Assuming a fee of course obatained by multiplying 10000 with number of credits
        
        double courseFee = noOfCredits*creditRate; 
        return courseFee;
          
    }
    
    //Print course details


    @Override
    public String toString()
    {
        return "Course id: "+ courseId + "\nCourse name: " + courseName + "\nNo of credits: " + noOfCredits + "\nCost per credit: Rs " + creditRate; 
    }
       
}

