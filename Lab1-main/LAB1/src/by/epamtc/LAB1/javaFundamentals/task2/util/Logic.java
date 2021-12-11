package by.epamtc.LAB1.javaFundamentals.task2.util;

public class Logic {

    public static boolean check(int x, int y){
        return checkBottomFigure(x, y) || checkTopFigure(x, y);
    }

    public static boolean checkBottomFigure(int x, int y){
        return (x>=-6 && x<=6) && (y>=-3 && y<=0);
    }

    public static boolean checkTopFigure(int x, int y){
        return (x>=-4 && x<=4) && (y>=0 && y<=5);
    }
}
