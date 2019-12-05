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
            System.out.print(workArray[i-1]+ " ");
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
    //Frage 1: array.length =/= index, array[array.length] = indexOutOfBoundsException
    //
    //Frage 2: weil die adresse des Arrays übergeben wird und als solches das außerhalb der Methode und übergebene Array bearbeitet wird.
    //
    //Frage 3: weil sowohl copiedArray als auch workArray/filledArray die gleiche adresse haben, da copiedArray = workArray/filledArray und copiedArray als solches kein "eigenes" Array ist
    //
    //Frage 4:
    //

    /*
    1. Welchen Datentyp muss der Indexausdruck haben, mit dem die Position in einem Array bestimmt wird?
    Int
    2. Müssen Sie ein Array initialisieren?
    nein.
    3. Wie kann die Länge eines Arrays verändert werden?
    technisch gesehen, gar nicht, realistisch kann man inhalte auf ein neues array kopieren, und dann die Adresse des hilfs arrays dem start array zuweisen.
    4. Wie gehen Sie vor, wenn Sie ein int-Array kopieren müssen?
    int[] newInt = new int[oldInt.length];
    for(int i = 0; i<oldInt.length; i++) newInt[i] = oldInt[i];
    5. Beginnt die Indexzählung eines Arrays immer bei 0?
    ja, außer das array hat length 0
    6. Ist es sinnvoll, zwei Arrays mit "==" zu vergleichen? Was passiert im Detail, bei einem Vergleich mit "=="?
    Machmal. Die pointer/Adressen der beiden Arrays werden verglichen.
     */
}

