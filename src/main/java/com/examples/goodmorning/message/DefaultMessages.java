package com.examples.goodmorning.message;

import java.util.ListResourceBundle;

public class DefaultMessages extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"MORNING", "Good morning, World!"},
                {"DAY", "Good day, World!"},
                {"EVENING", "Good evening, World!"},
                {"NIGHT", "Good night, World!"},
        };
    }
}
