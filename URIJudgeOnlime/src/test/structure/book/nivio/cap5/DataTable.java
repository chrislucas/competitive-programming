package test.structure.book.nivio.cap5;

public class DataTable {
	
	private Item data[];
	private int countE;
	
	public interface Item {
		public int compare(Item item);
		public void alterKey(Object key);
		public Object getKey();
	}
	
	public DataTable(int dataSize) {
		data = new Item[dataSize + 1];
		countE = 0;
	}
	
	
	public int search(Item item) {
		// isso eh feito para garantir que o metodo termine
		this.data[0] = item;
		// implementacao do livro de estrutura de dados do Nivio Ziviani
		int i = countE;
		while(data[i].compare(item) != 0)
			i--;
		return i;
	}
	
	public void insert(Item item) throws Exception {
		if(countE == (data.length - 1))
			throw new Exception("Exception Insert");
		data[++countE] = item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Data implements Item {
		@Override
		public int compare(Item item) {
			return 0;
		}

		@Override
		public void alterKey(Object key) {
			
		}

		@Override
		public Object getKey() {
			return null;
		}
	}

}
