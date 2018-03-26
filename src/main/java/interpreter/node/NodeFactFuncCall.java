package interpreter.node;

import interpreter.Environment;
import interpreter.EvalException;

public class NodeFactFuncCall extends NodeFact{

    private String id;
    private NodeExpr expr;

    public NodeFactFuncCall(int pos, String id,NodeExpr expr) {
        this.pos=pos;
        this.id=id;
        this.expr = expr;
    }

    public double eval(Environment env) throws EvalException {
        return env.get(pos,id);
    }
}
