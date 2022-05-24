package polinomioslagrange;

import java.util.ArrayList;

public class PolinomiosLagrange {

    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4};
        double[] y = {4, 2, -2, -2, 8};

        int n = x.length;
        
        ArrayList<Double> listaCoeficientes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Double> listaCoefRes = new ArrayList<>();
            double denominador = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    ArrayList<Double> listaCoefI;
                    ArrayList<Double> listaCoefJ = new ArrayList<>();
                    if (j == 0 || (i == 0 && j == 1)) {
                        listaCoefRes.add(-x[j]);
                        listaCoefRes.add(1.0);
                    } else {
                        listaCoefI = listaCoefRes;
                        listaCoefJ.add(-x[j]);
                        listaCoefJ.add(1.0);
                        listaCoefRes = new ArrayList<>();
                        for (int k = 0; k < listaCoefI.size(); k++) {
                            double valAux0 = listaCoefI.get(k) * listaCoefJ.get(0);
                            double valAux1 = listaCoefI.get(k) * listaCoefJ.get(1);
                            
                            if (listaCoefRes.size() <= k) {
                                listaCoefRes.add(0.0);
                            }
                            listaCoefRes.set(k, listaCoefRes.get(k) + valAux0);
                            if (listaCoefRes.size() <= k + 1) {
                                listaCoefRes.add(0.0);
                            }
                            listaCoefRes.set(k + 1, listaCoefRes.get(k + 1) + valAux1);
                        }
                    }
                    
                    denominador *= (x[i] - x[j]);
                }
            }
            
            for (int k = 0; k < listaCoefRes.size(); k++) {
                listaCoefRes.set(k, listaCoefRes.get(k) * y[i] / denominador);

                if (listaCoeficientes.size() <= k) {
                    listaCoeficientes.add(0.0);
                }
                listaCoeficientes.set(k, listaCoeficientes.get(k) + listaCoefRes.get(k));
            }
        }
        
        System.out.print("f(x) = ");
        for (int i = 0; i < listaCoeficientes.size(); i++) {
            if (i > 0) {
                System.out.print(" + ");
            }
            System.out.print(listaCoeficientes.get(i));
            if (i > 0) {
                System.out.print("x");
                if (i > 1) {
                    System.out.print("^" + i);
                }
            }
        }
        System.out.println();
    }

}
