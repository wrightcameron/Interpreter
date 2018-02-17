/* 
* This is the main class/method for the interpreter.
* Each command-line argument is a complete program,
* which is scanned, parsed, and evaluated.
* All evaluations share the same environment,
* so they can share variables.
*/
public class Interpreter {

	public static void main(String[] args) {
		Parser parser = new Parser();
		Environment env = new Environment();

		for (String stmt : args)
			try {
				parser.parse(stmt).eval(env);
				System.out.println(parser.parse(stmt).toString());
				System.out.println(env.toString());

			} catch (SyntaxException e) {
				e.printStackTrace();
				System.err.println(e);
			} catch (EvalException e) {
				System.err.println(e);
			}
	}

}