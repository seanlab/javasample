package me.seanxiao.leetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> paths = new Stack<String>();
        String[] subPaths = path.split("/");
        for (String subPath : subPaths) {
            if (subPath.equals("..")) {
                if (!paths.isEmpty()) {
                    paths.pop();
                }
            }
            else if (subPath.equals(".") || subPath.length() == 0) {
                
            }
            else {
                paths.push(subPath);
            }
        }
        String result = "";
        if (paths.isEmpty()) {
            return "/";
        }
        while (!paths.isEmpty()) {
            result = "/" + paths.peek() + result;
            paths.pop();
        }
        return result;
    }
}
