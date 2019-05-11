package org.cource.topic.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.cource.topic.starter.model.Topic;
import org.springframework.stereotype.Service;
@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
				new Topic("1","Java","Easy to learn and easy to developed"),
				new Topic("2","C","Specilly for system prgramming"),
				new Topic("3","C++","Middle language of C and java, very handy to explore")
			));
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public List<Topic> getAllTopic(){
		return this.topics;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
}
