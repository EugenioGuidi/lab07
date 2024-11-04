package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] array = null;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(T[] array) {
        this(array, new Predicate<T>() {
            public boolean test(T elem) {
                return true;
            }
        });
    }

    public IterableWithPolicyImpl(T[] array, Predicate<T> predicate) {
        this.array = array;
        this.predicate = predicate;
    }

    @Override
    public Iterator iterator() {
        IteratorImpl iterator = new IteratorImpl();

        return iterator;
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        this.predicate = filter;
    }

    public class IteratorImpl implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            while(index < IterableWithPolicyImpl.this.array.length) {
                if(IterableWithPolicyImpl.this.predicate.test(IterableWithPolicyImpl.this.array[this.index])) {
                    return true;
                }
                this.index++;
            }
            return false;
        }

        @Override
        public T next() {
            IterableWithPolicyImpl.this.predicate.test(IterableWithPolicyImpl.this.array[index]);
            this.index = this.index + 1;
            return IterableWithPolicyImpl.this.array[this.index - 1];
        }
        
    } 

}
