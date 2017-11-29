package ds.ctci.ch3;

public class QueueWith2Stacks {
	
	private static class Queue {

		Stack F = new Stack(), S  = new Stack(); // First and Second stack
		
		public void add(int item) {
			S.push(item);
		}
		
		public int remove() {
			if(isEmpty())
				throw new RuntimeException("empty queue");
			
			if(F.isEmpty())
				reshuffle();
			
			return F.pop();
		}

		public int peak() {
			if(isEmpty())
				throw new RuntimeException("empty queue");
			
			if(F.isEmpty())
				reshuffle();
			
			return F.peak();
		}

		public boolean isEmpty() {
			return F.isEmpty() && S.isEmpty();
		}
		
		private void reshuffle() {
			while(!S.isEmpty())
				F.push(S.pop());
		}

	}
	
	public static void main(String[] args) {
		
		Queue q = new Queue();
		System.out.println("Q : isEmpty : " + q.isEmpty());
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("Q : remove : " + q.remove());
		System.out.println("Q : peak : " + q.peak());
		System.out.println("Q : remove : " + q.remove());
		q.add(4);
		System.out.println("Q : remove : " + q.remove());
		System.out.println("Q : peak : " + q.peak());
		System.out.println("Q : remove : " + q.remove());
		//System.out.println("Q : remove : " + q.remove());
		
	}

}
