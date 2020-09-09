package stackdemo;

import java.util.Scanner;

public class LinkedStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackLinked stack = new stackLinked();
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
	//ͷ�ڵ㣬����
	private Linkedlist head=new Linkedlist(-1);
	//ջ��ָ��
	private Linkedlist top=null;
	//����ͷ�ڵ�
	public Linkedlist getHead(){
		return head;
	}
	//�ж�ջ��
	public boolean isEmpty(){
		return top==null;
	}
	//��ջ
	public void push(Linkedlist num) {
		// ��Ϊͷ��㲻�ܶ���������Ҫһ�������ڵ������
		Linkedlist temp = head;
		// ��������б��������������һ���ڵ㣬Ȼ�������ӽڵ�
		while (true) {
			// �ж��Ƿ�Ϊ�ڵ�����
			if (temp.next == null) {
				// ��Ϊ��ʱ��˵���Ѿ������һ���ڵ�
				break;
			}
			// �����Ϊ�գ���ָ������ƶ�
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��˵���������һ���ڵ�
		// ���ڵ���ӵ���������
		temp.next = num;
		// ��topָ������ڵ�
		top = num;
	}
	//��ջ���������������ɾ������
	public Linkedlist pop() {
		
		Linkedlist h=head;
		while(true){
			if(h.next==top){
				//�ҵ���
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
			System.out.println("����Ϊ��");
			return;
		}
		//��������з�ת
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
	//��ת
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