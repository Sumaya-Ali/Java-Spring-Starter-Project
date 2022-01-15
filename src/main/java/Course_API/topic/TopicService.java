package Course_API.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
		
	@Autowired		
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		ArrayList<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		Optional<Topic> topic = topicRepository.findById(id);
		return  topic.isPresent()?topic.get():null;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository .save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
}
