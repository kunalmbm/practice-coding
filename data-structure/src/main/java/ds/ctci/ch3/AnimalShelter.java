package ds.ctci.ch3;

public class AnimalShelter {

	private static final int DOG = 1;
	private static final int CAT = 2;

	private static class Queue {
		private int seqId = 0;
		private static final int DOG = 1;
		private static final int CAT = 2;

		private class Node {
			int aid = 0;
			int sid = 0;
			Node next;

			public Node(int aid, int sid) {
				this.aid = aid;
				this.sid = sid;
			}
		}

		Node dfirst = null, dlast = null, cfirst = null, clast = null;

		public boolean isEmpty() {
			return dfirst == null && cfirst == null;
		}

		public void printQueue() {
			System.out.println("------------ Queues ------------");
			System.out.print("Dog Q:");
			Node node = dfirst;
			while (node != null) {
				System.out.printf(" -> %d (%d)", node.aid, node.sid);
				node = node.next;
			}

			System.out.print("\nCat Q:");
			node = cfirst;
			while (node != null) {
				System.out.printf(" -> %d (%d)", node.aid, node.sid);
				node = node.next;
			}

			System.out.println("\n------------ Queues ------------");

		}

		public void enqueue(int type, int aid) {

			Node node = new Node(aid, ++seqId);
			switch (type) {
			case DOG:
				if (dfirst == null)
					dfirst = dlast = node;
				else
					dlast = dlast.next = node;
				break;

			case CAT:
				if (cfirst == null)
					cfirst = clast = node;
				else
					clast = clast.next = node;
				break;

			default:
				throw new RuntimeException("invalid animal type");
			}

		}

		public int dequeueDog() {

			if (dfirst == null)
				throw new RuntimeException("Dog Queue is empty");

			Node node = dfirst;
			dfirst = dfirst.next;
			return node.aid;

		}

		public int dequeueCat() {

			if (cfirst == null)
				throw new RuntimeException("Cat Queue is empty");

			Node node = cfirst;
			cfirst = cfirst.next;
			return node.aid;

		}

		public int dequeueAny() {

			if (isEmpty())
				throw new RuntimeException("Queue is empty");

			if (dfirst == null)
				return dequeueCat();

			if (cfirst == null)
				return dequeueDog();

			if (cfirst.sid > dfirst.sid)
				return dequeueDog();

			return dequeueCat();

		}
	}

	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println("Starting....");
		System.out.println("Queue : isEmpty : " + q.isEmpty());
		q.enqueue(DOG, 105);
		q.enqueue(DOG, 190);
		q.enqueue(DOG, 140);
		q.enqueue(CAT, 215);
		q.enqueue(CAT, 217);
		q.enqueue(DOG, 112);
		q.enqueue(CAT, 299);
		q.enqueue(CAT, 245);
		q.enqueue(CAT, 201);
		q.printQueue();

		System.out.println("dequeueCat : " + q.dequeueCat());
		System.out.println("dequeueDog : " + q.dequeueDog());
		System.out.println("dequeueAny : " + q.dequeueAny());
		System.out.println("dequeueAny : " + q.dequeueAny());
		System.out.println("dequeueAny : " + q.dequeueAny());
		q.printQueue();

		System.out.println("dequeueAny : " + q.dequeueAny());
		System.out.println("dequeueAny : " + q.dequeueAny());

		q.printQueue();

		System.out.println("dequeueAny : " + q.dequeueAny());
		System.out.println("dequeueAny : " + q.dequeueAny());

		q.printQueue();

		// System.out.println("dequeueAny : " + q.dequeueAny());
	}

}