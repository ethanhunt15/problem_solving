package problemsolving;

public class ThreeInOneStack {
	
	int stackSize = 5;
	int stack1Head = 4;
	int stack2Head = 9;
	int stack3Head = 14;
	int [] stack = new int[15];
			
public void pushStack1(int data)
{
	//check whether Stack is full
	if(stack1Head == 0)
	{
		System.out.println("Stack1 is full");
	}
	else
	{
		stack[stack1Head] = data;
		stack1Head--;
	}
}
}
