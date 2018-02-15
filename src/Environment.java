import java.util.HashMap;

// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

public class Environment {
	private HashMap<String, Integer> symbolTable;

	public Environment(){
		symbolTable = new HashMap<String, Integer>();
	}
	
    public int put(String var, int val) { 
    	symbolTable.put(var, val);
      	return 0;
    }
    //TODO What the hell does pos do?
    public int get(int pos, String var) throws EvalException { 
    	Integer val = symbolTable.get(var);
    	if(val == null){
    		throw new EvalException(pos,"Variable does not exist.");
    	}
    	return val;
    }
    
}
