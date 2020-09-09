package hashtable;

import java.util.Scanner;

public class HashTable {

	// 问题：有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,性别,年龄,名字,住址…),当输入该员工的id时,要求查找到该员工的所有信息。
	// 1)不使用数据库,,速度越快越好 => 哈希表(散列).
	// 2)添加时，保证按照id从低到高插入
	public static void main(String[] args) {
		// 创建哈希表
		Hashtab hashTab = new Hashtab(7);

		// 写一个简单的菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("雇员管理系统:");
			System.out.println("add : 添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("find: 查找雇员");
			System.out.println("del : 删除雇员");
			System.out.println("exit: 退出系统");

			key = scanner.next();
			switch (key) {
			case "add":
				System.out.print("输入id:");
				int id = scanner.nextInt();
				System.out.print("输入名字:");
				String name = scanner.next();
				// 创建雇员
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.print("请输入需要查找的id:");
				id = scanner.nextInt();
				hashTab.findId(id);
				break;
			case "del":
				System.out.print("请输入雇员的id:");
				id = scanner.nextInt();
				hashTab.del(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;

			}
		}
	}
}

// 编写一个哈希表
class Hashtab {
	private HashtableLinst[] HashtableLinstArr;
	private int size;// 表示有多少个链表

	public Hashtab(int size) {
		this.size = size;
		// 初始化链表数组
		HashtableLinstArr = new HashtableLinst[size];
		// 初始化每个链表
		for (int i = 0; i < size; i++) {
			HashtableLinstArr[i] = new HashtableLinst();
		}
	}

	// //编写一个散列函数,使用一个简单的取模法
	public int hashFun(int id) {
		return id % size;
	}

	// 1.添加
	public void add(Emp emp) {
		// 根据员工的id，插入
		int insertarrid = hashFun(emp.id);
		// 将emp添加到对应的链表中
		HashtableLinstArr[insertarrid].add(emp);
	}

	// 2.显示
	public void list() {
		for (int i = 0; i < size; i++) {
			HashtableLinstArr[i].list(i);
		}
	}

	// 3.查找
	public void findId(int id) {
		// 使用散列函数确定到哪条链表查找
		int findArrid = hashFun(id);
		Emp emp = HashtableLinstArr[findArrid].find(id);
		if (emp != null) {
			System.out.printf("在第%d条链表中找到,雇员 id = %d\n", (findArrid + 1), id);
		} else {
			System.out.println("在哈希表中,没有找到该雇员~");
		}
	}

	// 4.删除
	public void del(int id) {
		int delArrid = hashFun(id);
		HashtableLinstArr[delArrid].del(id);

	}

}

// 编写一个链表
class HashtableLinst {
	// 头指针，指向链表头部
	private Emp head;

	// 1.添加 直接添加在链表的最后即可,按照序号有序添加
	public void add(Emp emp) {
		// 如果头指针为空，则添加
		if (head == null) {
			head = emp;
			return;
		}
		// 如果head!=null 则定义一个辅助指针
		Emp cur = head;
		// 定义一个标志器
		boolean flag = true;
		while (true) {
			// 如果找到链表的最后
			if (cur.next == null) {
				break;
			}
			// 如果找到了，则break，添加
			if (cur.next.id > emp.id) {
				break;
			} else if (cur.id == emp.id) {
				// 如果已经存在了，则打印
				flag = false;
				break;
			}
			cur = cur.next;
		}
		if (flag) {
			emp.next = cur.next;
			cur.next = emp;
		} else {
			System.out.printf("编号%d已经存在了\n", emp.id);
		}
	}

	// 2.显示
	public void list(int nums) {
		if (head == null) {
			System.out.printf("第%d个链表为空\n", nums + 1);
			return;
		}
		System.out.println("第" + (nums + 1) + "个链表元素是");
		Emp cur = head;// 辅助指针
		while (true) {
			System.out.printf("=> id = %d name = %s\t", cur.id, cur.name);
			if (cur.next == null)
				break;
			cur = cur.next;

		}
		System.out.println();
	}

	// 3.查找
	public Emp find(int id) {
		if (head == null) {
			System.out.println("链表为空.");
			return null;
		}
		Emp cur = head;// 辅助指针
		while (true) {
			if (cur.id == id) {
				break;
			}
			if (cur.next == null) {
				break;
			}
			cur = cur.next;
		}
		return cur;
	}

	// 4.删除
	public void del(int id) {
		if (head == null) {
			System.out.println("没有这个员工！！！");
			return;
		}
		// 如果删除的是头节点
		if (head.id == id) {
			head = head.next;
			return;
		}
		Emp cur = head;
		while (cur.next != null) {
			if (cur.next.id == id) {
				cur.next = cur.next.next;
				System.out.println("Id为" + id + "的员工已经被删除~~");
				return;
			}
			cur = cur.next;
		}
		System.out.println("没有这个员工！！！");
	}
}

// 雇员类
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
