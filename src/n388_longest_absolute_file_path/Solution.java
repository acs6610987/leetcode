package n388_longest_absolute_file_path;

import java.util.Stack;

public class Solution {
	
	class StackItem{
		int indentLevel;
		int pathNameLen;
		boolean isFile;
		int longestPathLen;
		public StackItem(int indentLevel, int pathNameLen, boolean isFile, int longestPathLen){
			this.indentLevel = indentLevel;
			this.pathNameLen = pathNameLen;
			this.isFile = isFile;
			this.longestPathLen = longestPathLen;
		}
	}
	
	public int lengthLongestPath(String input) {
		if(null == input || 0 == input.length())
			return 0;
        
		String[] pathItems = input.split("\n");
		Stack<StackItem> stack = new Stack<StackItem>();
		
        for(int i = 0; i < pathItems.length; i++){
        	if(pathItems[i] == "") continue;
        	StackItem item = interpretPathItem(pathItems[i]);
        	if(stack.isEmpty() || item.indentLevel > stack.peek().indentLevel){
        		stack.push(item);
        		continue;
        	}
        	if(stack.peek().isFile)
        		stack.peek().longestPathLen = stack.peek().pathNameLen;
        	while(stack.size() >= 2 && item.indentLevel <= stack.peek().indentLevel){
        		StackItem top = stack.pop();
        		if(top.longestPathLen != 0 && stack.peek().longestPathLen < stack.peek().pathNameLen + 1 + top.longestPathLen)
        			stack.peek().longestPathLen = stack.peek().pathNameLen + 1 + top.longestPathLen;
        	}
        	stack.push(item);
        }
        
        if(stack.peek().isFile)
    		stack.peek().longestPathLen = stack.peek().pathNameLen;
        while(stack.size() >= 2 && stack.peek().indentLevel > 0){
        	StackItem top = stack.pop();
    		if(top.longestPathLen != 0 && stack.peek().longestPathLen < stack.peek().pathNameLen + 1 + top.longestPathLen)
    			stack.peek().longestPathLen = stack.peek().pathNameLen + 1 + top.longestPathLen;
        }
        
        int longest = 0;
        while(!stack.isEmpty()){
        	if(stack.peek().longestPathLen > longest)
        		longest = stack.peek().longestPathLen;
        	stack.pop();
        }
        
        return longest;
    }
	
	public StackItem interpretPathItem(String pathItem){
		int indentLevel = 0, pathNameLen = 0;
    	boolean isFile = false;
    	for(int j = 0; j < pathItem.length(); j++){
    		if(pathItem.charAt(j) == '\t')
    			indentLevel++;
    		else if(pathItem.charAt(j) == '.'){
    			isFile = true;
    			pathNameLen++;
    		}
    		else
    			pathNameLen++;
    	}
		return new StackItem(indentLevel, pathNameLen, isFile, 0);
	}
}
