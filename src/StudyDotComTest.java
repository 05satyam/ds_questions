import java.util.HashMap;
import java.util.Map;

public class StudyDotComTest {

    private Map<String, Integer> map;

    public StudyDotComTest() {
        map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 3);
    }

    public int getValue(String input, int numRetries)  {
        try {
            System.out.println("map.get(input); "+ map.get(input));
            return map.get(input);

        }
        catch (Exception e) {
            if (numRetries > 3) {
                System.out.println("numRetries "+ numRetries);
                throw e;
            }
            return getValue(input, numRetries + 1);
        }
    }

    public static void main(String[] a){
        StudyDotComTest sb = new StudyDotComTest();
        try {
           // System.out.println(sb.getValue("foo", 0));
            //System.out.println(sb.getValue("bar", 2));
            //System.out.println(sb.getValue("baz", 0));
            System.out.println(sb.getValue("fubar", 1));
        }catch(Exception e){
            System.out.println("in exep " + e.getMessage());
        }
    }
}


//Lets start with input :
// getValue("foo", 0) --> works fine because foo is present int he hashmap and it will return 1
// getValue("bar", 2)--> works fine because bar is present int he hashmap and it will return 3
//
// Now for inputs getValue("baz", 0) and getValue("fubar", 1)
//
//     Expected behaviour of Hashmap is if a key is not present in the map then map will return null with no exception
//     However, in the given code snipped map is created using Wrapper Class ( Map<String, Integer>) and the getValue is returing "int" data type value.
//     So, In this code snippet when hashmap get() returns null(if key not found in map), an attempt to unbox that null to an int would result in a runtime NullPointerException due to the wrapper class of Integer and compile will go the catch block.
//     When catch block is encountered, we have a condition of numRetries > 3 then retrun the exception else recursivley calls getValue(input, numRetries + 1); with incremeting numRetries by 1.
//
//     So for inputs :
//       getValue("baz", 0) --> at numRetries == 4 the exception will be thrown by catch block(i.e. an initial call plus 4 retries) because numRetries starting from 0
//       getValue("fubar", 1)-->at numRetries == 4 the exception will be thrown by catch block(i.e. an initial call plus 3 retries) because numRetries starting from 1
//