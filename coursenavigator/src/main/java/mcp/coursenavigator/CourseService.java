package mcp.coursenavigator;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "get_courses", description = "Get a list of courses from Dan Vega")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "get_course", description = "Get a single course from Dan Vega by title")
    public Course getCourse(String title) {
        return courses.stream()
                .filter(course -> course.title().equals(title))
                .findFirst()
                .orElse(null);
    }

    @Tool(name = "add_course", description = "Add a new course to the list")
    public void addCourse(String title, String url) {
        courses.add(new Course(title, url));
    }

    @Tool(name = "remove_course", description = "Remove a course from the list by title")
    public boolean removeCourse(String title) {
        return courses.removeIf(course -> course.title().equals(title));
    }

    @Tool(name = "update_course_url", description = "Update the URL of a course identified by title")
    public boolean updateCourseUrl(String title, String newUrl) {
        for (Course course : courses) {
            if (course.title().equals(title)) {
                courses.set(courses.indexOf(course), new Course(title, newUrl));
                return true;
            }
        }
        return false;
    }

    @Tool(name = "count_courses", description = "Get the total number of courses available")
    public int countCourses() {
        return courses.size();
    }

@PostConstruct
public void init() {
    courses.addAll(List.of(
        new Course(
            "Spring Boot Tutorial for Beginners - 2025 Crash Course",
            "https://spring.io/guides/gs/spring-boot/",
            "An official Spring guide offering a beginner-friendly crash course on Spring Boot 3."
        ),
        new Course(
            "Spring Boot Tutorial for Beginners [2025]",
            "https://www.youtube.com/watch?v=gJrjgg1KVL4",
            "A 2025 YouTube crash course covering Spring Boot fundamentals step-by-step."
        ),
        new Course(
            "End-to-End Spring Boot 2025 Tutorial",
            "https://www.youtube.com/watch?v=GAgelbsTb9M",
            "A full-length video tutorial walking through a complete Spring Boot application build in 2025."
        )
    ));
}

}