
class Hashmap<Key, Value>{

    private static final int SIZE = 16;
    private Entry<Key, Value> table[];
    private int size;

    class Entry<Key, Value>{

        Key key;
        Value value;
        Entry<Key, Value> next;

        private Entry(Key key, Value value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public Hashmap(){
        table = new Entry[SIZE];
        size = 0;
    }

    private int getSupplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
    private int getBucketNumber(int hash) {
        return hash & (SIZE - 1);
    }
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void put(Key key, Value value){
        int hash = getSupplementalHash(key.hashCode());
        int bucket = getBucketNumber(hash);
        Entry<Key, Value> existingElement = table[bucket];
        for (; existingElement != null; existingElement = existingElement.next){
            if(existingElement.key.equals(key)){
                existingElement.value = value;
                return;
            }
        }
        Entry<Key, Value> newEntry = new Entry<>(key, value);
        newEntry.next = table[bucket];
        table[bucket] = newEntry; 
        size++;
    }    

    public Value get(Key key){
        int hash = getSupplementalHash(key.hashCode());
        int bucket = getBucketNumber(hash);
        Entry<Key, Value> currentEntry = table[bucket];
        while(currentEntry != null){
            if(currentEntry.key.equals(key)){
                return currentEntry.value;
            }
            currentEntry = currentEntry.next;
        }
        return null;
    }

    public Value removeKey(Key key){
        int hash = getSupplementalHash(key.hashCode());
        int bucket = getBucketNumber(hash);
        Entry<Key, Value> currentEntry = table[bucket];
        Value ret = null;

        if(currentEntry.key.equals(key)){
            ret = currentEntry.value;
            currentEntry = currentEntry.next;
            table[bucket] = currentEntry;
            return ret;
        }
        while(currentEntry.next != null){
            if(currentEntry.next.key.equals(key)){
                ret = currentEntry.next.value;
                currentEntry.next = currentEntry.next.next;
                size--;
                break;
            }
            currentEntry = currentEntry.next;
        }
        table[bucket] = currentEntry;
        return ret;
    }

    public boolean removeValue(Value value){
        boolean ret = false;
        for(int i = 0; i < table.length; i++){
            //Test if not null
            Entry<Key, Value> currentEntry = table[i];
            if(currentEntry != null){
                if(currentEntry.value.equals(value)){
                    currentEntry = currentEntry.next;
                    table[i] = currentEntry;
                    return true;
                }
                while(currentEntry.next != null){
                    if(currentEntry.next.value.equals(value)){
                        currentEntry.next = currentEntry.next.next;
                        ret = true;
                        size--;
                        break;
                    }
                    currentEntry = currentEntry.next;
                }
                table[i] = currentEntry;
            }            
        }
        return ret;
    }


    public void clear(){
        table = new Entry[SIZE];
    }

    public Hashmap<Key, Value> clone(){
        return this;
    }

    public boolean containsValue(Value value){
        for(Entry<Key, Value> currentEntry : table){
            while(currentEntry != null){
                if(currentEntry.value.equals(value)){
                    return true;
                }
                currentEntry = currentEntry.next;
            }
        }
        return false;
    }

    public boolean containsKey(Key key){
        int hash = getSupplementalHash(key.hashCode());
        int bucket = getBucketNumber(hash);
        Entry<Key, Value> currentEntry = table[bucket];
        while(currentEntry != null){
            if(currentEntry.key.equals(key)){
                return true;
            }
            currentEntry = currentEntry.next;
        }
        return false;
    }

    @Override
    public String toString(){
        String res = "";
        for(int i =0; i < table.length; i++){
            Entry<Key, Value> currentEntry = table[i];
            res += "Bucket " + i + ":\n";
            while(currentEntry != null){
                res += "{" + currentEntry.key.toString() + ", " + currentEntry.value.toString() + "}, ";
                currentEntry = currentEntry.next;
            }
            res = res.substring(0, res.length() - 2) + "\n";
        }
        return res;
    }



    public static void main(String[] args) {
        Hashmap<Integer, String> m = new Hashmap<>();
        m.put(0, "zero");
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "four");
        m.put(3, "three");
        m.put(17, "twelve");
        System.out.println(m.get(1));
        System.out.println(m.get(0));
        System.out.println(m.get(3));
        System.out.println(m.containsKey(1));
        System.out.println(m.containsKey(5));
        System.out.println(m.containsValue("zero"));
        System.out.println(m.containsValue("four"));
        System.out.println(m.toString());
        // m.removeKey(0);
        // m.removeKey(2);
        // m.removeKey(0);
        // m.removeValue("zero");
        m.removeValue("twelve");
        System.out.println(m.toString());
        System.out.println(m.containsKey(1));
        System.out.println(m.size());
    }
    
}