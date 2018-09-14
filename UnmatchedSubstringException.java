package lexicalanalyzer;

public class UnmatchedSubstringException extends Exception {
    UnmatchedSubstringException(String substring) {
        this.substring = substring;
    }
    private final String substring;
    public String getUnmatchedSubstring() {
        return this.substring;
    }
}
