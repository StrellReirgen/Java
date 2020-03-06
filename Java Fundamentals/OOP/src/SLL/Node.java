package SLL;

public class Node {
	public int value;
    public Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }
	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}
    
    
}
