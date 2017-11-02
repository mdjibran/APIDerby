package com.example.demo.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicsService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<TopicList> getAllTopics()
	{
		List<TopicList> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics; 
	}
	
	public TopicList getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	  return topicRepository.findOne(id);
	}

	public void addTopic(TopicList topic)
	{
		topicRepository.save(topic);
	}

	public void updateTopic(String id, TopicList topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);		
	}
}
