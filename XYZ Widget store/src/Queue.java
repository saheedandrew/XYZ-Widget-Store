public interface Queue<Item>  extends Iterable<Item>{
    Item delete();
    void insert(Item item);
    boolean isEmpty();
    int size();
}
