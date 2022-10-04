public class MyLinkedList<T> {
    private Node<T> head, tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    private boolean isValid(int index) {
        return (index >= 0 && index < size);
    }

    public void clear() {
        this.head = this.tail = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = head;
            this.head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void set(int index, T data) {
        if (isValid(index) && !isEmpty()) {
            Node<T> temp = head;
            for (int i = 0; i <= index; i++) {
                if (i != index) {
                    temp = temp.next;
                } else {
                    temp.data = data;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new NullPointerException();
        } else {
            return head.data;
        }
    }

    public T getLast() {
        if (tail == null) {
            throw new NullPointerException();
        } else {
            return tail.data;
        }
    }

    public T get(int index) {
        if (isValid(index) && !isEmpty()) {
            Node<T> temp;
            if (index >= size / 2) {
                temp = tail;
                for (int i = size - 1; i >= 0; i--) {
                    if (i != index) {
                        temp = temp.prev;
                    } else {
                        return temp.data;
                    }
                }
            } else {
                temp = head;
                for (int i = 0; i <= index; i++) {
                    if (i != index) {
                        temp = temp.next;
                    } else {
                        return temp.data;
                    }
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFirst() {
        if (head != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return;
        }
        throw new NullPointerException();
    }

    public void removeLast() {
        if (tail != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return;
        }
        throw new NullPointerException();
    }

    public void removeFirstOccurence(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if (temp.next == null) {
                    removeLast();
                } else if (temp.prev == null) {
                    removeFirst();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    public void removeLastOccurence(T data) {
        Node<T> temp = tail;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if (temp.next == null) {
                    removeLast();
                } else if (temp.prev == null) {
                    removeFirst();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
                break;
            } else {
                temp = temp.prev;
            }
        }
    }

    public void remove(int index) {
        if (isValid(index) && !isEmpty()) {
            Node<T> temp;
            if (index >= size / 2) {
                temp = tail;
                for (int i = size - 1; i >= 0; i--) {
                    if (i != index) {
                        temp = temp.prev;
                    } else {
                        if (temp.next == null) {
                            removeLast();
                        } else if (temp.prev == null) {
                            removeFirst();
                        } else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                            size--;
                        }
                    }
                }
            } else {
                temp = head;
                for (int i = 0; i <= index; i++) {
                    if (i != index) {
                        temp = temp.next;
                    } else {
                        if (temp.next == null) {
                            removeLast();
                        } else if (temp.prev == null) {
                            removeFirst();
                        } else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                            size--;
                        }
                    }
                }
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    public int indexOf(T data) {
        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return index;
            } else {
                temp = temp.next;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        Node<T> temp = tail;
        int index = size - 1;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return index;
            } else {
                temp = temp.prev;
                index--;
            }
        }
        return -1;
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        Node<T> temp = this.head;
        while (temp != null) {
            s.append(temp.data);
            if (temp.next != null)
                s.append("-");
            temp = temp.next;
        }
        return s.toString();
    }
}

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node() {
    }

    Node(T data) {
        this.data = data;
    }
}