import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SymbolsDict {

    SymbolsDict() {
        this.symbolsMap.put("program", 1);
        this.symbolsMap.put("var", 2);
        this.symbolsMap.put("integer", 3);
        this.symbolsMap.put("begin", 4);
        this.symbolsMap.put("end", 5);
        this.symbolsMap.put("for", 6);
        this.symbolsMap.put("to", 7);
        this.symbolsMap.put("do", 8);
        this.symbolsMap.put("read", 9);
        this.symbolsMap.put("write", 10);
        this.symbolsMap.put(":=", 11);
        this.symbolsMap.put("+", 12);
        this.symbolsMap.put("-", 13);
        this.symbolsMap.put("*", 14);
        this.symbolsMap.put("div", 15);
        this.symbolsMap.put(";", 16);
        this.symbolsMap.put(",", 17);
        this.symbolsMap.put(".", 18);
        this.symbolsMap.put("(", 19);
        this.symbolsMap.put(")", 20);
        this.symbolsMap.put(":", 21);
    }

    private Map<String, Integer> symbolsMap = new HashMap<>();
    private Map<String, Integer> idMap = new HashMap<>();
    private Map<String, Integer> literalMap = new HashMap<>();

    /**Finds and returns a constant symbol from map*/
    public int find(String symbol) {
        return this.symbolsMap.get(symbol);
    }

    /**Returns a set containing all constant symbols*/
    public Set<String> symbolSet() {
        return this.symbolsMap.keySet();
    }

    /**Adds an identifier to map if it doesn't exist*/
    public boolean addIdentifier(String key) {
        if (!this.idMap.containsKey(key)) {
            this.idMap.put(key, idMap.size());
            return true;
        }
        return false;
    }

    /**Adds an literal to map if it doesn't exist*/
    public boolean addLiteral(String key) {
        if (!this.literalMap.containsKey(key)) {
            this.literalMap.put(key, literalMap.size());
            return true;
        }
        return false;
    }

    /**Finds and returns identifier from map*/
    public int getIdentifier(String key) {
        return this.idMap.get(key);
    }

    /**Finds and returns literal from map*/
    public int getLiteral(String key) {
        return this.literalMap.get(key);
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
