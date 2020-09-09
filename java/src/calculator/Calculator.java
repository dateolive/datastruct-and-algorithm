package calculator;
/*栈实现计算器
 * 
 * */
public class Calculator {
	public static void main(String[] args) {
		String exception="7*2*2-5+100-5+3*4";
		Arraystack numS=new Arraystack(10);
		Arraystack operS=new Arraystack(10);
		int index=0;//扫描下标
		int num1=0,num2=0,oper=0;
		int ans=0;
		char ch=' ';
		String longNum="";
		while(true){
			//取这个表达式的第一个字符
			ch=exception.substring(index, index+1).charAt(0);
			//如果ch是运算符
			if(operS.isOper(ch)){
				//如果当前符号栈不为空
				if(!operS.isEmpty())
				{
					//如果当前符号栈不为空，且当前字符优先级小于符号栈的运算符，
					//则从数栈中pop两个数进行计算，并且将结果入栈，然后将当前操作符入符号栈
					if(operS.priority(ch)<=operS.priority(operS.peek())){
						num1=numS.pop();
						num2=numS.pop();
						oper=operS.pop();
						ans=numS.cal(num1, num2, oper);
						numS.push(ans);
						operS.push(ch);
					}
					else{
						//如果当前优先级大于栈中的操作符优先级，则直接入栈
						operS.push(ch);
					}
				}
				//如果为空，则符号直接入栈
				else {
					operS.push(ch);
				}
			}else{
				//如果ch是数字的话，直接入数栈
				//这里的多位数需要处理下，用字符串拼接的形式，
				//注意的地方：
				//1.处理多位数，需要看当前表达式的index和index的后一位，如果是数，则拼接
				//直到有符号才入栈
				//2.拼接的字符串最后需要进行初始化
				//拼接
				longNum+=ch;
				//如果ch是表达式的最后一位，则入栈
				if(index==exception.length()-1){
					numS.push(Integer.parseInt(longNum));
					
				}else{
					if(operS.isOper(exception.substring(index+1, index+2).charAt(0)))
					{
						numS.push(Integer.parseInt(longNum));
						longNum="";
					}
				}
				
			}
			
			index++;
			if(index>=exception.length())
			{
				break;
			}
		}
		while(true){
			if(operS.isEmpty()){
				break;
			}
			num1=numS.pop();
			num2=numS.pop();
			oper=operS.pop();
			ans=numS.cal(num1, num2, oper);
			numS.push(ans);
		}
		System.out.printf("表达式%s=%d", exception,numS.pop());
	}
}


class Arraystack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	// 定义一个构造器
	public Arraystack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	// 判断是否栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 判断是否栈空
	public boolean isEmpty() {
		return top == -1;
	}
	//返回当前栈顶的值，当不是出栈
	public int peek(){
		return stack[top];
	}
	// 入栈
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 显示
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	//返回优先级大小
	public int priority(int oper){
		if(oper=='*'||oper=='/')
			return 1;
		else if(oper=='+'||oper=='-')
			return 0;
		else 
			return -1;//表达式目前只有+-*/
	}
	//判断当前是否为一个运算符
	public boolean isOper(char val){
		if(val=='+'||val=='/'||val=='*'||val=='-')
			return true;
		return false;
	}
	//计算
	public int cal(int num1,int num2,int oper){
		int ans=0;
		switch(oper){
		case '+':
			ans=num1+num2;
			break;
		case '-':
			ans=-num1+num2;
			break;
		case '*':
			ans=num1*num2;
			break;
		case '/':
			ans=num2/num1;
			break;
		default:
			break;
		}
		return ans;
	}
}