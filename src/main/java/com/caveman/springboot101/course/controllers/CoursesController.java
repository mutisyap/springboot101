package com.caveman.springboot101.course.controllers;

import com.caveman.springboot101.models.Course;
import com.caveman.springboot101.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by petro on 7/19/17.
 */

@RestController
public class CoursesController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/api/courses")
    public List<Course> getAllCourses(){
        return courseService.getAll();
    }


//    @RequestMapping("api/courses/{id}")
//    public Course getCourse(@PathVariable Integer id){
//        return courseService.getCourse(id);
//    }

    @RequestMapping("api/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer id){
        Course course = courseService.getCourse(id);
        if (course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/courses", method = RequestMethod.POST)

    public List<Course> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return courseService.getAll();
    }

    @RequestMapping(value = "/api/courses/{id}", method= RequestMethod.PUT)

    public List<Course> updateCourse(@RequestBody Course course,
                                     @PathVariable Integer id) throws Exception{
        //Let's check if course exists

        Course checkCourse = courseService.getCourse(id);

        if (checkCourse == null){
            throw new Exception("Course does not exist");
        }
        courseService.updateCourse(course, id);
        return courseService.getAll();
    }

    @RequestMapping(value="/api/courses/delete/{id}", method = RequestMethod.DELETE)
    public List<Course> deleteCourse(@PathVariable int id){
        courseService.delete(id);
        return courseService.getAll();
    }


}
