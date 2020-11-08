package com.trustar.interview.questionTwo;

import com.google.common.collect.ImmutableList;
import com.trustar.interview.questionOne.DetectPatternAttackOne;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.collect.ImmutableList.*;
import static java.util.regex.Pattern.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DetectPatternAttackTwoTest {

    private ImmutableList<Pattern> lisOfPattern;
    private String stringToAnalyzed;
    private DetectPatternAttackTwo detectPatternAttackTwo;
    private List<String> findPattern;

    @Test
    public void empty_matches(){
        givenADetectPatternAttack();
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList());
    }

    @Test
    public void words_matches_question_one(){
        givenADetectPatternAttack();
        givenAListOfPattern(of(compile("(the)"), compile("fox|f.nce")));
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList("the", "fox", "fence"));
    }

    @Test
    public void words_matches_question_two(){
        givenADetectPatternAttack();
        givenAListOfPattern(of(compile("th."), compile("he"), compile("fox")));
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList("the", "he", "fox"));
    }

    private void givenAListOfPattern(ImmutableList<Pattern> patterns) {
        lisOfPattern = patterns;
    }


    private void givenAStringToAnalyzed() {
        stringToAnalyzed = "The fox jumped over the fence";
    }

    private void givenADetectPatternAttack() {
        detectPatternAttackTwo = new DetectPatternAttackTwo();
    }

    private void whenAStringIsAnalyzed() {
        findPattern = detectPatternAttackTwo.findPatterns(lisOfPattern, stringToAnalyzed);
    }

    private void thenReturnPatternFound(List<String> expectedValue) {
        assertTrue(findPattern.size() == expectedValue.size());
        assertTrue(findPattern.containsAll(expectedValue));
    }

}
