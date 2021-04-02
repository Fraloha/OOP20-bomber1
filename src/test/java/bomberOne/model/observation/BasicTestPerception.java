package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public class BasicTestPerception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P2d staticPosition = new P2d(10, 10);
		EnemyObservation simple = new EnemyObservation(staticPosition);
		EnemySimpleObservation medium = new EnemySimpleObservation(staticPosition);
		EnemyTriggeredObservation semiRealistic = new EnemyTriggeredObservation(staticPosition);
		
		assertEquals(simple.getDestination(), staticPosition);
		assertEquals(simple.getNextPosition(), staticPosition);
		assertEquals(medium.calculateDistance(new P2d(5, 5)), new P2d(5, 5));
		assertEquals(semiRealistic.found(new P2d(2, 3)), false);
		
		System.out.println("\n\nEnd of the test.\n\n");
	}
	
	private static void assertEquals(Object expected, Object actual) {
		if(expected.equals(actual)) {
			System.out.println("Test passed.\n" + expected.toString() + " is equals to " + actual.toString());
		}else {
			System.out.println("Test not passed.\n" + expected.toString() + " is not equal to " + actual.toString());
		}
	}
}