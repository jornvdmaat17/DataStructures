class Queue{

  Node head;
  Node tail;

  public Queue(){
    this.head = null;
    this.tail = null;
  }

  public void enqueue(int data){
    Node newN = new Node(data, null);
    if(head == null){
      head = tail = newN;
    }else{
      tail.next = newN;
      tail = newN;
    }
  }

  public int dequeue(){
    Node ret = head;
    if(head == null){
      tail = null;
      return -1;
    }
    head = head.next;
    return ret.data;
  }
}

class Node{

  int data;
  Node next;

  public Node(int data, Node next){
    this.data = data;
    this.next = next;
  }
}
