package structure.list;

public interface GBList extends GBIterable{
    void add(String value);
    boolean remove(String value);
    int size();
    String getIndex(int index);
}
