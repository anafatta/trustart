package com.trustar.interview.questionFour.pattern.action;

import com.trustar.interview.questionFour.pattern.infraestructure.GithubConnection;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectToRepositoryTest {

    public static final String MITRE_CTI = "mitre/cti/";
    private String repositoryPath;
    private ConnectToRepository connectToRepository;
    private GithubConnection aRepositoryInstance = new GithubConnection();

    @Test
    public void connect_to_repository() {
        givenARepositoryPath();
        givenARepositoryConnection();
        whenConnect();
        thenInstanceIsAvailable();
    }

    private void givenARepositoryConnection() {
        connectToRepository = new ConnectToRepository(aRepositoryInstance);
    }

    private void givenARepositoryPath() {
        repositoryPath = MITRE_CTI;
    }

    private void whenConnect() {
        connectToRepository.connect(repositoryPath);
    }

    private void thenInstanceIsAvailable() {
       assertNotNull(aRepositoryInstance.connection());
    }

}