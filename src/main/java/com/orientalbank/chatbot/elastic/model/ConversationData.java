package com.orientalbank.chatbot.elastic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuppressWarnings("unused")
public class ConversationData {

	private String inputTranscript;
	private String botResponse;
	private String requestId;
	private ResponseCard responseCard;

}
