package calculator;
/*ջʵ�ּ�����
 * 
 * */
public class Calculator {
	public static void main(String[] args) {
		String exception="7*2*2-5+100-5+3*4";
		Arraystack numS=new Arraystack(10);
		Arraystack operS=new Arraystack(10);
		int index=0;//ɨ���±�
		int num1=0,num2=0,oper=0;
		int ans=0;
		char ch=' ';
		String longNum="";
		while(true){
			//ȡ������ʽ�ĵ�һ���ַ�
			ch=exception.substring(index, index+1).charAt(0);
			//���ch�������
			if(operS.isOper(ch)){
				//�����ǰ����ջ��Ϊ��
				if(!operS.isEmpty())
				{
					//�����ǰ����ջ��Ϊ�գ��ҵ�ǰ�ַ����ȼ�С�ڷ���ջ���������
					//�����ջ��pop���������м��㣬���ҽ������ջ��Ȼ�󽫵�ǰ�����������ջ
					if(operS.priority(ch)<=operS.priority(operS.peek())){
						num1=numS.pop();
						num2=numS.pop();
						oper=operS.pop();
						ans=numS.cal(num1, num2, oper);
						numS.push(ans);
						operS.push(ch);
					}
					else{
						//�����ǰ���ȼ�����ջ�еĲ��������ȼ�����ֱ����ջ
						operS.push(ch);
					}
				}
				//���Ϊ�գ������ֱ����ջ
				else {
					operS.push(ch);
				}
			}else{
				//���ch�����ֵĻ���ֱ������ջ
				//����Ķ�λ����Ҫ�����£����ַ���ƴ�ӵ���ʽ��
				//ע��ĵط���
				//1.�����λ������Ҫ����ǰ���ʽ��index��index�ĺ�һλ�������������ƴ��
				//ֱ���з��Ų���ջ
				//2.ƴ�ӵ��ַ��������Ҫ���г�ʼ��
				//ƴ��
				longNum+=ch;
				//���ch�Ǳ��ʽ�����һλ������ջ
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
		System.out.printf("���ʽ%s=%d", exception,numS.pop());
	}
}


class Arraystack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	// ����һ��������
	public Arraystack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	// �ж��Ƿ�ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// �ж��Ƿ�ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	//���ص�ǰջ����ֵ�������ǳ�ջ
	public int peek(){
		return stack[top];
	}
	// ��ջ
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}

	// ��ջ
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		int value = stack[top];
		top--;
		return value;
	}

	// ��ʾ
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	//�������ȼ���С
	public int priority(int oper){
		if(oper=='*'||oper=='/')
			return 1;
		else if(oper=='+'||oper=='-')
			return 0;
		else 
			return -1;//���ʽĿǰֻ��+-*/
	}
	//�жϵ�ǰ�Ƿ�Ϊһ�������
	public boolean isOper(char val){
		if(val=='+'||val=='/'||val=='*'||val=='-')
			return true;
		return false;
	}
	//����
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