package Baiseasion13;

public interface Manage2<T>
{
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}
