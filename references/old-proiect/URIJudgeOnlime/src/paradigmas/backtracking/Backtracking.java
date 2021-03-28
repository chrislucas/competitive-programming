package paradigmas.backtracking;

public class Backtracking {
	
	public static <T> void print(T[] set, int [] indices, int limit) {
		for(int i=0; i<limit; i++) {
			System.out.printf("%s ", set[indices[i]].toString());
		}
		System.out.println("");
	}
	
	public static <T> void subset(T [] set, int [] indices, int s, int e, int acc) {
		for(int i=s; i<e; i++) {
			indices[acc++] = i;
			print(set, indices, acc);
			if(i < e)
				subset(set, indices, i+1, e, acc);
			acc-=1;
		}
	}
	
	public static <T> void generateSet(T[] set, int[] indices) {
		int s = set.length,  limit = 1<<s;
		for(int i=0; i<limit; i++) {
			int acc = 0;
			for(int j=0; j<s; j++) {
				if((i & 1 << j ) > 0) {
					indices[acc++] = j;
				}
			}
			print(set, indices, acc);
		}
	}

	public static void main(String[] args) {
		//Integer [] set = {3,7,4};
		Character [] set = {'a', 'b', 'c', 'd'};
		int[] indices = new int[set.length];
		subset(set, indices, 0, set.length, 0);
		generateSet(set, indices);

	}

}
