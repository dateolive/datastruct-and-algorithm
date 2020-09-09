package stulinkedlist;

public class DoubleLinked {

	public static void main(String[] args) {
		Student2 stu1=new Student2(1, "小米");
		Student2 stu2=new Student2(2, "小蓝");
		Student2 stu3=new Student2(3, "小红");
		Student2 stu4=new Student2(4, "小非");
		DoubleLinkedList list=new DoubleLinkedList();
		/*list.add1(stu1);
		list.add1(stu2);
		list.add1(stu3);
		list.add1(stu4);*/
		list.add2(stu3);
		list.add2(stu4);
		list.add2(stu1);
		list.add2(stu2);
		System.out.println("显示初始链表:");
		list.showLinkedList();
		System.out.println("显示删除后的链表:");
		list.del(stu2);
		list.showLinkedList();
		System.out.println("显示修改后的链表:");
		Student2 newnode=new Student2(1, "小芳");
		list.updata(newnode);
		list.showLinkedList();

	}

}
class DoubleLinkedList{
	
	private Student2 head = new Student2(0, "");

	// 返回头节点
	public Student2 getHead() {
		return head;
	}
	
	//双向链表的增删改查
	//1.双向链表的添加
	public void add1(Student2 stunode){
		//由于头节点不能动，所以用一个辅助节点来进行遍历
		Student2 tmp=head;
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
		stunode.pre=tmp;
	}
	//按照顺序插入节点
	//根据节点的序号进行查找插入，过程是在内存中完成的，可以节省了一些sql的时间
	public void add2(Student2 stunode){
		// 由于头节点不能动，所以用一个辅助节点来进行遍历
		Student2 tmp = head;
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
		else if(tmp.next!=null){
			//插入链表
			Student2 tmp1=tmp.next;
			stunode.pre=tmp;
			stunode.next=tmp1;
			tmp1.pre=stunode;
			tmp.next=stunode;
		}else{
			stunode.pre=tmp;
			stunode.next=null;
			tmp.next=stunode;
		}
	}
	
	
	//2.双向链表的删除
	//1）不用像单向链表一样，需要找到要删除节点的前一个结点，直接操作要删除的结点即可
	//2）主要思路    tmp.pre.next=tmp.next;tmp.next.pre=tmp.pre;
	public void del(Student2 stunode){
		Student2 tmp=head;
		boolean flag=false;
		while(true){
			if(tmp.next==null){
				//遍历结束
				break;
			}
			if(tmp.no==stunode.no)
			{
				flag=true;
				break;
			}
			tmp=tmp.next;
		}
		if(flag){
			 tmp.pre.next=tmp.next;
			 tmp.next.pre=tmp.pre;
		}else{
			System.out.printf("编号%d不存在，删除失败", stunode.no);
		}
	}
	//3.修改结点
	public void updata(Student2 stunode){
		//如果链表为空
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		//定义一个辅助指针
		Student2 tmp=head;
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
		}else{
			System.out.printf("没有找到编号%d的节点",stunode.no);
		}
	}
	
	//4.显示
	//循环显示链表
	public void showLinkedList(){
		if(head.next==null){
			System.out.println("链表为空");
			return;
		}
		Student2 tmp=head.next;
		while(true){
			//链表到底
			if(tmp==null){
				break;
			}
			System.out.println(tmp);
			tmp=tmp.next;
		}
	}
	
}

class Student2 {
	public int no;
	public String name;
	public Student2 next; //指向下一个节点
	public Student2 pre; //指向前一个节点
	//构造器
	public Student2(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public Student2(){
		
	}
	//为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
}