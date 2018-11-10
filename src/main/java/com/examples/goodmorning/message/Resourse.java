package com.examples.goodmorning.message;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Resourse {
    private static final Logger log = Logger.getLogger(Resourse.class);

    private Map<String, Map<TypeOfTime, String>> localeMessages = new HashMap();

    public Resourse() {

        Map<TypeOfTime, String> mapDefault = new HashMap<TypeOfTime, String>();
        mapDefault.put(TypeOfTime.MORNIGN, "Good morning, World!");
        mapDefault.put(TypeOfTime.DAY, "Good day, World!");
        mapDefault.put(TypeOfTime.EVENING, "Good evening, World!");
        mapDefault.put(TypeOfTime.NIGHT, "Good night, World!");
        localeMessages.put(Locale.ENGLISH.getDisplayLanguage(), mapDefault);
        log.trace("Put to map message for Locale en");

        Map<TypeOfTime, String> mapRu = new HashMap<TypeOfTime, String>();
        mapRu.put(TypeOfTime.MORNIGN, "Доброе утро, Мир!");
        mapRu.put(TypeOfTime.DAY, "Добрый день, Мир!");
        mapRu.put(TypeOfTime.EVENING, "Добрый вечер, Мир!");
        mapRu.put(TypeOfTime.NIGHT, "Доброй ночи, Мир!");
        localeMessages.put(new Locale("ru").getDisplayLanguage(), mapRu);
        log.trace("Put to map message for Locale ru");

    }

    public Map<TypeOfTime, String> getMessagesByLocale(Locale locale) {
        Map<TypeOfTime, String> map;
        if (localeMessages.containsKey(locale.getDisplayLanguage())) {
            log.debug("Return messages for locale: " + locale.getDisplayLanguage());
            return localeMessages.get(locale.getDisplayLanguage());
        } else {
            log.debug("Map does not contain messages for locale: " +
                    locale.getDisplayLanguage() +
                    ". Return default for EN");
            return localeMessages.get(Locale.ENGLISH);
        }
    }
}
