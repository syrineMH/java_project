package ds.searchengine.tool;

import ds.util.TextSplit;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

    public class MapText {
        public static Map<String, Set<Integer>> getWordLineNumbers(String filepath) throws IOException {
            Map<String, Set<Integer>> wordLineNumbers = new HashMap<>();
            try {
                    Scanner scanner = new Scanner(new File(filepath));
                    //String line;
                    int lineNumber = 0;
                    while (scanner.hasNextLine()) {
                        lineNumber++;
                        String line=scanner.nextLine();
                        //text traitement
                        String[] words = TextSplit.getWords(line);
                        String[] cleanWords=TextSplit.cleanWords(words);
                        //for each words
                        for (String word : cleanWords) {
                            if (word.length()>1) {
                                //If the word in wordlineNumbers we get the set of line numbers where it appears
                                //If not we get an empty set

                                Set<Integer> lineNumbers = wordLineNumbers.getOrDefault(word, new HashSet<>());
                                //add our ligne to the set lines already exist(if there are)
                                lineNumbers.add(lineNumber);

                                wordLineNumbers.put(word, lineNumbers);
                            }
                        }
                    }
                }
            catch (IOException e){
                e.printStackTrace();
            }
            return wordLineNumbers;
        }

        public static void createJsonFile(Map<String, Set<Integer>> map, String filepath) throws  IOException {
            //using a mapper object to create a json file fro a map collection
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(filepath), map);
        }


    }













