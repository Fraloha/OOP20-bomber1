//package bomberOne.model.observation;
//
//import bomberOne.model.common.P2d;
//
//public class BasicTestPerception {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        P2d staticPosition = new P2d(10, 10);
//        EnemyObservation simple = new EnemyObservation(staticPosition);
//        EnemySimpleObservation medium = new EnemySimpleObservation(staticPosition);
//        EnemyTriggeredObservation semiRealistic = new EnemyTriggeredObservation(staticPosition);
//
//        assertEquals(simple.getDestination(), staticPosition, "[ TEST 1 ]");
//        assertEquals(medium.calculateDistance(new P2d(5.0, 5.0)), new P2d(5.0, 5.0), "[ TEST 2 ]");
//        assertEquals(semiRealistic.found(new P2d(2, 3)), false, "[ TEST 3 ]");
//
//        System.out.println("\n\nEnd of the test.\n\n");
//    }
//
//    private static void assertEquals(Object expected, Object actual, String formatString) {
//        if (expected.equals(actual)) {
//            System.out.println(formatString.toString() + " Test passed.\n" + expected.toString() + " is equals to "
//                    + actual.toString());
//        } else {
//            System.out.println("Test not passed.\n" + expected.toString() + " is not equal to " + actual.toString());
//        }
//    }
//}