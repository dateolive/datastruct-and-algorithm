package stackdemo;

import java.util.Scanner;

public class ArrayStackdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arraystack stack = new Arraystack(4);
		String key = ""; // �մ�
		boolean loop = true; // �����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show:��ʾ��ʾջ");
			System.out.println("exit:�˳�����");
			System.out.println("push:��ʾ������ݵ�ջ(��ջ)");
			System.out.println("pop:��ʾ��ջȡ������(��ջ)");
			System.out.println("���������ѡ��:");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����:");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

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

}