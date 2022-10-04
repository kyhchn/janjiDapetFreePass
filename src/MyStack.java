import java.util.EmptyStackException;

public class MyStack<T> {
    Node<T> head, tail = null;
    int size = 0;

    MyStack() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size > 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T pop() {
        Node<T> tempNode = new Node<>();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            tempNode = head;
            head = head.next;
            size--;
            return tempNode.data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return head.data;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        Node<T> temp = head;
        while (temp != null) {
            result.append(temp.data.toString());
            if (temp.next != null)
                result.append("-");
            temp = temp.next;
        }
        return result.toString();
    }
}

class Node<T> {
    Node<T> next;
    T data;

    Node() {
    }

    Node(T data) {
        this.data = data;
    }
}
