package com.trustar.interview.questionThree;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectPatternAttackThree {

    public List<String> findPatterns(ImmutableList<Pattern> patternList, String stringToAnalyzed, Optional<ImmutableList<Pattern>> patternToIgnore) {
        if(Strings.isNullOrEmpty(stringToAnalyzed) || patternList == null) return Collections.emptyList();
        return findWords(patternList, stringToAnalyzed, patternToIgnore);
    }

    private List<String> findWords(ImmutableList<Pattern> patternList, String stringToAnalyzed, Optional<ImmutableList<Pattern>> patternToIgnore) {
        return Arrays.stream(stringToAnalyzed.split("\\s+"))
                .map(entry -> {
                    if(patternToIgnore.isPresent() && patternToIgnore.get().parallelStream().anyMatch(pattern -> pattern.matcher(entry).find())) {
                        return null;
                    }
                    Matcher match;
                    for(Pattern pattern: patternList) {
                        match = pattern.matcher(entry);
                        if(match.find()) return match.group();
                    }
                    return null;
                }).filter(x -> x != null) //TODO: Think how to avoid this filter.
                .collect(Collectors.toList());
    }
}
