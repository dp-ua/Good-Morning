package com.examples.goodmorning.user;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInOut implements UI {
    private static final Logger log = Logger.getLogger(ConsoleInOut.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void write(String message) {
        log.trace("Write message to console: " + message);
        System.out.println(message);
    }

    public String read() throws IOException {
        String readln = reader.readLine();
        log.trace("Read message from console: " + readln);
        return readln;
    }
}
