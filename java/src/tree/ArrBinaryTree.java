package tree;

public class ArrBinaryTree {
	//˳��洢������
	/**
	 * Ҫ��:
		1.��ͼ�Ķ������Ľ�㣬Ҫ��������ķ�ʽ����� arr : [1, 2, 3, 4, 5, 6, 6]
		2.Ҫ���ڱ������� arrʱ����Ȼ������ǰ���������������ͺ�������ķ�ʽ��ɽ��ı���
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr={1, 2, 3, 4, 5, 6, 7 };
		ArraryBinaryTree Btree=new ArraryBinaryTree(arr);
		System.out.println("ǰ�����");
		Btree.preOrder();
		System.out.println("�������");
		Btree.infixOrder();
		System.out.println("�������");
		Btree.postOrder();
	}
	
}
/**
 *  1.˳�������ͨ��ֻ������ȫ������
	2.��n��Ԫ�ص����ӽڵ�Ϊ  2 * n + 1 
	3.��n��Ԫ�ص����ӽڵ�Ϊ  2 * n + 2
	4.��n��Ԫ�صĸ��ڵ�Ϊ  (n-1) / 2
	5.n : ��ʾ�������еĵڼ���Ԫ��(��0��ʼ���)
 */
//ʵ��˳��洢����������
class ArraryBinaryTree{
	private int[] arr;
	public ArraryBinaryTree(int[] arr){
		super();
		this.arr=arr;
	}
	//���ط���
	public void preOrder(){
		this.preOrder(0);
	}
	public void infixOrder(){
		this.infixOrder(0);
	}
	public void postOrder(){
		this.postOrder(0);
	}
	/**
	 * ʵ��˳��洢��������ǰ�����
	 * @param index  �����±�
	 */

	public void preOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("����Ϊ��,�޷��������ҡ�");
		}
		System.out.println(arr[index]);
		//����ݹ����
		if((index*2+1)<arr.length){
			preOrder(index*2+1);
		}
		//���ҵݹ����
		if((index*2+2)<arr.length){
			preOrder(index*2+2);
		}
	}
	/**
	 * ʵ��˳��洢���������������
	 * @param index �����±�
	 */
	public void infixOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("����Ϊ��,�޷��������ҡ�");
		}
		if((2*index+1)<arr.length){
			infixOrder(index*2+1);
		}
		System.out.println(arr[index]);
		if((2*index+2)<arr.length){
			infixOrder(index*2+2);
		}
		
	}
	/**
	 * ʵ��˳��洢�������ĺ������
	 * @param index �����±�
	 */
	public void postOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("����Ϊ��,�޷��������ҡ�");
		}
		if((index*2+1)<arr.length){
			postOrder(index*2+1);
		}
		if((index*2+2)<arr.length){
			postOrder(index*2+2);
		}
		System.out.println(arr[index]);
	}
	
}
