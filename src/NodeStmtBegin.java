// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeStmtBegin extends NodeStmt {

	private NodeBegin begin;

	public NodeStmtBegin(NodeBegin begin) {
		this.begin=begin;
	}

	public double eval(Environment env) throws EvalException {
		return begin.eval(env);
	}

}

