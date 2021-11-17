/*
 * Copyright 2021 ilyriadz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ilyriadz.solutions;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ilyriadz
 */
public class ReverseNumber
{
    public static void main(String[] args)
    {
        final var NUMBER = nextPositiveInt(); 
        
        int currentFragment;
        var currentNumber = Integer.MAX_VALUE;
        
        var divideDenominator = 1;
        var modulusDenominator = 10;
        
        while (currentNumber > 10)
        {
            divideDenominator *= 10;
            currentNumber = NUMBER / divideDenominator;
        } // end while
        
        currentNumber = NUMBER;
        var mulNumber = divideDenominator;
        var reversedNumber = 0;
        
        while (modulusDenominator <= divideDenominator)
        {           
            currentFragment = currentNumber % 10;
            currentNumber /= 10;
            modulusDenominator *= 10;
            currentFragment *= mulNumber;
            mulNumber /= 10;
            reversedNumber += currentFragment;
        } // end
        
        reversedNumber += NUMBER / divideDenominator;
        
        System.out.println(reversedNumber);      
    }
    
    public static int nextPositiveInt()
    {
        var sc = new Scanner(System.in);
        int number;
        
        while (true)
        {
            try 
            {
                System.out.print("enter an integer to reverse: ");
                number = sc.nextInt();
                if (String.valueOf(number).contains("0"))
                {
                    System.err.println(
                        "number entered contains zero(s) '" + number + "'");
                    throw new InputMismatchException();
                    
                }
                else if (number < 10 && number >= 0)
                {
                    System.err.println("number must have two digits or more");
                    throw new InputMismatchException();
                }
                else if (number < 0)
                {
                    System.err.println("number must be positive");
                    throw new InputMismatchException();
                }
                
                return number < 0 ? number * -1 : number;
            } 
            catch (InputMismatchException e) 
            {
                sc.nextLine();
            }
        } // end while
    }
}
