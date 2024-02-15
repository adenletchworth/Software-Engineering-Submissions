package Entity.Courses;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Instructor> instructors;
    private ArrayList<Textbook> textbooks;

    public Course(String name) {
        this.name = name;
        this.instructors = new ArrayList<>();
        this.textbooks = new ArrayList<>();
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addTextbook(Textbook textbook) {
        textbooks.add(textbook);
    }

    public Instructor getInstructor(int index) {
        return instructors.get(index);
    }

    public Textbook getTextbook(int index) {
        return textbooks.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(name).append("\n");

        sb.append("Instructors:\n");
        for (Instructor instructor : instructors) {
            sb.append(" - ").append(instructor).append("\n");
        }

        sb.append("Textbooks:\n");
        for (Textbook textbook : textbooks) {
            sb.append(" - ").append(textbook).append("\n");
        }

        return sb.toString();
    }
}
