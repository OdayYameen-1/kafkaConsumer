package com.DemoCounsumerOfkafka.kafkaConsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.Theme;

import com.DemoCounsumerOfkafka.kafkaConsumer.KafkaConfiguration.kafkaConf;
import com.DemoCounsumerOfkafka.kafkaConsumer.Model.User;
import com.oday.AerospikeConfiguration.AerospikeConfiguration;
import com.oday.AerospikeConfiguration.UserRepository;

@Service
@ComponentScan(basePackageClasses = AerospikeConfiguration.class)
@ComponentScan(basePackageClasses = kafkaConf.class)
public class kafkaListener implements CommandLineRunner{
		
		
	@Autowired
	UserRepository userRepository;
	
	@KafkaListener(topics = "Spring",groupId = "mygroup_JSON",containerFactory = "kafkaListenerContainerFactory")
	public void myConsumerJson(User user) {
		
		System.out.println("The message is recived ==> \n"+user);
		userRepository.save(user);
		
	}
	@KafkaListener(topics = "noor",groupId = "mygroup_String",containerFactory = "kafkaListenerContainerFactoryFOOOOOORString")
	public void myConsumerString(String str) {
		
		System.out.println("The message is recived ==> \n"+str);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}
	
}
