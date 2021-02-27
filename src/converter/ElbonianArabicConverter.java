package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.Locale;


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

        try{
            arabicCheck(number);
        }catch(NumberFormatException e){
            //elbonianCheck(number);
        }
        this.number = number;


    }
    private void arabicCheck(String arabicNumber) throws ValueOutOfBoundsException {
        int num = Integer.parseInt(arabicNumber);
        if((0 < num) && (num <= 3999)) {
            System.out.println("Valid Arabic Number within Range");
        } else {
            throw new ValueOutOfBoundsException("Invalid Number" + arabicNumber + "needs to be greater than 0 and less than or equal to 3999");
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
     *
     *
     */
    //upper case of the same letter can not follow its lowercase
    private void UpperAfterLower(String elbonianNumber) throws MalformedNumberException{
//        int mCount = 0;
//        int cCount = 0;
//        int xCount = 0;
//        int dCount = 0;
//        int lCount = 0;
//        int vCount = 0;
//        for(Character C: elbonianNumber.toCharArray());
//        char C =0;
//        if(C == 'm') mCount++;
//        if(C == 'c') mCount++;
//        if(C == 'x') mCount++;
//        if(C == 'd') mCount++;
//        if(C == 'l') mCount++;
//        if(C == 'v') mCount++;

        for (int i = 0; i<elbonianNumber.length(); i++){
            if(Character.isLowerCase(elbonianNumber.charAt(i))){
                if (Character.isUpperCase(elbonianNumber.charAt(i+1))){

                }

            }
        }


    }
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
