// (C) 2013 Jim Buffenbarger
// All rights reserved.

import java.util.*;

public class Environment {

    private Map<String,Integer> map;

    public Environment() {
	map=new HashMap<String,Integer>();
    }

    public int put(String var, int val) {
	map.put(var,val);
	return val;
    }

    public int get(int pos, String var) throws EvalException {
	if (map.containsKey(var))
	    return map.get(var);
	throw new EvalException(pos,"undefined variable: "+var);
    }

}
