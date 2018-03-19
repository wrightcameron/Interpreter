
public class NodeRd extends Node{
	
	public NodeRd() {
	}
	
	public double eval(Environment env) throws EvalException {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		return scan.nextDouble();
	}

}
