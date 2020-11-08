package com.trustar.interview.questionFour.pattern.infraestructure;

import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GithubConnection implements RepositoryInstance {

    private GHRepository connection;

    @Override
    public void connect(String repository) {
        try {
            GitHub github = GitHub.connectAnonymously();
            connection = github.getRepository(repository);
        } catch (IOException e) {
            System.out.println("Can not connect to github repository: " + repository);
        }
    }

    public GHRepository connection(){
        return connection;
    }

}
