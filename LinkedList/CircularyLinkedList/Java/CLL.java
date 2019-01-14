class CLL{

    private class Node{

        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        head = tail = null;
        size = 0;
    }

    public void insertFirst(int value){        
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }else{
            Node temp = head;
            newNode.next = temp;
            head = newNode;
            tail.next = head;
        }
        size++;      
    }

    public void insertLast(int value){
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
        size++;      
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

    public static void main(String[] args) {
        CLL l = new CLL();
        l.insertFirst(1);
        l.insertFirst(0);
        l.insertLast(2);
        l.printList();
    }

}