package lexicalanalyzer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SymbolsDict {

    SymbolsDict(SymbolPack symbolPack) {
        this.symbols = symbolPack;
    }

    SymbolPack symbols;
    private Map<String, Integer> idMap = new HashMap<>();
    private Map<String, Integer> literalMap = new HashMap<>();

    /**Finds and returns a constant symbol from map*/
    public int getSymbol(String symbol) {
        return this.symbols.find(symbol);
    }

    /**Returns a set containing all constant symbols*/
    public Set<String> symbolSet() {
        return this.symbols.symbolSet();
    }
    public Set<String> spacedSymbolSet() {
        return this.symbols.spacedSymbolSet();
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
        return this.symbols.getIdentifierCode();
    }

    /**Returns a code for a literal*/
    public int getLiteralCode() {
        return this.symbols.getLiteralCode();
    }
}
