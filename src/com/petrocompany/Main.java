package com.petrocompany;

public class Main {

    public static char[][] map;
    public static final int size = 3, dotsToWin = 3;
    public static final char x = 'X', o = 'O', empty = '*';


    public static void main(String[] args) {
        fillMap();
        printMap();
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
    }
}
