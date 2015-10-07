import java.lang.reflect.Array;


public class StackArray<T> {

	@SuppressWarnings("unused")
	private T [] stack;
	private int size;
	
	@SuppressWarnings("unchecked")
	public StackArray(Class<T> clazz, int size) {
		final T[] t = (T[]) Array.newInstance(clazz, size);
		this.size = size;
		this.stack = t;
	}
	
	@SuppressWarnings("unchecked")
	public StackArray(Class<T> clazz) {
		final T[] t = (T[]) Array.newInstance(clazz, 1);
		this.size = 1;
		this.stack = t;
	}
	
	public void add(T t) {
		if(stack != null) {
			
		}
	}
	
	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}
	
	public T peek() {
		return stack[--this.size];
	}
	
	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray<Integer>(Integer.class);
	}

}
