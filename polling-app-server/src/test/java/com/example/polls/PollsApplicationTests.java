package com.example.polls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class PollsApplicationTests {

	@Autowired
	private ConfigurableEnvironment configurableEnvironment;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getProperties() {
		Map<String, Object> mapOfProperties = configurableEnvironment.getPropertySources()
				.stream()
				.filter(propertySource -> propertySource.getName()
						.contains("application.properties"))
				.collect(Collectors.toMap(PropertySource::getName, PropertySource::getSource));
		mapOfProperties.values()
				.forEach(System.out::println);
	}

}
