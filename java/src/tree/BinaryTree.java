package tree;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ȴ���һ�ö�����
		Binarytreedemo binaryTree = new Binarytreedemo();
		// ������Ҫ�Ľڵ�
		Student root = new Student(1, "�ν�");
		Student hero2 = new Student(2, "����");
		Student hero3 = new Student(3, "¬����");
		Student hero4 = new Student(4, "�ֳ�");
		Student hero5 = new Student(5, "��ʤ");
		
		// ˵��,���ֶ�����������,�ٵݹ鷽ʽ����������
		root.setLeft(hero2);
		root.setRight(hero3);
		hero3.setRight(hero4);
		hero3.setLeft(hero5);
		binaryTree.setRoot(root);

		/*// ����
		System.out.println("ǰ�����:"); // 1,2,3,5,4
		binaryTree.perOrder();

		// ����2
		System.out.println("�������:"); // 2,1,5,3,4
		binaryTree.infixOrder();

		// ����3
		System.out.println("�������:"); // 2,5,4,3,1
		binaryTree.postOrder();*/
		
		// ǰ���������
		// ǰ��������ҵĴ��� :4
		System.out.println("ǰ��������ҷ�ʽ:");
		Student node = binaryTree.perOrderFind(5);
		if (node != null) {
			System.out.printf("�ҵ���,��ϢΪ id = %d name = %s\n", node.getId(),
					node.getName());
		} else {
			System.out.printf("û���ҵ�,�����Ϣ�����\n");
		}

		// �����������
		// ����������Ҵ��� :3
		System.out.println("����������ҷ�ʽ:");
		Student node2 = binaryTree.infixOrderFind(5);
		if (node2 != null) {
			System.out.printf("�ҵ���,��ϢΪ id = %d name = %s\n", node2.getId(),
					node2.getName());
		} else {
			System.out.printf("û���ҵ�,�����Ϣ�����\n");
		}

		// �����������
		// ����������Ҵ��� :2
		System.out.println("����������ҷ�ʽ:");
		Student node3 = binaryTree.postOrderFind(5);
		if (node3 != null) {
			System.out.printf("�ҵ���,��ϢΪ id = %d name = %s\n", node3.getId(),
					node3.getName());
		} else {
			System.out.printf("û���ҵ�,�����Ϣ�����\n");
		}
		
		//����ɾ��
		System.out.println("ɾ��ǰ,ǰ�����:");
		binaryTree.perOrder(); // 1,2,3,5,4
		binaryTree.delNode(5);
		// binaryTree.delNode(3);
		System.out.println("ɾ����ǰ�����:");
		binaryTree.perOrder(); // 1,2,3,4
	}

}
//����һ��������
class Binarytreedemo{
	private Student root;
	
