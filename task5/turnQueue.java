import java.util.ArrayList;

class turnQueue {

    public static void turn(Queue queue, int count) {
        if(queue.size() == 0 || count == 0) {
            return;
        }

        for(int i = 0; i < count % queue.size(); i ++) {
            queue.enqueue(queue.dequeue());
        }
    }
}



