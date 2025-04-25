public class MyHashTable<K,V> {

    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{"+key+" "+value+"}";
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        String keyString = key.toString();
        int hashValue = 0;
        for (int i = 0; i < keyString.length(); i++) {
            hashValue += (int) keyString.charAt(i);
        }
        return hashValue % M;
    }

    public void put(K key,V value){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        HashNode<K,V> newNode = new HashNode<>(key,value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        if(head==null){
            return null;
        }
        if(head.key.equals(key)){
            V res = head.value;
            chainArray[index] = head.next;
            size--;
            return res;
        }
        while(head!=null && head.next!=null){
            if(head.next.key.equals(key)){
                V res = head.next.value;
                head.next = head.next.next;
                size--;
                return res;
            }
            head = head.next;
        }
        return null;
    }

    public boolean contains(V value){
        for(int i=0;i< chainArray.length;i++){
            HashNode<K,V> head = chainArray[i];
            while(head!=null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(int i=0;i< chainArray.length;i++){
            HashNode<K,V> head = chainArray[i];
            while(head!=null){
                if(head.value.equals(value)){
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

    public void PrintTable(){
        for(int i = 0;i< chainArray.length;i++){
            System.out.print("["+i+"] ");
            HashNode<K,V> head = chainArray[i];
            while(head!=null){
                System.out.print("{"+head.key+" : "+head.value+"} -->");
                head = head.next;
            }
            System.out.println();
        }
    }
}
