package interpreter.node;

import interpreter.Environment;
import interpreter.EvalException;
import interpreter.Token;

public class NodeFuncDecl extends Node {
    private String funcId;
    private String arguId;
    private NodeExpr expr;

    public NodeFuncDecl(String funcId, String arguId, NodeExpr expr) {
        this.funcId = funcId;
        this.arguId = arguId;
        this.expr = expr;
    }

    public double eval(Environment env) throws EvalException {
        //return env.put(id,expr.eval(env));
        throw new EvalException(pos, "cannot eval() node!");
    }
}
