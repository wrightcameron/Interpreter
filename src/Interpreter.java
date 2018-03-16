// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class Interpreter {

    public static void main(String[] args) {
	Parser parser=new Parser();
	Environment env=new Environment();
	for (String prog: args)
	    try {
		parser.parse(prog).eval(env);
	    } catch (SyntaxException e) {
		System.err.println(e);
	    } catch (EvalException e) {
		System.err.println(e);
	    }
    }
}
