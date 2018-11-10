package com.examples.goodmorning.message;

import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.Map;

import static com.examples.goodmorning.message.TypeOfTime.*;

public class Message {
    private static final Logger log = Logger.getLogger(Message.class);

    private Resourse resourse = new Resourse();

    public TypeOfTime getTypeByHour(int h) {
        TypeOfTime type  = NIGHT;
        if (h < 0 || h > 24) throw new IllegalArgumentException("Hours must be between 0 and 24");
        if (h >= 6 && h <= 8) type= MORNIGN;
        if (h >= 9 && h <= 18) type= DAY;
        if (h >= 19 && h <= 22) type= EVENING;
        log.debug("Hours:" + h + ". Detecting type is " + type.toString());

        return type;

    }

    public String getMessage(TypeOfTime type, Locale locale) {
        Map<TypeOfTime, String> map = resourse.getMessagesByLocale(locale);
        String result = map.get(type);
        log.debug("Type: " + type.toString() +
                ", Locale: " +locale.getDisplayLanguage() +
                ", text message result: " + result);
        return result;
    }

}
