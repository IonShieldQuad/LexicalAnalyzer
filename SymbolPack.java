package lexicalanalyzer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class SymbolPack {

    SymbolPack() {
        initSymbols();
    }

    private final Map<String, Integer> symbolsMap = new HashMap<>();
    private final Map<String, Integer> spacedSymbolsMap = new HashMap<>();
    private int identifierCode;
    private int literalCode;

    protected void add(String symbol) {
        this.symbolsMap.put(symbol, this.getSymbolCount());
    }
    protected void add(String symbol, int index) {
        this.symbolsMap.put(symbol, index);
    }
    protected void addSpaced(String symbol) {
        int index = this.getSymbolCount();
        this.spacedSymbolsMap.put(symbol, index);
        this.add(symbol, index);
    }
    protected void addSpaced(String symbol, int index) {
        this.spacedSymbolsMap.put(symbol, index);
        this.add(symbol, index);
    }

    /**Called after construction to add symbols to the map*/
    protected abstract void initSymbols();

    protected final void setIdentifierCode(int in) {
        this.identifierCode = in;
    }
    protected final void setLiteralCode(int in) {
        this.literalCode = in;
    }

    public int getSymbolCount() {
        return this.symbolsMap.size();
    }

    public final int getIdentifierCode() {
        return this.identifierCode;
    }
    public final int getLiteralCode() {
        return this.literalCode;
    }

    public final int find(String symbol) {
        return this.symbolsMap.get(symbol);
    }

    public final Set<String> symbolSet() {
        return this.symbolsMap.keySet();
    }
    public final Set<String> spacedSymbolSet() {
        return this.spacedSymbolsMap.keySet();
    }
}
