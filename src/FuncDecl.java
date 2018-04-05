
public class FuncDecl extends Function {

    public FuncDecl(String functionName, String argumentId, NodeExpr functionBody) {
        super(functionName,argumentId,functionBody);
    }

    public double eval(Environment env) throws EvalException {
        return env.decl(functionName,this);
    }
}
