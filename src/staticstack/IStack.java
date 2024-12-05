package staticstack;

public interface IStack {
    int size();
    boolean isEmpty();
    void push(int element);
    int pop();
    int top();

}
