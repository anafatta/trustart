package com.trustar.interview.questionFour.pattern.infraestructure;

import com.trustar.interview.questionFour.pattern.domain.RepositoryInstance;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GithubConnection implements RepositoryInstance {

    private GHRepository connection;

    @Override
    public void connect(String repository) throws Exception {
        GitHub github = GitHub.connectAnonymously();
        connection = github.getRepository(repository);
    }

    @Override
    public String retrieveFile(String path) throws Exception {
        return new BufferedReader(new InputStreamReader(connection().getFileContent(path).read(), StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
    }

    private GHRepository connection(){
        return connection;
    }

}
