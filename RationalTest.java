import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }
    
    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) )
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    //Adds 11 test cases below
    
    public void testPlus(){
        
        //Test for negative and positive
        Rational a = new Rational(1,4);
        Rational b = new Rational(1,-2);
        assertEquals(a.plus(b),new Rational(1,-4));
        //Test for positive
        Rational c = new Rational(1,2);
        assertEquals(c.plus(a),new Rational(3,4));
        //Test for negative
        Rational d = new Rational(-1,4);
        assertEquals(d.plus(b),new Rational(-3,4));
    
    }
    
    public void testMinus(){
        
        //Test for negative and positive
        Rational a = new Rational(1,4);
        Rational b = new Rational(1,-2);
        assertEquals(a.minus(b),new Rational(3,4));
        //Test for positive
        Rational c = new Rational(1,2);
        assertEquals(a.minus(c),new Rational(-1,4));
        //Test for negative
        Rational d = new Rational(-1,4);
        assertEquals(d.minus(b),new Rational(1,4));
    }
    
    public void testzeroEquals(){
        assertEquals(new Rational(0,3),new Rational(0,6));
        assertEquals(new Rational(0,3),new Rational(0,-6));
        assertEquals(new Rational(0,-3),new Rational(0,-6));
    }
    
    public void testTimes(){
        //Test for negative and positive
        Rational a = new Rational(1,4);
        Rational b = new Rational(1,-2);
        assertEquals(a.times(b),new Rational(1,-8));
        //Test for positive
        Rational c = new Rational(1,2);
        assertEquals(a.times(c),new Rational(1,8));
        //Test for negative
        Rational d = new Rational(-1,4);
        assertEquals(d.times(b),new Rational(1,8));
    }
    
    public void testDevides(){
        Rational a = new Rational(-1,4);
        Rational b = new Rational(0,5);
        assertEquals(a.divides(b),new Rational(6,0));
    }
    
    public void testAbs(){
        
        Rational a = new Rational(-1,4);
        Rational b = new Rational(2,-8);
        assertEquals(a.abs(),b.abs());
    }
    
    public void testIsLessThan(){
        
        Rational a = new Rational(1,16);
        Rational ref = new Rational(1,4);
        Rational b = null;
        try {
            b = a.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( b.isLessThan( ref.plus( Rational.getTolerance() ) )
                   && ref.minus( Rational.getTolerance() ).isLessThan( b ) );
    }
    
    public void testNegIsLessThan(){
        Rational neg1 = new Rational(-2,5);
        Rational neg2 = new Rational(-3,5);
        assertTrue(neg2.isLessThan(neg1));
    }
    
    public void testoIsLessThan(){
        Rational neg1 = new Rational(-2,5);
        Rational pos1 = new Rational(3,5);
        assertFalse(pos1.isLessThan(neg1));
    }
    
    public void testTolerance(){
        
        Rational a = new Rational(1,2);
        assertTrue(a.isLessThan(a.plus(Rational.getTolerance())));
        assertTrue(a.minus(Rational.getTolerance()).isLessThan(a));
        // Beyond tolerance should be equalls
        Rational ref = Rational.getTolerance();
        Rational b = new Rational(4,1);
        assertTrue(a.minus(ref.divides(b)).equals(a));
        Rational newtol = new Rational(1,400);
        Rational.setTolerance(newtol);
        assertEquals(new Rational(1,400),Rational.getTolerance());
        
    }
    public void testEquals(){
        Rational a = new Rational(0,2);
        Rational b = new Rational(0,-4);
        assertTrue(a.equals(b));
        
    }
    public void testSetTolerance(){
        Rational newref = new Rational(1,2000);
        Rational.setTolerance(newref);
        assertEquals(new Rational(1,2000),Rational.getTolerance());
    }
    public void testNegRoot(){
        Rational a = new Rational(1,-4);
        Rational b = null;
        try {
            b = a.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertFalse( b.isLessThan( HALF.plus( Rational.getTolerance() ) )
                   && HALF.minus( Rational.getTolerance() ).isLessThan( b ) );
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
