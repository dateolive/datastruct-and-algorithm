package stulinkedlist;

public class DoubleLinked {

	public static void main(String[] args) {
		Student2 stu1=new Student2(1, "С��");
		Student2 stu2=new Student2(2, "С��");
		Student2 stu3=new Student2(3, "С��");
		Student2 stu4=new Student2(4, "С��");
		DoubleLinkedList list=new DoubleLinkedList();
		/*list.add1(stu1);
		list.add1(stu2);
		list.add1(stu3);
		list.add1(stu4);*/
		list.add2(stu3);
		list.add2(stu4);
		list.add2(stu1);
		list.add2(stu2);
		System.out.println("��ʾ��ʼ����:");
		list.showLinkedList();
		System.out.println("��ʾɾ���������:");
		list.del(stu2);
		list.showLinkedList();
		System.out.println("��ʾ�޸ĺ������:");
		Student2 newnode=new Student2(1, "С��");
		list.updata(newnode);
		list.showLinkedList();

	}

}
class DoubleLinkedList{
	
	private Student2 head = new Student2(0, "");

	// ����ͷ�ڵ�
	public Student2 getHead() {
		return head;
	}
	
	//˫���������ɾ�Ĳ�
	//1.˫����������
	public void add1(Student2 stunode){
		//����ͷ�ڵ㲻�ܶ���������һ�������ڵ������б���
		Student2 tmp=head;
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
		stunode.pre=tmp;
	}
	//����˳�����ڵ�
	//���ݽڵ����Ž��в��Ҳ��룬���������ڴ�����ɵģ����Խ�ʡ��һЩsql��ʱ��
	public void add2(Student2 stunode){
		// ����ͷ�ڵ㲻�ܶ���������һ�������ڵ������б���
		Student2 tmp = head;
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
		else if(tmp.next!=null){
			//��������
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
	
	
	//2.˫�������ɾ��
	//1��������������һ������Ҫ�ҵ�Ҫɾ���ڵ��ǰһ����㣬ֱ�Ӳ���Ҫɾ���Ľ�㼴��
	//2����Ҫ˼·    tmp.pre.next=tmp.next;tmp.next.pre=tmp.pre;
	public void del(Student2 stunode){
		Student2 tmp=head;
		boolean flag=false;
		while(true){
			if(tmp.next==null){
				//��������
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
			System.out.printf("���%d�����ڣ�ɾ��ʧ��", stunode.no);
		}
	}
	//3.�޸Ľ��
	public void updata(Student2 stunode){
		//�������Ϊ��
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		//����һ������ָ��
		Student2 tmp=head;
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
		}else{
			System.out.printf("û���ҵ����%d�Ľڵ�",stunode.no);
		}
	}
	
	//4.��ʾ
	//ѭ����ʾ����
	public void showLinkedList(){
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		Student2 tmp=head.next;
		while(true){
			//������
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
	public Student2 next; //ָ����һ���ڵ�
	public Student2 pre; //ָ��ǰһ���ڵ�
	//������
	public Student2(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public Student2(){
		
	}
	//Ϊ����ʾ��������������toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
}