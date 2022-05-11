package edu.htwk.fdit.prog2.uebung5.persistence;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTutorial {
    public static void main(String[] args) {
        Pattern pattern = null;
        Matcher matcher;
        String regEx = "[A-Za-z0-9]+=[0-9]+";
        String logContent;
        int matches = 0;

        try {
            logContent = LogReader.readFile();
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(logContent);

            while(matcher.find()) {
                matches++;
                System.out.println(matcher.group());
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Found " + pattern + " " + matches + " times");
    }
}
