import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>,V>{
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private Node(K key,V val){
            this.key= key;
            this.value = val;
        }
    }
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if(root==null) {
            root = newNode;
            return;
        }
        Node current = root;
        while(true){
            int raz = key.compareTo(current.key);
            if(raz<0){
                if(current.left==null){
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (raz>0) {
                if(current.right==null){
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }else{
                current.value = newNode.value;
                return;
            }
        }
    }
    public  V get(K key){
        Node current = root;
        while(current!=null){
            int raz = key.compareTo(current.key);
            if(raz<0){
                current= current.left;
            }else if(raz>0){
                current = current.right;
            } else{
                return current.value;
            }
        }
        return null;
    }
    public  void delete (K key){
        Node current = root;
        Node parent = null;
        while(current!=null){
            int raz = key.compareTo(current.key);
            if(raz<0){
                parent = current;
                current = current.left;
            }else if(raz>0){
                parent = current;
                current = current.right;
            }else{
                if(current.left==null && current.right==null){
                    if(current==root){
                        root=null;
                    }
                    else if(parent.left==current){
                        parent.left=null;
                    }else{
                        parent.right = null;
                    }
                    return;
                }
                else if(current.right==null){
                    if(current==root){
                        root = root.left;
                    }
                    else if(parent.left==current){
                        parent.left = current.left;
                    }else{
                        parent.right =current.left;
                    }
                    return;
                }
                else if(current.left==null){
                    if(current==root){
                        root = root.right;
                    }else if(parent.left==current){
                        parent.left = current.right;
                    }else{
                        parent.right = current.right;
                    }
                    return;
                }
                else{
                    Node successorParent = current;
                    Node successor = current.right;
                    while (successor.left != null){
                        successorParent = successor;
                        successor = successor.left;
                    }
                    if(successorParent!=current){
                        successorParent.left = successor.right;
                        successor.right = current.right;
                    }
                    successor.left = current.left;
                    if(current == root){
                        root = successor;
                    }else if(parent.left ==current){
                        parent.left = successor;
                    }else{
                        parent.right = successor;
                    }
                    return;
                }
            }
        }
        return;
    }
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current!=null || !(stack.isEmpty())){
            while (current!= null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            keys.add(current.key);
            current = current.right;
        }
        return keys;
    }
}
