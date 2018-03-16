// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact = fact;
		this.mulop = mulop;
		this.term = term;
	}

	public double eval(Environment env) throws EvalException {
		return term == null ? fact.eval(env) : mulop.op(fact.eval(env), term.eval(env));
	}

}
