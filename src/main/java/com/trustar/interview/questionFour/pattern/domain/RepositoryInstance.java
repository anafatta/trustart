package com.trustar.interview.questionFour.pattern.domain;

public interface RepositoryInstance {

    void connect(String repository) throws Exception;

    String retrieveFile(String path) throws Exception;

}
