package com.examples.goodmorning.message;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static com.examples.goodmorning.message.TypeOfTime.*;

/**
 * Class for operation with text Message
 */
public class Message {
    private static final Logger log = Logger.getLogger(Message.class);

    ResourceBundle resourceBundle = null;

    /**
     * Determines which type of time corresponds to the specified number of hours.
     *
     * @param h time is indicated as an hour
     * @return Type of time according to enum TypeOfTime
     * @throws IllegalArgumentException if the input argument is out of range
     */
    public TypeOfTime getTypeByHour(int h) throws IllegalArgumentException {
        TypeOfTime type = NIGHT;
        if (h < 0 || h > 24) {
            log.error("Hours: " + h + ". Illegal argumet");
            throw new IllegalArgumentException("Hours must be between 0 and 24");
        }
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
     * If not find Resource for specified locale - use default locale("en","US")
     * @throws MissingResourceException when default en_US messages file not found
     */
    public String getMessage(TypeOfTime type, Locale locale) throws MissingResourceException {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(locale);
            resourceBundle = ResourceBundle.getBundle("Messages");
        } catch (MissingResourceException mr) {
            if (locale.equals(new Locale("en", "US"))) {
                log.error("Locale: en_US not found. Cant load default messages. Need file: Messages_en_US.properties");
                throw mr;
            } else {
                log.error("Locale: " + locale.toString() + " not found. Loading en_US locale messages ");
                return getMessage(type, new Locale("en", "US"));
            }
        }

        String result = resourceBundle.getString(type.toString());
        try {
            result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        log.debug("Type: " + type.toString() +
                ", Locale: " + locale.getDisplayLanguage() +
                ", text message result: " + result);
        Locale.setDefault(defaultLocale);
        return result;
    }

}
