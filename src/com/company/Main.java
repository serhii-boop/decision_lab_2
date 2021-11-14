package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\serhi\\OneDrive\\Робочий стіл\\Теорія прийняття рішень\\lab_3\\src\\matrix.txt");

        double[] x = Files.lines(path)
                .flatMap(e -> Stream.of(e.split(" ")))
                .mapToDouble(Double::parseDouble)
                .toArray();
        System.out.println(Arrays.toString(x)+"\n");

        double[] res1 = new double[2];
        double[] res = new double[3];


        OV(x, res1);
        OM(x, res1);
        V(x, res);
        M(x, res);
        better_o(res1);
        O(x,res);
        System.out.print("\nОптимальне рішення даної задачі: ");
        better_all(res);

    }

    static void OV(double[] x, double res1[]) {
        double ov;
        ov = (x[1] * x[12] + x[3] * x[13]) * 4 - x[0];
        res1[global.i] = ov;
        System.out.println("Очікування і великий завод:\t" + res1[global.i]);
        global.i += 1;
    }

    static void OM(double[] x, double res1[]) {
        double om;
        om = (x[6] * x[12] + x[8] * x[13]) * 4 - x[5];
        res1[global.i] = om;
        System.out.println("Очікування і менший завод:\t" + res1[global.i]);
        global.i += 1;
    }

    static void better_o(double[] res1) {
        if (res1[0] >= res1[1]) {
            global.max = res1[0];
        } else {
            global.max = res1[1];
        }
    }

        static void V ( double[] x, double[] res){
            double v;
            v = (x[1] * x[2] + x[3] * x[4]) * 5 - x[0];
            res[global.j] = v;
            System.out.println("Великий завод:\t" + res[global.j]);
            global.j += 1;
        }

    static void M(double[] x, double[] res) {
        double v;
        v = (x[6] * x[7] + x[8] * x[9]) * 5 - x[5];
        res[global.j] = v;
        System.out.println("Менший завод:\t"+ res[global.j]);
	    global.j += 1;
    }

    static void O(double[] x, double[] res) {
        double v;
        v = global.max + (x[10] * 0 * 1 + x[11] * 0 * 1) - 0;
        res[global.j] = v;
        System.out.println("Очікування і збір інформації:\t"+ res[global.j]);
        global.j += 1;
    }

    static void better_all(double[]res) {
        double max=0;
        for (int i = 0; i < 3; i++) {
            if (max < res[i])
                max = res[i];
        }
        System.out.println(max);
    }
}

