import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DictionaryMethods extends Dictionary {
    DictionaryMethods() {

    }

    public static void writer(String key, String word) {
        try {
            JSONObject temp = new JSONObject();
            temp.put(key, word);
            dictionary.add(temp);
            FileWriter file = new FileWriter(filePath, false);
            file.write(dictionary.toJSONString());
            file.close();
            System.out.println("Успешно записали данную пару слов");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writer() {
        try {
            FileWriter file = new FileWriter(filePath, false);
            file.write(dictionary.toJSONString());
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static JSONArray reader() {
        try {
            File file = new File(filePath);
            if (file.length() == 0) return new JSONArray();
            else return (JSONArray) new JSONParser().parse(new FileReader(filePath));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JSONArray();
    }

    public static void remover(String key) {
        boolean flag = false;
        try {
            for (int i = 0; i < dictionary.size(); i++) {
                JSONObject jOb = (JSONObject) dictionary.get(i);
                if (!(jOb.get(key) == null)) {
                    dictionary.remove(jOb);
                    writer();
                    flag = true;
                    System.out.println("Успешно удалили");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!flag) System.out.println("Нет такого слова");
    }

    public static String search(String key) {
        for (Object o : dictionary) {
            JSONObject jOb = (JSONObject) o;
            if (!(jOb.get(key) == null)) return (String) jOb.get(key);
        }
        return "Не удалось найти";
    }
}
