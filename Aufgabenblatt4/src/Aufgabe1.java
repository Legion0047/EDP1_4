/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {
    
    private static void genArray(int[] filledArray){
        int value = 2;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = value;
            value += 2;
        }
    }
    
    private static void printFilteredArrayContent(int[] workArray){
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if(copiedArray[i] % 3 == 0){
                copiedArray[i] = 0;
            }
        }
        printArray(copiedArray);
    }
    
    private static void genNewArrayContent(int[] workArray){
        int[] helpArray = new int[20];
        int value = 4;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = value;
            value += 4;
        }
        workArray = helpArray;
        printArray(workArray);
    }
    
    private static void printArray(int[] workArray){
        for (int i = workArray.length; i > 0; i--) {
            System.out.print(workArray[i]+ " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] filledArray = new int[20];
        genArray(filledArray);
        printArray(filledArray);
        
        printFilteredArrayContent(filledArray);
        printArray(filledArray);
        
        filledArray[0] = 1000;
        printArray(filledArray);
        
        genNewArrayContent(filledArray);
        printArray(filledArray);
    }
    
    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    //
    //Frage 2:
    //
    //Frage 3:
    //
    //Frage 4:
    //
}

