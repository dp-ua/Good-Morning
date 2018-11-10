package com.examples.goodmorning.user;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements of User In out Interface
 * Console implementation
 */
public class ConsoleInOut implements UI {
    private static final Logger log = Logger.getLogger(ConsoleInOut.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Write String to User
     * @param message string to user
     */
    public void write(String message) {
        log.trace("Write message to console: " + message);
        System.out.println(message);
    }

    /**
     * Get string from user
     * @return String from user from console
     * @throws IOException some input|output exception during input
     */
    public String read() throws IOException {
        String readln = reader.readLine();
        log.trace("Read message from console: " + readln);
        return readln;
    }
}
