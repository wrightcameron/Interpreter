package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

public class NodeRd extends Node {

	private String id; 
	
	public NodeRd(String id) {
		this.id=id;
	}

	public double eval(Environment env) throws EvalException {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		double value = scan.nextDouble();
		return env.put(id,value);
	}

}
