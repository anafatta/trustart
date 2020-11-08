package com.trustar.interview.questionOne;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class DetectPatternAttackOneTest {

    private ImmutableList<Pattern> lisOfPattern;
    private String stringToAnalyzed;
    private DetectPatternAttackOne detectPatternAttackOne;
    private List<String> findPattern;

    @Test
    public void empty_matches(){
        givenADetectPatternAttack();
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList());
    }

    @Test
    public void words_matches(){
        givenADetectPatternAttack();
        givenAListOfPattern();
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList("the", "fox", "fence"));
    }

    private void givenAListOfPattern() {
        lisOfPattern = ImmutableList.of(Pattern.compile("(the)"), Pattern.compile("(fox|f.nce)"));
    }

    private void givenAStringToAnalyzed() {
        stringToAnalyzed = "The fox jumped over the fence";
    }

    private void givenADetectPatternAttack() {
        detectPatternAttackOne = new DetectPatternAttackOne();
    }

    private void whenAStringIsAnalyzed() {
        findPattern = detectPatternAttackOne.findPatterns(lisOfPattern, stringToAnalyzed);
    }

    private void thenReturnPatternFound(List<String> expectedValue) {
        assertEquals(expectedValue, findPattern);
    }

}
