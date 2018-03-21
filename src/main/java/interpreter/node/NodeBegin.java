package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

public class NodeBegin extends Node{

	private NodeBlock block;
	
	public NodeBegin(NodeBlock block) {
		this.block = block;
	}
	
	public double eval(Environment env) throws EvalException {
		return block.eval(env);
	}

}
