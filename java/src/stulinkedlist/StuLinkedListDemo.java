package stulinkedlist;

import java.util.Stack;

public class StuLinkedListDemo {

	public static void main(String[] args) {
		Student stu1=new Student(1, "С��", "�೤");
		Student stu2=new Student(2, "С��", "���೤");
		Student stu3=new Student(3, "С��", "ѧϰίԱ");
		Student stu4=new Student(4, "С��", "����ίԱ");
		
		Student stu5=new Student(5, "��С", "�೤");
		Student stu6=new Student(6, "��С", "���೤");
		Student stu7=new Student(7, "��С", "ѧϰίԱ");
		Student stu8=new Student(8, "��С", "����ίԱ");
		StuLinkedList linkedlist=new StuLinkedList();
		/*
		System.out.println("����˳��");
		linkedlist.add1(stu1);
		linkedlist.add1(stu3);
		linkedlist.add1(stu4);
		linkedlist.add1(stu2);
		linkedlist.showLinkedList();
		*/

		
		
		System.out.println("��˳��");
		linkedlist.add2(stu1);
		linkedlist.add2(stu2);
		linkedlist.add2(stu3);
		linkedlist.add2(stu4);
		linkedlist.showLinkedList();
		
		StuLinkedList linkedlist2=new StuLinkedList();
		linkedlist2.add2(stu5);
		linkedlist2.add2(stu6);
		linkedlist2.add2(stu7);
		linkedlist2.add2(stu8);
		
		System.out.println("�ϲ�������������");
		StuLinkedList linkedlist3=linkedlist.twoLinked(linkedlist, linkedlist2);
	    linkedlist3.showLinkedList();
	    
		
		
		
		
		System.out.println("ʹ��stack�������");
		reserveprint(linkedlist.getHead());
	
		System.out.println("��ת����");
		reservelist(linkedlist.getHead());
		linkedlist.showLinkedList();
		
		System.out.println("�޸Ľڵ�");
		Student newstu1=new Student(1, "mark", "funny");
		linkedlist.updata(newstu1);
		linkedlist.showLinkedList();
		
		System.out.println("ɾ���ڵ�");
		linkedlist.del(stu2);
		linkedlist.showLinkedList();
		
		System.out.println("����ĸ���Ϊ��"+getLength(linkedlist.getHead()));
		
		Student res=LastNode(linkedlist.getHead(), 2);
		System.out.println(res);
		
		
		
	}
	//��ȡ�������Ч�ڵ����
	public static int getLength(Student head){
		if(head.next==null){
			//������
			return 0;
		}
		int length=0;
		Student cur=head.next;
		while(cur!=null){
			length++;
			cur=cur.next;
		}
		return length;
		
	}
	//���ҵ������еĵ�����k����� �����������⡿
	public static Student LastNode(Student head,int index){
		if(head==null){
			return null;
		}
		int size=getLength(head);
		if(index<=0||index>size)
		{
			return null;
		}
		Student cur=head.next;
		for(int i=0;i<size-index;i++)
		{
			cur=cur.next;
		}
		return cur;
		
		
	}
	
	//������ķ�ת����Ѷ�����⡿
	//1.�ȶ���һ���½ڵ�reservehead
	//2.ͨ����������ԭ�����ÿһ���ڵ㣬���β���reservehead����ǰ�ˣ����ͨ��head.next=reservehead.next������ɹ���ת
	public static void reservelist(Student head)
	{
		if(head.next==null||head.next.next==null)
		{
			return;
		}
		Student reservehead=new Student(0, "", "");
		Student cur=head.next;
		Student next=null;
		while(cur!=null)
		{
			next=cur.next;
			cur.next=reservehead.next;
			reservehead.next=cur;
			cur=next;
		}
		head.next=reservehead.next;
	}
	
	//��β��ͷ��ӡ�����ٶ����ԡ�
	//1.�ȷ�ת���ڴ�ӡ�������ƻ������ԭ���ṹ
	//2.ʹ��stack���������Ƚ������ԭ������ӡ
	public static void reserveprint(Student head)
	{
		if(head.next==null)
		{
			//�������򷵻�
			return;
		}
		Stack<Student>stack=new Stack<Student>();
		Student cur=head.next;
		while(cur!=null)
		{
			stack.push(cur);
			cur=cur.next;
		}
		while(stack.size()>0)
		{
			System.out.println(stack.pop());
		}
	}
	

	
}
class StuLinkedList{
	private Student head=new Student(0,"","");
	
	//����ͷ�ڵ�
	public Student getHead(){
		return head;
	}
	//
	public StuLinkedList(){
		head=new Student();
	}
	
	//��StuLinkedList����ڵ�
	public StuLinkedList(Student head){
		this.head=head;
	}
	
