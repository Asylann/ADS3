import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass,Integer> table = new MyHashTable<>(100);
        Random rn = new Random();

        for(int i=0;i<10000;i++){
            int id = rn.nextInt(10000);
            table.put(new MyTestingClass(id),i);
        }

        int[] arr = new int[100];
        for(int i = 0;i<100;i++){
            int count = 0;
            MyHashTable<MyTestingClass,Integer>.HashNode<MyTestingClass,Integer> head = table.getChainArray()[i];
            while(head!=null){
                head = head.getNext();
                count++;
            }
            arr[i] = count;
        }

        for(int i = 0;i<100;i++){
            System.out.printf("arr[%d] = %d elements",i,arr[i]);
            System.out.println();
        }
    }
}