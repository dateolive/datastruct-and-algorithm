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
//����������
class CircleLinkedList{
	private Boy first=null;
	//��ӽڵ�
	public void add(int nums){
		if(nums<1)
		{
			System.out.println("numsֵ����ȷ");
			return;
		}
		//����ָ��
		Boy cur=null;
		for(int i=1;i<=nums;i++)
		{
			Boy boy=new Boy(i);
			//�����ͷ�ڵ�
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
	//�����ڵ�
	public void list(){
		if(first==null){
			System.out.println("����Ϊ��");
			return;
		}
		//����ָ��
		Boy cur=first;
		while(true){
			System.out.printf("��ǰ�ڵ�����%d\n",cur.getId());
			if(cur.getNext()==first){
				break;
			}
			cur=cur.getNext();
		}
	}
	public void getOutCircleList(int startid,int cntnum,int nums){
		if(startid<1||startid>nums||first==null)
		{
			System.out.println("��������ȷ");
			return;
		}
		//����һ������ָ��
		Boy cur=first;
		//����ʹ��cur����ָ������������һ���ڵ�
		while(true){
			if(cur.getNext()==first){
				break;
			}
			cur=cur.getNext();
		}
		//��ʼǰ����first��cur�ƶ�startid-1��
		for(int i=0;i<startid-1;i++)
		{
			first=first.getNext();
			cur=cur.getNext();
		}
		//��������ʱ��first��cur�ƶ�cntnum-1��
		//��cur=firstʱ��ֻʣ���һ��
		while(true){
			if(cur==first)
			{
				break;
			}
			//ͨ��
			for(int i=0;i<cntnum-1;i++)
			{
				first=first.getNext();
				cur=cur.getNext();
			}
			System.out.printf("��Ȧ����%d\n", first.getId());
			first=first.getNext();
			cur.setNext(first);
		}
		System.out.printf("������%d\n", cur.getId());
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
