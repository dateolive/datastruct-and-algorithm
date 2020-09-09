package stackdemo;

import java.util.Scanner;

public class LinkedStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackLinked stack = new stackLinked();
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
				Linkedlist list = new Linkedlist(value);
				stack.push(list);
				break;
			case "pop":
				try {
					Linkedlist res = stack.pop();
					System.out.println(res.val);
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
class stackLinked{
	//头节点，不动
	private Linkedlist head=new Linkedlist(-1);
	//栈顶指针
	private Linkedlist top=null;
	//返回头节点
	public Linkedlist getHead(){
		return head;
	}
	//判断栈空
	public boolean isEmpty(){
		return top==null;
	}
	//入栈
	public void push(Linkedlist num) {
		// 因为头结点不能动，所以需要一个辅助节点来完成
		Linkedlist temp = head;
		// 对链表进行遍历，遍历到最后一个节点，然后进行添加节点
		while (true) {
			// 判断是否为节点的最后
			if (temp.next == null) {
				// 当为空时，说明已经是最后一个节点
				break;
			}
			// 如果不为空，则指针向后移动
			temp = temp.next;
		}
		// 当退出while循环时，说明到了最后一个节点
		// 将节点添加到链表的最后
		temp.next = num;
		// 将top指向这个节点
		top = num;
	}
	//出栈，即可理解成链表的删除操作
	public Linkedlist pop() {
		
		Linkedlist h=head;
		while(true){
			if(h.next==top){
				//找到了
				break;
			}
			h=h.next;
		}
		Linkedlist cur=h.next;
		top=h;
		return cur;
	}
	public void list(){
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		//将链表进行反转
		reservelist(head);
		Linkedlist tmp=head.next;
		while(true){
			if(tmp==null){
				break;
			}
			System.out.println(tmp);
			tmp=tmp.next;
		}
		
	}
	//反转
	public static void reservelist(Linkedlist head)
	{
		if(head.next==null||head.next.next==null)
		{
			return;
		}
		Linkedlist reservehead=new Linkedlist(-1);
		Linkedlist cur=head.next;
		Linkedlist next=null;
		while(cur!=null)
		{
			next=cur.next;
			cur.next=reservehead.next;
			reservehead.next=cur;
			cur=next;
		}
		head.next=reservehead.next;
	}
	
}
class Linkedlist{
	public int val;
	public Linkedlist next;
	public Linkedlist(int val){
		this.val=val;
	}
	@Override
	public String toString() {
		return "Linkedlist [val=" + val + ", next=" + next + "]";
	}
}