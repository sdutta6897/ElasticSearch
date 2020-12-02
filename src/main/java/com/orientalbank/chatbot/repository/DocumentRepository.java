package com.orientalbank.chatbot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.orientalbank.chatbot.elastic.model.ChatBotTranscriptData;

public interface DocumentRepository extends ElasticsearchRepository<ChatBotTranscriptData, String> {
}
