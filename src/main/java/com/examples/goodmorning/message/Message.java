package com.examples.goodmorning.message;

import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.Map;

import static com.examples.goodmorning.message.TypeOfTime.*;

/**
 * Class for operation with text Message
 */
public class Message {
    private static final Logger log = Logger.getLogger(Message.class);

    private Resourse resourse = new Resourse();

    /**
     * Determines which type of time corresponds to the specified number of hours.
     *
     * @param h time is indicated as an hour
     * @return Type of time according to enum TypeOfTime
     * @throws IllegalArgumentException if the input argument is out of range
     */
    public TypeOfTime getTypeByHour(int h) throws IllegalArgumentException {
        TypeOfTime type = NIGHT;
        if (h < 0 || h > 24) throw new IllegalArgumentException("Hours must be between 0 and 24");
        if (h >= 6 && h <= 8) type = MORNIGN;
        if (h >= 9 && h <= 18) type = DAY;
        if (h >= 19 && h <= 22) type = EVENING;
        log.debug("Hours:" + h + ". Detecting type is " + type.toString());

        return type;
    }

    /**
     * Get text message from resourse according to the specified locale
     *
     * @param type   Type of Time from enum TypeOfTime
     * @param locale specified locale
     * @return String message to the specified time type in the language of the requested locale.
     */
    public String getMessage(TypeOfTime type, Locale locale) {
        Map<TypeOfTime, String> map = resourse.getMessagesByLocale(locale);
        String result = map.get(type);
        log.debug("Type: " + type.toString() +
                ", Locale: " + locale.getDisplayLanguage() +
                ", text message result: " + result);
        return result;
    }

}
