import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean isBalanced(String s) {
        char[] sCharArray = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c: sCharArray){
            if(c == '(' || c== '{' || c=='[')
                stack.push(c);
            else if(c == ')' || c== '}' || c==']'){
                if(!stack.isEmpty()){
                    if((c==')' && stack.peek() == '(') || (c=='}' && stack.peek() == '{') || (c==']' && stack.peek() == '['))
                        stack.pop();
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();  // 1, 2, 3, 4
        list.reverse();
        list.printList();  // 4, 3, 2, 1
        System.out.println();
        System.out.println("Middle node is" + list.findMiddle().getValue());


        String s = "([)]";
        System.out.println("String " + s + " is valid: " + isBalanced(s));

        MyQueue queue = new MyQueue(List.of(1,2,3));
        System.out.println("First element in queue: " + queue.peek());
        System.out.println("Delete first element in queue: " + queue.pop());
        queue.push(4);
        System.out.println("First element in queue: " + queue.peek());

    }
}