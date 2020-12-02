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
public class GenericAttachment {
	private String title;
	private String subTitle;
	private List<Button> buttons;
	private Object imageUrl;
	private Object attachmentLinkUrl;
}
