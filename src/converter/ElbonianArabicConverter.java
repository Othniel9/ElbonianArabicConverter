package converter;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


// Carley Gilmore and Othniel Bondah - TeamI


/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        if(number.trim().length() == 0){
            throw new NumberFormatException("Cannot input an empty string");
        }
        // TODO check to see if the number is valid, then set it equal to the string
        try{
            arabicCheck(number.trim());
        }catch(NumberFormatException e){
            elbonianCheck(number);
        }
        this.number = number.trim();
    }

    // Error handling for incorrect formatting/value of an Arabic or Elbonian input

    private void arabicCheck(String arabicNumber) throws ValueOutOfBoundsException {
        int num = Integer.parseInt(arabicNumber);
        if((0 < num) && (num <= 3999)) {
            System.out.println("Valid Arabic Number within Range");
        } else {
            throw new ValueOutOfBoundsException("Invalid Number" + arabicNumber + "needs to be greater than 0 and less than or equal to 3999");
        }
    }

    private void elbonianCheck(String elbonianNumber) throws MalformedNumberException {
        String formatterString = "\\s*?M{0,3}(mM)?(|D|dD)C{0,3}(cC)?(|L|lL)X{0,3}(xX)?(|V|vV)I{0,3}\\s*?";
        if(!Pattern.matches(formatterString,elbonianNumber)){
            throw new MalformedNumberException("Input "+ elbonianNumber + " is of invalid form");
        }
        ArrayList<String> formatArray = new ArrayList<String>();
        formatArray.add("mMD");
        formatArray.add("mMC");
        formatArray.add("cCL");
        formatArray.add("cCX");
        formatArray.add("xXV");
        formatArray.add("xXI");
        formatArray.add("dDC");
        formatArray.add("lLX");
        formatArray.add("vVI");

        for(int i =0; i < formatArray.size(); i++){
            if(elbonianNumber.contains(formatArray.get(i))) {
                throw new MalformedNumberException("Input " + elbonianNumber + " is of invalid form");
            }
        }
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        try {
            return Integer.parseInt(this.number);
        }catch (NumberFormatException n){

        }
        int AraNum = 0;
        for(int i = 0; i< this.number.length(); i++){
            char c = this.number.charAt(i);
            switch (c){
                case 'M' :
                    AraNum += 1000;
                    break;

                case 'm':
                    i++;
                    AraNum += 900;
                    break;


                case 'D':
                    AraNum += 500;
                    break;
                case 'd':
                    i++;
                    AraNum += 400;
                    break;


                case 'C':
                    AraNum += 100;
                    break;

                case 'c':
                    i++;
                    AraNum += 90;
                    break;

                case 'L':
                    AraNum += 50;
                    break;

                case 'l':
                    AraNum += 40;
                    i++;
                    break;

                case 'X':
                    AraNum += 10;
                    break;

                case 'x':
                    i++;
                    AraNum += 9;
                    break;

                case 'V':
                    AraNum += 5;
                    break;
                case 'v':
                    AraNum += 4;
                    i++;
                    break;
                case 'I':
                    AraNum += 1;
                    break;

                default:
                    System.out.println(c + "Invalid number");
            }

        }
        return AraNum;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // String that will be altered based on the number value
        String returnString = new String();
        // Check if the value that is entered is an arabic integer and not already Elbonian
        int arabicVal;
        try {
            arabicVal = Integer.parseInt(this.number);
        } catch (NumberFormatException e) {
            return this.number;
        }

        int letterCount = 0; //track if the letter count exceeds 3 in a row
        while (arabicVal >= 1000 && letterCount < 3) { //remove 1000 for every M added to the returnString
            letterCount++;
            arabicVal -= 1000;
            returnString += "M";
        }
        while (arabicVal >= 900) { //remove 900 for every mM added to the returnString
            letterCount++;
            arabicVal -= 900;
            returnString += "mM";
        }
        letterCount = 0;
        while (arabicVal >= 500 && letterCount < 1 && !returnString.contains("mM")) { //remove 500 for every D added to the returnString
            letterCount++;
            arabicVal -= 500;
            returnString += "D";
        }
        while (arabicVal >= 400) { //remove 400 for every dD added to the returnString
            letterCount++;
            arabicVal -= 400;
            returnString += "dD";
        }
        letterCount = 0;
        while (arabicVal >= 100 && letterCount < 3 && !returnString.contains("dD")) { //remove 100 for every C added to the returnString
            letterCount++;
            arabicVal -= 100;
            returnString += "C";
        }
        while (arabicVal >= 90) { //remove 90 for every cC added to the returnString
            letterCount++;
            arabicVal -= 90;
            returnString += "cC";
        }
        letterCount = 0;
        while (arabicVal >= 50 && letterCount < 1) { //remove 50 for every L added to the returnString
            letterCount++;
            arabicVal -= 50;
            returnString += "L";
        }
        while (arabicVal >= 40) { //remove 40 for every lL added to the returnString
            letterCount++;
            arabicVal -= 40;
            returnString += "lL";
        }
        letterCount = 0;
        while (arabicVal >= 10 && letterCount < 3 && !returnString.contains("lL")) { //remove 10 for every X added to the returnString
            letterCount++;
            arabicVal -= 10;
            returnString += "X";
        }
        while (arabicVal >= 9) { //remove 9 for every xX added to the returnString
            letterCount++;
            arabicVal -= 9;
            returnString += "xX";
        }
        letterCount = 0;
        while (arabicVal >= 5 && letterCount < 1) { //remove 5 for every V added to the returnString
            arabicVal -= 5;
            returnString += "V";
        }
        while (arabicVal >= 4) { //remove 4 for every vV added to the returnString
            letterCount++;
            arabicVal -= 4;
            returnString += "vV";
        }
        letterCount = 0;
        while (arabicVal >= 1 && letterCount < 3 && !returnString.contains("vV")) { //remove 4 for every vV added to the returnString
            letterCount++;
            arabicVal -= 1;
            returnString += "I";
        }

        return returnString;
        }

    }


