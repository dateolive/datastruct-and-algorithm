package tree;
/**
 * 1.ƽ�������Ҳ��ƽ�������������Self-balancing binary search tree���ֱ���ΪAVL���� ���Ա�֤��ѯЧ�ʽϸߡ�
2.���������ص㣺����һ �ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ���������ƽ���
�����ĳ���ʵ�ַ����к������AVL������������Treap����չ���ȡ�
 * @author Lenovo
 *
 */
public class AVLTree {

	public static void main(String[] args) {
		//int[] arr = { 4, 3, 6, 5, 7, 8 };
		//int arr[] = { 10,12, 8, 9, 7, 6};
		int arr[] = { 10,12, 8, 9, 7, 6};
		// ����һ�� AVLTree����
		AVLtreedemo avlTree = new AVLtreedemo();

		// ��ӽ��
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node3(arr[i]));
		}

		// �������
		System.out.println("�������:");
		avlTree.infixOrder(); // 3,4,5,6,7,8

		System.out.println("����ƽ�⴦�����:");
		System.out.println("���ĸ߶�:" + avlTree.getRoot().heigth()); // 3
		System.out.println("�����������߶�:" + avlTree.getRoot().leftheight()); // 2
		System.out.println("�����������߶�:" + avlTree.getRoot().rightheight()); // 2
		System.out.println("��ǰ�ĸ��ڵ�:" + avlTree.getRoot());//8

	}

}
//����Node���
class Node3 {
	int value;
	Node3 left;
	Node3 right;

	public Node3(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node3 [value=" + value + "]";
	}

	// ��ӽڵ�ķ���
	// �ݹ����ʽ��ӽ��,ע����Ҫ���������������Ҫ��
	public void add(Node3 node) {
		if (node == null) {
			return;
		}

		// �жϴ���Ľ���ֵ,�͵�ǰ�����ĸ�����ֵ�Ĺ�ϵ
		if (node.value < this.value) {
			if (this.left == null) { // �����ǰ������ӽ��Ϊnull
				this.left = node;
			} else {
				// �ݹ�������������
				this.left.add(node);
			}
		} else { // ��ӵĽڵ��ֵ���ڵ�ǰ����ֵ
			if (this.right == null) {
				this.right = node;
			} else {
				// �ݹ�������������
				this.right.add(node);
			}
		}
		//�����һ���ڵ㣬����������-�������ĸ߶�>1��������ת
		if(rightheight()-leftheight()>1){
			//����������������������߶ȴ��������������������ĸ߶ȣ�
			if(right!=null&&(right.leftheight()>right.rightheight())){
				//�Ƚ�������ת
				right.rightRate();
				leftRate();
			}else{
			leftRate();
			}
			return;//��return�Ļ��ܿ���������ѭ��
		}
		//�����һ���ڵ㣬����������-�������ĸ߶�>1��������ת
		if(leftheight()-rightheight()>1){
			//����������������������߶ȴ��������������ĸ߶�
			if(left!=null&&(left.rightheight()>left.leftheight()))
			{
				//�Ƚ�������ת
				left.leftRate();
				rightRate();
			}else{
				rightRate();
			}
			
		}
		
	}

