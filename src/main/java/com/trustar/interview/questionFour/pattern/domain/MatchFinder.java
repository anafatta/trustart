package com.trustar.interview.questionFour.pattern.domain;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public interface MatchFinder {

    List<String> findPatterns(ImmutableList<Pattern> patternList, String stringToAnalyzed, Optional<ImmutableList<Pattern>> patternToIgnore);

}
