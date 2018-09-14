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

    protected void add(String symbol, int value) {
        this.symbolsMap.put(symbol, value);
    }
    protected void addSpaced(String symbol, int value) {
        this.add(symbol, value);
        this.spacedSymbolsMap.put(symbol, value);
    }

    protected abstract void initSymbols();

    protected final void setIdentifierCode(int in) {
        this.identifierCode = in;
    }
    protected final void setLiteralCode(int in) {
        this.literalCode = in;
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
