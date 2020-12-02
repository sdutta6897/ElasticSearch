package com.orientalbank.chatbot.elastic.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuppressWarnings("unused")
public class ResponseCard {

	private List<GenericAttachment> genericAttachments;

}
