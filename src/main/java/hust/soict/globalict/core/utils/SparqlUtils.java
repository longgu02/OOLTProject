package hust.soict.globalict.core.utils;

public class SparqlUtils {
    public static String convertOptionalQuery(String triple){
        String result = "    OPTIONAL {" +  triple + "}\n";
        return result;
    }
}
