import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static java.lang.Character.isDigit;

public class AnalyzerMain {

    public static void main(String args[]) {

        //Reader object, reads from file
        BufferedReader reader;
        //Writer object, writes to file
        BufferedWriter writer;
        //Input string, received from reader then processed
        String inLine;
        //Output string, created by processing input string then passed to writer
        String outLine;
        //Symbols dictionary object, contains information about symbols
        SymbolsDict symbols = new SymbolsDict();
        try {
            //Create reader and writer
            reader = new BufferedReader(new FileReader("input.txt"));
            writer = new BufferedWriter(new FileWriter("output.txt"));
            do {
                //Read a line, reset string values
                inLine = reader.readLine();
                outLine = "";
                //Unmatched string that contains substring not in dictionary - custom identifier or literal
                String id = "";
                if (inLine != null) {
                    System.out.println(inLine);
                    //Removes spaces from input line
                    inLine = removeSpaces(inLine);

                    while (inLine.length() != 0) {
                        //String storing the symbol matched
                        String matched = null;

                        //Try to match each symbol in the dictionary
                        for (String symbol : symbols.symbolSet()) {
                            if (inLine.startsWith(symbol)) {
                                if (matched == null || matched.length() < symbol.length()) {
                                    matched = symbol;
                                }
                            }
                        }

                        //Cuts off matched substring
                        if (matched != null) {
                            inLine = inLine.substring(matched.length());
                        }

                        //Tries to process unmatched substring as identifier or literal
                        if ((matched != null || inLine.length() == 0) && id != "") {
                            //String
                            if (id.charAt(0) == '\"' && id.charAt(id.length() - 1) == '\"') {
                                symbols.addLiteral(id);
                                outLine = addSpace(outLine);
                                outLine += symbols.getLiteralCode();
                                outLine += ".";
                                outLine += symbols.getLiteral(id);
                            }
                            //Integer
                            else if (isDigit(id.charAt(0))) {
                                symbols.addLiteral(id);
                                outLine = addSpace(outLine);
                                outLine += symbols.getLiteralCode();
                                outLine += ".";
                                outLine += symbols.getLiteral(id);
                            }
                            //Identifier
                            else {
                                symbols.addIdentifier(id);
                                outLine = addSpace(outLine);
                                outLine += symbols.getIdentifierCode();
                                outLine += ".";
                                outLine += symbols.getIdentifier(id);
                            }
                            //Resets unmatched string
                            id = "";
                        }

                        //Adds matched symbol to output string
                        if (matched != null) {
                            outLine = addSpace(outLine);
                            outLine += symbols.find(matched);
                        }
                        //Transfers first character from input string to unmatched string
                        else {
                            id += inLine.substring(0, 1);
                            inLine = inLine.substring(1);
                        }

                    }
                    //Writes a line
                    System.out.println(outLine);
                    writer.write(outLine);
                    writer.newLine();
                }
            } while (inLine != null);
            //Closes reader and writer after use
            reader.close();
            writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**Removes all spaces from a string*/
    public static String removeSpaces(String str) {
        return str.trim().replaceAll(" +" , "");
    }

    /**Adds a space at the end if it not exists already*/
    public static String addSpace(String str) {
        if (str.length() == 0 || str.charAt(str.length() - 1) != ' ') {
            return str + ' ';
        }
        return str;
    }
}
