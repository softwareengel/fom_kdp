package de.fom.kdp.ml.kap3;

public class A3_2ML {
    
        public static void main(String[] args) {
            // Step 1: Create two StringBuffer objects
            StringBuffer sb1 = new StringBuffer("Super Java!");
            StringBuffer sb2 = new StringBuffer("30");
    
            // Step 2: Create a third variable sb3 and point it to sb1
            StringBuffer sb3 = sb1;
            System.out.println(sb3); // Output: Super Java!
    
            // Step 3: Define an int variable named summe
            int summe = 20 + Integer.parseInt(sb2.toString());
            System.out.println(summe); // Output: 50
    
            // Step 4: Extend sb2 and point sb3 to sb2
            sb2.append(" Grad warmes Wasser");
            sb3 = sb2;
            System.out.println(sb3); // Output: 30 Grad warmes Wasser
        }
    
}
