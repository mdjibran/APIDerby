package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<CourseList> getAllTopics()
	{
		List<CourseList> topics = new ArrayList<>();
		courseRepository.findAll().forEach(topics::add);
		return topics; 
	}
	
	public CourseList getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	  return courseRepository.findOne(id);
	}

	public void addTopic(CourseList topic)
	{
		courseRepository.save(topic);
	}

	public void updateTopic(String id, CourseList topic) {
		courseRepository.save(topic);
	}

	public void deleteTopic(String id) {
		courseRepository.delete(id);		
	}
}
