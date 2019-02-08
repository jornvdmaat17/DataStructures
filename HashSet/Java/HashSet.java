import java.util.NoSuchElementException;

class HashSet<T>{

    private class Node<T>{

        private T data;
        private Node next;

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(T data){
            this.data = data;
            this.next = null;
        }

    }

    private static final int CAPACITY = 16;
    private Node[] buckets;
    private int size;

    public HashSet(){
        buckets = new Node[CAPACITY];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void add(T data){
        int index = data.hashCode() % buckets.length;
        Node bucket = buckets[index];
        Node<T> newN = new Node(data);
        
        if(bucket == null){
            buckets[index] = newN;
            size++;
            return;
        }

        while(bucket.next != null){
            if(bucket.data.equals(data)){
                return;
            }
            bucket = bucket.next;
        }
        if(!bucket.data.equals(data)){
            bucket.next = newN;
            size++;
        }
    }

    public boolean remove(T data){
        int index = data.hashCode() % buckets.length;
        Node bucket = buckets[index];

        if (bucket == null) {
            return false;
        }
        
        if(bucket.data.equals(data)){
            buckets[index] = bucket.next;
            size--;
            return true;
        }

        Node prev = bucket; 
        
        while(bucket != null){
            if(bucket.data.equals(data)){
                prev.next = bucket.next;
                size--;
                return true;
            }
            prev = bucket;
            bucket = bucket.next;
        }
        return false;
    }

    public boolean contains(T data){
        int index = data.hashCode() % buckets.length;
        Node bucket = buckets[index];

        if (bucket == null) {
            return false;
        }

        while(bucket != null){
            if(bucket.data.equals(data)){
                return true;
            }
            bucket = bucket.next;
        }
        return false;        
    }
    
    public void clear(){
        buckets = new Node[CAPACITY];
    }

    @Override
    public HashSet<T> clone(){
        return this;
    }
    
    public Object[] toArray(){
        Object[] ret = new Object[size];
        int index = 0;
        for(int i = 0; i < buckets.length; i++){
            Node current = buckets[i];
            while(current != null){
                ret[index] = current.data;
                index++;
                current = current.next;
            }
        }
        return ret;
    }

    @Override
    public String toString(){
        String ret = "[";
        for(int i = 0; i < buckets.length; i++){
            Node current = buckets[i];
            while(current != null){
                ret += current.data.toString() + ", ";
                current = current.next;
            }
        }
        ret = ret.substring(0, ret.length() - 2);
        ret += "]";
        return ret;
    }
}