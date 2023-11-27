package rate.exception;

public class RateAppException extends java.lang.Exception {
    public static <Key,Value> String noSuchElement(Key key,Value value){
        return "No element found with "+key+": "+value;
    }
}
