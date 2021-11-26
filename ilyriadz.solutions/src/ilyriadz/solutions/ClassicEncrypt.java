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

/**
 *
 * @author ilyriadz
 */
public class ClassicEncrypt 
{
    public final static char[] ALPHABET = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
        'u', 'v', 'w', 'x', 'y', 'z'};
    
    public int pos(char c)
    {
        int pos = -1;
        
        for (int i = 0; i < ALPHABET.length; i++) 
        {
            if (c == ALPHABET[i])
            {
                pos = i;
                break;
            } // end if
        }
        
        return pos;
    }
    
    public int newPos(int pos, int n)
    {
        int newPos = pos + n;
        
        if (newPos >= 0 && newPos < ALPHABET.length)
            return newPos;
        else if (newPos < 0)
            return ALPHABET.length + newPos;
        else
            return newPos % ALPHABET.length;
    }
    
    public String encrypt(String str, int n)
    {
        char[] encrypt = new char[str.length()];
        
        for (int i = 0; i < str.length(); i++) 
        {
            int pos = pos(str.charAt(i));
            int newPos = newPos(pos, n);
            
            encrypt[i] = ALPHABET[newPos];
        } // end for
        
        return new String(encrypt);
    }
    
    public String decrypt(String str, int n)
    {
        char[] decrypt = new char[str.length()];
        
        for (int i = 0; i < str.length(); i++) 
        {
            int pos = pos(str.charAt(i));
            int newPos = newPos(pos, -n);
            
            decrypt[i] = ALPHABET[newPos];
        } // end for
        
        return new String(decrypt);
    }
    
    public static void main(String[] args) 
    {
        String ilyriadz = "ilyriadz";

        ClassicEncrypt ce = new ClassicEncrypt();
        
        String encrypt = ce.encrypt(ilyriadz, 5);
        System.out.println("'" + ilyriadz + "' encrypted to '" + encrypt + "'");
        
        String decrypt = ce.decrypt(encrypt, 5);
        
        System.out.println("'" + encrypt + "' decrypted to '" + decrypt + "'");
    }
}
