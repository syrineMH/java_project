package ds.searchengine.tool;
import ds.util.TextSplit;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import com.fasterxml.jackson.databind.ObjectMapper;

public class App
{     static Map<String, Set<Integer>> readJsonToHashMap(String filepath) throws FileNotFoundException {
    // create instance of the ObjectMapper class to map JSON data
    ObjectMapper mapper = new ObjectMapper();
    // create instance of the File class
    File fileObj = new File(filepath);
    // use try-catch block to convert JSON data into Map
    Map<String, Set<Integer>> data = null;
    try {
        // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes
        data = mapper.readValue(
                fileObj, new TypeReference<Map<String, Set<Integer>>>() {
                });
    } catch (Exception e) {
        // show error message
        System.out.println("Json file not found");
        // If file is  not find we create the file using Htext class
        //But first we shoud create a Map from the text file
        try {
            System.out.println("Reading text file");
            String textFilePath="src/main/resources/input/paris.txt";
            data= MapText.getWordLineNumbers(textFilePath);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            //Now we create the json file from the Map object.
            System.out.println("Creating json file");
            String filepathOutput = "src/main/resources/output/hash_text.json";

            MapText.createJsonFile(data,filepathOutput);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Json file created");
    }
    return data;
}

    public static Set<Integer> searchLineNumbers(Map<String, Set<Integer>> map, String[] words) {

        //Initializing the lineNumbers set with the list
        // of line numbers associated with the first word in the words array.
        Set<Integer> lineNumbers = map.get(words[0]);
        for (String word : words) {
            //If the word does not exist in the HashMap, it returns an empty set.
            if (!map.containsKey(word)) {

                return Collections.emptySet();
            }
            // retainAll maintain only line numbers that match with the line numbers of the recent word.
            lineNumbers.retainAll(map.get(word));

        }
        return lineNumbers;
    }


    public static void main(String[] args) throws IOException {
        String filepath = "src/main/resources/output/hash_text.json";

        Map<String, Set<Integer>> data = readJsonToHashMap(filepath);
        Scanner sc= new Scanner(System.in);
        String exitKey ="";
        while (!exitKey.equals("exit")){
            System.out.print("Enter search keywords separated by blank space :");
            String s= sc.nextLine();
            String[] words= TextSplit.getWords(s);
            String[] cleanWords=TextSplit.cleanWords(words);
            Set<Integer> searchResult =searchLineNumbers(data,cleanWords);
            System.out.println("These lines contain the key words : " + searchResult);
            System.out.println("Would you like to pursue, if no write "+"exit"+" :");
            exitKey= sc.nextLine();//.toLowerCase().trim().replaceAll("[;,:.]", "");
            System.out.println(exitKey);
        }


    }

}



