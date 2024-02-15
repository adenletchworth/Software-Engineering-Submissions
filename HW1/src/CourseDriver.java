import Entity.Courses.Course;
import Entity.Courses.Instructor;
import Entity.Courses.Textbook;

public class CourseDriver {
    public static void main(String[] args) {
        Instructor nima = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook designPatterns = new Textbook("Design Patterns", "Gang of Four", "978-0201633610");

        Course softwareEngineering = new Course("Software Engineering");
        softwareEngineering.addInstructor(nima);
        softwareEngineering.addTextbook(designPatterns);

        System.out.println(softwareEngineering);

        Instructor korah = new Instructor("John", "Korah", "3-2637");
        Textbook cleanCode = new Textbook("Clean Code", "Robert C. Martin", "978-0132350884");

        softwareEngineering.addInstructor(korah);
        softwareEngineering.addTextbook(cleanCode);

        System.out.println(softwareEngineering);
    }
}
