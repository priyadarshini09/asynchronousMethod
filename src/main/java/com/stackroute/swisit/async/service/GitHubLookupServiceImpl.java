package com.stackroute.swisit.async.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.swisit.async.domain.User;

@Service
public class GitHubLookupServiceImpl implements GitHubLookupService{
	
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupServiceImpl.class);

    private final RestTemplate restTemplate;

    public GitHubLookupServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
	@Override
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException{
		logger.info("Looking up "+ user);
		String url=String.format("https://api.github.com/users/%s", user);
		User results=restTemplate.getForObject(url, User.class);
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(results);
	}

}
