package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicMinNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ElbonianToArabicMaxNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("3888");
        assertEquals(eaTest2.toElbonian(), "MMMDCCCLXXXVIII");
    }

    @Test
    public void ElbonianToArabicSimpleNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("100");
        assertEquals(eaTest1.toElbonian(), "C");
    }

    @Test
    public void ElbonianToArabicNullTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("");
        assertEquals(eaTest1.toElbonian(), "");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ElbonianToArabicZeroTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("0");
        eaTest1.toElbonian();
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ElbonianToArabicNegativeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("-1");
        eaTest1.toElbonian();
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ElbonianToArabicOverMaxTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("3889");
        eaTest1.toElbonian();
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabic4MTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MMMM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicDoubleDLVTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DDLLVV");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicOutOfOrderTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("LMMM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabic2DTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DdD");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicCapLowTwiceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("CcCC");
    }

    


    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
}
