package com.trustar.interview.questionOne;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectPatternAttack {

    public List<String> findPatterns(ImmutableList<Pattern> lisOfPattern, String stringToAnalyzed) {
        List<String> wordsFounded = new ArrayList<>();

        if(Strings.isNullOrEmpty(stringToAnalyzed) || lisOfPattern == null) return wordsFounded;

        Matcher match;
        for(Pattern pattern: lisOfPattern){
            match = pattern.matcher(stringToAnalyzed);
            while(match.find()){
                wordsFounded.add(match.group());
            }
        }
        return wordsFounded;
    }

}
