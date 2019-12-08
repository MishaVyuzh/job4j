package ru.job4j.generic;

import java.util.NoSuchElementException;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<T>(size);
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;

        simpleArray.set(findIndexById(id), model);
        if (findById(id) == null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try {
            simpleArray.remove(findIndexById(id));
            result = true;
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T base = null;

        for (T current : simpleArray) {
            if (current.getId().equals(id)) {
                base = current;
                break;
            }
        }
        return base;
    }

    public int findIndexById(String id) {
        int index = -1;
        int count = 0;

        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                index = count;
                break;
            }
            count++;
        }
        return index;
    }
}
