
    public class SimpleLinearRegressionBenetton {

        static class DataPoint {
            double advertising;
            double sales;

            DataPoint(double advertising, double sales) {
                this.advertising = advertising;
                this.sales = sales;
            }
        }
        public static void main(String[] args) {
            // Dataset hardcoded
            DataPoint[] data = {
                    new DataPoint(23,651),
                    new DataPoint(26, 762),
                    new DataPoint( 856,30),
                    new DataPoint( 34,1063),
                    new DataPoint(43,1190 ),
                    new DataPoint(48,1298),
                    new DataPoint(52,1421 ),
                    new DataPoint( 57,1440),
                    new DataPoint(58,1518 ),
            };

            int n = data.length;
            double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

            for (DataPoint dp : data) {
                sumX += dp.advertising;
                sumY += dp.sales;
                sumXY += dp.advertising * dp.sales;
                sumX2 += dp.advertising * dp.advertising;
            }

            // Calcular coeficientes
            double b1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
            double b0 = (sumY - b1 * sumX) / n;

            // Mostrar ecuación
            System.out.printf("Ecuacion de regresion: y = %.4f + %.4f * x (Advertising)%n", b0, b1);

            double[] nuevosAdvertising = {8, 18, 28, 38, 48};

            System.out.println("\nPredicciones para nuevos valores de advertising:");
            for (double adv : nuevosAdvertising) {
                double prediccion = b0 + b1 * adv;
                System.out.printf("Advertising = %.1f -> Sales estimadas = %.2f%n", adv, prediccion);
            }
        }
    }

