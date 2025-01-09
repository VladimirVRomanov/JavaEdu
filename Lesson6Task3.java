/*
    Написать метод, который возвращает true, если в мапе нет двух и более одинаковых value, и false в противном случае.
    Для пустой мапы метод возвращает true.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Lesson6Task3 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
        isUniqueMessage(map);
        map.put("1", "Один");
        map.put("2", "Два");
        map.put("3", "Три");
        map.put("4", "Четыре");
        map.put("5", "Пять");
        isUniqueMessage(map);
        map.replace("5", "Четыре");
        isUniqueMessage(map);
    }

    public static boolean isUnique(Map<String, String> map) {
        Map<String, String> copyOfMap = new HashMap<>(Map.copyOf(map));
        for (var item : map.entrySet()) {
            copyOfMap.remove(item.getKey());
            if (copyOfMap.containsValue(item.getValue()))
                return false;
        }
        return true;
    }

    public static void isUniqueMessage(Map<String, String> map) {
        System.out.printf("\nДля коллекции " + map.values().toString() + " метод isUnique() вернул %b\n", isUnique(map));
    }
}