

public class Logger {
    Map<String, Integer> lastPrintTime;
   
    public Logger() {
        lastPrintTime = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
    
        if(lastPrintTime.containsKey(message)) {
//         	如果两个time差距小于10，就false
            if(timestamp - lastPrintTime.get(message) < 10){
                return false;
            }
        }
        
//         如果map里没有这个message，或者两个time差距大于等于10，
//         就把新的time加到这个msg里
        lastPrintTime.put(message, timestamp);
        
        return true;
    }
}