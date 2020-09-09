package circlearrayqueue;

import java.util.Scanner;

public class Circlearrqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circlequeue queue=new circlequeue(4);//这里有效数据是3
		char ch = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		System.out.println("a.添加数据\tb.显示数据\tc.出队列\td.显示队列头\te.退出");
		while (loop) {
			ch = scanner.next().charAt(0);
			switch (ch) {
			case 'a':
				System.out.println("请输入一个数");
				int n = scanner.nextInt();
				queue.addQueue(n);
				break;
			case 'b':
				queue.showQueue();
				break;
			case 'c':
				try {
					int res = queue.getQueue();
					System.out.println("取出的数据是" + res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'd':
				try {
					int res = queue.headQueue();
					System.out.println("取出的数据是" + res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				System.out.println("已退出");
				loop = false;
				break;
			default:
				break;

			}
		}
	}

}
//环形队列
class circlequeue {
	private int maxSize;// 最大容量
	private int front;// 队列队首
	private int rear;// 队尾
	private int[] arr;// 存放数据的数组

	// 创建队列的构造器
	public circlequeue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;// 指向队列的头部
		rear = 0;// 指向队列的尾部
	}

	// 判断队列是否已满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 入队，添加数据
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列已满");
			return;
		}
		// 将rear后移，因为是环形队列，所以这里需要取模，保证不越界且是环形
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// 出队，获取数据
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		int flag = arr[front];
		front = (front + 1) % maxSize;
		return flag;
	}

	// 显示队列数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		} else {
			for (int i = front; i <front + size(); i++) {
				System.out
						.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
			}
			System.out.println();
		}
	}

	// 计算有效数据个数
	public int size() {
		return (rear - front + maxSize) % maxSize;
	}

	// 显示队列头数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front];
	}
}
