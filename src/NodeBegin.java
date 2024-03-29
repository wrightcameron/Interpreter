// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeBegin extends Node {

	private NodeBlock block;

	public NodeBegin(NodeBlock block) {
		this.block=block;
	}

	public double eval(Environment env) throws EvalException {
		return block.eval(env);
	}

}
