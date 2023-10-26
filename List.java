public class List {

    Node head;
    Node tail;



    public void push (int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

//    public Integer pop(){
//        if (head != null)
//        int result = head.value;
//    }

    public void add(int value) { // ДОБАВЛЕНИЕ В КОНЕЦ
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) { // ДОБАВЛЕНИЕ В CЕРЕДИНУ
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        }else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){
            head = next;
        }else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }

    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value) return  currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }


    public void revert(){   // ДЛЯ ДВУСВЯЗНОГО СПИСКА
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;

        }


//        private void revertForSingle (Node currentNode, Node previousNode) {
//            if (currentNode.next == null) {
//                head = currentNode;
//            }else {
//                revertForSingle(currentNode.next, currentNode);
//            }
//            currentNode.next = previousNode;
//        }
    }




    public class Node {
        int value;
        Node next;

        Node previous;
    }
}
