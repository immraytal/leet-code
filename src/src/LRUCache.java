import java.util.HashMap;

public class LRUCache {
        HashMap<Integer, Node> map;
        CacherLinkedList history;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.history = new CacherLinkedList();
        }

        /**
         *
         * 1 1    2 2
         * 0      1
         * */

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);

                if (history.head != node) {
                    history.remove(node);
                    history.addToHead(node);
                }

                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                removeItem(map.get(key));
            }

            if (map.size() >= capacity) {
                evictLastRecentItem();
            }

            Node node = new Node(key, value);
            history.addToHead(node);
            map.put(key, node);
        }

        private void evictLastRecentItem() {
            Node tail = this.history.tail;
            removeItem(tail);
        }

        private void removeItem(Node node) {
            map.remove(node.key);
            history.remove(node);
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class CacherLinkedList {
        Node head;
        Node tail;

        void addToHead(Node node) {
            if (node == null) {
                return;
            }

            if (this.head != null) {
                node.next = this.head;
                this.head.prev = node;
            }

            if (this.tail == null) {
                this.tail = node;
            }

            this.head = node;
        }

        void remove(Node node) {
            if (node == null) {
                return;
            }

            Node prev = node.prev;
            Node next = node.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }

            if (this.head == node) {
                this.head = next;
            }

            if (this.tail == node) {
                this.tail = prev;
            }

            node.next = null;
            node.prev = null;
        }
    }
