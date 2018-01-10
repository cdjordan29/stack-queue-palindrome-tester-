import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * Model represents the input data for Project 2
 * @author Daniel Jordan
 * @version 1.0
 */
public class Model {

	private String s;
	
	/**
	 * Constructor for Project 2
	 */
	public Model(){
		
		this.s = "";
	}

	/**
	 * Getter method for String s
	 * @return s
	 */
	public String getS() {
		return s;
	}

	/**
	 * Setter method for String s
	 * @param s
	 */
	public void setS(String s) {
		this.s = s;
	}
	
	/**
	 * validate checks the String of the Model to see if its a palindrome
         * @param str 
         * @return boolean
	 */
	public boolean validate(String str){
		
		boolean valid = true;
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new LinkedList<Character>();
                
		if(str.equals("")){
                    valid = false;
                }
                else{
                    for(int i = 0; i < str.length(); i++){
			
                            stack.push(str.charAt(i));
                            queue.add(str.charAt(i));
                    }
		
                    while(!stack.isEmpty() && !queue.isEmpty()){
			
			if(!(queue.remove().equals(stack.pop()))){
				
				valid = false;
			}
                    }     
            }
                return valid;
	}

}
