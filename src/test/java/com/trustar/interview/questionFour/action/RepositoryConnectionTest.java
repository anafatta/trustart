package com.trustar.interview.questionFour.action;

import com.trustar.interview.questionFour.infraestructure.GithubConnection;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RepositoryConnectionTest {

    public static final String MITRE_CTI = "mitre/cti/";
    private String repositoryPath;
    private RepositoryConnection repositoryConnection;
    private GithubConnection aRepositoryInstance = new GithubConnection();

    @Test
    public void connect_to_repository() {
        givenARepositoryPath();
        givenARepositoryConnection();
        whenConnect();
        thenInstanceIsAvailable();
    }

    private void givenARepositoryConnection() {
        repositoryConnection = new RepositoryConnection(aRepositoryInstance);
    }

    private void givenARepositoryPath() {
        repositoryPath = MITRE_CTI;
    }

    private void whenConnect() {
        repositoryConnection.connect(repositoryPath);
    }

    private void thenInstanceIsAvailable() {
       assertNotNull(aRepositoryInstance.connection());
    }

}