package com.orientalbank.chatbot.elastic.model;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@org.springframework.data.elasticsearch.annotations.Document(indexName = "chanbottranscriptlogs")
/**
 * The class will map transcripts for entire session to an index
 * 
 * @author sourav
 *
 */
public class ChatBotTranscriptData {
	@Id
	private String id;

	@Field
	private List<ConversationData> conversations;

	@Field(name = "documentDate", type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZZ")
	private ZonedDateTime creationDate;

}
