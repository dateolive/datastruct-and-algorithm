package recursion;

public class Queue8 {

	// 定义max表示多少个皇后
	int max = 8;
	// arr数组保存皇后位置
	int[] arr = new int[max];
	// 走法
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue8 queue =new Queue8();
		queue.Quenem(0);
		System.out.printf("解法有%d种\n",cnt);
		
	}

	// 自定义一个方法,放置n个皇后
	public void Quenem(int n) {
		// 放置结束
		if (n == max) {
			print();
			return;
		}
		// 依次放入皇后,并进行相关判断
		for (int i = 0; i < max; i++) {
			// 先把当前的皇后,放到该行的第1列
			arr[n] = i;
			// 判断当放置的第n个皇后到i列时,是否冲突
			if (judge(n)) { // 如果不冲突
				// 继续放n+1个皇后,即开始递归
				Quenem(n + 1);
			}
			// 如果冲突,就继续执行 array[n] = i; 即将第n个皇后,放置在本行的皇后,后移的一个位置
		}
	}

	// 判断是否产生冲突
	public boolean judge(int n) {
		// 1.array[i] == array[n] 表示判断:第n个皇后是否和前面的n-1个皇后在同一列
		// 2.Math.abs(n-i) == Math.abs(array[n] - array[i])
		// 表示判断:第n个皇后是否和第i皇后是否在同一斜线
		// n = 1 放置第 2列 1 n = 1 array[1] = 1
		// Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
		// 3.表示判断:是否在同一行, 没有必要,n 每次都在递增
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n]
					|| Math.abs(arr[n] - arr[i]) == Math.abs(n - i))
				return false;
		}
		return true;
	}

	// 输出皇后解法
	public void print() {
		cnt++;
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d\t", arr[i]);
		}
		System.out.println();
	}

}
