package interpreter.node;
import interpreter.Environment;
import interpreter.EvalException;

// (C) 2013 Jim Buffenbarger
// All rights reserved.

public class NodeFactExpr extends NodeFact {

    private NodeExpr expr;

    public NodeFactExpr(NodeExpr expr) {
	this.expr=expr;
    }

    public double eval(Environment env) throws EvalException {
	return expr.eval(env);
    }

}
