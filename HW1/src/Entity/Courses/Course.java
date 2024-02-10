package Entity.Courses;

import java.util.ArrayList;

public class Course {
    String name;
    ArrayList<Instructor> instructors;
    ArrayList<Textbook> textbooks;

    public Course() {

    }

    public Course(String name, ArrayList<Instructor> instructors, ArrayList<Textbook> textbooks) {
        this.name = name;
        this.instructors = instructors;
        this.textbooks = textbooks;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void setTextbooks(ArrayList<Textbook> textbooks) {
        this.textbooks = textbooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Textbook> getTextbooks() {
        return textbooks;
    }

    public String toString() {
        
        String textBookString = "";
        String instructorString = "";

        for (Textbook textbook : textbooks) {
            textBookString += textbook.toString() + "\n";
        }

        for (Instructor instructor : instructors) {
            instructorString += instructor.toString() + "\n";
        }

        return "Course: " + name + "Instructors: " + instructorString + "Textbooks: " + textBookString;

    }
}
