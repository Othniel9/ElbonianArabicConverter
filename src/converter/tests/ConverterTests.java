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

    // Arabic to Elbonian
    @Test
    public void ArabicToElbonianMinNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianMaxNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("3999");
        assertEquals(eaTest2.toElbonian(), "MMMmMcCxX");
    }

    @Test
    public void ArabicToElbonianTensTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("13");
        assertEquals(eaTest2.toElbonian(), "XIII");
    }

    @Test
    public void ArabicToElbonianHundredsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("366");
        assertEquals(eaTest2.toElbonian(), "CCCLXVI");
    }

    @Test
    public void ArabicToElbonianThousandsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("2442");
        assertEquals(eaTest2.toElbonian(), "MMdDlLII");
    }

    @Test
    public void ArabicToElbonianSimpleNumber1Test() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("1949");
        assertEquals(eaTest2.toElbonian(), "MmMlLxX");
    }

    @Test
    public void ArabicToElbonian3Test() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest2 = new ElbonianArabicConverter("1333");
        assertEquals(eaTest2.toElbonian(), "MCCCXXXIII");
    }

    @Test
    public void ArabicToElbonianSimpleNumber2Test() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("100");
        assertEquals(eaTest1.toElbonian(), "C");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ArabicToElbonianZeroTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("0");
        eaTest1.toElbonian();
    }

    //Elbonian TO Arabic test cases

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

    @Test
    public void  ElbonianToArabicLowerCasesInBeginingTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("mMlL");
        assertEquals(eaTest1.toArabic(),940);

    }
    @Test
    public void  ElbonianToArabicLowerCasesInMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MdDV");
        assertEquals(eaTest1.toArabic(),1405);
    }
    @Test
    public void  ElbonianToArabicLowerCasesAtTheEndTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("DCvV");
        assertEquals(eaTest1.toArabic(),604);

    }
    @Test
    public void  ElbonianToArabicUpperCasesTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MDXI");
        assertEquals(eaTest1.toArabic(),1511);

    }

    // Exceptions

    //New Rules added by Wong
//    formatArray.add("mMD");
//        formatArray.add("mMC");
//        formatArray.add("cCL");
//        formatArray.add("cCX");
//        formatArray.add("xXV");
//        formatArray.add("xXI");
//        formatArray.add("dDC");
//        formatArray.add("lLX");
//        formatArray.add("vVI");

    @Test (expected = MalformedNumberException.class)
    public void mMDTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("mMD");
    }

    @Test (expected = MalformedNumberException.class)
    public void mMCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("mMC");
    }

    @Test (expected = MalformedNumberException.class)
    public void cCLTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("cCL");
    }

    @Test (expected = MalformedNumberException.class)
    public void cCXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("cCX");
    }

    @Test (expected = MalformedNumberException.class)
    public void xXVTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("xxV");
    }

    @Test (expected = MalformedNumberException.class)
    public void xXITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("xXI");
    }

    @Test (expected = MalformedNumberException.class)
    public void dDCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("dDC");
    }

    @Test (expected = MalformedNumberException.class)
    public void lLXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("lLX");
    }

    @Test (expected = MalformedNumberException.class)
    public void vVITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("vVI");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ElbonianToArabicNegativeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("-1");
        eaTest1.toElbonian();
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void ElbonianToArabicOverMaxTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("4000");
        eaTest1.toElbonian();
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabic4MTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MMMM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicLowerLimitTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("mMmM");
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicLowerITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("i");
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

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("0");
    }

    @Test (expected = MalformedNumberException.class)
    public void illegalCharTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("MAD");
    }

    @Test (expected = MalformedNumberException.class)
    public void illegalCharTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("W54");
    }

    @Test(expected = NumberFormatException.class)
    public void ArabicToElbonianSpacesOnlyTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("  ");
    }

    @Test(expected = NumberFormatException.class)
    public void ArabicToElbonianEmptyStringTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("");
    }

    // Whitespace Test
    @Test
    public void  ArabicToElbonianSpacesInFrontTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter(" 84");
        assertEquals(eaTest1.toElbonian(),"LXXXvV");

    }

    @Test
    public void  ElbonianToArabicSpacesAtEndTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter(" M   ");
        assertEquals(eaTest1.toArabic(),1000);

    }


    @Test(expected = MalformedNumberException.class)
    public void  ElbonianToArabicSpacesInMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter eaTest1 = new ElbonianArabicConverter("1 5");
    }

    // TODO Add more test cases
}
