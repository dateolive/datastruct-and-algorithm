package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	
	public ArrayList<String> vertexList;
	public int[][] str;//存储图的邻接矩阵
	public int numofEdges;//边的个数
	public boolean[] isVisited;//记录是否被访问过
	public static void main(String[] args) {
		int n=8;
		String Ver[]={ "1", "2", "3", "4", "5", "6", "7", "8"};
		Graph graph=new Graph(n);
		for(String ver:Ver){
			graph.insertVertex(ver);
		}
		graph.insertEdges(0, 1, 1);
		graph.insertEdges(0, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);
		graph.insertEdges(3, 7, 1);
		graph.insertEdges(4, 7, 1);
		graph.insertEdges(2, 5, 1);
		graph.insertEdges(2, 6, 1);
		graph.insertEdges(5, 6, 1);
		
		//显示邻接矩阵

		graph.showGraph();
		System.out.println("dfs搜索");
		graph.dfs();//深度优先遍历顺序为 1->2->4->8->5->3->6->7
		System.out.println("\nbfs搜索");
		graph.bfs();//广度优先算法的遍历顺序为：1->2->3->4->5->6->7->8 
	}
	/**
	 * 构造器
	 * @param n
	 */
	public Graph(int n){
		str=new int[n][n];
		vertexList=new ArrayList<String>(n);
		numofEdges=0;
		isVisited=new boolean[n];
	}
	/**
	 * 插入节点
	 * @param value
	 */
	public void insertVertex(String value){
		vertexList.add(value);
	}
	/**
	 * 添加边
	 * @param v1 
	 * @param v2
	 * @param weight
	 */
	public void insertEdges(int v1,int v2,int weight){
		str[v1][v2]=weight;
		str[v2][v1]=weight;
		numofEdges++;
	}
	/**
	 * 图常用的方法
	 */
	/**
	 * 返回节点个数
	 * @return
	 */
	public int getNumber(){
		return vertexList.size();
	}
	/**
	 * 返回边的个数
	 * @return
	 */
	public int getEdgesNum(){
		return numofEdges;
	}
	/**
	 * 返回结点i(下标)对应的值
	 * @param i
	 * @return
	 */
	public String getIndexValue(int i){
		return vertexList.get(i);
	}
	/**
	 * 返回v1和v2的权值
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1,int v2){
		return str[v1][v2];
	}
	/**
	 * 显示图
	 */
	public void showGraph(){
		for(int[] link:str){
			System.out.println(Arrays.toString(link));
		}
	}
	//得到第一个邻接结点的下标 w
	/**
	 * 
	 * @param index  
	 * @return 如果存在就返回对应的下标，否则返回-1
	 */
	public int getFirstNeigh(int index){
		for(int i=0;i<vertexList.size();i++)
		{
			if(str[index][i]>0){
				return i;
			}
		}
		return -1;
		
	}
	//根据前一个邻接结点的下标来获取下一个邻接结点
	/**
	 * 
	 * @param v1  
	 * @param v2
	 * @return
	 */
	public int getNextNeigh(int v1,int v2){
		for(int i=v2+1;i<vertexList.size();i++)
		{
			if(str[v1][i]>0){
				return i;
			}
		}
		return -1;
	}
	/**
深度优先遍历算法步骤:
1.访问初始结点v，并标记结点v为已访问。
2.查找结点v的第一个邻接结点w。
3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
	 * @param isV
	 * @param i
	 */
	public void dfs(boolean[] isV,int i ){
		System.out.print(getIndexValue(i)+"=>");
		isV[i]=true;
		int w=getFirstNeigh(i);
		while(w!=-1){
			if(!isV[w]){
				dfs(isV,w);
			}
			w=getNextNeigh(i, w);
		}
	}
	/**
	 * 对dfs继续重载
	 */
	public void dfs(){
		isVisited=new boolean[vertexList.size()];
		for(int i=0;i<getNumber();i++)
		{
			if(!isVisited[i]){
				dfs(isVisited,i);
			}
		}
	}
	
	/**
	 广度优先遍历算法步骤:
1.访问初始结点v并标记结点v为已访问。
2.结点v入队列
3.当队列非空时，继续执行，否则算法结束。
4.出队列，取得队头结点u。
5.查找结点u的第一个邻接结点w。
6.若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
	6.1 若结点w尚未被访问，则访问结点w并标记为已访问。 
	6.2 结点w入队列 
	6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。

	 */
	public void bfs(boolean[] isV,int i){
		int u;//表示队列头节点的下标
		int w;//邻接节点
		//队列
		LinkedList<Integer> queue=new LinkedList<Integer>();
		System.out.print(getIndexValue(i)+"=>");
		isV[i]=true;
		queue.addLast(i);
		while(!queue.isEmpty()){
			u=(Integer)queue.removeFirst();
			w=getFirstNeigh(u);
			while(w!=-1){
				if(!isV[w]){
					System.out.print(getIndexValue(w)+"=>");
					isV[w]=true;
					queue.addLast(w);
				}
				// 以u为前驱点,找w后面的下一个邻结点
				w=getNextNeigh(u, w);
			}
		}
	}
	//对BFS进行重载,遍历所有的结点,并进行BFS
	public void bfs(){
		isVisited=new boolean[vertexList.size()];
		for(int i=0;i<vertexList.size();i++)
		{
			if(!isVisited[i])
			{
				bfs(isVisited,i);
			}
		}
	}
}
