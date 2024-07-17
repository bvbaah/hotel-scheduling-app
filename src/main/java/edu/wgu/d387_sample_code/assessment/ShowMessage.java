package edu.wgu.d387_sample_code.assessment;

import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ShowMessage {

    private List<String> messageList = new ArrayList<>();

    public String[] getWelcomeMessage() {
        ExecutorService messageExecutor = Executors.newFixedThreadPool(5);
        Properties properties = new Properties();

        // Submit tasks to load messages asynchronously
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(stream);
                String welcomeMessage = properties.getProperty("welcome");
                synchronized (messageList) {
                    messageList.add(welcomeMessage);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);
                String welcomeMessage = properties.getProperty("welcome");
                synchronized (messageList) {
                    messageList.add(welcomeMessage);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        // Shutdown the ExecutorService after submitting tasks
        messageExecutor.shutdown();

        // Return the messages
        return awaitAndReturnMessages(messageExecutor);
    }

    private String[] awaitAndReturnMessages(ExecutorService messageExecutor) {
        try {
            // Wait for tasks to finish
            messageExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Synchronize access to the message list
        synchronized (messageList) {
            return messageList.toArray(new String[0]); // Return an array of messages
        }
    }
}
