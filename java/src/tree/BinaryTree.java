package tree;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先创建一棵二叉树
		Binarytreedemo binaryTree = new Binarytreedemo();
		// 创建需要的节点
		Student root = new Student(1, "宋江");
		Student hero2 = new Student(2, "吴用");
		Student hero3 = new Student(3, "卢俊义");
		Student hero4 = new Student(4, "林冲");
		Student hero5 = new Student(5, "关胜");
		
		// 说明,先手动创建二叉树,再递归方式创建二叉树
		root.setLeft(hero2);
		root.setRight(hero3);
		hero3.setRight(hero4);
		hero3.setLeft(hero5);
		binaryTree.setRoot(root);

		/*// 测试
		System.out.println("前序遍历:"); // 1,2,3,5,4
		binaryTree.perOrder();

		// 测试2
		System.out.println("中序遍历:"); // 2,1,5,3,4
		binaryTree.infixOrder();

		// 测试3
		System.out.println("后序遍历:"); // 2,5,4,3,1
		binaryTree.postOrder();*/
		
		// 前序遍历查找
		// 前序遍历查找的次数 :4
		System.out.println("前序遍历查找方式:");
		Student node = binaryTree.perOrderFind(5);
		if (node != null) {
			System.out.printf("找到了,信息为 id = %d name = %s\n", node.getId(),
					node.getName());
		} else {
			System.out.printf("没有找到,相关信息的人物。\n");
		}

		// 中序遍历查找
		// 中序遍历查找次数 :3
		System.out.println("中序遍历查找方式:");
		Student node2 = binaryTree.infixOrderFind(5);
		if (node2 != null) {
			System.out.printf("找到了,信息为 id = %d name = %s\n", node2.getId(),
					node2.getName());
		} else {
			System.out.printf("没有找到,相关信息的人物。\n");
		}

		// 后序遍历查找
		// 后序遍历查找次数 :2
		System.out.println("中序遍历查找方式:");
		Student node3 = binaryTree.postOrderFind(5);
		if (node3 != null) {
			System.out.printf("找到了,信息为 id = %d name = %s\n", node3.getId(),
					node3.getName());
		} else {
			System.out.printf("没有找到,相关信息的人物。\n");
		}
		
		//测试删除
		System.out.println("删除前,前序遍历:");
		binaryTree.perOrder(); // 1,2,3,5,4
		binaryTree.delNode(5);
		// binaryTree.delNode(3);
		System.out.println("删除后，前序遍历:");
		binaryTree.perOrder(); // 1,2,3,4
	}

}
//创建一个二叉树
class Binarytreedemo{
	private Student root;
	
	public void setRoot(Student root) {
		this.root = root;
	}
	//前序遍历
	public void perOrder(){
		if(this.root!=null){
			this.root.perOrder();
		}else{
			System.out.println("二叉树为空,无法遍历");
		}
	}
	//中序遍历
	public void infixOrder(){
		if(this.root!=null){
			this.root.infixOrder();
		}else{
			System.out.println("二叉树为空,无法遍历");
		}
	}
	//后序遍历
	public void postOrder(){
		if(this.root!=null){
			this.root.postOrder();
		}else{
			System.out.println("二叉树为空,无法遍历");
		}
	}
	//前序遍历查找
	public Student perOrderFind(int id){
		if(root != null){
			return root.perOrderFind(id);
		}else{
			return null;
		}
	}
	//中序遍历查找
	public Student infixOrderFind(int id){
		if(root != null){
			return root.infixOrderFind(id);
		}else{
			return null;
		}
	}
	//后序遍历查找
	public Student postOrderFind(int id){
		if(root != null){
			return root.postOrderFind(id);
		}else{
			return null;
		}
	}
	//删除操作
	/*首先先处理
	考虑如果树是空树root，如果只有一个root结点，则等价将二叉树
	置空*/
	public void delNode(int id){
		if(root != null){
			//如果只有一个root结点，则等价将二叉树置空
			if(root.getId() == id){
				root = null;
			}else{
				//递归删除
				root.delNode(id);
			}
		}else{
			System.out.println("空树,不能删除");
		}
	}
	
}
//创建一个结点
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
分析二叉树的前序,中序,后序的遍历步骤：
1. 创建一颗二叉树
2. 前序遍历
    2.1 先输出当前节点(初始的时候是root节点)
    2.2 如果左子节点不为空,则递归继续前序遍历
    2.3 如果右子节点不为空,则递归继续前序遍历
3. 中序遍历
    3.1 如果当前节点的左子节点不为空,则递归中序遍历,
    3.2 输出当前节点
    3.3 如果当前节点的右子节点不为空,则递归中序遍历
