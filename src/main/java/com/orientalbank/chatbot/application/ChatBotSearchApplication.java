package com.orientalbank.chatbot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JavaDeveloperZone on 16-12-2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.orientalbank.chatbot")
public class ChatBotSearchApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(ChatBotSearchApplication.class);
		application.run(args);
	}
}
