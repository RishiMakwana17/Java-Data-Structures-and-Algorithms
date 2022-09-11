public class EquationSolver
{
    public double solve(String equation) //Calls parseInfixToPostfix() then evaluatePostfix()
    {
        DSACircularQueue postfixQueue;
        double answer;

        postfixQueue = parseInfixToPostfix(equation);
        answer = evaluatePostfix(postfixQueue);

        return answer;
    }
    
    private DSACircularQueue parseInfixToPostfix( String equation ) // Converts infix form equation to postfix.Stores the postfix terms in a queue of Objects; use doubles for operands and characters for operators, but put them all in the queue in a postfix order
    {
        String term;
        String operators = "+-*/";
        String[] infixArray = equation.split(" "); // Splitting the string assuming there is a space between each operator
        DSAStack operatorStack = new DSAStack(infixArray.length);
        DSACircularQueue postfixQueue = new DSACircularQueue(infixArray.length);

        for(int i = 0; i < infixArray.length; i++)
        {
            term = infixArray[i];
            if(term.equals("(" )) // Checking if infix is open bracket
            {
                operatorStack.push(term.charAt(0)); // If true then push it
            }
            else if(term.equals(")")) // Checking if infix is closed bracket
            {
                while(!operatorStack.top().equals('(')) // If its true then find the open bracket. Pop everything between those two operators and enqueue it
                {
                    postfixQueue.enqueue(operatorStack.pop());
                }
                operatorStack.pop(); //Pop the '(' and discard it
            }
            else if(operators.contains(term)) //If term is +,-,* or /
            {
                while(!operatorStack.isEmpty() && !operatorStack.top().equals('(') && (precedenceOf(operatorStack.top().toString().charAt(0)) >= precedenceOf(term.charAt(0)))) 
                {
                    postfixQueue.enqueue(operatorStack.pop());
                }
                operatorStack.push(term); //Puts the new operator onto the stack
            }
            else
            {
                postfixQueue.enqueue(Double.valueOf(term)); // Term is an operand
            }
        }
        while(!operatorStack.isEmpty())
        {
            //Push any remaining operands
            postfixQueue.enqueue(operatorStack.pop()); // Push any remaining operands
        }
        return postfixQueue;
    }

    private double evaluatePostfix(DSACircularQueue postfixQueue) // Takes the postfixQueue and evaluates it 
    {
        char op;
        double op1, op2;

        DSAStack operandStack = new DSAStack(postfixQueue.getCount());
        while(!postfixQueue.isEmpty())
        {
            if(postfixQueue.peek() instanceof Double) // Uses instance of to determine if a term in a double or a character
            {
                operandStack.push( postfixQueue.dequeue()); // Next item is an operand
            }
            else
            {
                //Next item is an operator
                op2 = (double)operandStack.pop();
                op1 = (double)operandStack.pop();
                op = postfixQueue.dequeue().toString().charAt(0);
                operandStack.push( executeOperation(op, op1, op2));
            }
        }
        return (double)operandStack.pop();
    }

    private int precedenceOf(char theOp) // Helper function for parseInFixToPostfix() 
    //Returns the precedence (as an integer) or theOperator
    {
        int precedence;
        if(theOp == '+' || theOp == '-')
        {
            precedence = 1;
        }
        else if(theOp == '*' || theOp == '/')
        {
            precedence = 2;
        }
        else
        {
            throw new IllegalArgumentException("Postfix equation contains operator " + theOp);
        }
        return precedence;
    }

    private double executeOperation( char op, double op1, double op2 ) // Helper function for evaluatePostFix()
    // Executes the binary operator implied by op, either op1 + op2, op1 - op2, op1 * op2 or op1/op2 and returns answer
    {
        double answer;
        switch(op)
        {
            case '+':
            {
                answer = op1 + op2;
                break;
            }
            case '-':
            {
                answer = op1 - op2;
                break;
            }
            case '*':
            {
                answer = op1 * op2;
                break;
            }
            case '/':
            {
                answer = op1 / op2;
                break;
            }
            default:
            {
                throw new IllegalArgumentException("Postfix equation contains operator " + op);
            }
        }
        return answer;
    }
}
