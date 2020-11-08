package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;

public class ConnectToRepository {

    private RepositoryInstance repositoryInstance;

    public ConnectToRepository(RepositoryInstance aRepositoryInstance){
        repositoryInstance = aRepositoryInstance;
    }

    public void connect(String repository){
        repositoryInstance.connect(repository);
    }

}
