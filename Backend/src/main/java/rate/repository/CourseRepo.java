package rate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rate.model.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
