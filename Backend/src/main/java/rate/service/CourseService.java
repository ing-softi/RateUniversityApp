package rate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rate.model.Course;
import rate.repository.CourseRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public List<Course> findAll(){
        List<Course> allCourses=courseRepo.findAll();
        Collections.sort(allCourses);
        return allCourses;
    }
}
