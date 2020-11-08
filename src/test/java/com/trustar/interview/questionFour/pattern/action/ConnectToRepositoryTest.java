package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.infraestructure.GithubConnection;
import org.junit.Test;

public class ConnectToRepositoryTest {

    public static final String MITRE_CTI = "mitre/cti/";
    public static final String MITRE_CTI_WRONG = "mitre/wrong/";
    private String repositoryPath;
    private ConnectToRepository connectToRepository;
    private GithubConnection aRepositoryInstance = new GithubConnection();

    @Test(expected = Exception.class)
    public void error_when_connect_to_repository() throws Exception {
        givenARepositoryPath(MITRE_CTI_WRONG);
        givenARepositoryConnection();
        whenConnect();
    }

    @Test
    public void connect_to_repository() throws Exception {
        givenARepositoryPath(MITRE_CTI);
        givenARepositoryConnection();
        whenConnect();
        thenInstanceIsAvailable();
    }


    private void givenARepositoryConnection() {
        connectToRepository = new ConnectToRepository(aRepositoryInstance);
    }

    private void givenARepositoryPath(String path) {
        repositoryPath = path;
    }

    private void whenConnect() throws Exception {
            connectToRepository.connect(repositoryPath);
    }

    private void thenInstanceIsAvailable() {
        //Connection works, didn`t throw exception
    }
}