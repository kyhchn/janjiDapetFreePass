public class MyQueue<T> {
    Node<T> head, tail = null;
    int size = 0;

    MyQueue() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = newNode;
            size++;
            return true;
        } else {
            
        }
    }

    public T element(){
        return head.data;
    }



    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        } else {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.data.equals(data)) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                    return true;
                }
                if (temp.next != null) {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        } else {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.data.equals(data)) {
                    return true;
                }
                if (temp.next != null) {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    public Object[] toArray() {
        Object[] tempArray = new Object[size];
        Node<T> tempNode = head;
        int index = 0;
        while (tempNode != null) {
            tempArray[index] = tempNode.data;
            tempNode = tempNode.next;
            index++;
        }
        return tempArray;
    }

}

class Node<T> {
    Node<T> next, prev;
    T data;

    Node() {
    }

    Node(T data) {
        this.data = data;
    }
}
