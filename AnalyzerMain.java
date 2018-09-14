package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static java.lang.Character.isDigit;

public class AnalyzerMain {

    public static void main(String args[]) {

        SymbolPack symbolPack = new PascalSymbolPack();
        String fileNameIn = "input.txt";
        String fileNameOut = "output.txt";

        //Reader object, reads from file
        BufferedReader reader;
        //Writer object, writes to file
        BufferedWriter writer;
        //Input string, received from reader then processed
        String inLine;
        //Output string, created by processing input string then passed to writer
        String outLine;
        //Symbols dictionary object, contains information about symbols
        SymbolsDict symbols = new SymbolsDict(symbolPack);
        StringLexer lex = new StringLexer(symbols);
        try {
            //Create reader and writer
            reader = new BufferedReader(new FileReader(fileNameIn));
            writer = new BufferedWriter(new FileWriter(fileNameOut));
            do {
                //Reads a line
                inLine = reader.readLine();
                if (inLine != null) {
                    System.out.println(inLine);
                    try {
                        //Processes line into lexemes
                        outLine = lex.processString(inLine);
                        //Writes a line
                        System.out.println(outLine);
                        writer.write(outLine);
                    }
                    catch (UnmatchedSubstringException e) {
                        System.out.println("Error: Failed to match substring: " + e.getUnmatchedSubstring());
                    }
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
}
