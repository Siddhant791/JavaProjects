package src.collectionframework;

import java.util.Collection;

public class MyList<T> {
    private Collection<T> list;
    public MyList(Collection<T> list) {
        this.list = list;
    }

    public Collection<T> getList() {
        return list;
    }

    public void setList(Collection<T> list) {
        this.list = list;
    }
}
