package gradientLossFunction;

import java.util.Scanner;

public class lossFunction {

    public static double totalLoss(double w1, double w2) {

        double[][] data = {
                {1, 0, 1},
                {2, 1, 9},
                {0, 1, 1},
                {-2, 1, 7}
        };

        double loss = 0.0;
        for (double[] row : data) {
            double x1 = row[0];
            double x2 = row[1];
            double y = row[2];

            double predicted = w1 * x1 + w2 * x2;

            loss += Math.pow(predicted - y, 2);
        }
        return loss;
    }

    public static double[] computeGradient(double w1, double w2, double[][] data) {
        double[] gradients = new double[2];

        for (double[] row : data) {
            double x1 = row[0];
            double x2 = row[1];
            double y = row[2];

            double predicted = w1 * x1 + w2 * x2;
            double error = predicted - y;

            gradients[0] += error * x1;
            gradients[1] += error * x2;
        }

        gradients[0] /= data.length;
        gradients[1] /= data.length;

        return gradients;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Weight_1:");
        double w1 = scanner.nextDouble();

        System.out.println("Enter the Weight_2:");
        double w2 = scanner.nextDouble();

        // Compute the initial total loss
        double loss = totalLoss(w1, w2);
        System.out.println("Initial Total Loss: " + loss);

        // Compute the initial gradients

        w1 = 0;
        w2 = 0;
        double learningRate = 0.1; // Learning rate
        double[][] data = {
                {1, 0, 1},
                {2, 1, 9},
                {0, 1, 1},
                {-2, 1, 7}
        };
        int iterations = 100;

        for (int i = 0; i < iterations; i++) {
            double[] gradients = computeGradient(w1, w2, data);
            w1 -= learningRate * gradients[0];
            w2 -= learningRate * gradients[1];
        }

        System.out.println("Final weights: w1 = " + w1 + ", w2 = " + w2);

    }

}
