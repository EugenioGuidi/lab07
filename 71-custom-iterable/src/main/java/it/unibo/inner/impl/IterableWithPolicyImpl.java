package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] array = null;

    public IterableWithPolicyImpl(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator iterator() {
        IteratorImpl iterator = new IteratorImpl();

        return iterator;
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    public class IteratorImpl implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < IterableWithPolicyImpl.this.array.length) {
                return true;
            }else {
                return false;
            }
        }

        @Override
        public T next() {
            this.index = this.index + 1;
            return IterableWithPolicyImpl.this.array[this.index - 1];
        }
        
    } 

}
