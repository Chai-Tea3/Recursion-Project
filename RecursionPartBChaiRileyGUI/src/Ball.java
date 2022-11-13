/*
 * Author: Riley Chai
 * Class: ICS4U
 * Program: Recursion Assignment Part B GUI
 */

import java.util.ArrayList;

/**
 *
 * @author 335480661
 */
public class Ball {

    private ArrayList<Double> xyCoordinate = new ArrayList<>();

    public Ball() {
    }

    public double halfDistance(double startDist, double curDist, ArrayList<Double> xyCoordinate, double percentJump) {
        if (startDist <= 5) {//Base case: When the jump distance is less than 5.
            return 1;
        } else {
            double xValue = curDist;//Sets the starting x-value to the current distance.
            double startPoint = curDist;//Sets the start point for the jump to the current distance.

            curDist += startDist * percentJump;//Calculates the new current distance.

            double endPoint = curDist;//Sets the end point for the jump to the new current distance.
            double xIncrement = (endPoint - startPoint) / 20;//Increment is equal to the distance between the start and end point divided by 20. (To create 20 points for each jump)

            if (xIncrement > 1) {//Only calculates the points if the increment is greater than 1.
                calculateXY(xValue, xIncrement, startPoint, endPoint, xyCoordinate);//Calculates the points for the jump.
            }

            return curDist + halfDistance(startDist * (1 - percentJump), curDist, xyCoordinate, percentJump);//Recursive call. Updates the starting distance.
        }
    }
    
    /* //Part 1
    public static double halfDistance(double startDist, double curDist, int maxBounces) {
        if (maxBounces >= 10) {//Base case: When the number of bounces is greater than 10.
            return 1;
        } else {
            curDist += startDist / 2;//Calculates the new current distance.
            System.out.println(curDist);//Displays the remaining distance.
            return curDist + halfDistance(startDist / 2, curDist, maxBounces + 1);//Recursive call. Updates the starting distance, Increases maxBounces.
        }
    } */
   
    public ArrayList<Double> calculateXY(double xValue, double xIncrement, double startPoint, double endPoint, ArrayList<Double> xyCoordinate) {
        if (xValue > endPoint) {//Base case: When the x-value is greater than the end point of the jump.
            setBallXY(xyCoordinate);//Updates the ArrayList with the coordinates for the jump.
            return xyCoordinate;//Returns the ArrayList so the points for the next jump will be appended to the the ArrayList.
        } else {           
            double yValue = -0.01 * (xValue - startPoint) * (xValue - endPoint);//Calculates the y-value.
            
            //Adds the x and y values to the ArrayList.
            xyCoordinate.add(xValue);
            xyCoordinate.add(yValue);

            return calculateXY(xValue + xIncrement, xIncrement, startPoint, endPoint, xyCoordinate);//Recursive call. Increases the x-value by the previously calculated increment. 
        }
    }
   
    /* //Part 2
    public static double calculateXY(double xValue, double xIncrement, double startPoint, double endPoint) {
        if (xValue > endPoint) {//Base case: When the x-value is greater than the end point.
            return 1;
        } else {
            double yValue = -0.1 * (xValue - startPoint) * (xValue - endPoint);//Calculates the y-value.
            System.out.println(xValue + ", " + yValue);//Prints out the x and y values.
            return calculateXY(xValue + xIncrement, xIncrement, startPoint, endPoint);//Recursive call. Increases the x-value by the previously calculated increment. 
        }
    } */
    
    /* //Part 3
    public static ArrayList<Double> calculateXY(double xValue, double xIncrement, double startPoint, double endPoint,ArrayList<Double> coordinates) {
        if (xValue > endPoint) {//Base case: When the x-value is greater than the end point of the jump.
            return coordinates;//Returns the ArrayList of coordinates.
        } else {
            double yValue = -0.1 * (xValue - startPoint) * (xValue - endPoint);//Calculates the y-value.

            //Adds the x and y values to the ArrayList.
            coordinates.add(xValue);
            coordinates.add(yValue);
    
            return calculateXY(xValue + xIncrement, xIncrement, startPoint, endPoint,coordinates);//Recursive call. Increases the x-value by the previously calculated increment. 
        }
    } */
  
    /* //Part 4
    public static ArrayList<Double> calculateXY(double xValue, double xIncrement, double startPoint, double endPoint,ArrayList<Double> coordinates) {
        if (xValue > 1) {//Base case will happen on the second call.
            return coordinates;//Returns the ArrayList.
        } else {
            double yValue = -0.1 * (xValue - startPoint) * (xValue - endPoint);//Calculates the y-value.
    
            //Adds the x and y values to the ArrayList.
            coordinates.add(xValue);
            coordinates.add(yValue);
            return calculateXY(xValue + xIncrement, xIncrement, startPoint, endPoint,coordinates);//Recursive call. Increases the x-value by the previously calculated increment. 
        }
    } */
    
    /* //Part 5
    public static ArrayList<Double> calculateXY(double xValue, double xIncrement, double startPoint, double endPoint,ArrayList<Double> coordinates) {
        if (xValue > endPoint) {//Base case: When the x-value is greater than the end point of the jump.
            return coordinates;//Updates the ArrayList with the coordinates for the jump.
        } else {
            double yValue = -0.2 * (xValue - startPoint) * (xValue - endPoint);//Calculates the y-value.
    
            //Adds the x and y values to the ArrayList.
            coordinates.add(xValue);
            coordinates.add(yValue);
    
            //System.out.println(xValue + ", " + yValue);//Displays all (x,y) values.

            return calculateXY(xValue + xIncrement, xIncrement, startPoint, endPoint,coordinates);//Recursive call. Increases the x-value by the previously calculated increment.
        }
    } */
    
    /* //Part 6
    for (int i = 1; i < coordinates.size(); i += 2) {//Loops through the ArrayList of coordinates. Increases by 2 since we only want y-values.
        for (int j = 0; j < coordinates.get(i); j++) {//Prints out a horizontal bar proportional to the y-value.
            System.out.print("*");
        }
        System.out.println("*");
    } */
   
    /**
     * Fills the ArrayList with coordinates.
     *
     * @param xyCoordinate A double type ArrayList that holds the XY coordinates
     * for the ball.
     */
    public void setBallXY(ArrayList<Double> xyCoordinate) {
        this.xyCoordinate = xyCoordinate;//Updates the ArrayList with the xy coordinates.
    }

    /**
     * Resets the ArrayList.
     */
    public void resetBallXY() {
        xyCoordinate.clear();//Clears the ArrayList.
    }

    /**
     * Returns the ArrayList of coordinates.
     *
     * @return xyCoordinate
     */
    public ArrayList<Double> getBallXY() {
        return xyCoordinate;
    }
}
