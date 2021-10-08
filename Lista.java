public interface Lista<T> extends Percorrivel<T>{
    void add(T dado);
    int size();
    T get(int i);
    String toString();
    void setCursor(int pos);
}
