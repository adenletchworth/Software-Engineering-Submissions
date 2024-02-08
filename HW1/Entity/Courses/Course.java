package HW1.Entity.Courses;

public class Course {
    String name;
    Instructor instructor;
    Textbook textbook;

    public Course() {

    }

    public Course(String name, Instructor instructor, Textbook textbook) {
        this.name = name;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public String getName() {
        return name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Textbook getTextbook() {
        return textbook;
    }
}
