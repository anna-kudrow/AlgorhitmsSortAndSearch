//1.Реализуем простой односвязный список.
//        2.Пишем только структуру, никаких методов не требуется.

//1.Реализуем метод добавления новых элементов в начало списка и удаление
//        первого элемента связного списка.
//        2.Односвязный список всегда имеет ссылку на первый элемент
//        последовательности, потому именно с реализации методов для первого
//        элемента последовательности стоит начать

//1.Реализуем метод поиска элемента в односвязном списке для проверки наличия
//        элемента внутри списка.
//        2.Для корректной работы со связным список необходимо понимать, как именно
//        можно обходить все значения внутри связного списка.
//        3.Для нашего примера проще всего будет написать метод поиска значения в
//        связном списке и возвращения из метода информации о наличии искомого
//        внутри списка.

//.Реализуем метод добавления новых элементов в конец списка и удаление
//        последнего элемента связного списка.

public class Lesson3 {

    public static void main(String[] args) {
        MyList myList = new MyList();
        for (int i = 0; i < 10; i++) {
            myList.addLast(i);
        }
        System.out.println(myList);
        myList.removeFirst();
        myList.removeLast();
        System.out.println(myList);

    }

}

class MyList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node nextNode;

        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean add(int value) {

        Node node = new Node(value);
        if (head == null) {
            head = node;
            return true;
        }
        head.previous = node;
        node.nextNode = head;
        head = node;
        return true;
    }

    public Node find(int value) {
        if (head == null) return null;
        for (Node temp = head; temp != null; temp = temp.nextNode) {
            if (temp.value == value) return temp;
        }
        return null;
    }

    public Integer removeFirst() {
        if (head == null) return null;
        int temp = head.value;
        head = head.nextNode;
        if (head != null) head.previous = null;
        return temp;
    }


    public Integer removeLast() {
        if (tail == null) return null;
        int temporary = tail.value;
        tail.previous.nextNode = null;
        tail = tail.previous;
        return temporary;
    }

    public void addLast(int value) {
        if (head == null) {
            add(value);
            return;
        }
        if (tail == null) {
            tail = new Node(value);
            return;
        }
        tail.nextNode = new Node(value);
        tail.nextNode.previous = tail;
        tail = tail.nextNode;
    }

    @Override
    public String toString() {
        String str = "{ ";
        for (Node temp = tail; temp != null; temp = temp.previous) {
            str += String.valueOf(temp.value) + " ";
        }
        return str + "}";
    }
}
