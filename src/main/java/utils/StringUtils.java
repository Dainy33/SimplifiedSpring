package utils;

public class StringUtils {
    public static String UpperCaseFirstChar(String str){
        String firstCharStr = str.substring(0, 1);
        String lastCharStr = str.substring(1);
        return firstCharStr.toUpperCase()+lastCharStr;
    }
}
