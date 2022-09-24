import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    static final Pattern patAnySymbol = Pattern.compile("[a-zA-Z0-9]+");
    static final Pattern patNumber = Pattern.compile("[0-9]+");
    static Scanner sc = new Scanner(System.in);
    public static String temp;
    public static String start;
    public static boolean flag = false;
    static Dictionary dr = new Dictionary();
    static Dictionaries dc = null;

    public static void printMenu_1() {
        do {
            System.out.print("Какой словарь будем использовать? (1 или 2): ");
            start = sc.next();
            Matcher matPatNumber = patNumber.matcher(start);
            if (start.equals("1") && matPatNumber.matches()) {
                dr = new Dictionary("json.txt");
                dc = new Dictionary_1();
                flag = true;
            } else if (start.equals("2") && matPatNumber.matches()) {
                dr = new Dictionary("json2.txt");
                dc = new Dictionary_2();
                flag = true;
            } else {
                System.out.println("Неверный номер словаря");
            }
        } while (!flag);
    }

    public static void printMenu_2() {
        printMenu_1();
        do {
            System.out.print("Текущий словарь: " +
                    start +
                    '\n' +
                    "Что хотите сделать?\n" +
                    "1. Прочитать словарь\n" +
                    "2. Записать в словарь\n" +
                    "3. Удалить из словаря\n" +
                    "4. Найти определенное слово\n" +
                    "5. Сменить словарь\n" +
                    "6. Выйти\n");
            System.out.print("Номер: ");
            temp = sc.next();
            switch (temp) {
                case "1":
                    System.out.println("Содержимое " + start + "-го словаря: ");
                    JSONArray js = DictionaryMethods.reader();
                    js.forEach(item -> {
                        JSONObject obj = (JSONObject) item;
                        System.out.println(obj.toString());
                    });
                    break;
                case "2":
                    do {
                        System.out.print("Введите 1-е и 2-е слово через символ ':': ");
                        temp = sc.next();

                        Matcher matAnySymbol = patAnySymbol.matcher(temp);
                        int findSym = temp.indexOf(':');
                        boolean findSym2 = matAnySymbol.find(0);
                        boolean findSym3 = matAnySymbol.find(findSym + 1);

                        if (findSym != -1 && findSym2 && findSym3) {
                            String[] str = temp.split(":");
                            if (dc.check(temp)) Dictionary.writer(str[0], str[1]);
                            else System.out.println("Неверное слово");
                        } else System.out.println("Неверный формат или отсутствует какое-либо слово");

                        System.out.print("Хотите внести еще одну пару? (y/n): ");
                        temp = sc.next();
                    } while (temp.equals("y"));
                    break;
                case "3":
                    do {
                        System.out.print("Введите ключ для удаления определенной пары: ");
                        temp = sc.next();
                        if (dc.check_2(temp)) DictionaryMethods.remover(temp);
                        else System.out.println("Неверное слово");
                        System.out.print("Хотите удалить еще одну пару? (y/n): ");
                        temp = sc.next();
                    } while (temp.equals("y"));
                    break;
                case "4":
                    do {
                        System.out.print("Введите по какому ключу будет осуществляться поиск: ");
                        temp = sc.next();
                        if (dc.check_2(temp)) System.out.println(DictionaryMethods.search(temp));
                        else System.out.println("Неверное слово");
                        System.out.print("Хотите еще чего-нибудь найти? (y/n): ");
                        temp = sc.next();
                    } while (temp.equals("y"));
                    break;
                case "5":
                    printMenu_1();
                    break;
                case "6":
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Неверный номер");
            }
        } while (!temp.equals("6"));
    }
}
