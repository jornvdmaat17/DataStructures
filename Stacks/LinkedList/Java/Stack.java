class Stack{

  private Element head;
  private int size;

  public Stack(){
    this.head = null;
    this.size = 0;
  }

  public void push(int data){
    Element newE;
    if(head == null){
      newE = new Element(data, null);
    }else{
      newE = new Element(data, head);
    }
    head = newE;
    this.size++;
  }

  public int pop(){
      if(head == null){
        return -1;
      }
      int ret = this.head.data;
      this.head = this.head.prev;
      this.size--;
      return ret;
  }

  public int returnSize(){
    return this.size;
  }

  public boolean isEmpty(){
    return this.size == 0;
  }
}

class Element{

  int data;
  Element prev;

  public Element(int data, Element prev){
    this.data = data;
    this.prev = prev;
  }

}
