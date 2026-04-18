package com.strands.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        // To run this example, move the file to interview-eventmanager/src/main/java/com/strands/interviews
        questionA("f.soler@strands.com");
        questionA("i.tarradellas@strands.com");
        questionA("a.dereina@strands.com");
        questionA("invalid@strands.com");

        questionB("ELCORTEINGLES28/5/13");
        questionB("CARREFOUR2/10/13");
    }

    private static void questionA(String emailInput) {
        Pattern pattern = Pattern.compile("^[a-z]\\.[a-z]+@strands\\.com$");
        Matcher matcher = pattern.matcher(emailInput);
        boolean matchFound = matcher.find();
        System.out.println(matchFound ? "Match found" : "Match not found");
    }

    private static void questionB(String input) {
        Pattern pattern = Pattern.compile("^([A-Z]+)(\\d{1,2}/\\d{1,2}/\\d{1,2})$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String date = matcher.group(2);
            System.out.println("Date: " + date);
        }
    }
}