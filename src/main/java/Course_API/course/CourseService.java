package Course_API.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Course_API.topic.Topic;

@Service
public class CourseService {
		
	@Autowired		
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		ArrayList<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		Optional<Course> course = courseRepository.findById(id);
		return  course.isPresent()?course.get():null;
	}
	
	public void addCourse(Course course,String topicId) {
		course.setTopic(new Topic(topicId));
		courseRepository.save(course);
	}

	public void updateCourse(Course course,String topicId) {
		course.setTopic(new Topic(topicId));
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
}
