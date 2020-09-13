package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 ����n��Ȩֵ��Ϊn��Ҷ�ӽ�㣬����һ�ö��������������Ĵ�Ȩ·������(wpl)�ﵽ��С���������Ķ�����Ϊ���Ŷ�������Ҳ��Ϊ��������(Huffman Tree)
 �շ������Ǵ�Ȩ·��������̵�����Ȩֵ�ϴ�Ľ������Ͻ���

1.·����·�����ȣ���һ�����У���һ��������¿��Դﵽ�ĺ��ӻ����ӽ��֮���ͨ·����Ϊ·����ͨ·�з�֧����Ŀ��Ϊ·�����ȡ����涨�����Ĳ���Ϊ1��
��Ӹ���㵽��L�����·������ΪL-1
2.����Ȩ����Ȩ·�����ȣ��������н�㸳��һ������ĳ�ֺ������ֵ���������ֵ��Ϊ�ý���Ȩ�����Ĵ�Ȩ·������Ϊ���Ӹ���㵽�ý��֮���·������
��ý���Ȩ�ĳ˻�
3.���Ĵ�Ȩ·�����ȣ����Ĵ�Ȩ·�����ȹ涨Ϊ����Ҷ�ӽ��Ĵ�Ȩ·������֮�ͣ���ΪWPL(weighted path length) ,ȨֵԽ��Ľ��������Խ���Ķ�����
�������Ŷ�������
4.WPL��С�ľ��Ǻշ�����


 * @author Lenovo
 *
 */
public class Hufumantree {
	/**
	 * 
���ɺշ������Ĳ��裺
1.��С�����������, ��ÿһ�����ݣ�ÿ�����ݶ���һ���ڵ� �� ÿ���ڵ���Կ�����һ����򵥵Ķ�����
2.ȡ�����ڵ�Ȩֵ��С�����Ŷ�����
3.���һ���µĶ�����, ���µĶ������ĸ��ڵ��Ȩֵ��ǰ�����Ŷ��������ڵ�Ȩֵ�ĺ�
4.�ٽ�����µĶ��������Ը��ڵ��Ȩֵ��С �ٴ����� �����ظ� 1-2-3-4 �Ĳ��裬ֱ�������У����е����ݶ��������͵õ�һ�źշ�����
	 * @param args
	 */

	public static void main(String[] args) {
		int arr[]={13, 7, 8, 3, 29, 6, 1 };
		Node root=hufuManTree(arr);
		PreOrder(root);
		

	}
	//ǰ���������
	public static void PreOrder(Node root){
		if(root!=null){
			root.PreOrder();
		}else{
			System.out.println("�������޷�����");
		}
		
	}
	//����hufuman��
	public static Node hufuManTree(int[] arr){
		// ��һ��,Ϊ�˲�������
		// 1.���� arr ����
		// 2.��arr��ÿ��Ԫ�ع���һ��Node
		// 3.��Node ���뵽ArrayList��
		List<Node> nodes=new ArrayList<Node>();
		for(int value:arr){
			nodes.add(new Node(value));
		}
		//ѭ������
		while(nodes.size()>1){
			//��С��������
			Collections.sort(nodes);
			// ȡ�����ڵ�Ȩֵ��С�����Ŷ�����
			// (1)ȡ��Ȩֵ��С�Ľ��(������)
			Node leftNode=nodes.get(0);
			//(2)ȡ��Ȩֵ��С�Ľڵ�
			Node rightNode=nodes.get(1);
			// (3)����һ���µĶ�����
			Node parent=new Node(leftNode.value+rightNode.value);
			parent.leftNode=leftNode;
			parent.rightNode=rightNode;
			// (4)��ArrayListɾ��������Ķ�����
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// (5)��parent���뵽nodes
			nodes.add(parent);
		}
		// ���غշ�������root���
		return nodes.get(0);
		
	}
	


}
//����һ���ڵ�
// Ϊ����Node �����������Collections��������
// ��Node ʵ��Comparable�ӿ�
class Node implements Comparable<Node>{
	int value;//Ȩֵ
	Node leftNode;//���ӽڵ�
	Node rightNode;//���ӽڵ�
	
	public Node(int value){
		this.value=value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// ��ʾ��С��������
		return this.value - o.value;
	}
	//ǰ�����
	public void PreOrder(){
		System.out.println(this);
		if(this.leftNode!=null)
			this.leftNode.PreOrder();
		if(this.rightNode!=null)
			this.rightNode.PreOrder();
	}

	
}
