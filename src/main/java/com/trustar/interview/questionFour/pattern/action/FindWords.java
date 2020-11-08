package com.trustar.interview.questionFour.pattern.action;

import com.google.common.collect.ImmutableList;
import com.trustar.interview.questionFour.pattern.domain.MatchFinder;
import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class FindWords {

    private MatchFinder matchFinder;
    private RepositoryInstance repositoryInstance;


    public FindWords(RepositoryInstance aRepositoryInstance, MatchFinder aMatchFinder) {
        repositoryInstance = aRepositoryInstance;
        matchFinder = aMatchFinder;
    }

    public List<String> findPattern(ImmutableList<Pattern> patternList, String stringToAnalyzed, Optional<ImmutableList<Pattern>> patternToIgnore) {
        return matchFinder.findPatterns(patternList, stringToAnalyzed, patternToIgnore);
    }
}
