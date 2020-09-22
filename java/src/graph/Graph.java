package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	
	public ArrayList<String> vertexList;
	public int[][] str;//�洢ͼ���ڽӾ���
	public int numofEdges;//�ߵĸ���
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
		
		//��ʾ�ڽӾ���
		graph.showGraph();

	}
	/**
	 * ������
	 * @param n
	 */
	public Graph(int n){
		str=new int[n][n];
		vertexList=new ArrayList<String>(n);
		numofEdges=0;
	}
	/**
	 * ����ڵ�
	 * @param value
	 */
	public void insertVertex(String value){
		vertexList.add(value);
	}
	/**
	 * ��ӱ�
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
	 * ͼ���õķ���
	 */
	/**
	 * ���ؽڵ����
	 * @return
	 */
	public int getNumber(){
		return vertexList.size();
	}
	/**
	 * ���رߵĸ���
	 * @return
	 */
	public int getEdgesNum(){
		return numofEdges;
	}
	/**
	 * ���ؽ��i(�±�)��Ӧ��ֵ
	 * @param i
	 * @return
	 */
	public String getIndexValue(int i){
		return vertexList.get(i);
	}
	/**
	 * ����v1��v2��Ȩֵ
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1,int v2){
		return str[v1][v2];
	}
	/**
	 * ��ʾͼ
	 */
	public void showGraph(){
		for(int[] link:str){
			System.out.println(Arrays.toString(link));
		}
	}
}
