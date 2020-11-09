package com.trustar.interview.questionFour.pattern.action;

import com.google.common.collect.ImmutableList;
import com.trustar.interview.questionFour.pattern.infraestructure.GithubConnection;
import com.trustar.interview.questionThree.DetectPatternAttackThree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.google.common.collect.ImmutableList.of;
import static com.trustar.interview.questionFour.pattern.domain.URIUtils.*;
import static java.util.regex.Pattern.compile;
import static org.junit.Assert.assertTrue;

public class FindWordsTest {

    private FindWords findWords;

    private GithubConnection repositoryInstance = new GithubConnection();
    private DetectPatternAttackThree matchFinder = new DetectPatternAttackThree();
    private String text;
    private List<String> listOfMatches;
    private List<String> listOfMatchesWithAllParameters;

    @Before
    public void init() throws Exception {
        repositoryInstance.connect(MITRE_CTI);
    }

    @Test
    public void not_found_matches(){
        givenAFindWordAction();
        whenFindByPattern(of(compile("(abc)")));
        thenEmptyMatchesReturn();
    }

    @Test
    public void retrieve_all_http_and_https_matches() throws Exception {
        givenAFindWordAction();
        givenAFileToAnalyzed(FILE_PATH);
        whenFindByPattern(of(compile("(http:\\/\\/|https:\\/\\/)")));
        thenMatchesFound();
    }

    @Test
    public void retrieve_matches_with_avoid_patterns() throws Exception {
        givenAFindWordAction();
        givenAFileToAnalyzed(FILE_PATH_WITH_SYMANTEC);
        whenFindByPattern(of(compile("(http:\\/\\/|https:\\/\\/)")));
        whenFindByPatternWithAvoidPattern(of(compile("(http:\\/\\/|https:\\/\\/)")), Optional.of(of(compile("(symantec.com|cybereason.com)"))));
        thenMatchesFoundWithAllParameters();
    }

    @Test
    public void retrieve_all_requested_matches() throws Exception {
        givenAFindWordAction();
        givenAFileToAnalyzed(FILE_PATH);
        whenFindByPattern(of(compile("(http:\\/\\/|https:\\/\\/)"), compile("APT..")));
        whenFindByPatternWithAvoidPattern(of(compile("APT.."), compile("(http:\\/\\/|https:\\/\\/)")), Optional.of(of(compile("(symantec.com|cybereason.com)"))));
        thenMatchesFound();
    }

    private void givenAFindWordAction() {
        findWords = new FindWords(repositoryInstance, matchFinder);
    }

    private void givenAFileToAnalyzed(String filePath) throws Exception {
        text = repositoryInstance.retrieveFile(filePath);
    }

    private void whenFindByPattern(ImmutableList<Pattern> patterns) {
        listOfMatches = findWords.findPattern(patterns, text, Optional.empty());
    }

    private void whenFindByPatternWithAvoidPattern(ImmutableList<Pattern> patterns, Optional<ImmutableList<Pattern>> avoidPatterns) {
        listOfMatchesWithAllParameters = findWords.findPattern(patterns, text, avoidPatterns);
    }

    private void thenEmptyMatchesReturn() {
        assertTrue(listOfMatches.isEmpty());
    }

    private void thenMatchesFound() {
        assertTrue(listOfMatches.size() > 0);
    }

    private void thenMatchesFoundWithAllParameters() {
        assertTrue(listOfMatches.size() > 0);
        assertTrue(listOfMatchesWithAllParameters.size() > 0);
        assertTrue(listOfMatches.size() > listOfMatchesWithAllParameters.size());
    }
}
