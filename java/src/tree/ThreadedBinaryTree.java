package tree;
/**
 * �������: 
1.�����Ƕ�����Ķ����������������ʱ������Ϊ {8, 3, 10, 1, 6, 14 }
2.���� 6, 8, 10, 14 �⼸���ڵ�� ����ָ�룬��û����ȫ��������.
3.�������ϣ����ֵ����� �����ڵ������ָ�룬 �ø����ڵ����ָ���Լ���ǰ��ڵ�,��ô��?
 * @author Lenovo
 *
 */
public class ThreadedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������������������Ĺ���
				 StuNode root = new StuNode(1, "Z1");
				 StuNode node2 = new StuNode(3, "S5");
				 StuNode node3 = new StuNode(6, "R6");
				 StuNode node4 = new StuNode(8, "G4");
				 StuNode node5 = new StuNode(10, "P8");
				 StuNode node6 = new StuNode(14, "Q1");
				
				//��������������ҪҪ�ݹ鴴��,�����ȼ򵥴���ʹ���ֶ�����
				root.setLeft(node2);
				root.setRight(node3);
				node2.setLeft(node4);
				node2.setRight(node5);
				node3.setLeft(node6);
				
				//��������������
				ThreadeTree threadTree = new ThreadeTree();
				threadTree.setRoot(root);
				threadTree.treadNodes();
				
				//����:��10�Žڵ����
				 StuNode left = node5.getLeft();
				 StuNode right = node5.getRight();
				System.out.println("10�Žڵ��ǰ����:" + left);
				System.out.println("10�Žڵ�ĺ����:" + right);
	}
	
}
/**
 * ����һ�� StuNode ���
 * 
 */
class StuNode{
	private int id;
	private String name;
	private StuNode  left; // Ĭ��Ϊnull,���ӽڵ�
	private StuNode  right; // Ĭ��Ϊnull,���ӽڵ�
	//1.���leftType == 0 ��ʾָ�����������, ��� 1 ���ʾָ��ǰ�����
	//2.���rightType == 0 ��ʾָ����������, ��� 1��ʾָ���̽��
	private int leftType;
	private int rightType;
	/**
	 * �� StuNode ��������
	 * @param id ���
	 * @param name  ����
	 */
	public StuNode (int id,String name){
		this.id=id;
		this.name=name;
		
	}
	/**
	 * @return the leftType
	 */
	public int getLeftType() {
		return leftType;
	}
	/**
	 * @param leftType the leftType to set
	 */
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	/**
	 * @return the rightType
	 */
	public int getRightType() {
		return rightType;
	}
	/**
	 * @param rightType the rightType to set
	 */
	public void setRightType(int rightType) {
		this.rightType = rightType;
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
	public  StuNode  getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft( StuNode  left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public  StuNode  getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight( StuNode  right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return " StuNode  [id=" + id + ", name=" + name + "]";
	}
}
/**
 * 	n�����Ķ��������к���n+1 ����ʽ 2n-(n-1)=n+1�� ����ָ�������ö��������еĿ�ָ����
 * 	���ָ��ý����ĳ�ֱ��������µ�ǰ���ͺ�̽���ָ�루���ָ��ӵ�ָ���Ϊ"����"
	���ּ����������Ķ��������Ϊ����������Ӧ�Ķ�������Ϊ����������(Threaded BinaryTree)��
	�����������ʵĲ�ͬ�������������ɷ�Ϊǰ�����������������������������ͺ�����������������
	һ������ǰһ����㣬��Ϊǰ�����
	һ�����ĺ�һ����㣬��Ϊ��̽��
 */
//����һ����������������ʵ�ֶԶ�������������
class ThreadeTree{
	private  StuNode  root;
	//Ϊ��ʵ��������,��Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
	//�ڵݹ����������ʱ,pre ���Ǳ���ǰһ�����
	private  StuNode  pre=null;
	/**
	 * @return the root
	 */
	public  StuNode  getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot( StuNode  root) {
		this.root = root;
	}
	//���� �������ķ���treadNodes
	public void treadNodes(){
		this.treadNodes(root);
	}
	//��д�Զ��������������������ķ���
	//node ����ǰ��Ҫ�������Ľ��
	public void treadNodes(StuNode  node){
		//���nodeΪ�գ�ֱ�ӷ���
		if(node==null){
			return;
		}
		
		//�Զ���������������������
		//1.��������������
		treadNodes(node.getLeft());
		//2.��������ǰ���
		//��������ǰ����ǰ�����
		if(node.getLeft()==null){
			//�õ�ǰ�Ľ��ָ��ǰ�����
			node.setLeft(pre);
			//Ȼ���޸ĵ�ǰ�ڵ��ָ������
			node.setLeftType(1);
		}
		//��������ǰ���ĺ�̽��
		if(pre!=null&&pre.getRight()==null)
		{
			//��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			//�޸ĵ�ǰ����ָ������
			pre.setRightType(1);
		}
		//��Ҫ  ÿ����һ������,�õ�ǰ�������һ������ǰ�����
		pre=node;
		//3.�Ż�������
		treadNodes(node.getRight());
	}
	
}

