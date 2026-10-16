package org.example;



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Hello world!
 *
 */

public class App 
{

 //   public record Point(int x, int y) { };
    public static void main( String[] args )
    {
        int x = 100;
        int y = 100;
        boolean found = false;
        int cntSteps= 0;
        Set<Point> points = new HashSet<>();
        Point point;

        System.out.println( "Hello World!" );
        int turn = 0;
        char key;
        String inputStr = "SSLSLSLSSRSRS";
        //String inputStr = "SSRSRSRS";
        for (int i = 0; i < inputStr.length(); i++) {
            if (found) break;
            key = inputStr.charAt(i);
            switch (key) {
                case 'S': point = stepRobot(x,y, turn);
                    x = point.getX();
                    y = point.getY();
                    if (points.contains(point)) {
                        found = true;
                        break;
                    }
                    points.add(point);
                    cntSteps++;
                    break;
                case 'L': if (turn == 0) turn = 270;
                else turn -= 90;
                    break;
                case 'R': turn += 90;
                    if (turn == 360)  turn = 0;
                    break;
            }

        }
        System.out.println( cntSteps );

    }

    public static Point stepRobot(int x, int y, int turn){
        Point point;
        switch (turn) {
            case 0: point = new Point(x+1, y);
                break;
            case 90: point = new Point(x, y+1);
                break;
            case 180: point = new Point(x-1, y);
                break;
            case 270: point = new Point(x, y-1);
                break;
            default: point = new Point(x, y);
        }
        return point;
    }


}
