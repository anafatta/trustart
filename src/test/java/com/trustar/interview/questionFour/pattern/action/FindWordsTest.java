package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.infraestructure.GithubConnection;
import com.trustar.interview.questionThree.DetectPatternAttackThree;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FindWordsTest {

    private FindWords findWords;
    public static final String MITRE_CTI = "mitre/cti/";
    private GithubConnection repositoryInstance = new GithubConnection();
    private DetectPatternAttackThree matchFinder = new DetectPatternAttackThree();

    @Before
    public void init() throws Exception {
        repositoryInstance.connect(MITRE_CTI);
    }

    @Test
    public void not_found_matches(){
        givenAFindWordAction();
        whenFindByPattern();
        thenEmptyMatchesReturn();
    }

    private void givenAFindWordAction() {
        findWords = new FindWords(repositoryInstance, matchFinder);
    }

    private void whenFindByPattern() {
        findWords.findPattern();
    }

    private void thenEmptyMatchesReturn() {
    }
}
