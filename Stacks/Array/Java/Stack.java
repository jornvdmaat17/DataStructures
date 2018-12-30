class Stack{

  private int size;
  private int capacity;
  private int[] stack;

  public Stack(){
    size = 0;
    capacity = 1;
    stack = new int[capacity];
  }

  public void push(int data){
    if(this.size == this.capacity / 2){
      this.capacity*=4;
      int[] nS = new int[this.capacity];
      System.arraycopy(this.stack, 0, nS, 0, this.stack.length);
      this.stack = nS;
    }
    this.stack[this.size] = data;
    this.size++;
  }

  public int pop(){
    int ret = this.stack[this.size - 1];
    size--;
    if(this.size < this.capacity / 4){
      this.capacity/=2;
      int[] nS = new int[this.capacity];
      System.arraycopy(this.stack, 0, nS, 0, this.stack.length);
      this.stack = nS;
    }
    return ret;
  }

  public int returnSize(){
    return this.size;
  }

  public int returnCapacity(){
    return this.capacity;
  }

  public boolean isEmpty(){
    return this.size == 0;
  }

  public static void main(String args[]){
    Stack s = new Stack();
    s.push(6);
    s.push(7);
    System.out.println(s.returnSize());
    System.out.println(s.returnCapacity());
    System.out.println(s.pop());
  }

}
