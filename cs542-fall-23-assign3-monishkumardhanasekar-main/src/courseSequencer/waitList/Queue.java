package courseSequencer.waitList;

public class Queue {

    public class Node {
        String course;
        Node next;

        public Node(String course)
        {
            this.course = course;
            this.next = null;
        }
    }

	Node front, rear;

	public Queue() {
        this.front = this.rear = null;
    }

	public void enqueue(String course)
	{
		Node newCourse = new Node(course);

		
		if (this.rear == null) {
			this.front = this.rear = newCourse;
			return;
		}

		
		this.rear.next = newCourse;
		this.rear = newCourse;
	}

	
	public String dequeue()
	{
		if (this.front == null)
			return "";


		Node temp = this.front;
		this.front = this.front.next;
		if (this.front == null)
			this.rear = null;
		
		return temp.course;
	}

	public boolean isEmpty() {
        return front == null;
    }
}



