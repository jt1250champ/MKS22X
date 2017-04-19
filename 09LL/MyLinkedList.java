import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    private class LNode {
	
        private int element;
        private LNode next, prev;

        public LNode(int ele){
            this.element = ele;
        }
	
	public String toString() {
	    return value + "";
	}
	
    }

    public class MyLinkedListIterator implements Iterator<Integer> {
	
	private MyLinkedList bob;
	private LNode current;

	public MyLinkedListIterator(MyLinkedList george) {
	    current = george.head;
	    this.bob = george;
	}

	public boolean hasNext() {
	    return bob.next != null;
	}

	public Integer next() {
	    if(hasNext()) {
		int val - current.value;
		current = current.next;
		return val;
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }
    
    public Iterator<Integer> iterator() {
	return new MyLinkedListIterator(this);
    }

    LNode head = null, tail = null;
    int size = 0;

    public MyLinkedList(){
    }

    public int size() {
	return size;
    }
    
    private LNode getNthNode(int n) {
        if(n < 0 || n >= size) {
	    throw new IndexOutOfBoundsException();
	}
	if(n > size/2) {
	    LNode current = tail;
	    for(int i = size; i > n + 1; i--){
		current = current.prev;
	    }
	}else{
	    LNode current = start;
	    for(int i = n; i > 0; i--) {
		current = current.next;
	    }
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded) {
	if(size == 0) {
	    head = toBeAdded;
	    tail = toBeAdded;
	}else if(location == tail) {
	    tail = toBeAdded;
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	    toBeAdded.next = null;
	}else if(location == head) {
	    head = toBeAdded;
	    location.prev = toBeAdded;
	    toBeAdded.next = location;
	    toBeAdded.prev = null;
	}else{
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
	size++;
    }

    private void remove(LNode target) {
	if(size == 1) {
	    head = null;
	    tail = null;
	}else if(target == head) {
	    head.next.prev = null;
	    head = head.next;
	}else if(target == tail) {
	    tail.prev.next = null;
	    tail = tail.prev;
	}else {
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }

    public String toString() {
        String s = "[";
        LNode current = head;
        for (int i = 0; i < size; i++) {
            s = s + current.element + ", ";
            current = current.next;
        }
	
        if (size == 0) {
	    return s + "]";
	}
	
        return s.substring(0, s.length() - 2) + "]";
    }


    public int size() {
        return size;
    }

    public int get(int index) {
        return getNthNode(index).value;
    }

    public void set(int index, int value) {
	int old = getNthNode(index).value;
        getNthNode(index).value = value;
	return old;
    }

    public int indexOf(int value) {
        int counter = 0;
        LNode current = start;
        while (current.element != value) {
            if (current.next == null) {
		return -1;
	    }
            current = current.next;
            counter++;
        }
        return counter;
    }

    public boolean add(int value) {
        add(size -1, value);
	return true;
    }

    public void add(int index, int value) {
        if(index >= size) {
	    throw new IndexOutOfBoundsException();
	}

        int counter = 0;
        LNode current = start;
        while(counter < index) {
            current = current.next;
            counter++;
        }

        current = new LNode(value, current);
        counter = 0;
        LNode currentN = start;
	while(counter < (index - 1)) {
            currentN = currentN.next;
            counter++;
        }
        currentN.next = current;
        size++;
    }

    public int remove(int index) {
        if(index >= size) {
	    throw new IndexOutOfBoundsException();
	}

        int counter = 0;
        LNode current = start;
        while (counter < index - 1) {
            current = current.next;
            counter++;
        }

        LNode now = current.next.next;
        current.next = now;
        size--;
        return index;
    }

    public int get(int index) {
	LNode n = getNthNode(index);
	return n.value;
    }

    public int set(int index, int value) {
	LNode n = getNthNode(index);
	int temp = n.value;
	n.value = value;
	return temp;
    }

    public int indexOf(int value) {
	int index = 0;
	LNode current = start;
	if(index == size) {
	    return -1;
	}
	while(current.value != value) {
	    index++;
	    current = current.next;
	}
	return index;
    }
    
    public static void main(String[] args) {
	MyLinkedList a = new MyLinkedList();
	a.add(3);
	a.add(4);
	a.add(5);
	System.out.println(a);
	a.remove(2);
	System.out.println(a);
	a.add(1,8);
	System.out.println(a);
	System.out.println(a.get(2));
	a.set(2, 99);
	System.out.println(a);
    }

}