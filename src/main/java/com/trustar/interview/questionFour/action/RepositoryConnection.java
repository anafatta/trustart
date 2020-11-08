package com.trustar.interview.questionFour.action;

import com.trustar.interview.questionFour.domain.RepositoryInstance;

public class RepositoryConnection {

    private RepositoryInstance repositoryInstance;

    public RepositoryConnection(RepositoryInstance aRepositoryInstance){
        repositoryInstance = aRepositoryInstance;
    }

    public void connect(String repository){
        repositoryInstance.connect(repository);
    }

}
