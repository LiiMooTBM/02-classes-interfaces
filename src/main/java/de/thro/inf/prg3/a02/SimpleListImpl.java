package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

     private Element head = null;
     public Iterator iterator(){
         return new SimpleIteratorImpl(head);
     }
    @Override
    public void add(Object o) {
         if (head==null) {
             head = new Element(o);
             return;
         }
         Element it = head;
        while (it.next != null){
            it = it.next;
        }
        it.next = new Element(o);
    }

    @Override
    public int size() {
        int count = 0;
       Iterator it = this.iterator();
       while (it.hasNext()){
           it.next();
           count++;
       }
        return count;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList list = new SimpleListImpl();
        for(Object o : this){
            if(filter.include(o)){
                list.add(o);
            }
        }
        return list;
    }

    private static class Element {
        private Object Item;
        private Element next;
        public Element(Object o) {
            next = null;
            Item = o;
        }
    }
    private class SimpleIteratorImpl implements Iterator{
         private Element aktuell;
        @Override
        public boolean hasNext() {
            return aktuell != null;
        }
        @Override
        public Object next() {
            Object o = aktuell.Item;
            aktuell = aktuell.next;
            return o;
        }
        private SimpleIteratorImpl(Element head) {
            this.aktuell = head;
        }
    }

    // TODO: Implement the required methods.

}
