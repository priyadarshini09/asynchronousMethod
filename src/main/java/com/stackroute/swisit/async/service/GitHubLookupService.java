package com.stackroute.swisit.async.service;

import java.util.concurrent.CompletableFuture;

import com.stackroute.swisit.async.domain.User;

public interface GitHubLookupService {

	public CompletableFuture<User> findUser(String user) throws InterruptedException;
}
