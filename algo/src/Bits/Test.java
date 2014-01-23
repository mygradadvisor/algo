package Bits;
import java.util.Stack;
public class Test {
	boolean areSymbolsMatched(String symbolString) throws Exception
	{
	        Stack<String> st = new Stack<String>();
	        int n = symbolString.length();
	        for(int i=0; i<n; i++){
	                if(symbolString.substring(i,i+1).equals("<")||symbolString.substring(i,i+1).equals("{")||
	                        symbolString.substring(i,i+1).equals("(")){
	                                st.push(symbolString.substring(i,i+1));
	                }
	                else if(symbolString.substring(i,i+1).equals(">")){
	                                String str = st.peek();
	                                if(str.equals("<")) st.pop();
	                                else return false;

	                }
	                else if(symbolString.substring(i,i+1).equals("{")){
	                                String str = st.peek();
	                                if(str.equals("}")) st.pop();
	                                else return false;
	                }
	                else if(symbolString.substring(i,i+1).equals(")")){
	                                String str = st.peek();
	                                if(str.equals(")")) st.pop();
	                                else return false;
	                }
	        }

	        if (st.size()>0) return false;
	        return true;
}
}
