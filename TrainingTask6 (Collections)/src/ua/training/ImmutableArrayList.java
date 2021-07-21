package ua.training;

import java.util.ArrayList;
import java.util.Collection;

public class ImmutableArrayList<T> extends ArrayList<T> {
    ImmutableArrayList()  {
        super();
    }
    ImmutableArrayList(Collection<? extends T> c)  {
        super(c);
    }
    ImmutableArrayList(int initialCapacity)  {
        super(initialCapacity);
    }

    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }
}
