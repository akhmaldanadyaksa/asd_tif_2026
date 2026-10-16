/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }
    @Override //Pengerjaan Muhammad Akmal
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }

        return currentNode.data;
    }
    @Override //Pengerjaan Muhammad Akmal
    public int indexOf(Object targetData) {
        Node currentNode = head;
        int index = 0;

        while (currentNode != null) {
            if (java.util.Objects.equals(currentNode.data, targetData)) {
                return index;
            }

            currentNode = currentNode.pointer;
            index++;
        }

        return -1;
    }
    @Override //Pengerjaan Muhammad Akmal
    public void printReverse() {
        printReverseHelper(head);
    }

    private void printReverseHelper(Node node) {
        if (node == null) {
        return;
        }

        printReverseHelper(node.pointer);
        System.out.println(node.data);
    }
    @Override //Pengerjaan Muhammad Akmal
    public boolean remove(Object targetData) {
        if (isEmpty()) {
        return false;
        }

        if (java.util.Objects.equals(head.data, targetData)) {
            deleteFirst();
            return true;
        }

        Node currentNode = head;

        while (currentNode.pointer != null) {
            if (java.util.Objects.equals(
                    currentNode.pointer.data, targetData)) {

                if (currentNode.pointer == tail) {
                    tail = currentNode;
                }

                currentNode.pointer = currentNode.pointer.pointer;
                size--;
                return true;
            }

            currentNode = currentNode.pointer;
        }

        return false;
    }
    @Override //Pengerjaan Muhammad Akmal
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.pointer;
        }

        return array;
    }
}
