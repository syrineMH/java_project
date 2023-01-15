package ds.searchengine.tool;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.util.*;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws FileNotFoundException {
        Map<String, Set<Integer>> computedJson= App.readJsonToHashMap("src/main/resources/input/hash_text_test.json");
        Map<String, Set<Integer>> expectedJson = new HashMap<>();
        expectedJson.put("Paris",new HashSet<>(Arrays.asList(1,2,4,6,9)));
        expectedJson.put("3ds",new HashSet<>(Arrays.asList( 1,5,2,9,4,6)));
        assertEquals(expectedJson, computedJson);
    }
    public void testAppe2e() throws FileNotFoundException {
        Map<String, Set<Integer>> computedJson= App.readJsonToHashMap("src/main/resources/input/hash_text_test.json");
        String[] words={"Paris", "3ds"};
        Set<Integer> searchResult =App.searchLineNumbers(computedJson, words);
        Set<Integer> expectedSet =new HashSet<>(Arrays.asList(1, 2,4,6,9));

        assertEquals(searchResult, expectedSet);
    }
}
