package tree;
/**
 
 ������������BST: (Binary Sort(Search) Tree), ���ڶ������������κ�һ����Ҷ�ӽڵ㣬Ҫ�����ӽڵ��ֵ�ȵ�ǰ�ڵ��ֵС��
 ���ӽڵ��ֵ�ȵ�ǰ�ڵ��ֵ��
 �ر�˵�����������ͬ��ֵ�����Խ��ýڵ�������ӽڵ�����ӽڵ�
 * @author Lenovo
 *
 */
public class BinarySortTree {

	public static void main(String[] args) {
		int arr[] = {7,3,10,12,5,1,9};
		Binarysort tree=new Binarysort();
		for(int i=0;i<arr.length;i++){
			tree.add(new Node2(arr[i]));
		}
		System.out.println("�����������������");
		tree.infixOrder();
		//����һ��ɾ��Ҷ�ӽڵ�
		tree.delNode(1);
		tree.delNode(3);
		System.out.println("ɾ����Ľڵ�:");
		tree.infixOrder(); // 0,1,3,5,9,10,12

	}

}
//����Node2�ڵ�
class Node2{
	int value;
	Node2 leftNode2;
	Node2 rightNode2;
	
	public Node2(int value){
		this.value=value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node2 [value=" + value + "]";
	}
	//��ӽڵ�
	//�ݹ����ʽ��ӽ��,ע����Ҫ���������������Ҫ��
	public void add(Node2 node){
		if(node==null){
			return;
		}
		//���Ҫ��ӵĽڵ�С�ڵ�ǰ�����ĸ��ڵ㣬����������
		if(node.value<this.value){
			//�����ǰ�����ӽڵ�Ϊ�գ������
			if(this.leftNode2==null){
				this.leftNode2=node;
			}else{
				//�����ǰ�����ӽڵ㲻Ϊ�գ���ݹ�
				this.leftNode2.add(node);
			}
		}else{
			//���Ҫ��ӵĽڵ���ڵ��ڵ�ǰ�����ĸ��ڵ㣬��������ұ�
			//�����ǰ�����ӽڵ�Ϊ�գ������
			if(this.rightNode2==null){
				this.rightNode2=node;
			}else{
				//��Ϊ����ݹ�
				this.rightNode2.add(node);
			}
		}
	}
	//�������
	public void infixOrder(){
		if(this.leftNode2!=null){
			this.leftNode2.infixOrder();
		}
		System.out.println(this);
		if(this.rightNode2!=null){
			this.rightNode2.infixOrder();
		}
	}

	//Ѱ��Ҫɾ���Ľڵ�
	public Node2 search(int value){
		if(this.value==value){
			//����ҵ��ˣ��򷵻�
			return this;
		}else if(this.value>value){
			//�����ǰ�ڵ����Ҫ�ҵĽڵ��ֵ�����������
			if(this.leftNode2==null){
				return null;//������Ϊ��
			}
			return this.leftNode2.search(value);
		}else{
			if(this.rightNode2==null){
				return null;
			}
			return this.rightNode2.search(value);
		}
	}
	//����Ҫɾ���ĸ��ڵ�
	public Node2 searchParent(int value){
		//�����ǰ����һ����(��)�ӽڵ㲻Ϊ�գ���ֵ����ҵ�ֵ��ͬ���򷵻ص�ǰ�Ľڵ�
		if((this.leftNode2!=null&&this.leftNode2.value==value)||(this.rightNode2!=null&&this.rightNode2.value==value)){
			return this;
		}else{
			//������ҵ�ֵС�ڵ�ǰ����ֵ,�ҵ�ǰ�������ӽ�㲻Ϊ��
			if(this.leftNode2!=null&&this.value>value){
				return this.leftNode2.searchParent(value);//�ݹ�������������
			}else if(this.rightNode2!=null&&this.value<=value){
				return this.rightNode2.searchParent(value);
			}else{
				return null;
			}
		}
	}
	
}
//����һ������������
class Binarysort{
	private Node2 root;
	
	//��д��ӽڵ�
	public void add(Node2 node){
		if(root==null){
			root=node;
		}else{
			root.add(node);
		}
	}
	
