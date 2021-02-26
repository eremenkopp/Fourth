package com.petrocompany;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.Struct;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int size = 3, dotsToWin = 3;
    public static final char cross = 'X', zero = 'O', empty = '*';
    public static Scanner input = new Scanner(System.in);
    public static Random r = new Random();


    public static void main(String[] args) {
        fillMap();
        printMap();
        for (int i = 0; i <= size*size; i++) {
            manTurn();
            printMap();

            compTurn();
            printMap();
        }
    }

    public static boolean checkWin(char symbolWin) {
        String winResult = "", result;
        for (int i = 0; i < dotsToWin; i++) {
            winResult += symbolWin;
        }
        for (int i = 0; i < dotsToWin; i++) {
            result = "";
            for (int j = 0; j < dotsToWin; j++) {
                result += map[i][j];
            }
            if (result.equals(winResult)){
                return true;
            }
            result = "";
            for (int j = i; j < dotsToWin; j++) {

            }
        }
        return false;
    }

    public static boolean checkMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == zero){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkCell(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size){
            return false;
        }
        if (map[y][x] == empty){
            return true;
        }
        return false;
    }

    public static void manTurn(){
        int x, y;
        do {
            System.out.println("Please make a move (input X Y):");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
        } while (checkCell(x, y) == false);
        map[y][x] = cross;
    }

    public static void compTurn(){
        int x, y;
        do {
            x = r.nextInt(size);
            y = r.nextInt(size);
        } while (checkCell(x, y) == false);
        System.out.println("Computer made a move x = " + (x+1) + " y = " + (y+1));
        map[y][x] = zero;
    }

    public static void fillMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = empty;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
