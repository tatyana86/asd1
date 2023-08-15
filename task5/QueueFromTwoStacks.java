public class QueueFromTwoStacks<T> {

    Stack<T> stack1;
    Stack<T> stack2;
    int count;

    public QueueFromTwoStacks()
    {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.count = 0;
    }

    public void enqueue(T item)
    {
        this.stack1.push(item);
        this.count ++;
    }

    public T dequeue()
    {
        if(this.count == 0) {
            return null;
        }

        if(this.stack2.size() == 0) {
            while(this.stack1.size() > 0) {
                this.stack2.push(this.stack1.pop());
            }
        }

        this.count --;
        return this.stack2.pop();
    }

    public int size()
    {
        return count;
    }
}
