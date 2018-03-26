package interpreter.node;

import interpreter.Environment;
import interpreter.EvalException;

public class NodeStmtFuncDecl extends NodeStmt {

    private NodeFuncDecl funcDecl;

    public NodeStmtFuncDecl(NodeFuncDecl funcDecl) {
        this.funcDecl = funcDecl;
    }

    public double eval(Environment env) throws EvalException {
        return funcDecl.eval(env);
    }
}