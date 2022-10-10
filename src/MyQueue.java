public class MyQueue<T> {
    Node<T> head = null;
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
        head = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.head = null;
        } else {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.next == null) {
                    temp.next = newNode;
                    break;
                }
            }
            size++;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            head.next.prev = null;
            head = head.next;
            size--;
        } else {
            throw new NullPointerException();
        }
    }

    public T getFrontAndDequeue() {
        if (!isEmpty()) {
            Node<T> temp = head;
            head.next.prev = null;
            head = head.next;
            size--;
            return temp.data;
        } else {
            throw new NullPointerException();
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
            throw new NullPointerException();
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
            if (tempNode.next != null) {
                tempNode = tempNode.next;
            }
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
