/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * Implement the Solution class:
 *
 * Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 *
 * Input: url = "https://leetcode.com/problems/design-tinyurl"
 * Output: "https://leetcode.com/problems/design-tinyurl"
 *
 * Explanation:
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // returns the encoded tiny url.
 * string ans = obj.decode(tiny); // returns the original url after deconding it.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EncodeDecodeTinyUrl {
    Map<String, String> urlToIdxMap = new HashMap<>();
    public String encode(String longUrl) {
        char[] urlChar = longUrl.toCharArray();

        String uuid = String.valueOf(System.currentTimeMillis()).substring(0,5)+ UUID.randomUUID().toString().substring(0,5);
        urlToIdxMap.put(uuid , longUrl);

        return uuid;
    }

    public String decode(String shortUrl) {
        return urlToIdxMap.get(shortUrl);
    }



    //solution2

    int val=0;
    Map<String, String> urlToIdxMap1 = new HashMap<>();
    public String encode1(String longUrl) {
        char[] urlChar = longUrl.toCharArray();

        String uuid = "http://tinyurl.com/" + val++;
        urlToIdxMap1.put(uuid , longUrl);

        return uuid;
    }

    public String decode1(String shortUrl) {
        return urlToIdxMap1.get(shortUrl);
    }


}
