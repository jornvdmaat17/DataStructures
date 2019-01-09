import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
      this.data = data;
      right = null;
      left = null;
  }
}

class Tree {

  Node root;

  Tree(){
    this.root = null;
  }

  public void add(int data){
    root = addRec(root, data);
  }

  private Node addRec(Node current, int data){
    if(current == null){
      return new Node(data);
    }

    if(data < current.data){
      current.left = addRec(current.left, data);
    }else if(data > current.data){
      current.right = addRec(current.right, data);
    }else{
      return current;
    }
    return current;
  }

  public boolean containsNode(int data){
    return containsNodeRec(root, data);
  }

  private boolean containsNodeRec(Node current, int data){
    if(current == null){
      return false;
    }
    if(data == current.data){
      return true;
    }
    return data < current.data ? containsNodeRec(current.left, data) : containsNodeRec(current.right, data);
  }

  public Node deleteNode(int data){
    return deleteNodeRec(root, data);
  }

  private Node deleteNodeRec(Node current, int data){
    if(current == null){
      return null;
    }

    if(current.data == data){
      if(current.left == null && current.right == null){
        return null;
      }
      if(current.right == null){
        return current.left;
      }
      if(current.left == null){
        return current.right;
      }
      int small = findSmallestNode(current.right);
      current.data = small;
      current.right = deleteNodeRec(current.right, data);
      return current;
    }

    if(data < current.data){
      current.left = deleteNodeRec(current.left, data);
      return current;
    }

    current.right = deleteNodeRec(current.right, data);
    return current;  
  }

  private int findSmallestNode(Node current){
    return current.left == null ? current.data : findSmallestNode(current.right);
  }

  public void traverseInOrder(){
    inOrderRec(root);
    System.out.print("\n");
  }

  private void inOrderRec(Node node){
    if (node != null) {
      inOrderRec(node.left);
      System.out.print(" " + node.data);
      inOrderRec(node.right);
    }
  }

  public void traversePreOrder(){
    preOrderRec(root);
    System.out.print("\n");
  }
  
  private void preOrderRec(Node node){
    if (node != null) {
      System.out.print(" " + node.data);
      preOrderRec(node.left);
      preOrderRec(node.right);
    }
  }

  public void traversePostOrder(){
    postOrderRec(root);
    System.out.print("\n");
  }
  
  private void postOrderRec(Node node){
    if (node != null) {
      postOrderRec(node.left);
      postOrderRec(node.right);
      System.out.print(" " + node.data);
    }
  }

  public void traverseBreadthFirst(){
    if(root == null){
      return;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while(!nodes.isEmpty()){

      Node tmp = nodes.remove();
      System.out.print(" " + tmp.data);

      if(tmp.left != null){
        nodes.add(tmp.left);
      }

      if(tmp.right != null){
        nodes.add(tmp.right);
      }
    }


  }
}
