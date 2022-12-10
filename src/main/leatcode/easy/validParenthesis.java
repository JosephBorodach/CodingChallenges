package src.main.leatcode.easy;

import java.util.*;

public class validParenthesis {
    Stack<Character> st = new Stack<>();
    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                this.st.push(c);
            }
            //Right Symbol
            else {
                if (c == ')') {
                    if (!this.st.isEmpty() && this.st.peek() == '(') {
                        this.st.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (!this.st.isEmpty() && this.st.peek() == '{') {
                        this.st.pop();
                    } else{
                        return false;
                    }
                } else if (c == ']') {
                    if (!this.st.isEmpty() && this.st.peek() == '[') {
                        this.st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return this.st.isEmpty();
    }
}
