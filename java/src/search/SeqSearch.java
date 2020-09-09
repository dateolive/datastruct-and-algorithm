package search;

public class SeqSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 9, 11, -1, 34, 89 };
		System.out.println(seqSearch(arr, 11));
		
		
			
	}
	public static boolean seqSearch(int[] arr,int value)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==value)
				return true;
			
		}
		return false;
	}

}
