class Stack<T>{

  private Element head;
  private int size;

  public Stack(){
    this.head = null;
    this.size = 0;
  }

  public void push(T data){
    Element newE;
    if(head == null){
      newE = new Element(data, null);
    }else{
      newE = new Element(data, head);
    }
    head = newE;
    this.size++;
  }

  public T pop(){
      if(head == null){
        return null;
      }
      T ret = this.head.data;
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


  private class Element{

    T data;
    Element prev;

    public Element(T data, Element prev){
      this.data = data;
      this.prev = prev;
    }
  }
}
