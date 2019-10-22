package com.hpe.demo.topic;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	Map m=new HashMap();
	
	
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopic();
		
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addtopic(topic);
	
	}
	//, consumes = "text/plain" to pass a String from web	
	@RequestMapping(method = RequestMethod.PUT,value="/topic/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic( topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/topic/{id}")
	public void updateTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}

