package hashtable;

import java.util.Scanner;

public class HashTable {

	// ���⣺��һ����˾,�����µ�Ա��������ʱ,Ҫ�󽫸�Ա������Ϣ����(id,�Ա�,����,����,סַ��),�������Ա����idʱ,Ҫ����ҵ���Ա����������Ϣ��
	// 1)��ʹ�����ݿ�,,�ٶ�Խ��Խ�� => ��ϣ��(ɢ��).
	// 2)���ʱ����֤����id�ӵ͵��߲���
	public static void main(String[] args) {
		// ������ϣ��
		Hashtab hashTab = new Hashtab(7);

		// дһ���򵥵Ĳ˵�
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("��Ա����ϵͳ:");
			System.out.println("add : ��ӹ�Ա");
			System.out.println("list: ��ʾ��Ա");
			System.out.println("find: ���ҹ�Ա");
			System.out.println("del : ɾ����Ա");
			System.out.println("exit: �˳�ϵͳ");

			key = scanner.next();
			switch (key) {
			case "add":
				System.out.print("����id:");
				int id = scanner.nextInt();
				System.out.print("��������:");
				String name = scanner.next();
				// ������Ա
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.print("��������Ҫ���ҵ�id:");
				id = scanner.nextInt();
				hashTab.findId(id);
				break;
			case "del":
				System.out.print("�������Ա��id:");
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

// ��дһ����ϣ��
class Hashtab {
	private HashtableLinst[] HashtableLinstArr;
	private int size;// ��ʾ�ж��ٸ�����

	public Hashtab(int size) {
		this.size = size;
		// ��ʼ����������
		HashtableLinstArr = new HashtableLinst[size];
		// ��ʼ��ÿ������
		for (int i = 0; i < size; i++) {
			HashtableLinstArr[i] = new HashtableLinst();
		}
	}

	// //��дһ��ɢ�к���,ʹ��һ���򵥵�ȡģ��
	public int hashFun(int id) {
		return id % size;
	}

	// 1.���
	public void add(Emp emp) {
		// ����Ա����id������
		int insertarrid = hashFun(emp.id);
		// ��emp��ӵ���Ӧ��������
		HashtableLinstArr[insertarrid].add(emp);
	}

	// 2.��ʾ
	public void list() {
		for (int i = 0; i < size; i++) {
			HashtableLinstArr[i].list(i);
		}
	}

	// 3.����
	public void findId(int id) {
		// ʹ��ɢ�к���ȷ���������������
		int findArrid = hashFun(id);
		Emp emp = HashtableLinstArr[findArrid].find(id);
		if (emp != null) {
			System.out.printf("�ڵ�%d���������ҵ�,��Ա id = %d\n", (findArrid + 1), id);
		} else {
			System.out.println("�ڹ�ϣ����,û���ҵ��ù�Ա~");
		}
	}

	// 4.ɾ��
	public void del(int id) {
		int delArrid = hashFun(id);
		HashtableLinstArr[delArrid].del(id);

	}

}

// ��дһ������
class HashtableLinst {
	// ͷָ�룬ָ������ͷ��
	private Emp head;

	// 1.��� ֱ��������������󼴿�,��������������
	public void add(Emp emp) {
		// ���ͷָ��Ϊ�գ������
		if (head == null) {
			head = emp;
			return;
		}
		// ���head!=null ����һ������ָ��
		Emp cur = head;
		// ����һ����־��
		boolean flag = true;
		while (true) {
			// ����ҵ���������
			if (cur.next == null) {
				break;
			}
			// ����ҵ��ˣ���break�����
			if (cur.next.id > emp.id) {
				break;
			} else if (cur.id == emp.id) {
				// ����Ѿ������ˣ����ӡ
				flag = false;
				break;
			}
			cur = cur.next;
		}
		if (flag) {
			emp.next = cur.next;
			cur.next = emp;
		} else {
			System.out.printf("���%d�Ѿ�������\n", emp.id);
		}
	}

	// 2.��ʾ
	public void list(int nums) {
		if (head == null) {
			System.out.printf("��%d������Ϊ��\n", nums + 1);
			return;
		}
		System.out.println("��" + (nums + 1) + "������Ԫ����");
		Emp cur = head;// ����ָ��
		while (true) {
			System.out.printf("=> id = %d name = %s\t", cur.id, cur.name);
			if (cur.next == null)
				break;
			cur = cur.next;

		}
		System.out.println();
	}

	// 3.����
	public Emp find(int id) {
		if (head == null) {
			System.out.println("����Ϊ��.");
			return null;
		}
		Emp cur = head;// ����ָ��
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

	// 4.ɾ��
	public void del(int id) {
		if (head == null) {
			System.out.println("û�����Ա��������");
			return;
		}
		// ���ɾ������ͷ�ڵ�
		if (head.id == id) {
			head = head.next;
			return;
		}
		Emp cur = head;
		while (cur.next != null) {
			if (cur.next.id == id) {
				cur.next = cur.next.next;
				System.out.println("IdΪ" + id + "��Ա���Ѿ���ɾ��~~");
				return;
			}
			cur = cur.next;
		}
		System.out.println("û�����Ա��������");
	}
}

// ��Ա��
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