	public void setRoot(Student root) {
		this.root = root;
	}
	//ǰ�����
	public void perOrder(){
		if(this.root!=null){
			this.root.perOrder();
		}else{
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	//�������
	public void infixOrder(){
		if(this.root!=null){
			this.root.infixOrder();
		}else{
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	//�������
	public void postOrder(){
		if(this.root!=null){
			this.root.postOrder();
		}else{
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	//ǰ���������
	public Student perOrderFind(int id){
		if(root != null){
			return root.perOrderFind(id);
		}else{
			return null;
		}
	}
	//�����������
	public Student infixOrderFind(int id){
		if(root != null){
			return root.infixOrderFind(id);
		}else{
			return null;
		}
	}
	//�����������
	public Student postOrderFind(int id){
		if(root != null){
			return root.postOrderFind(id);
		}else{
			return null;
		}
	}
	//ɾ������
	/*�����ȴ���
	����������ǿ���root�����ֻ��һ��root��㣬��ȼ۽�������
	�ÿ�*/
	public void delNode(int id){
		if(root != null){
			//���ֻ��һ��root��㣬��ȼ۽��������ÿ�
			if(root.getId() == id){
				root = null;
			}else{
				//�ݹ�ɾ��
				root.delNode(id);
			}
		}else{
			System.out.println("����,����ɾ��");
		}
	}
	
}
//����һ�����
class Student{
	private int id;
	private String name;
	private Student left;
	private Student right;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the left
	 */
	public Student getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(Student left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public Student getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(Student right) {
		this.right = right;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	/*
	 *  * 
������������ǰ��,����,����ı������裺
1. ����һ�Ŷ�����
2. ǰ�����
    2.1 �������ǰ�ڵ�(��ʼ��ʱ����root�ڵ�)
    2.2 ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
    2.3 ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
3. �������
    3.1 �����ǰ�ڵ�����ӽڵ㲻Ϊ��,��ݹ��������,
    3.2 �����ǰ�ڵ�
    3.3 �����ǰ�ڵ�����ӽڵ㲻Ϊ��,��ݹ��������
4.�������
    4.1 �����ǰ�ڵ�����ӽڵ㲻Ϊ��,��ݹ�������,
    4.2 �����ǰ�ڵ�����ӽڵ㲻Ϊ��,��ݹ�������
    4.3 �����ǰ�ڵ�        
	 * */
	// ��дǰ������ķ���
	public void perOrder(){
		//������ڵ�
		System.out.println(this);
		//������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if(this.left!=null){
			this.left.perOrder();
		}
		//������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if(this.right!=null){
			this.right.perOrder();
		}
	}
	//��д��������ķ���
	public void infixOrder(){
		// ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if (this.left != null) {
			this.left.infixOrder();
		}
		//������ڵ�
		System.out.println(this);
		// ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	//��д��������ķ���
	public void postOrder(){
		// ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if (this.left != null) {
			this.left.postOrder();
		}
		// ������ӽڵ㲻Ϊ��,��ݹ����ǰ�����
		if (this.right != null) {
			this.right.postOrder();
		}
		// ������ڵ�
		System.out.println(this);
	}
/**
 ʹ��ǰ�����򣬺���ķ�ʽ����ѯָ���Ľ��
>>ǰ�����˼·
1.���жϵ�ǰ����no�Ƿ����Ҫ���ҵ�
2���������򷵻ص�ǰ���
3������ȣ����жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�������Ϊ����ݹ�ǰ
�����
4������͹�ǰ������ҵ�����򷵻ط���ά���жϵ�ǰ�Ľ�����
�ӽڵ��Ƿ�Ϊ�գ����������ά�����ҵݹ�ǰ����ҡ�
>>�������˼·
1��ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
2����ҵ����򷵻����û���ҵ����ͺ͵�ǰ���Ƚ�������򷵻ص�ǰ
��㣬������������ҵݹ���������
3����ҵݹ���������ҵ��ͷ��أ����򷵻�nul
>>�������˼·
1�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�������Ϊ����ݹ�������
2����ҵ��ͷ��أ����û���ҵ������жϵ�ǰ�������ӽڵ��Ƿ�Ϊ��
�����Ϊ�գ����ҵݹ���к����������ҵ��ͷ���
3�ͺ͵�ǰ�����жԱȣ�������򷵻ط��򷵻�nul
 */
	// ǰ�����
	public Student perOrderFind(int id) {
		// 1.���жϵ�ǰ����no�Ƿ����Ҫ���ҵ�
		if (this.id == id) {
			return this;
		}
		Student resnode = null;
		// 2.��ǰ�������ӽڵ��Ƿ�Ϊ�������Ϊ����ݹ�ǰ�����
		if (this.left != null) {
			resnode = this.left.perOrderFind(id);
		}
		if (resnode != null) {
			// �ҵ���������
			return resnode;
		}
		// //3.��������ж�,��ǰ�Ľ������ӽڵ��Ƿ�Ϊ��
		// 4.�������,��ά�����ҵݹ�ǰ����ҡ�
		if (this.right != null) {
			resnode = this.right.perOrderFind(id);
		}
		return resnode;
	}
	//�������
	public Student infixOrderFind(int id){
		//1��ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		Student resNode=null;
		if(this.left!=null){
			resNode=this.left.infixOrderFind(id);
		}
		// �ҵ���������
		if(resNode!=null){
			return resNode;
		}
		//2����ҵ����򷵻�,���û���ҵ����ͺ͵�ǰ���Ƚ�������򷵻ص�ǰ
		//��㣬������������ҵݹ���������
		if(this.id==id){
			return this;
		}
		//3����ҵݹ���������ҵ��ͷ��أ����򷵻�nul
		if(this.right!=null){
			resNode=this.right.infixOrderFind(id);
		}
		return resNode;
	}
	//�������
	public Student postOrderFind(int id){
		//1�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�������Ϊ����ݹ�������
		Student resNode=null;
		if(this.left!=null){
			resNode=this.left.postOrderFind(id);
		}
		//2����ҵ��ͷ��أ����û���ҵ������жϵ�ǰ�������ӽڵ��Ƿ�Ϊ��
		if(resNode!=null){
			//�ҵ���������
			return resNode;
		}
		//�����Ϊ�գ����ҵݹ���к����������ҵ��ͷ���
		if(this.right!=null){
			resNode=this.right.postOrderFind(id);
		}
		if(resNode!=null){
			//�ҵ���������
			return resNode;
		}
		//3�ͺ͵�ǰ�����жԱȣ�������򷵻ط��򷵻�nul
		if(this.id==id){
			return this;
		}
		return resNode;	
	}
	/**
���ɾ�����Ĳ���
�涨
1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
2���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
˼·
�����ȴ���
����������ǿ���root�����ֻ��һ��root��㣬��ȼ۽�������
�ÿ�
Ȼ��������沽��
1.��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ����
����Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����
2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����
�ͽ� this. left=nu���Ҿͷ��أ������ݹ�ɾ����
3�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬
�ͽ� this right=nu���Ҿͷ��أ������ݹ�ɾ����
4�����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�
ɾ��
5�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
	 * 
	 */
	//�h��
	//1.���ɾ���Ľڵ���Ҷ�ӽڵ�,��ɾ���ýڵ�
	//2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ�,��ɾ��������
	public void delNode(int id){
		//�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����
		//�ͽ� this. left=null���Ҿͷ��أ������ݹ�ɾ����
		if(this.left!=null && this.left.id==id){
			this.left=null;
			return;
		}
		//�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬
		//�ͽ� this right=null���Ҿͷ��أ������ݹ�ɾ����
		if(this.right!=null&&this.right.id==id){
			this.right=null;
			return;
		}
		//�����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
		if(this.left!=null){
			this.left.delNode(id);
		}
		//�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
		if(this.right!=null){
			this.right.delNode(id);
		}
	}
}
