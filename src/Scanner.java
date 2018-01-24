
// This class is a scanner for the program
// and programming language being interpreted.

import java.util.*;

public class Scanner {

	private String program; // source program being interpreted
	private int pos; // index of next char in program
	private Token token; // last/current scanned token

	private Set<String> whitespace = new HashSet<String>();
	private Set<String> letters = new HashSet<String>();
	private Set<String> keywords = new HashSet<String>();
	private Set<String> numbers = new HashSet<String>();
	private Set<String> operators = new HashSet<String>();

	// constructor:
	// - squirrel-away source program
	// - initialize sets
	public Scanner(String program) {
		this.program = program;
		pos = 0;
		token = null;
		initWhitespace(whitespace);
		initLetters(letters);
		initKeywords(keywords);
		initNumbers(numbers);
		initOperators(operators);
	}

	private void initKeywords(Set<String> keywords2) {
		// .... no keywords yet
	}

	private void initLetters(Set<String> s) {
		fill(s, 'A', 'Z');
		fill(s, 'a', 'z');
	}

	private void fill(Set<String> s, char lo, char hi) {
		for (char c = lo; c <= hi; c++) {
			s.add(c + "");
		}
	}

	private void initWhitespace(Set<String> s) {
		s.add(" ");
		s.add("\n");
		s.add("\t");
	}

	private void initNumbers(Set<String> s) {
		fill(s, '0', '9');
	}

	private void initOperators(Set<String> s) {
		s.add(";");
		s.add("=");
	}

	// handy string-processing methods

	public boolean done() {
		return pos >= program.length();
	}

	private void many(Set<String> s) {
		while (!done() && s.contains(program.charAt(pos) + ""))
			pos++;
	}

	private void past(char c) {
		while (!done() && c != program.charAt(pos))
			pos++;
		if (!done() && c == program.charAt(pos))
			pos++;
	}

	// This method determines the kind of the next token (e.g., "id"),
	// and calls a method to scan that token's lexeme (e.g., "foo").
	public boolean next() {
		if (done())
			return false;
		many(whitespace);
		String c = program.charAt(pos) + "";

		if (letters.contains(c)) {
			nextKwID();
		} else if (numbers.contains(c)) {
			nextKwNum();
		} else if (operators.contains(c)) {
			token = new Token(c, c);
			pos++;
		} else {
			System.err.println("illegal character at position " + pos);
			pos++;
			return next();
		}

		return true;
	}

	private void nextKwID() {
		int old = pos;
		many(letters);
		String lexeme = program.substring(old, pos);
		token = new Token((keywords.contains(lexeme) ? lexeme : "id"), lexeme);
	}

	private void nextKwNum() {
		int old = pos;
		many(numbers);
		String lexeme = program.substring(old, pos);
		// Most numbers are not keywords in a language.
		token = new Token((keywords.contains(lexeme) ? lexeme : "num"), lexeme);
	}

	// This method scans the next lexeme,
	// if the current token is the expected token.
	public void match(Token t) throws SyntaxException {
		if (!t.equals(curr()))
			throw new SyntaxException(pos, t, curr());
		next();
	}

	public Token curr() throws SyntaxException {
		if (token == null)
			throw new SyntaxException(pos, new Token("ANY"), new Token("EMPTY"));
		return token;
	}

	public int pos() {
		return pos;
	}

	// for unit testing
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(args[0]);
			while (scanner.next())
				System.out.println(scanner.curr());
		} catch (SyntaxException e) {
			System.err.println(e);
		}
	}

}