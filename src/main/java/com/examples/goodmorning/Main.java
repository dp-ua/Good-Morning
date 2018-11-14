package com.examples.goodmorning;

import com.examples.goodmorning.message.Message;

import com.examples.goodmorning.message.TypeOfTime;
import com.examples.goodmorning.user.ConsoleInOut;
import com.examples.goodmorning.user.UI;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Locale;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            UI console = new ConsoleInOut();
            Message message = new Message();
            Locale locale = Locale.getDefault();

            int hours = Calendar.getInstance().getTime().getHours();

            TypeOfTime type = message.getTypeByHour(hours);

            console.write(message.getMessage(type,locale));

        } catch (Throwable e) {
            log.error(e.getMessage(),e);
            e.printStackTrace();
        }
    }
}
