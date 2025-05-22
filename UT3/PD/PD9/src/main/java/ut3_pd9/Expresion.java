package ut3_pd9;
import java.util.List;
import java.util.Stack;

public class Expresion {

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : listaDeEntrada) {
            if (c == '{') {
                stack.push(c);
            } 
            else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
