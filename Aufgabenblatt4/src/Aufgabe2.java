/*
    Aufgabe 2) Eindimensionale Arrays und File I/O
*/
import java.awt.*;

public class Aufgabe2 {
    
    private static String[] readFileData(String fileName, int lineStart, int lineEnd) {
        In fileReader = new In(fileName);
        int arrayLength = lineEnd-lineStart+1;
        if (arrayLength<0) arrayLength=0;
        String[] lines = new String[arrayLength];
        for (int i = 0; i<lineStart;i++){
            if( fileReader.hasNextLine()) fileReader.readLine();
        }
        for (int i = 0; i<arrayLength;i++){
            if( fileReader.hasNextLine()) lines[i] = fileReader.readLine();
        }
        return lines;
    }
    
    private static void extractData(String[] dataArray, int[] resultArray, int numColumn, int entriesPerYear) {
        for (int i = 0; i<(dataArray.length/entriesPerYear);i++){
            int[] entries = new int[entriesPerYear];
            for (int j = 0; j<entriesPerYear;j++){
                String[] split = dataArray[(i*entriesPerYear+j)].split(";");
                entries[j] = Integer.parseInt(split[numColumn-1]);
            }
            int result = 0;
            for (int k = 0; k<entries.length;k++){
                result = result+entries[k];
            }
            resultArray[i]=result;
        }
    }
    
    
    private static void drawChart(int[] frostDays, int[] iceDays, int[] summerDays, int[] heatDays) {
        int width = 1230;
        int height = 500;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(-height / 2, height / 2);

        // null line
        StdDraw.setPenRadius(0.0055);
        StdDraw.setPenColor(StdDraw.GREEN);

        StdDraw.line(8,0,width-8,0);

        //y-axis
        Font font = new Font("Times", Font.PLAIN, 10);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.textLeft(8, 50, "25");
        StdDraw.textLeft(8, 100, "50");
        StdDraw.textLeft(8, 150, "75");
        StdDraw.textLeft(8, 200, "100");

        StdDraw.textLeft(8, -50, "25");
        StdDraw.textLeft(8, -100, "50");
        StdDraw.textLeft(8, -150, "75");
        StdDraw.textLeft(8, -200, "100");

        StdDraw.textRight(width-8, 50, "25");
        StdDraw.textRight(width-8, 100, "50");
        StdDraw.textRight(width-8, 150, "75");
        StdDraw.textRight(width-8, 200, "100");

        StdDraw.textRight(width-8, -50, "25");
        StdDraw.textRight(width-8, -100, "50");
        StdDraw.textRight(width-8, -150, "75");
        StdDraw.textRight(width-8, -200, "100");

        //x-axis
        int year = 79;
        for (int i = 0; i<40;i++){
            if (year==100) year = 0;
            if ((year+"").length()<2) StdDraw.textLeft(20 + (i * 30), -230, "0"+year);
            else StdDraw.textLeft(20 + (i * 30), -230, ""+year);
            year++;
        }

        //summerDays
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i<summerDays.length;i++){
            StdDraw.rectangle((30+(30*i)),summerDays[i],10,summerDays[i]);
        }

        //heatDays
        for (int i = 0; i<heatDays.length;i++){
            StdDraw.filledRectangle(30+(30*i),heatDays[i],5,heatDays[i]);
        }

        //frostDays
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 0; i<summerDays.length;i++){
            StdDraw.rectangle((30+(30*i)),-frostDays[i],10,frostDays[i]);
        }

        //iceDays
        for (int i = 0; i<heatDays.length;i++){
            StdDraw.filledRectangle(30+(30*i),-iceDays[i],5,iceDays[i]);
        }
    }
    
    public static void main(String[] args) {
        String[] rawData = new String[480];
        rawData = readFileData("weather_data.csv",290,769);

        int[] frostDays = new int[40];
        extractData(rawData,frostDays,10,12);

        int[] iceDays = new int[40];
        extractData(rawData,iceDays,11,12);

        int[] summerDays = new int[40];
        extractData(rawData,summerDays,12,12);

        int[] headDays = new int[40];
        extractData(rawData,headDays,13,12);

        drawChart(frostDays,iceDays,summerDays,headDays);
    }
}


