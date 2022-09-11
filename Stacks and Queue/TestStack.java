public class TestStack
{
    public static void main(String[] args)
    {
        DSAStack stack = new DSAStack(8);
        
        System.out.println("Output true if stack is empty: ");
        System.out.println(stack.isEmpty());       
        System.out.println("Adding elements to the stack: ");
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.push(18);
        stack.push(19);
        stack.push(20);
        stack.push(21);
        stack.push(22);
    
        System.out.println("Full Stack Queue " + stack);
        System.out.println("Removing following element from stack queue: ");
        System.out.println(stack.pop() + "");
        stack.push(23);
        System.out.println("Adding stack queue with 23: ");
        System.out.println(stack);

        
    }
}
