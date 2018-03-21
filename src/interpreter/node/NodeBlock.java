package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeBlock extends Node {

	private NodeStmt stmt;
	private NodeBlock block;

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}

	public double eval(Environment env) throws EvalException {
		double r = stmt.eval(env);
		return block == null ? r : block.eval(env);
	}

}