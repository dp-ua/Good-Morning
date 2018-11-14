package com.examples.goodmorning.message;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class DefaultMessagesTest {
private final ResourceBundle resourceBundle=new DefaultMessages();


    @Test
    public void containsKey_Day() {
        assertTrue(resourceBundle.containsKey("DAY"));
    }

    @Test
    public void containsKey_EVENING() {
        assertTrue(resourceBundle.containsKey("EVENING"));
    }

    @Test
    public void containsKey_NIGHT() {
        assertTrue(resourceBundle.containsKey("NIGHT"));
    }

    @Test
    public void containsKey_Morning() {
        assertTrue(resourceBundle.containsKey("MORNING"));
    }


}