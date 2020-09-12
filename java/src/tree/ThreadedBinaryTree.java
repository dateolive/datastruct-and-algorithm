package tree;
//����������������
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
				
				//����ǰ��������
				/*ThreadeTree threadTree = new ThreadeTree();
				threadTree.setRoot(root);
				threadTree.treadNodesPre();
				//���ԣ�
				StuNode left = node5.getLeft();
				StuNode right = node5.getRight();
				System.out.println("10�Žڵ��ǰ����:" + left);
				System.out.println("10�Žڵ�ĺ����:" + right);
				System.out.println("ǰ����������������ǰ�����");
				threadTree.treadListPre(); // 1,3,8,10,6,14*/
				
				//��������������
				/*ThreadeTree threadTree = new ThreadeTree();
				threadTree.setRoot(root);
				threadTree.treadNodes();
				
				//����:��10�Žڵ����
				 StuNode left = node5.getLeft();
				 StuNode right = node5.getRight();
				System.out.println("10�Žڵ��ǰ����:" + left);
				System.out.println("10�Žڵ�ĺ����:" + right);
				System.out.println("�������������������������");
				threadTree.treadListmiddle();*/
				
				//��Ӹ��ڵ�
				node2.setParent(root);
				node3.setParent(root);
				node4.setParent(node2);
				node5.setParent(node2);
				node6.setParent(node3);
				
				ThreadeTree threadTree = new ThreadeTree();
				threadTree.setRoot(root);
				threadTree.treadNodesPost(root);
				//���ԣ�
				StuNode left = node5.getLeft();
				StuNode right = node5.getRight();
				System.out.println("10�Žڵ��ǰ����:" + left);
				System.out.println("10�Žڵ�ĺ����:" + right);
				System.out.println("�������������ĺ������");
				threadTree.treadListPost();
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
	private StuNode parent;////�����ָ��
	/**
	 * @return the parent
	 */
	public StuNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(StuNode parent) {
		this.parent = parent;
	}
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
	//���� �������ķ���treadNodesPre
	public void treadNodesPre() {
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
	
	//��д�Զ���������ǰ���������ķ���
	// node ����ǰ��Ҫ�������Ľ��
	public void treadNodesPre(StuNode node) {
		// ���nodeΪ�գ�ֱ�ӷ���
		if (node == null) {
			return;
		}

		// �Զ���������������������
		// 1.��������ǰ���
		// ��������ǰ����ǰ�����
		if (node.getLeft() == null) {
			// �õ�ǰ�Ľ��ָ��ǰ�����
			node.setLeft(pre);
			// Ȼ���޸ĵ�ǰ�ڵ��ָ������
			node.setLeftType(1);
		}
		// ��������ǰ���ĺ�̽��
		if (pre != null && pre.getRight() == null) {
			// ��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			// �޸ĵ�ǰ����ָ������
			pre.setRightType(1);
		}
		// ��Ҫ ÿ����һ������,�õ�ǰ�������һ������ǰ�����
		pre = node;
		// 2.��������������
		if(node.getLeftType()!=1)
		treadNodesPre(node.getLeft());
		// 3.�Ż�������
		if(node.getRightType()!=1)
		treadNodesPre(node.getRight());
	}
	
	// ��д�Զ��������к����������ķ���
	// node ����ǰ��Ҫ�������Ľ��
	public void treadNodesPost(StuNode node) {
		// ���nodeΪ�գ�ֱ�ӷ���
		if (node == null) {
			return;
		}
		// 1.��������������
			treadNodesPost(node.getLeft());
		// 2.�Ż�������
			treadNodesPost(node.getRight());
		// �Զ��������к�����������
		// 1.��������ǰ���
		// ��������ǰ����ǰ�����
		if (node.getLeft() == null) {
			// �õ�ǰ�Ľ��ָ��ǰ�����
			node.setLeft(pre);
			// Ȼ���޸ĵ�ǰ�ڵ��ָ������
			node.setLeftType(1);
		}
		// ��������ǰ���ĺ�̽��
		if (pre != null && pre.getRight() == null) {
			// ��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			// �޸ĵ�ǰ����ָ������
			pre.setRightType(1);
		}
		// ��Ҫ ÿ����һ������,�õ�ǰ�������һ������ǰ�����
		pre = node;
	
	}
	
	// ����ǰ���������������������ڵ����ͨ�����ͷ�ʽ�������������ʹ�õݹ鷽ʽ������Ҳ����˱�����Ч�ʡ� �����Ĵ���Ӧ����ǰ���������һ�¡�
	// ����ǰ��������������
	public void treadListPre() {
		// ����һ������,����|�洢��ǰ�����Ľ��,��root��ʼ
		StuNode node = root;
		while (node != null) {
			// ��ӡ��ǰ�ڵ�
			System.out.println(node);
			// ѭ�����ҵ�leftType == 1�Ľ��,��һ���ҵ�����8���
			// �������ű������仯,��Ϊ��leftType==1ʱ,˵���ý���ǰ�����������������Ч���
			while (node.getLeftType() == 0) {
				node = node.getLeft();
				System.out.println(node);
			}
			// �����ǰ������ָ��ָ����Ǻ�̽��,
			while (node.getRightType() == 1) {
				// ��ȡ��ǰ�ڵ�ĺ�̽ڵ�
				node = node.getRight();
			}
			// �滻��ǰ�ڵ�
			node = node.getRight();
		}

	}
	
	
	//���������������������������ڵ����ͨ�����ͷ�ʽ�������������ʹ�õݹ鷽ʽ������Ҳ����˱�����Ч�ʡ� �����Ĵ���Ӧ���������������һ�¡�
	//��������������������
	public void treadListmiddle(){
		//����һ������,����|�洢��ǰ�����Ľ��,��root��ʼ
		StuNode node=root;
		while(node!=null){
			//ѭ�����ҵ�leftType == 1�Ľ��,��һ���ҵ�����8���
			//�������ű������仯,��Ϊ��leftType==1ʱ,˵���ý���ǰ�����������������Ч���
			while(node.getLeftType()==0){
				node=node.getLeft();
			}
			//��ӡ��ǰ�ڵ�
			System.out.println(node);
			//�����ǰ������ָ��ָ����Ǻ�̽��,���һֱ���
			while(node.getRightType()==1){
				//��ȡ��ǰ�ڵ�ĺ�̽ڵ�
				node=node.getRight();
				System.out.println(node);
			}
			//�滻��ǰ�ڵ�
			node=node.getRight();
		}
		
	}
	//���������������������������ڵ����ͨ�����ͷ�ʽ�������������ʹ�õݹ鷽ʽ������Ҳ����˱�����Ч�ʡ� �����Ĵ���Ӧ���������������һ�¡�
	//��������������������
	public void treadListPost() {
		// ����һ������,����|�洢��ǰ�����Ľ��,��root��ʼ
		StuNode node = root;
		while(node!=null&&node.getLeftType()==0)
		{
			node=node.getLeft();
		}
		StuNode pre=null;
		while (node != null) {
			 //�ҽڵ�������
			if(node.getRightType()==1)
			{
				System.out.println(node);
				pre=node;
				node=node.getRight();
			}else{
				//����ϸ�����Ľڵ��ǵ�ǰ�ڵ���ҽڵ�
				if(node.getRight()==pre)
				{
					System.out.println(node);
					if(node==root){
						return;
					}
					pre=node;
					node=node.getParent();
				}else{
					 //�������ڵ�Ľ������ҵ�������������ڵ�
					node=node.getRight();
					while(node.getLeftType()==0)
					{
						node=node.getLeft();
					}
				}
			}

		}

	}
	
}

