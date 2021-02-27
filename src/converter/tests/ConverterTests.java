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



    //Arabic to elbanian Testcases
    @Test
    public void ArabicToElbonianMinNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianMaxNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("3999");
        assertEquals(eaTest2.toElbonian(), "MMMDCCCLXXXVIII");
    }

    @Test
    public void ArabicToElbonianSimpleNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("100");
        assertEquals(eaTest1.toElbonian(), "C");
    }

    @Test
    public void ArabicToElbonianNullTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("");
        assertEquals(eaTest1.toElbonian(), "");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ArabicToElbonianZeroTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("0");

    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ArabicToElbonianNegativeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("-1");

    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ArabicToElbonianOverMaxTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("3999");

    }

    @Test (expected = MalformedNumberException.class)
    public void ArabicToElbonian4MTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MMMM");

    }

    @Test (expected = MalformedNumberException.class)
    public void ArabicToElbonianDoubleDLVTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DDLLVV");

    }

    @Test (expected = MalformedNumberException.class)
    public void ArabicToElbonianOutOfOrderTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("LMMM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ArabicToElbonian2DTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DdD");

    }

    @Test (expected = MalformedNumberException.class)
    public void ArabicToElbonianCapLowTwiceTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("CcCC");

    }






    //Elbonian TO Arabic test cases
    @Test
    public void  ElbonianToArabicZeroTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter(" ");
        assertEquals(eaTest1.toArabic(),0);
    }

    @Test
    public void ElbonianToArabicMinumTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }
    @Test
    public void  ElbonianToArabicMaxNumTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMmMcCxX");
        assertEquals(converter.toArabic(), 3999);
    }
    @Test (expected = MalformedNumberException.class)
    public void  ElbonianToArabic4MTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("4000");

    }

    @Test
    public void  ElbonianToArabicLowerCasesInBeginingTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("mMD");
        assertEquals(eaTest1.toArabic(),1400);

    }
    @Test
    public void  ElbonianToArabicLowerCasesInMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MdDV");
        assertEquals(eaTest1.toArabic(),1405);
    }
    @Test
    public void  ElbonianToArabicLowerCasesAtTheEndTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DCvV");
        assertEquals(eaTest1.toArabic(),605);

    }
    @Test
    public void  ElbonianToArabicUpperCasesTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MDXI");
        assertEquals(eaTest1.toArabic(),);

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
