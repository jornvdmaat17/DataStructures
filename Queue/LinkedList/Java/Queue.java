class Queue<T>{

  Node head;
  Node tail;

  public Queue(){
    this.head = null;
    this.tail = null;
  }

  public void enqueue(T data){
    Node newN = new Node(data, null);
    if(head == null){
      head = tail = newN;
    }else{
      tail.next = newN;
      tail = newN;
    }
  }

  public T dequeue(){
    Node ret = head;
    if(head == null){
      tail = null;
      return null;
    }
    head = head.next;
    return ret.data;
  }

  private class Node{

    T data;
    Node next;

    public Node(T data, Node next){
      this.data = data;
      this.next = next;
    }
  }
}
