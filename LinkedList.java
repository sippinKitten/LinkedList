//Выполнил студент группы 2А Иванов Данил

public class LinkedList<T> {
    private Node<T> head; // Голова списка
    private int size; // Размер списка

    // Внутренний класс для представления узла списка
    private static class Node<T> {
        private T data; // Данные узла
        private Node<T> next; // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
        }
    }

    // Конструктор
    public LinkedList() {
        head = null;
        size = 0;
    }

    // Проверка, пуст ли список
    public boolean isEmpty() {
        return head == null;
    }

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Вставка элемента в начало списка
    public void insertAtStart(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Вставка элемента в конец списка
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Вставка элемента на указанную позицию
    public void insertAtPosition(T data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            insertAtStart(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> previous = null;
            Node<T> current = head;
            int currentPosition = 0;
            while (currentPosition < position) {
                previous = current;
                current = current.next;
                currentPosition++;
            }
            previous.next = newNode;
            newNode.next = current;
            size++;
        }
    }

    // Удаление элемента из начала списка
    public void deleteFromStart() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        head = head.next;
        size--;
    }

    // Удаление элемента из конца списка
    public void deleteFromEnd() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
        }
        size--;
    }

    // Удаление элемента с указанной позиции
    public void deleteFromPosition(int position) {
        if (isEmpty() || position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            deleteFromStart();
        } else if (position == size - 1) {
            deleteFromEnd();
        } else {
            Node<T> previous = null;
            Node<T> current = head;
            int currentPosition = 0;
            while (currentPosition < position) {
                previous = current;
                current = current.next;
                currentPosition++;
            }
            previous.next = current.next;
            size--;
        }
    }

    // Получение значения элемента на указанной позиции
    public T get(int position) {
        if (isEmpty() || position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        Node<T> current = head;
        int currentPosition = 0;
        while (currentPosition < position) {
            current = current.next;
            currentPosition++;
        }
        return current.data;
    }

    // Преобразование списка в массив
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int currentPosition = 0;
        while (current != null) {
            array[currentPosition] = current.data;
            current = current.next;
            currentPosition++;
        }
        return array;
    }
}
