package com.examples.goodmorning.message;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getTypeMorning() {
        Message message = new Message();
        int hours = 7;
        Assert.assertEquals(TypeOfTime.MORNIGN,message.getTypeByHour(hours));
    }

    @Test
    public void getTypeDay() {
        Message message = new Message();
        int hours = 13;
        Assert.assertEquals(TypeOfTime.DAY,message.getTypeByHour(hours));
    }

    @Test
    public void getTypeEvening() {
        Message message = new Message();
        int hours = 22;
        Assert.assertEquals(TypeOfTime.EVENING,message.getTypeByHour(hours));
    }

    @Test
    public void getTypeNight() {
        Message message = new Message();
        int hours = 3;
        Assert.assertEquals(TypeOfTime.NIGHT,message.getTypeByHour(hours));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTypeException() {
        Message message = new Message();
        int hours = 26;
        Assert.assertEquals(TypeOfTime.NIGHT,message.getTypeByHour(hours));
    }


    @Test
    public void getMessage() {
        Locale locale= new Locale("en","US");
        TypeOfTime type = TypeOfTime.NIGHT;
        Message message = new Message();
        Assert.assertEquals("Good night, World!", message.getMessage(type,locale));

    }
}