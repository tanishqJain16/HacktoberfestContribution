import java.util.Scanner;

public class CryptoGraded1 {
    
    public static String repeatedKey(String pt,String key2){
        for(int i=0; i<pt.length(); i++) {
            if(key2.length() == pt.length()){
                break;
            }
            key2 = key2 + key2.charAt(i);
        }  
        return key2;
    }

    public static String VigenereCipher(String pt, String newKey2){
        String x = "abcdefghijklmnopqrstuvwxyz";
        String EncryptStr = "";

        for(int i=0; i<pt.length(); i++) {
            int pt_pos = x.indexOf(pt.charAt(i));
            int k_pos = x.indexOf(newKey2.charAt(i));
            int EncryptPos = (k_pos + pt_pos) % 26;   
            char EncryptChar = x.charAt(EncryptPos);   
              
            // adding encrypted char to encrypted string   
            EncryptStr += EncryptChar;  
        }
        return EncryptStr;     
    }
    public static String CaeserCipher(String pt,int key1 ){
            String x = "abcdefghijklmnopqrstuvwxyz";
            String EncryptStr = "";

            for(int i=0; i<pt.length(); i++) {
                int pt_pos = x.indexOf(pt.charAt(i));
                int EncryptPos = (pt_pos + key1) % 26;                                                                                                                                                 
                char EncryptChar = x.charAt(EncryptPos);   

                 // adding encrypted char to encrypted string   
                EncryptStr += EncryptChar;  
            }
            return EncryptStr;
    }
    public static String CaeserDecrypt(String FinalEncrypt, int key1){    
        String x="abcdefghijklmnopqrstuvwxyz";  
        String DecryptStr = "";  

        for (int i = 0; i < FinalEncrypt.length(); i++)   
        {   
            int pos = x.indexOf(FinalEncrypt.charAt(i));
               
            int DecryptPos = (pos - key1 ) % 26;   
        
            if (DecryptPos < 0){   
                DecryptPos = x.length() + DecryptPos;   
            }   
            char DecryptChar = x.charAt(DecryptPos);      
            DecryptStr += DecryptChar;   
        }                                                                                                                                                                                                                                                                                                                                                                                                                           
        return DecryptStr;   
    } 

    public static String VigenereDecrypt(String ct, String newKey2){    
        String x="abcdefghijklmnopqrstuvwxyz";   
        String DecryptStr = "";      

        for (int i=0; i<ct.length(); i++)   
        {   
            int ct_pos = x.indexOf(ct.charAt(i));
            int k_pos=x.indexOf(newKey2.charAt(i));     
            int DecryptPos = (ct_pos - k_pos) % 26;   
        
            if (DecryptPos < 0){   
                DecryptPos = x.length() + DecryptPos;   
            }   
            char DecryptChar = x.charAt(DecryptPos);      
            DecryptStr += DecryptChar;   
        }                                                                                                                                                                                                                                                                                                                                                                                                                           
        return DecryptStr;   
    }   
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter plaintext: ");
        String plainText=sc.next();
        System.out.print("\nEnter first key in numeric value: ");
        int key1 = sc.nextInt();aa
        System.out.print("\nEnter second key: ");
        String key2 = sc.next();
        String newKey2 = repeatedKey(plainText, key2);
        System.out.println("New Key for Vigenere Cipher: "+newKey2);

        String VigEncrypt = VigenereCipher(plainText,newKey2);
        String FinalEncrypt = CaeserCipher(VigEncrypt,key1);
        System.out.println("\nEncrypted String : "+ FinalEncrypt);

        System.out.println("Decrypted String: "+VigenereDecrypt(CaeserDecrypt(FinalEncrypt,key1),newKey2));

    }
}