import java.util.Arrays;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        short[] d = new short[9];
        fillShort(d);
        double[] x = new double[14];
        fillDouble(x);
        double[][] p = new double[9][14];
        fillShit(p, x, d);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(x));
        print(p);
    }

    public static void fillShort(short[] arr) {
        int k = 5;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short) k;
            k += 2;
        }
        //5 7 9 11 13 15 17 19 21
    }

    public static void fillDouble(double[] arr) {
        double min = -11.0;
        double max = 4.0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random() * (max - min) + min;
        }
    }

    public static void fillShit(double[][] p, double[] x, short[] d) {
        int[] numbersToCheck = new int[]{5, 15, 17, 19};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 14; j++) {
                if (d[i] == 7) {
                    p[i][j] = asin(1 / exp(tan(atan(sin(x[j]))) * tan(atan(sin(x[j])))));
                } else if (contains(numbersToCheck, d[i])) {
                    p[i][j] = log(tan(exp(x[j] / 2)) * tan(exp(x[j] / 2)));
                } else {
                    p[i][j] = exp(Math.round(pow(exp(sin(x[j])), 1.0 / 3.0)));
                }
            }
        }
    }

    public static void print(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%,.4f ", array[i][j]));

            }
            System.out.println("");
        }
    }

    public static boolean contains(int[] arr, int key) {
        return Arrays.asList(arr).contains(key);
    }

}

//int, bool, float, double, char, long, short, byte
