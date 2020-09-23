package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	
	public ArrayList<String> vertexList;
	public int[][] str;//�洢ͼ���ڽӾ���
	public int numofEdges;//�ߵĸ���
	public boolean[] isVisited;//��¼�Ƿ񱻷��ʹ�
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
		
		//��ʾ�ڽӾ���

		graph.showGraph();
		System.out.println("dfs����");
		graph.dfs();//������ȱ���˳��Ϊ 1->2->4->8->5->3->6->7
		System.out.println("\nbfs����");
		graph.bfs();//��������㷨�ı���˳��Ϊ��1->2->3->4->5->6->7->8 
	}
	/**
	 * ������
	 * @param n
	 */
	public Graph(int n){
		str=new int[n][n];
		vertexList=new ArrayList<String>(n);
		numofEdges=0;
		isVisited=new boolean[n];
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
	//�õ���һ���ڽӽ����±� w
	/**
	 * 
	 * @param index  
	 * @return ������ھͷ��ض�Ӧ���±꣬���򷵻�-1
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
	//����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
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
������ȱ����㷨����:
1.���ʳ�ʼ���v������ǽ��vΪ�ѷ��ʡ�
2.���ҽ��v�ĵ�һ���ڽӽ��w��
3.��w���ڣ������ִ��4�����w�����ڣ���ص���1��������v����һ����������
4.��wδ�����ʣ���w����������ȱ����ݹ飨����w������һ��v��Ȼ����в���123����
5.���ҽ��v��w�ڽӽ�����һ���ڽӽ�㣬ת������3��
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
	 * ��dfs��������
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
	 ������ȱ����㷨����:
1.���ʳ�ʼ���v����ǽ��vΪ�ѷ��ʡ�
2.���v�����
3.�����зǿ�ʱ������ִ�У������㷨������
4.�����У�ȡ�ö�ͷ���u��
5.���ҽ��u�ĵ�һ���ڽӽ��w��
6.�����u���ڽӽ��w�����ڣ���ת������3������ѭ��ִ�������������裺
	6.1 �����w��δ�����ʣ�����ʽ��w�����Ϊ�ѷ��ʡ� 
	6.2 ���w����� 
	6.3 ���ҽ��u�ļ�w�ڽӽ������һ���ڽӽ��w��ת������6��

	 */
	public void bfs(boolean[] isV,int i){
		int u;//��ʾ����ͷ�ڵ���±�
		int w;//�ڽӽڵ�
		//����
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
				// ��uΪǰ����,��w�������һ���ڽ��
				w=getNextNeigh(u, w);
			}
		}
	}
	//��BFS��������,�������еĽ��,������BFS
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
