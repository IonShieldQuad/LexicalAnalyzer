import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SymbolsDict {

    SymbolsDict() {
        this.map.put("program", 1);
        this.map.put("var", 2);
        this.map.put("integer", 3);
        this.map.put("begin", 4);
        this.map.put("end", 5);
        this.map.put("for", 6);
        this.map.put("to", 7);
        this.map.put("do", 8);
        this.map.put("read", 9);
        this.map.put("write", 10);
        this.map.put(":=", 11);
        this.map.put("+", 12);
        this.map.put("-", 13);
        this.map.put("*", 14);
        this.map.put("div", 15);
        this.map.put(";", 16);
        this.map.put(",", 17);
        this.map.put(".", 18);
        this.map.put("(", 19);
        this.map.put(")", 20);
        this.map.put(":", 21);
    }

    private Map<String, Integer> map = new HashMap<>();
    private Map<String, Integer> custom = new HashMap<>();

    /**Finds and returns a constant symbol from map*/
    public int find(String symbol) {
        return this.map.get(symbol);
    }

    /**Returns a set containing all constant symbols*/
    public Set<String> symbolSet() {
        return this.map.keySet();
    }

    /**Adds an identifier to map if it doesn't exist*/
    public boolean addIdentifier(String key) {
        if (!this.custom.containsKey(key)) {
            this.custom.put(key, custom.size());
            return true;
        }
        return false;
    }

    /**Finds and returns identifier from map*/
    public int getIdentifier(String key) {
        return this.custom.get(key);
    }

    /**Returns a code for an identifier*/
    public int getIdentifierCode() {
        return 22;
    }

    /**Returns a code for a literal*/
    public int getLiteralCode() {
        return 23;
    }
}
