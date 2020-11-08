package com.trustar.interview.questionTwo;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectPatternAttackTwo {

    public List<String> findPatterns(ImmutableList<Pattern> patternList, String stringToAnalyzed) {
        if(Strings.isNullOrEmpty(stringToAnalyzed) || patternList == null) return Collections.emptyList();
        return findWords(patternList, stringToAnalyzed);
    }

    private List<String> findWords(ImmutableList<Pattern> patternList, String stringToAnalyzed) {
        return Arrays.stream(stringToAnalyzed.split("\\s+"))
                .map(entry -> {
                    Matcher match;
                    for(Pattern pattern: patternList) {
                        match = pattern.matcher(entry);
                        if(match.find()) return match.group();
                    }
                    return null;
                }).filter(x -> x != null)
                .collect(Collectors.toList());
    }
}
