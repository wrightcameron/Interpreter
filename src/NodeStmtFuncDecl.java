
public class NodeStmtFuncDecl extends NodeStmt {

    private FuncDecl funcDecl;

    public NodeStmtFuncDecl(FuncDecl funcDecl) {
        this.funcDecl = funcDecl;
    }

    public double eval(Environment env) throws EvalException {
        return funcDecl.eval(env);
    }
}