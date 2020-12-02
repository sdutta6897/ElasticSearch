package com.orientalbank.chatbot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.orientalbank.chatbot.elastic.model.ChatBotTranscriptData;
import com.orientalbank.chatbot.elastic.model.ConversationData;
import com.orientalbank.chatbot.elastic.model.ResponseCard;
import com.orientalbank.chatbot.json.model.ChatBotTranscript;
import com.orientalbank.chatbot.repository.DocumentRepository;

/**
 * Created by JavaDeveloperZone on 16-12-2017.
 */
@RestController
@EnableWebMvc
@RequestMapping("/chatbot/transcript")
public class ESDocumentController {

	@Autowired
	private ElasticsearchOperations chatBotTranscriptOperations;

	@Autowired
	private DocumentRepository documentRespository;

	@PostMapping("/save")
	public String saveChatTranscript(@RequestBody ChatBotTranscript transcriptData) {

		String responseResult = null;
		try {

			// try and fetch and see if there is an existing chat
			Optional<ChatBotTranscriptData> chatBotTranscriptExistingData = documentRespository
					.findById(transcriptData.getSessionId());

			chatBotTranscriptExistingData.ifPresentOrElse(chatBotDataFromDb -> {
				ConversationData conversationData = populateConversationData(transcriptData);
				chatBotDataFromDb.getConversations().add(conversationData);
				documentRespository.save(chatBotDataFromDb);
			}, () -> {
				ChatBotTranscriptData chatBotTranscriptData = new ChatBotTranscriptData();
				chatBotTranscriptData.setId(transcriptData.getSessionId());
				ConversationData conversationData = populateConversationData(transcriptData);
				chatBotTranscriptData.setConversations(Arrays.asList(conversationData));
				documentRespository.save(chatBotTranscriptData);
			});
			responseResult = "SUCCESS";
		} catch (Exception ex) {
			responseResult = "FAILURE";
		}

		return responseResult;
	}

	private ConversationData populateConversationData(ChatBotTranscript transcriptData) {
		ConversationData conversationData = new ConversationData();
		conversationData.setInputTranscript(transcriptData.getInputTranscript());
		conversationData.setBotResponse(transcriptData.getBotResponse());
		ResponseCard responseCard = new ResponseCard();
		BeanUtils.copyProperties(transcriptData.getResponseCard(), responseCard);
		conversationData.setResponseCard(responseCard);
		return conversationData;
	}

	@GetMapping("/getAll")
	public List<ChatBotTranscriptData> getAllDocs() {
		List<ChatBotTranscriptData> documents = new ArrayList<>(); // iterate all
		for (ChatBotTranscriptData doc : this.documentRespository.findAll()) {
			documents.add(doc);
		}
		return documents;
	}

	/*
	 * @DeleteMapping("/delete") public String deleteAllDocuments() { try { //
	 * delete all documents from solr core documentRepository.deleteAll(); return
	 * "documents deleted succesfully!"; } catch (Exception e) { return
	 * "Failed to delete documents"; } }
	 * 
	 * @PostMapping("/save") public String saveDocument() throws ParseException {
	 * 
	 * return null; }
	 * 
	 * @GetMapping("/getAll") public List<ChatBotTranscriptData> getAllDocs() {
	 * List<ChatBotTranscriptData> documents = new ArrayList<>(); // iterate all
	 * documents and add it to list for (ChatBotTranscriptData doc :
	 * this.documentRepository.findAll()) { documents.add(doc); } return documents;
	 * }
	 * 
	 * @GetMapping("/getByDateRange") public List<ChatBotTranscriptData>
	 * getByDateRange() throws ParseException { List<ChatBotTranscriptData>
	 * documents = new ArrayList<>();
	 * 
	 * SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); LocalDate
	 * localDate = LocalDate.of(1976, 9, 01); LocalDate localDate1 =
	 * LocalDate.of(1976, 11, 8);
	 * 
	 * DateTimeFormatter format =
	 * DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSZZ");
	 * 
	 * LocalDateTime ldt1 = LocalDateTime.of(2016, Month.JULY, 22, 14, 30, 01, 01);
	 * LocalDateTime ldt2 = LocalDateTime.of(2026, Month.SEPTEMBER, 22, 14, 30, 01,
	 * 01); ZonedDateTime klDateTime1 = ldt1.atZone(ZoneId.of("Asia/Kuala_Lumpur"));
	 * ZonedDateTime klDateTime2 = ldt2.atZone(ZoneId.of("Asia/Kuala_Lumpur")); //
	 * Date date1 = //
	 * Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()); //
	 * Date date2 = //
	 * Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant()); //
	 * iterate all documents and add it to list
	 * 
	 * for (ChatBotTranscriptData doc :
	 * this.documentRepository.findByDocumentDateWithin(format.format(klDateTime1),
	 * format.format(klDateTime2))) { documents.add(doc); }
	 * 
	 * 
	 * QueryBuilder queryBuilder = QueryBuilders.boolQuery()
	 * .must(QueryBuilders.rangeQuery("documentDate").gt(klDateTime1).lt(klDateTime2
	 * )); final NativeSearchQuery searchQuery = new
	 * NativeSearchQueryBuilder().withQuery(queryBuilder).build();
	 * SearchHits<Document> docs = elasticsearchTemplate.search(searchQuery,
	 * Document.class); System.out.println(docs);
	 * 
	 * 
	 * return documents; }
	 */

}
