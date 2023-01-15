package ds.util;

import java.util.Arrays;

public class TextSplit {
   public static String[] getWords(String s){
        String[] words = s.split("\\s+");
        return words;
    }
    public static String [] cleanWords (String[]  words){
        String[] cleanWords = Arrays.stream(words)
                .map(String::toLowerCase).map(String::trim).map(s->s.replaceAll("[;,:.]", ""))
                .toArray(String[]::new);
        return cleanWords;


    }
}
