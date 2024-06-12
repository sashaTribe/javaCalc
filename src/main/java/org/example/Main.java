package org.example;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> paintCoverage = new HashMap<String, Integer>();
        Double[] duluxTinAmount = {2.5};
        Integer[] crownTinAmount = {1,5};
        Integer[] graphenTinAmount = {1,10};
        //paintCoverage.put("Farrow & Ball", 12);
        paintCoverage.put("Dulux", 16);
        paintCoverage.put("Crown", 16);
        //paintCoverage.put("Little Greene", 14);
        paintCoverage.put("Graphenstone", 18);
        //ask for height of wall

        System.out.println("What is the height of your wall?");
        double height = scan.nextDouble();

        //ask for width
        System.out.println("What is the width of your wall?");
        double width = scan.nextDouble();

        //ask for color
        System.out.println("What brand do you want to use?");
        String brand = scan.next();

        double areaOfWall = convertCm2ToM2(calcArea(width, height));
        System.out.print("Hello");
        int coverage = 0;
        double amountOfPaintNeeded = 0;
        HashMap<Double, Integer> tinsAmount = new HashMap<Double,Integer>();
        switch (brand) {
            /*
            case "Farrow & Ball":
                coverage = paintCoverage.get("Farrow & Ball");
                break;

             */
            case "Crown":
                coverage = paintCoverage.get("Crown");
                amountOfPaintNeeded = calcNumOfLitresNeeded(areaOfWall, coverage);
                for (int i=0; i < crownTinAmount.length; i++){
                    tinsAmount.put((double) crownTinAmount[i], getNumOfTins(crownTinAmount[i], amountOfPaintNeeded));
                }
                break;
                /*
                case "Little Greene":
                coverage = paintCoverage.get("Little Greene");
                break;
                * */
            case "Dulux":
                coverage = paintCoverage.get("Dulux");
                amountOfPaintNeeded = calcNumOfLitresNeeded(areaOfWall, coverage);
                for (int i=0; i < duluxTinAmount.length; i++){
                    tinsAmount.put((double) duluxTinAmount[i], getNumOfTins(duluxTinAmount[i], amountOfPaintNeeded));
                }
                break;
            case "Graphenstone":
                coverage =paintCoverage.get("Graphenstone");
                amountOfPaintNeeded = calcNumOfLitresNeeded(areaOfWall, coverage);
                for (int i=0; i < crownTinAmount.length; i++){
                    tinsAmount.put((double) graphenTinAmount[i], getNumOfTins(graphenTinAmount[i], amountOfPaintNeeded));
                }
                break;
            default:
                System.out.println("Painting brand unavailable");
        }



        System.out.println("The brand chosen is " + brand);
        System.out.println("The amount of paint you need for this wall with total area of " + areaOfWall +  " is " + Math.round(amountOfPaintNeeded * 100)/100);
        for (Map.Entry<Double, Integer> entry : tinsAmount.entrySet()) {
            System.out.println("You will need " + entry.getValue() + " " + entry.getKey() + " litre tins");
        }


    }
    public static double calcArea (double width, double height) {
        return width * height;
    }

    public static double convertCm2ToM2 (double givenArea) {
        return givenArea/ 10000;
    }

    public static double calcNumOfLitresNeeded (double givenArea, int litreCoverage) {
        return (givenArea/litreCoverage) * 2;
    }

    public static int getNumOfTins (double givenTinNumber, double givenLitreVal) {
        int total = 0;
        do{
            givenLitreVal -= givenTinNumber;
            total += 1;
        }while(givenLitreVal > 0);
        return total;
    }
}