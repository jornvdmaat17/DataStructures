class SSL{

    private class Node{
        
        int value;
        Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;        
        }
    }

    Node head;

    public SSL(){
        head = null;
    }

    public void insert(int value){        
        Node newNode = new Node(value, head);
        head = newNode;        
    }

    public void remove(){
        head = head.next;
    }

    public boolean contains(int value){
        Node current = head;
        while(current != null){
            if(current.value == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }
}