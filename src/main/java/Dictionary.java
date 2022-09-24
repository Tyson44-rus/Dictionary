import org.json.simple.JSONArray;

public class Dictionary {
    public static String filePath;
    protected static JSONArray dictionary;

    Dictionary(String filePath) {
        Dictionary.filePath = filePath;
        dictionary = DictionaryMethods.reader();
    }

    Dictionary() {
        filePath = "";
    }

    public static void writer(String s, String s1) {
        DictionaryMethods.writer(s, s1);
    }
}
