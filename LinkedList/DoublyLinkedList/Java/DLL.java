class DLL{

    private class Node{

        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DLL(){
        head = tail = null;
        size = 0;
    }

    public void insertFirst(int value){
        Node newNode = new Node(value, null, head);
        if(head == null){
            tail = newNode;
        }else{
            head.prev = newNode;
        }        
        head = newNode;        
        size++;
    }

    public void insertLast(int value){  
        Node newNode = new Node(value, tail, null);
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void insertAtPos(int value, int pos){
        if(pos <= 1){
            insertFirst(value);
            return;
        }
        if(pos >= size){
            insertLast(value);
            return;
        }
        Node current = head;
        for(int i = 2; i < pos; i++){
            current = current.next;
        }
        Node tmp = current.next;
        Node newNode = new Node(value, current, tmp);
        current.next = newNode;
        tmp.prev = newNode;        
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void removeFirst(){
        if(head != null){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            size--;
        }        
    }

    public void removeLast(){
        if(tail != null){
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            size--;
        }       
    }

    public void removeAtPos(int pos){
        if(pos <= 1){
            removeFirst();
            return;
        }
        if(pos >= size){
            removeLast();
            return;
        }
        Node current = head.next;
        for(int i = 2; i < pos; i++){
            current = current.next;
        }
        Node p = current.prev;
        Node n = current.next;
        p.next = n;
        n.prev = p;     
        size--;
    }

    public void printListFromHead(){
        Node current = head;
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void bigPrint(){
        Node current = head;
        while(current != null){
            if(current.prev != null){
                System.out.println("Prev: " + current.prev.value);
            }            
            System.out.println("Value: " + current.value);
            if(current.next != null){
                System.out.println("Next: " + current.next.value);
            }  
            System.out.println();
            current = current.next;
        }
    }
}
