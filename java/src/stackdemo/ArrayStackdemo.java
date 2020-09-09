package stackdemo;

import java.util.Scanner;

public class ArrayStackdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arraystack stack = new Arraystack(4);
		String key = ""; // 空串
		boolean loop = true; // 控制是否退出菜单
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show:表示显示栈");
			System.out.println("exit:退出程序");
			System.out.println("push:表示添加数据到栈(入栈)");
			System.out.println("pop:表示从栈取出数据(出栈)");
			System.out.println("请输入你的选择:");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数:");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("取出的数据是%d\n", res);
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

}