package com.trustar.interview.questionThree;

import com.google.common.collect.ImmutableList;
import com.trustar.interview.questionTwo.DetectPatternAttackTwo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.collect.ImmutableList.of;
import static java.util.Optional.ofNullable;
import static java.util.regex.Pattern.compile;
import static org.junit.Assert.assertTrue;

public class DetectPatternAttackThreeTest {

    private ImmutableList<Pattern> lisOfPattern;
    private String stringToAnalyzed;
    private DetectPatternAttackThree detectPatternAttackThree;
    private List<String> findPattern;
    private ImmutableList<Pattern> patternToIgnore;

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

    @Test
    public void words_matches_question_three(){
        givenADetectPatternAttack();
        givenAListOfPattern(of(compile("(the)"), compile("(fox|f.nce)"), compile("(abc)")));
        givenAPatterToIgnore(of(compile("f.x")));
        givenAStringToAnalyzed();
        whenAStringIsAnalyzed();
        thenReturnPatternFound(Arrays.asList("the", "fence"));
    }

    private void givenAPatterToIgnore(ImmutableList<Pattern> aPatternToIgnore) {
        patternToIgnore = aPatternToIgnore;
    }


    private void givenAListOfPattern(ImmutableList<Pattern> patterns) {
        lisOfPattern = patterns;
    }


    private void givenAStringToAnalyzed() {
        stringToAnalyzed = "The fox jumped over the fence";
    }

    private void givenADetectPatternAttack() {
        detectPatternAttackThree = new DetectPatternAttackThree();
    }

    private void whenAStringIsAnalyzed() {
        findPattern = detectPatternAttackThree.findPatterns(lisOfPattern, stringToAnalyzed, ofNullable(patternToIgnore));
    }

    private void thenReturnPatternFound(List<String> expectedValue) {
        assertTrue(findPattern.size() == expectedValue.size());
        assertTrue(findPattern.containsAll(expectedValue));
    }

}