4.后序遍历
    4.1 如果当前节点的左子节点不为空,则递归后序遍历,
    4.2 如果当前节点的右子节点不为空,则递归后序遍历
    4.3 输出当前节点        
	 * */
	// 编写前序遍历的方法
	public void perOrder(){
		//输出父节点
		System.out.println(this);
		//如果左子节点不为空,则递归继续前序遍历
		if(this.left!=null){
			this.left.perOrder();
		}
		//如果右子节点不为空,则递归继续前序遍历
		if(this.right!=null){
			this.right.perOrder();
		}
	}
	//编写中序遍历的方法
	public void infixOrder(){
		// 如果左子节点不为空,则递归继续前序遍历
		if (this.left != null) {
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		// 如果右子节点不为空,则递归继续前序遍历
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	//编写后序遍历的方法
	public void postOrder(){
		// 如果左子节点不为空,则递归继续前序遍历
		if (this.left != null) {
			this.left.postOrder();
		}
		// 如果右子节点不为空,则递归继续前序遍历
		if (this.right != null) {
			this.right.postOrder();
		}
		// 输出父节点
		System.out.println(this);
	}
/**
 使用前序，中序，后序的方式来查询指定的结点
>>前序查找思路
1.先判断当前结点的no是否等于要査找的
2如果是相等则返回当前结点
3如果不等，则判断当前结点的左子节点是否为空如果不为空则递归前
序查找
4如果左送归前序查找找到结点则返回否则维续判断当前的结点的右
子节点是否为空，如果不空则维续向右递归前序查找。
>>中序查找思路
1当前结点的左子节点是否为空，如果不为空，则递归中序查找
2如果找到，则返回如果没有找到，就和当前结点比较如果是则返回当前
结点，否则继续进行右递归的中序查找
3如果右递归中序查找找到就返回，否则返回nul
>>后序查找思路
1判断当前节点的左子节点是否为空如果不为空则递归后序查找
2如果找到就返回，如果没有找到，就判断当前结点的右子节点是否为空
如果不为空，则右递归进行后序查找如果找到就返回
3就和当前结点进行对比，如果是则返回否则返回nul
 */
	// 前序查找
	public Student perOrderFind(int id) {
		// 1.先判断当前结点的no是否等于要査找的
		if (this.id == id) {
			return this;
		}
		Student resnode = null;
		// 2.当前结点的左子节点是否为空如果不为空则递归前序查找
		if (this.left != null) {
			resnode = this.left.perOrderFind(id);
		}
		if (resnode != null) {
			// 找到了左子树
			return resnode;
		}
		// //3.否则继续判断,当前的结点的右子节点是否为空
		// 4.如果不空,则维续向右递归前序查找。
		if (this.right != null) {
			resnode = this.right.perOrderFind(id);
		}
		return resnode;
	}
	//中序查找
	public Student infixOrderFind(int id){
		//1当前结点的左子节点是否为空，如果不为空，则递归中序查找
		Student resNode=null;
		if(this.left!=null){
			resNode=this.left.infixOrderFind(id);
		}
		// 找到了左子树
		if(resNode!=null){
			return resNode;
		}
		//2如果找到，则返回,如果没有找到，就和当前结点比较如果是则返回当前
		//结点，否则继续进行右递归的中序查找
		if(this.id==id){
			return this;
		}
		//3如果右递归中序查找找到就返回，否则返回nul
		if(this.right!=null){
			resNode=this.right.infixOrderFind(id);
		}
		return resNode;
	}
	//后序查找
	public Student postOrderFind(int id){
		//1判断当前节点的左子节点是否为空如果不为空则递归后序查找
		Student resNode=null;
		if(this.left!=null){
			resNode=this.left.postOrderFind(id);
		}
		//2如果找到就返回，如果没有找到，就判断当前结点的右子节点是否为空
		if(resNode!=null){
			//找到了左子树
			return resNode;
		}
		//如果不为空，则右递归进行后序查找如果找到就返回
		if(this.right!=null){
			resNode=this.right.postOrderFind(id);
		}
		if(resNode!=null){
			//找到了右子树
			return resNode;
		}
		//3就和当前结点进行对比，如果是则返回否则返回nul
		if(this.id==id){
			return this;
		}
		return resNode;	
	}
	/**
完成删除结点的操作
规定
1.如果删除的节点是叶子节点，则删除该节点
2如果删除的节点是非叶子节点，则删除该子树
思路
首先先处理
考虑如果树是空树root，如果只有一个root结点，则等价将二叉树
置空
然后进行下面步骤
1.因为我们的二又树是单向的，所以我们是判断当前结点的子结点是
否需要删除结点，而不能去判断当前这个结点是不是需要删除结点
2.如果当前结点的左子结点不为空，并且左子结点就是要删除结点
就将 this. left=nu并且就返回（结束递归删除）
3如果当前结点的右子结点不为空，并且右子结点就是要删除结点，
就将 this right=nu并且就返回（结束递归删除）
4如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归
删除
5如果第4步也没有删除结点，则应当向右子树进行递归删除
	 * 
	 */
	//刪除
	//1.如果删除的节点是叶子节点,则删除该节点
	//2.如果删除的节点是非叶子节点,则删除该子树
	public void delNode(int id){
		//如果当前结点的左子结点不为空，并且左子结点就是要删除结点
		//就将 this. left=null并且就返回（结束递归删除）
		if(this.left!=null && this.left.id==id){
			this.left=null;
			return;
		}
		//如果当前结点的右子结点不为空，并且右子结点就是要删除结点，
		//就将 this right=null并且就返回（结束递归删除）
		if(this.right!=null&&this.right.id==id){
			this.right=null;
			return;
		}
		//如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
		if(this.left!=null){
			this.left.delNode(id);
		}
		//如果第4步也没有删除结点，则应当向右子树进行递归删除
		if(this.right!=null){
			this.right.delNode(id);
		}
	}
}
