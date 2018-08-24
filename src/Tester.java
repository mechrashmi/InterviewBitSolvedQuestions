import java.util.LinkedHashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        int capacity = 3;
        LinkedHashMap<Integer, Integer> cache= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            public boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }
}
