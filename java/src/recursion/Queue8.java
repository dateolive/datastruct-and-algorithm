package recursion;

public class Queue8 {

	// ����max��ʾ���ٸ��ʺ�
	int max = 8;
	// arr���鱣��ʺ�λ��
	int[] arr = new int[max];
	// �߷�
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue8 queue =new Queue8();
		queue.Quenem(0);
		System.out.printf("�ⷨ��%d��\n",cnt);
		
	}

	// �Զ���һ������,����n���ʺ�
	public void Quenem(int n) {
		// ���ý���
		if (n == max) {
			print();
			return;
		}
		// ���η���ʺ�,����������ж�
		for (int i = 0; i < max; i++) {
			// �Ȱѵ�ǰ�Ļʺ�,�ŵ����еĵ�1��
			arr[n] = i;
			// �жϵ����õĵ�n���ʺ�i��ʱ,�Ƿ��ͻ
			if (judge(n)) { // �������ͻ
				// ������n+1���ʺ�,����ʼ�ݹ�
				Quenem(n + 1);
			}
			// �����ͻ,�ͼ���ִ�� array[n] = i; ������n���ʺ�,�����ڱ��еĻʺ�,���Ƶ�һ��λ��
		}
	}

	// �ж��Ƿ������ͻ
	public boolean judge(int n) {
		// 1.array[i] == array[n] ��ʾ�ж�:��n���ʺ��Ƿ��ǰ���n-1���ʺ���ͬһ��
		// 2.Math.abs(n-i) == Math.abs(array[n] - array[i])
		// ��ʾ�ж�:��n���ʺ��Ƿ�͵�i�ʺ��Ƿ���ͬһб��
		// n = 1 ���õ� 2�� 1 n = 1 array[1] = 1
		// Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
		// 3.��ʾ�ж�:�Ƿ���ͬһ��, û�б�Ҫ,n ÿ�ζ��ڵ���
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n]
					|| Math.abs(arr[n] - arr[i]) == Math.abs(n - i))
				return false;
		}
		return true;
	}

	// ����ʺ�ⷨ
	public void print() {
		cnt++;
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d\t", arr[i]);
		}
		System.out.println();
	}

}
