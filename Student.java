public class Student {
    int id;
    String name;
    Course course;
    void displayInfo(){
        System.out.println("Student #"+id);
        System.out.println("Student name: "+name);
    }
}

    class Course extends Student{
     String code;
     String title;

     void showCourses(){
         System.out.println("Courses #"+code);
         System.out.println("Course name: "+title);
     }

}
