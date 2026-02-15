package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class WelcomeService {
    public String getWelcomeMessages() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> english = executor.submit(() -> ResourceBundle.getBundle("messages", Locale.ENGLISH).getString("welcome"));
        Future<String> french = executor.submit(() -> ResourceBundle.getBundle("messages", Locale.FRENCH).getString("welcome"));

        String result = english.get() + " | " + french.get();

        executor.shutdown();

        return result;
    }
}
