import java.util.HashMap;

public class FuncCall extends Function{

    protected NodeExpr arguExpr;

    public FuncCall(int pos, String id,NodeExpr arguExpr) {
        super(id,null,null);
        this.pos=pos;
        this.arguExpr = arguExpr;
    }

    public double call(Environment env) throws EvalException {
        //Get function from eval
        Function func =  env.call(pos,functionName);
        argumentId = func.argumentId;
        functionBody = func.functionBody;
        //Copy the env for scope.
        Environment scopeEnv = env.copyEnv();
        //Give argument id the argument expression
        scopeEnv.put(argumentId,arguExpr.eval(env));
        //env.eval on expression
        return functionBody.eval(scopeEnv);
    }
}
