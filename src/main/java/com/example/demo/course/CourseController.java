package com.example.demo.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseServices;
	
	@RequestMapping("/topics")
	public List<CourseList> getAllTopics()
	{
		return courseServices.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public CourseList getTopic(@PathVariable String id)
	{
		return courseServices.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody CourseList topic)	{
		courseServices.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="topics/{id}")
	public void updateTopic(@RequestBody CourseList topic, @PathVariable String id) {
		courseServices.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{id}")
	public void deleteTopic(@RequestBody CourseList topic, @PathVariable String id)
	{
		courseServices.deleteTopic(id);
	}
}