	//������˳��ʱ��ӽڵ�
	//1.��ѭ����ǰ�����ҵ����Ľڵ㣬Ȼ������ڵ��nextָ���µĽڵ�
	public void add1(Student stunode){
		//����ͷ�ڵ㲻�ܶ���������һ�������ڵ������б���
		Student tmp=head;
		while(true){
			//����ҵ���������
			if(tmp.next==null)
			{
				break;
			}
			//�����û�У������
			tmp=tmp.next;
		}
		//ѭ��������tmp���ҵ��������
		tmp.next=stunode;
	}
	//����˳�����ڵ�
	//���ݽڵ����Ž��в��Ҳ��룬���������ڴ�����ɵģ����Խ�ʡ��һЩsql��ʱ��
	public void add2(Student stunode){
		// ����ͷ�ڵ㲻�ܶ���������һ�������ڵ������б���
		Student tmp = head;
		//�ñ�־���жϱ���Ƿ����
		boolean flag=false;
		while (true) {
			// ����ҵ���������
			if (tmp.next == null) {
				break;
			}
			if(tmp.next.no>stunode.no)
			{
				//�ҵ��˾���tmp�������
				break;
			}else if(tmp.next.no==stunode.no){
				//����Ѵ���
				flag=true;
				break;
			}
			
			// �����û�У������
			tmp = tmp.next;
		}
		// ѭ��������tmp���ҵ��������
		if(flag){
			System.out.printf("���%d�Ѿ�������\n", stunode.no);
		}
		else{
			//��������
			stunode.next=tmp.next;
			tmp.next=stunode;
		}
	}
	
	//�޸Ľڵ㣬���ݱ�����޸ģ���Ų��ܸ�
	public void updata(Student stunode){
		//�������Ϊ��
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		//����һ������ָ��
		Student tmp=head;
		boolean flag=false;//��ʾ�Ƿ��ҵ��ڵ�
		while(true){
			if(tmp==null){
				break;
				//��������
			}
			if(tmp.no==stunode.no)
			{
				flag=true;
				break;
			}
			//ѭ������
			tmp=tmp.next;
		}
		if(flag){
			tmp.name=stunode.name;
			tmp.nickname=stunode.nickname;
		}else{
			System.out.printf("û���ҵ����%d�Ľڵ�",stunode.no);
		}
	}
	//ɾ���ڵ�
	public void del(Student stunode){
		//�����ҵ�Ҫɾ���Ľڵ��ǰһ���ڵ㣬�ж�Ҫɾ���Ľڵ��Ƿ����
		//�������򷵻أ����ڣ���Ҫɾ���ڵ��ǰһ���ڵ��nextָ�����¸��ڵ�
		Student tmp=head;
		boolean flag=false;
		while(true){
			if(tmp.next==null){
				//��������
				break;
			}
			if(tmp.next.no==stunode.no)
			{
				flag=true;
				break;
			}
			tmp=tmp.next;
		}
		if(flag){
			tmp.next=tmp.next.next;
		}else{
			System.out.printf("���%d�����ڣ�ɾ��ʧ��", stunode.no);
		}
	}
	//ѭ����ʾ����
	public void showLinkedList(){
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		Student tmp=head.next;
		while(true){
			//������
			if(tmp==null){
				break;
			}
			System.out.println(tmp);
			tmp=tmp.next;
		}
	}
	//�ϲ���������������ϲ�֮����������
	public static StuLinkedList twoLinked(StuLinkedList list1,StuLinkedList list2)
	{
		if(list1.head.next==null)
		{
			//������������һ��Ϊ��
			return list2;
		}
		else if(list2.head.next==null)
		{
			//һ��Ϊ�գ�����һ����Ϊ��
			return list1;
		}

		Student newnode=new Student();
		Student node=newnode;
		Student l1=list1.head.next;
		Student l2=list2.head.next;
		while(l1!=null&&l2!=null)
		{
			if(l1.no>l2.no)
			{
				//��һ���������һ��next�ı�Ŵ�������һ������ı�ţ��򽫱Ƚ�С�ı�Ų���
				//node�ĺ���
				node.next=l2;
				l2=l2.next;
				node=node.next;
				
			}
			else{
				node.next=l1;
				l1=l1.next;
				node=node.next;
			}
			System.out.print("1");
		}
		if(l1==null)
		{
			node.next=l2;
		}
		if(l2==null)
		{
			node.next=l1;
		}
		return new StuLinkedList(newnode);
		
		
	}
	
}
class Student {
	public int no;
	public String name;
	public String nickname;
	public Student next; //ָ����һ���ڵ�
	//������
	public Student(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	public Student(){
		
	}
	//Ϊ����ʾ��������������toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}