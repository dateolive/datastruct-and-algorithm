package stulinkedlist;

public class Yusepfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleLinkedList list=new CircleLinkedList();
		list.add(5);
		list.list();
		list.getOutCircleList(1, 2, 5);

	}

}
//单向环形链表
class CircleLinkedList{
	private Boy first=null;
	//添加节点
	public void add(int nums){
		if(nums<1)
		{
			System.out.println("nums值不正确");
			return;
		}
		//辅助指针
		Boy cur=null;
		for(int i=1;i<=nums;i++)
		{
			Boy boy=new Boy(i);
			//如果是头节点
			if(i==1){
				first=boy;
				first.setNext(first);
				cur=first;
			}else{
				cur.setNext(boy);
				boy.setNext(first);
				cur=boy;
			}
		}
	}
	//遍历节点
	public void list(){
		if(first==null){
			System.out.println("链表为空");
			return;
		}
		//辅助指针
		Boy cur=first;
		while(true){
			System.out.printf("当前节点编号是%d\n",cur.getId());
			if(cur.getNext()==first){
				break;
			}
			cur=cur.getNext();
		}
	}
	public void getOutCircleList(int startid,int cntnum,int nums){
		if(startid<1||startid>nums||first==null)
		{
			System.out.println("参数不正确");
			return;
		}
		//定义一个辅助指针
		Boy cur=first;
		//遍历使得cur辅助指针在链表的最后一个节点
		while(true){
			if(cur.getNext()==first){
				break;
			}
			cur=cur.getNext();
		}
		//开始前，让first和cur移动startid-1次
		for(int i=0;i<startid-1;i++)
		{
			first=first.getNext();
			cur=cur.getNext();
		}
		//人数报数时，first和cur移动cntnum-1次
		//当cur=first时，只剩最后一个
		while(true){
			if(cur==first)
			{
				break;
			}
			//通过
			for(int i=0;i<cntnum-1;i++)
			{
				first=first.getNext();
				cur=cur.getNext();
			}
			System.out.printf("出圈的是%d\n", first.getId());
			first=first.getNext();
			cur.setNext(first);
		}
		System.out.printf("最后的是%d\n", cur.getId());
	}
	
}
class Boy{
	private int id;
	private Boy next;
	public Boy(int id)
	{
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
}
