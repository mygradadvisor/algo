package Bits;

public class Test2 {
	public static void main(String[] args){
		Test2 t = new Test2();
		System.out.println("res: "+ t.clean("a bc!. def !."));
	}
	/**
     * Clean returns a modified version of its argument. It modifies it's
input according to some simple
     * rules.
     *
     * 1. It removes spurious punctuation characters. Specifically if
there is a sequence of one or more of the
     * following "!", "#" or "." only the first and last characters in
that sequence should be included in the output.
     * 2. It trims whitespace characters so if there is more than one in a
row only a single space it output.
     * 3. All other characters are copied into the output.
     *
     * Examples:
     *
     * clean("abc!!#.#.def#.#..g") should return "abc!.def#.g"
     * clean("a   bc!!#.#.  def !.") should return "a bc!. def !."
     * clean("abc") should return "abc"
     *
     * @param rawString
     * @return a cleaned version of the rawString argument.
     */
    public String clean(String rawString){
    	int n = rawString.length();
    	if(n<2) return rawString;
    	
    	
    	String prev = rawString.substring(0,1);
    	String res=prev;
    	for(int i=1; i<n-1; i++){
    		//System.out.println(prev);
    		String current=rawString.substring(i,i+1);
    		String next = rawString.substring(i+1,i+2);
    		if(current.equals(" ") && prev.equals(" ")) continue;
    		else if( ( prev.equals("!") || prev.equals("#") || prev.equals(".") ) && ( current.equals("!") || current.equals("#") || current.equals(".") )
    				& ( next.equals("!") || next.equals("#") || next.equals(".") )){
    			continue;
    		}
    		else
    			res+=current;
    		prev = current;
    	
    	}
    	
    	return res+rawString.substring(n-1,n);
    }
}
