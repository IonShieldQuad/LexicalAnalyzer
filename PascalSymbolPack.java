package lexicalanalyzer;

public class PascalSymbolPack extends SymbolPack {
    protected void initSymbols() {
        this.add("program", 1);
        this.add("var", 2);
        this.add("integer", 3);
        this.add("begin", 4);
        this.add("end", 5);
        this.add("for", 6);
        this.add("to", 7);
        this.add("do", 8);
        this.add("read", 9);
        this.add("write", 10);
        this.addSpaced(":=", 11);
        this.addSpaced("+", 12);
        this.addSpaced("-", 13);
        this.addSpaced("*", 14);
        this.add("div", 15);
        this.addSpaced(";", 16);
        this.addSpaced(",", 17);
        this.addSpaced(".", 18);
        this.addSpaced("(", 19);
        this.addSpaced(")", 20);
        this.addSpaced(":", 21);
        this.setIdentifierCode(22);
        this.setLiteralCode(23);
    }    
}
