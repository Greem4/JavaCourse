package edu.javacourse.date;

import java.util.*;

public class Starter {
    public static void main(String[] args) {

        String[] tmz = TimeZone.getAvailableIDs();
        for (String s : tmz) {
            System.out.println(s);
        }
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale loc : locales) {
            if (loc.getDisplayLanguage().equals("английский"))
            System.out.println(loc.getDisplayLanguage() + ":" +
                    loc.getDisplayCountry() + ":" + loc.getDisplayVariant());
        }

        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), new Locale("ru"));
        System.out.println(c);


    }
}
