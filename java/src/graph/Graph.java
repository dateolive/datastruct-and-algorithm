package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	
	public ArrayList<String> vertexList;
	public int[][] str;//存储图的邻接矩阵
	public int numofEdges;//边的个数
	public static void main(String[] args) {
		int n=5;
		String Ver[]={ "A", "B", "C", "D", "E" };
		Graph graph=new Graph(n);
		for(String ver:Ver){
			graph.insertVertex(ver);
		}
		graph.insertEdges(0, 1, 1); // A-B
		graph.insertEdges(0, 2, 1); // A-C
		graph.insertEdges(1, 2, 1); // B-C
		graph.insertEdges(1, 3, 1); // B-D
		graph.insertEdges(1, 4, 1); // B-E 
		
		//显示邻接矩阵
		graph.showGraph();

	}
	/**
	 * 构造器
	 * @param n
	 */
	public Graph(int n){
		str=new int[n][n];
		vertexList=new ArrayList<String>(n);
		numofEdges=0;
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
}
