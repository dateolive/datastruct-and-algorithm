package stulinkedlist;

import java.util.Stack;

public class StuLinkedListDemo {

	public static void main(String[] args) {
		Student stu1=new Student(1, "小米", "班长");
		Student stu2=new Student(2, "小蓝", "副班长");
		Student stu3=new Student(3, "小红", "学习委员");
		Student stu4=new Student(4, "小非", "生活委员");
		
		Student stu5=new Student(5, "米小", "班长");
		Student stu6=new Student(6, "蓝小", "副班长");
		Student stu7=new Student(7, "红小", "学习委员");
		Student stu8=new Student(8, "非小", "生活委员");
		StuLinkedList linkedlist=new StuLinkedList();
		/*
		System.out.println("不按顺序：");
		linkedlist.add1(stu1);
		linkedlist.add1(stu3);
		linkedlist.add1(stu4);
		linkedlist.add1(stu2);
		linkedlist.showLinkedList();
		*/

		
		
		System.out.println("按顺序：");
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
		
		System.out.println("合并两个有序链表");
		StuLinkedList linkedlist3=linkedlist.twoLinked(linkedlist, linkedlist2);
	    linkedlist3.showLinkedList();
	    
		
		
		
		
		System.out.println("使用stack逆序输出");
		reserveprint(linkedlist.getHead());
	
		System.out.println("反转链表");
		reservelist(linkedlist.getHead());
		linkedlist.showLinkedList();
		
		System.out.println("修改节点");
		Student newstu1=new Student(1, "mark", "funny");
		linkedlist.updata(newstu1);
		linkedlist.showLinkedList();
		
		System.out.println("删除节点");
		linkedlist.del(stu2);
		linkedlist.showLinkedList();
		
		System.out.println("链表的个数为："+getLength(linkedlist.getHead()));
		
		Student res=LastNode(linkedlist.getHead(), 2);
		System.out.println(res);
		
		
		
	}
	//获取链表的有效节点个数
	public static int getLength(Student head){
		if(head.next==null){
			//空链表
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
	//查找单链表中的倒数第k个结点 【新浪面试题】
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
	
	//单链表的反转【腾讯面试题】
	//1.先定义一个新节点reservehead
	//2.通过遍历，将原链表的每一个节点，依次插在reservehead的最前端，最后通过head.next=reservehead.next将链表成功反转
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
	
	//从尾到头打印链表【百度面试】
	//1.先反转，在打印，但会破坏链表的原本结构
	//2.使用stack来，利用先进后出的原则来打印
	public static void reserveprint(Student head)
	{
		if(head.next==null)
		{
			//空链表则返回
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
	
	//返回头节点
	public Student getHead(){
		return head;
	}
	//
	public StuLinkedList(){
		head=new Student();
	}
	
	//给StuLinkedList传入节点
	public StuLinkedList(Student head){
		this.head=head;
	}
	
	//不考虑顺序时添加节点
	//1.先循环当前链表，找到最后的节点，然后将这个节点的next指向新的节点
	public void add1(Student stunode){
		//由于头节点不能动，所以用一个辅助节点来进行遍历
		Student tmp=head;
		while(true){
			//如果找到链表的最后
			if(tmp.next==null)
			{
				break;
			}
			//如果还没有，则后移
			tmp=tmp.next;
		}
		//循环结束后，tmp就找到链表最后
		tmp.next=stunode;
	}
	//按照顺序插入节点
	//根据节点的序号进行查找插入，过程是在内存中完成的，可以节省了一些sql的时间
	public void add2(Student stunode){
		// 由于头节点不能动，所以用一个辅助节点来进行遍历
		Student tmp = head;
		//用标志器判断编号是否存在
		boolean flag=false;
		while (true) {
			// 如果找到链表的最后
			if (tmp.next == null) {
				break;
			}
			if(tmp.next.no>stunode.no)
			{
				//找到了就在tmp后面插入
				break;
			}else if(tmp.next.no==stunode.no){
				//编号已存在
				flag=true;
				break;
			}
			
			// 如果还没有，则后移
			tmp = tmp.next;
		}
		// 循环结束后，tmp就找到链表最后
		if(flag){
			System.out.printf("编号%d已经存在了\n", stunode.no);
		}
		else{
			//插入链表
			stunode.next=tmp.next;
			tmp.next=stunode;
		}
	}
	
	//修改节点，根据编号来修改，编号不能改
	public void updata(Student stunode){
		//如果链表为空
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		//定义一个辅助指针
		Student tmp=head;
		boolean flag=false;//表示是否找到节点
		while(true){
			if(tmp==null){
				break;
				//遍历结束
			}
			if(tmp.no==stunode.no)
			{
				flag=true;
				break;
			}
			//循环后移
			tmp=tmp.next;
		}
		if(flag){
			tmp.name=stunode.name;
			tmp.nickname=stunode.nickname;
		}else{
			System.out.printf("没有找到编号%d的节点",stunode.no);
		}
	}
	//删除节点
	public void del(Student stunode){
		//遍历找到要删除的节点的前一个节点，判断要删除的节点是否存在
		//不存在则返回，存在，则将要删除节点的前一个节点的next指向下下个节点
		Student tmp=head;
		boolean flag=false;
		while(true){
			if(tmp.next==null){
				//遍历结束
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
			System.out.printf("编号%d不存在，删除失败", stunode.no);
		}
	}
	//循环显示链表
	public void showLinkedList(){
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		Student tmp=head.next;
		while(true){
			//链表到底
			if(tmp==null){
				break;
			}
			System.out.println(tmp);
			tmp=tmp.next;
		}
	}
	//合并两个有序的链表，合并之后仍让有序
	public static StuLinkedList twoLinked(StuLinkedList list1,StuLinkedList list2)
	{
		if(list1.head.next==null)
		{
			//两个链表其中一个为空
			return list2;
		}
		else if(list2.head.next==null)
		{
			//一个为空，另外一个不为空
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
				//第一个链表的下一个next的编号大于另外一个链表的编号，则将比较小的编号插在
				//node的后面
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
	public Student next; //指向下一个节点
	//构造器
	public Student(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	public Student(){
		
	}
	//为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}