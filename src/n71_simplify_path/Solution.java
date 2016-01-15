package n71_simplify_path;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> pathElements = new Stack<String>();
        StringBuilder simplifiedPath = new StringBuilder();
        int start = 1, end = start;
        while(start < path.length() && path.charAt(start) == '/') start++;
        end = start;
        while(end < path.length()){
        	while(end < path.length() && path.charAt(end) != '/') end++;
        	String element = path.substring(start, end);
        	if(element.equals("..")){
        		if(!pathElements.isEmpty())
        			pathElements.pop();
        	}
        	else if(!element.equals("."))
        		pathElements.push(element);
        	while(end < path.length() && path.charAt(end) == '/') end++;
        	start = end;
        }
        while(!pathElements.isEmpty())
        	simplifiedPath.insert(0, "/" + pathElements.pop());
        if(simplifiedPath.length() == 0) simplifiedPath.append('/');
        return simplifiedPath.toString();
    }
}
