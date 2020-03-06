package SLL;

public class SinglyLinkedList {
	    public Node head;
	    public SinglyLinkedList() {
	    	this.head = null;
	    }
	    //Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar nodos a la lista.
	    public void add(int value) {
	        Node newNode = new Node(value);
	        if(head == null) {
	            head = newNode;
	        } else {
	            Node runner = head;
	            while(runner.next != null) {
	                runner = runner.next;
	            }
	            runner.next = newNode;
	        }
	   }    
	   public SinglyLinkedList remove() {
	        Node pointer = this.head;
	        while(pointer.next.next != null) {
	            pointer = pointer.next;
	        }
	        pointer.next = null;
	        return this;
	   }
	   public void printValues() {
	        Node pointer = this.head;
	        if(pointer == null) {
	            System.out.println(pointer);
	        } else {
	            while(pointer != null) {
	                System.out.println(pointer.value);
	                pointer = pointer.next;
	            }
	        }
	   }
	   public Node find(int value) {
	        Node pointer = this.head;
	        while(pointer.value != value){
	            pointer = pointer.next;
	        }
	        return pointer;
	   }
	   public SinglyLinkedList removeAt(int index) {
	        Node pointer = this.head;
	        if(pointer == null) {
	            return this;
	        }
	        if(index == 0){
	            this.head = pointer.next;
	            return this;
	        }
	        for(int i=0; i<index-1; i++){
	            pointer = pointer.next;
	        }
	        pointer.next = pointer.next.next;
	        return this;
	    }
}
