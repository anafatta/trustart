package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;

public class RetrieveFile {

    private RepositoryInstance repositoryInstance;

    public RetrieveFile(RepositoryInstance aRepositoryInstance) {
        repositoryInstance = aRepositoryInstance;
    }

    public String invoke(String path) throws Exception {
        return repositoryInstance.retrieveFile(path);
    }
}
