/**
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 *
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 *
 *
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 *
 *
 */
package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimitter {
    String msg;
    int timeStamp;

    public LoggerRateLimitter() {

    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String getMsg() {
        return msg;
    }

    public int getTimeStamp() {
        return timeStamp;
    }
    Map<String, Integer> currMsgTime = new HashMap<>();
    public boolean shouldPrintMessage(int timestamp, String message) {
            if(currMsgTime.containsKey(message)){
                if(currMsgTime.get(message)>timestamp)
                    return false;
                else{
                    currMsgTime.put(message, 10+timestamp);
                    return true;
                }
            }else{
                currMsgTime.put(message, 10+timestamp);
            }
        return true;
    }
}
