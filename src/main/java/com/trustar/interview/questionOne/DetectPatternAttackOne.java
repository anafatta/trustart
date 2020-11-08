package com.trustar.interview.questionOne;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectPatternAttackOne{

    public List<String> findPatterns(ImmutableList<Pattern> patternList, String stringToAnalyzed) {
        if(Strings.isNullOrEmpty(stringToAnalyzed) || patternList == null) return Collections.emptyList();
        return findWords(patternList, stringToAnalyzed);
    }

    private List<String> findWords(ImmutableList<Pattern> patternList, String stringToAnalyzed) {
        List<String> wordsFounded = new ArrayList<>();
        Matcher match;
        for(Pattern pattern: patternList){
            match = pattern.matcher(stringToAnalyzed);
            while(match.find()){
                wordsFounded.add(match.group());
            }
        }
        return wordsFounded;
    }

}
