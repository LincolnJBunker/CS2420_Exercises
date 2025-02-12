package ceStackQueue;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * CE Stack Queue Part 2
 * Exercise to practice the use of stacks and queues.
 * 
 * @author CSIS 2420 Starter Code and Lincoln Bunker
 *
 */
public class StackQueue {

	/**
	 * Performs the following transformations:
	 * Replaces the characters '1' with 'i'
	 * Removes characters that are not letters
	 * Removes upper-case letters
	 * 
	 * Example: [9 h ; e l # A l D 0 o . ] => [h e l l o ]
	 * 
	 * @param q an inputted queue
	 * @return transformed input
	 */
	private static Iterable<Character> transformationA(Queue<Character> q) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Character n = q.dequeue();
			if (n == '1') { //if character is a '1', add it in as an 'i'
				q.enqueue('i');
			}
			
			else if (Character.isLowerCase(n)) { //only enqueue lowercase chars
				q.enqueue(n);
			}
			
		}
		
		return q; //return the queue
	}
	

    /**
     * Performs the following transformations:
     * Duplicate all slashes and backslashes ( / and \ )
     * Add the reversed (transformed) character sequence to the end.
     *
     * Example: [. / ^ \ ~ ] => [. / / ^ \ \ ~ ~ \ \ ^ / / . ]
     *
     * @param q the input queue of characters
     * @return transformed input queue
     */
    private static Iterable<Character> transformationB(Queue<Character> q) {
        Queue<Character> finalQueue = new Queue<>(); //Create a new queue to add the reversed stack to
        Stack<Character> reversedStack = new Stack<>(); //Create a stack to reverse elements from the queue

        //Duplicate / and \ while building finalQueue
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Character c = q.dequeue();
            if (c == '/' || c == '\\') {
                finalQueue.enqueue(c); //add the slashes twice
                finalQueue.enqueue(c);
            } else {
                finalQueue.enqueue(c); //add everything else 1
            }
        }

        //Push finalQueue elements onto the stack to reverse them
        for (Character ch : finalQueue) {
            reversedStack.push(ch); //each character one by one
        }

        //Append reversed sequence to finalQueue
        while (!reversedStack.isEmpty()) {
            finalQueue.enqueue(reversedStack.pop()); //pop to ensure they go in reversed order
        }

        return finalQueue; //return the queue with the reversed characters
    }
	
	public static void main(String[] args) {
		Queue<Character> inputQueue = new Queue<>();
		for(Character c : new Character[] {'9', 'h', ';', 'e', 'l', '#', 'A', 'l', 'D', '0', 'o', '.'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'f', 'R', 'e', '!', 'P', 'l', '1', 'c', '1', 'D', '5', 't', ';', 'y'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		Queue<Character> emptyQueue = new Queue<>();
		for(Character c : new Character[0]) {
			emptyQueue.enqueue(c);
		}
		testTransformA(emptyQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'.', '/', '^', '\\', '~'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'/', 'A', '|', 'A', '\\', 'o'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		testTransformB(emptyQueue);
	}

	private static void testTransformA(Queue<Character> queue) {
		StdOut.println("TransformA (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationA(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
	
	private static void testTransformB(Queue<Character> queue) {
		StdOut.println("TransformB (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationB(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
}
