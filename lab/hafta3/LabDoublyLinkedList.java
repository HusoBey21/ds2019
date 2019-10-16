public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {
        if(index==0)
            addFirst(value);
        else if(index==size())
            addLast(value);
        else {
            Node<T> node=getHead();
            for(int i=0;i<index-1;i++)
                node=node.next;
            Node<T> newNode=new Node<>(value, node.next, node);
            node.next.previous=newNode;
            node.next=newNode;
            setSize(size()+1);
        }
    }

    /**
     * Verilen konumdaki elemanı siler
     * @param index konum
     * @return silinen eleman
     */
    @Override
    public T removeAt(int index) { 
        if(index==0)
            return removeFirst();
        else if(index==size()-1)
            return removeLast();
        else {
            Node<T> node=getHead();
            for(int i=0;i<index;i++)
                node=node.next;
            node.next.previous=node.previous;
            node.previous.next=node.next;
            setSize(size()-1);
            return node.value;
        }
        
    }
}
