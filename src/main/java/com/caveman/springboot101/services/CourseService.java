package com.caveman.springboot101.services;

import com.caveman.springboot101.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by petro on 7/19/17.
 */

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1, "Computer Science", "We teach you nothing"),
            new Course(2, "Computer Technology", "We teach you hardware"),
            new Course(3, "Medicine", "We make you cram")
    ));

    public List<Course> getAll(){
        return courses;
    }

    public Course getCourse(int id){

        for(Course course: courses){
            if (course.getId() == id){
                return course;
            }
        }

        //ID not found
        return null;
    }

    public List<Course> addCourse (Course course) {
        courses.add(course);
        return courses;
    }

    public void updateCourse (Course course, int id) {

        int i=0;
        for (Course course1: courses){
            if (course1.getId() == id) {
                courses.set(i, course);
            }
            i++;
        }
    }
    public void delete (int id) {

        int i=0;
        for (Course course1: courses){
            if (course1.getId() == id) {
                courses.remove(i);
            }
            i++;
        }
    }

}
