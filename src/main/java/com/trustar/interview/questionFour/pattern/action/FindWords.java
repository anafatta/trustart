package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.domain.MatchFinder;
import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;

public class FindWords {

    private MatchFinder matchFinder;
    private RepositoryInstance repositoryInstance;


    public FindWords(RepositoryInstance aRepositoryInstance, MatchFinder aMatchFinder) {
        repositoryInstance = aRepositoryInstance;
        matchFinder = aMatchFinder;
    }


    public void findPattern() {

    }
}
