package com.hpe.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	 private static List<Topic> topic=new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring FrameWork","Spring FrameWork Description"),
			new Topic("Java","Core Java","Core Java Description")
			));
	 
	 public static List<Topic> getAllTopic(){
		 return topic;
	 }
	 public Topic getTopic(String id) {
		return  topic.stream().filter(t->t.getId().equals(id)).findFirst().get();
	 }
	public void addtopic(Topic topic2) {
		topic.add(topic2);
	}
	public void updateTopic(Topic topic2, String id) {
		for(int i=0;i<topic.size();i++) {
			Topic t=topic.get(i);
			System.out.println(t.getId());
			if(t.getId().equals(id)) {
				topic.set(i, t);
			}
		}
	}
	
	
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topic.removeIf(t->t.getId().equals(id));
		
	}
}