	// �������
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// ����Ҫɾ���Ľڵ�
	/**
	 * 
	 * @Description
	 * @param value
	 *            ϣ��ɾ���Ľ���ֵ
	 * @return ����ҵ���ֵ����,δ�ҵ�����null
	 */
	public Node3 search(int value) {
		if (value == this.value) { // ˵���ҵ���
			return this;
		} else if (value < this.value) { // ���ҵ�ֵС�ڵ�ǰ����ֵ,������������
			if (this.left == null) { // ���ӽ��Ϊ��
				return null;
			}
			return this.left.search(value);
		} else { // ���ҵ�ֵ��С�ڵ�ǰ����ֵ,������������
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	// ����Ҫɾ�����ĸ����
	/**
	 * 
	 * @param value
	 *            ϣ��ɾ���Ľ���ֵ
	 * @return ���ص���Ҫɾ���Ľ��ĸ����,���û�оͷ���null
	 */
	public Node3 searchP(int value) {
		// �����ǰ�����Ҫɾ���Ľ��ĸ����,���û�оͷ���null
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			// ������ҵ�ֵС�ڵ�ǰ����ֵ,�ҵ�ǰ�������ӽ�㲻Ϊ��
			if (value < this.value && this.left != null) {
				return this.left.searchP(value); // ������������
			} else if (value >= this.value && this.right != null) {
				return this.right.searchP(value); // ���������ݹ����
			} else {
				return null; // δ�ҵ������
			}
		}
	}
	//���ظýڵ�Ϊ���ڵ�����ĸ߶�
	public int heigth(){
		return Math.max(left==null?0:left.heigth(),right==null?0:right.heigth())+1;
	}
	
	//�����������ĸ߶�
	public int leftheight(){
		if(left==null)
			return 0;
		return left.heigth();
	}
	//�����������ĸ߶�
	public int rightheight(){
		if(right==null)
			return 0;
		return right.heigth();
	}
	
	public void leftRate(){
		// �����µĽ�㣬�Ե�ǰ������ֵ
		Node3 newNode=new Node3(value);
		// ���µĽ������������óɵ�ǰ����������
		newNode.left=left;
		// ���µĽ������������óɵ�ǰ������������������
		newNode.right=right.left;
		//�ѵ�ǰ�ڵ�����ӽڵ��ֵ������ǰ�ڵ�
		value=right.value;
		// �ѵ�ǰ�������������óɵ�ǰ�����������������
		right=right.right;
		//�ѵ�ǰ�ڵ�����������ó��µĽڵ�
		left=newNode;
		
	}
	public void rightRate(){
		Node3 newNode=new Node3(value);
		newNode.right=right;
		newNode.left=left.right;
		value=left.value;
		left=left.left;
		right=newNode;
	}
	



}

//����AVL��
class AVLtreedemo {
	private Node3 root;

	public Node3 getRoot() {
		return root;
	}

	// ��ӽ��ķ���
	public void add(Node3 node) {
		if (root == null) {
			root = node; // ���rootΪ����ֱ����rootָ��node
		} else {
			root.add(node);
		}
	}

	// ��������
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("����������Ϊ�գ�����");
		}
	}

	// ����Ҫ�h���Ľ��
	public Node3 search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	// ����Ҫɾ���Ľڵ�ĸ��ڵ�
	public Node3 searchP(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchP(value);
		}
	}

	// ɾ���ڵ�
	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			// 1.������ȥ�ҵ�Ҫɾ���Ľ�� targetNode
			Node3 targetNode = search(value);
			// ���û���ҵ�Ҫɾ���Ľ��
			if (targetNode == null) {
				return;
			}
			// ������Ƿ��ֵ�ǰ��Ŷ���������ֻ��һ�����
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// ȥ�ҵ�targetNode�ĸ����
			Node3 parent = searchP(value);
			// ���Ҫɾ���Ľڵ�ΪҶ�ӽڵ�
			if (targetNode.left == null && targetNode.right == null) {
				// �ж�targetNode�Ǹ��ڵ�����ӽ��,�������ӽڵ�
				if (parent.left != null && parent.left.value == value) { // ���ӽڵ�
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) { // ���ӽڵ�
					parent.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) { // ɾ�������������Ľڵ�
				int minVa = delRightT(targetNode.right);
				targetNode.value = minVa;
			} else { // ɾ��ֻ��һ�������Ľڵ�
				// ���Ҫɾ���Ľ�������ӽ��
				if (targetNode.left != null) {
					if (parent != null) {
						// ��� targetNode �� parent �����ӽ��
						if (parent.left.value == value) {
							parent.left = targetNode.left;
						} else { // targetNode �� parent �����ӽ��
							parent.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else { // ���Ҫɾ���Ľ�������ӽ��
					if (parent != null) {
						// ��� targetNode �� parent �����ӽ��
						if (parent.left.value == value) {
							parent.left = targetNode.right;
						} else { // ��� targetNode �� parent �����ӽ��
							parent.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}
	}

	// ��д����
	// 1.���ص� ��node Ϊ�����Ķ�������������С����ֵ
	// 2.ɾ��node Ϊ�����Ķ�������������С���
	/**
	 * 
	 * @Description
	 * @param node
	 *            ����Ľ��(Ϊ�����������ĸ����)
	 * @return ���ص� ��node Ϊ�����Ķ�������������С����ֵ
	 */
	public int delRightT(Node3 node) {
		Node3 tar = node;
		// ѭ���Ĳ������ӽڵ㣬�ͻ��ҵ���Сֵ
		while (tar.left != null) {
			tar = tar.left;
		}
		// ��ʱ target��ָ������С���
		// ɾ����С���
		delNode(tar.value);
		return tar.value;
	}
}