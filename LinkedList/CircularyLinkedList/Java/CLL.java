class CLL<T>{

    private class Node{

        T value;
        Node next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        head = tail = null;
        size = 0;
    }

    public void insertFirst(T value){        
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;      
    }

    public void insertLast(T value){
        if(head == null){
            insertFirst(value);
        }else{
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            size++;
        }
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        tail.next = head;
        size--; 
    }

    public void printList(){
        Node current = head;
        while(true){
            System.out.print(current.value + " ");
            current = current.next;
            if(current == head){
                break;
            }
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }   
}
