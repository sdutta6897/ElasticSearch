package com.orientalbank.chatbot.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.orientalbank.chatbot")
public class AwsElasticConfiguration {

	@Value("${elastic.url}")
	private String elasticSearcEndpoint;

	@Value("${elastic.username}")
	private String elasticSearcUser;

	@Value("${elastic.password}")
	private String elasticSearcPassword;

	private static Logger logger = LoggerFactory.getLogger(AwsElasticConfiguration.class);

	@Bean
	public RestHighLevelClient client() {
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		logger.info("Elasticsearch " + elasticSearcEndpoint);
		credentialsProvider.setCredentials(AuthScope.ANY,
				new UsernamePasswordCredentials(elasticSearcUser, elasticSearcPassword));
		RestClientBuilder builder = RestClient.builder(new HttpHost(elasticSearcEndpoint, 443, "https"))
				.setHttpClientConfigCallback(
						httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
		return new RestHighLevelClient(builder);
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}

}