	//��д�������
	public void infixOrder(){
		if(root==null){
			System.out.println("����������Ϊ�գ�����");
		}else{
			root.infixOrder();
		}
	}
	//����Ҫɾ���Ľڵ�
	public Node2 search(int value){
		if(root==null)
			return null;
		return root.search(value);
	}
	//����Ҫɾ���Ľڵ�ĸ��ڵ�
	public Node2 searchParent(int value){
		if(root==null)
			return null;
		return root.searchParent(value);
	}
	/**
��һ�����: ɾ��Ҷ�ӽڵ� (���磺2, 5, 9, 12)
˼·
(1) ������ȥ�ҵ�Ҫɾ���Ľ��  targetNode
(2) �ҵ�targetNode �� ����� parent 
(3) ȷ�� targetNode �� parent�����ӽ�� �������ӽ��
(4) ����ǰ����������Ӧɾ��
	���ӽ�� parent.left = null
	���ӽ�� parent.right = null;
�ڶ������: ɾ��ֻ��һ�������Ľڵ� ���� 1
˼·
(1) ������ȥ�ҵ�Ҫɾ���Ľ��  targetNode
(2) �ҵ�targetNode �� ����� parent 
(3) ȷ��targetNode ���ӽ�������ӽ�㻹�����ӽ��
(4) targetNode �� parent �����ӽ�㻹�����ӽ��
(5) ���targetNode �����ӽ��
	5.1 ��� targetNode �� parent �����ӽ��
		parent.left = targetNode.left;
	5.2 ��� targetNode �� parent �����ӽ��
		parent.right = targetNode.left;
(6) ���targetNode �����ӽ��
	6.1 ��� targetNode �� parent �����ӽ��
		parent.left = targetNode.right;
	6.2 ��� targetNode �� parent �����ӽ��
		parent.right = targetNode.right
		
�����: ɾ�������������Ľڵ�. (���磺7, 3��10 )
˼·
(1) ������ȥ�ҵ�Ҫɾ���Ľ��  targetNode
(2) �ҵ�targetNode �� ����� parent 
(3) ��targetNode ���������ҵ���С�Ľ��
(4) ��һ����ʱ�������� ��С����ֵ���� temp = 11
(5) ɾ������С���
(6) targetNode.value = temp

	 */
	//ɾ���ڵ�
	public void delNode(int value){
		if(root==null)
			return;
		else{
			//������ȥ�ҵ�Ҫɾ���Ľ��  targetNode
			Node2 targetNode=search(value);
			//Ҫ�ҵĽڵ�Ϊ��
			if(targetNode==null)
				return;
			//�����ǰ�����������Ľ��ֻ��һ��
			if(root.leftNode2==null&&root.rightNode2==null){
				root=null;
				return;
			}
			//�ҵ�targetNode �� ����� parent 
			Node2 parent=searchParent(value);
			//�жϵ�ǰ����Ҷ�ӽڵ�
			if(targetNode.leftNode2==null&&targetNode.rightNode2==null){
				//�ж�tar��parent�����ӽڵ�
				if(parent.leftNode2!=null&&parent.leftNode2.value==value){
					parent.leftNode2=null;
				}else if(parent.rightNode2!=null&&parent.rightNode2.value==value){
					parent.rightNode2=null;
				}
			}else if(targetNode.leftNode2!=null&&targetNode.rightNode2!=null)
			{
				//�жϵ�ǰ�������������Ľڵ�
				int minval=delRightT(targetNode.rightNode2);
				//int maxval=delLeftT(targetNode.leftNode2);
				targetNode.value=minval;
				
				
				
			}else{
				//�жϵ�ǰ��ֻ��һ�������Ľڵ�
				//���targetNode ���ӽ�������ӽ��
				if(targetNode.leftNode2!=null){
					//�жϵ�ǰ�ĸ��ڵ��Ƿ�Ϊ��
					if(parent!=null){
						//��� targetNode �� parent �����ӽ��
						if(parent.leftNode2.value==value){
							parent.leftNode2=targetNode.leftNode2;
						}else{
							//��� targetNode �� parent �����ӽ��
							parent.rightNode2=targetNode.leftNode2;
						}
					}else{
						root=targetNode.leftNode2;
					}
				}else{
					//���targetNode ���ӽ�������ӽ��
					//�жϵ�ǰ���ڵ��Ƿ�Ϊ��
					if(parent!=null){
						if(parent.leftNode2.value==value){
							parent.leftNode2=targetNode.rightNode2;
						}else{
							parent.rightNode2=targetNode.rightNode2;
						}
					}else{
						root=targetNode.rightNode2;
					}
				}
			}
			
			
			
		}
	}
	//��д����
		//1.���ص� ��node Ϊ�����Ķ�������������С����ֵ
		//2.ɾ��node Ϊ�����Ķ�������������С���
		/**
		  * 
		  * @Description 
		  * @param node ����Ľ��(Ϊ�����������ĸ����),����Ľڵ���Ҫɾ���ڵ�����ӽڵ�
		  * @return ���ص� ��node Ϊ�����Ķ�������������С����ֵ//��targetNode ���������ҵ���С�Ľ��
		 */
	public int delRightT(Node2 node){
		Node2 tar = node;
		//ѭ���Ĳ������ӽڵ㣬�ͻ��ҵ���Сֵ
		while(tar.leftNode2 != null){
			tar = tar.leftNode2;
		}
		//��ʱ target��ָ������С���
		//ɾ����С���
		delNode(tar.value);
		return tar.value;
	}

	// ��д����
	// 1.���ص� ��node Ϊ�����Ķ�����������������ֵ
	// 2.ɾ��node Ϊ�����Ķ����������������
	/**
	 * 
	 * @Description
	 * @param node
	 *            ����Ľ��(Ϊ�����������ĸ����),����Ľڵ���Ҫɾ���ڵ�����ӽڵ�
	 * @return ���ص� ��node Ϊ�����Ķ�����������������ֵ//��targetNode ���������ҵ����Ľ��
	 */
	public int delLeftT(Node2 node) {
		Node2 tar = node;
		while (tar.rightNode2 != null) {
			tar = tar.rightNode2;
		}
		delNode(tar.value);
		return tar.value;

	}
	
}
