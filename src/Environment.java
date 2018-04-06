// (C) 2013 Jim Buffenbarger
// All rights reserved.

import java.util.*;

public class Environment {

    private HashMap<String, Double> valMap;
    private HashMap<String, Function> funcMap;

    public Environment() {
        valMap = new HashMap<String, Double>();
        funcMap = new HashMap<String, Function>();
    }

    protected Environment(HashMap<String, Double> valMap,HashMap<String, Function> funcMap) {
        //Use copy constructs
        this.valMap = new HashMap<String, Double>(valMap);
        this.funcMap = new HashMap<String, Function>(funcMap);
    }


    public double put(String var, double val) {
        valMap.put(var, val);
        return val;
    }

    public double get(int pos, String var) throws EvalException {
        if (valMap.containsKey(var))
            return valMap.get(var);
        throw new EvalException(pos, "undefined variable: " + var);
    }

    //For functions
    public double decl(String func, Function expr) {
        funcMap.put(func, expr);
        return 0;
    }

    public Function call(int pos, String func) throws EvalException {
        if (funcMap.containsKey(func))
            return funcMap.get(func);
        throw new EvalException(pos, "undefined function: " + func);
    }

    public Environment copyEnv(){
        return new Environment(valMap, funcMap);
    }

}
