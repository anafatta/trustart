package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;
import com.trustar.interview.questionFour.pattern.infraestructure.GithubConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.base.Strings.isNullOrEmpty;

public class RetrieveFileTest {

    private RetrieveFile retrieveFile;
    private RepositoryInstance repositoryInstance = new GithubConnection();
    private static final String MITRE_CTI = "mitre/cti/";
    private static final String FILE_PATH = "/enterprise-attack/intrusion-set/intrusion-set--899ce53f-13a0-479b-a0e4-67d46e241542.json";
    private String text;

    @Before
    public void init() throws Exception {
        repositoryInstance.connect(MITRE_CTI);
    }

    @Test(expected = Exception.class)
    public void not_found_file() throws Exception {
        givenARetrieveFileAction();
        whenInvokeAction(null);
    }

    @Test
    public void retrieve_file() throws Exception {
        givenARetrieveFileAction();
        whenInvokeAction(FILE_PATH);
        thenFileFound();
    }

    private void givenARetrieveFileAction() {
        retrieveFile = new RetrieveFile(repositoryInstance);
    }

    private void whenInvokeAction(String path) throws Exception {
        text = retrieveFile.invoke(path);
    }

    private void thenFileFound() {
        Assert.assertTrue(!isNullOrEmpty(text));
    }

}
