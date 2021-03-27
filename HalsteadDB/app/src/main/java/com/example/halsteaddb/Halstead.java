package com.example.halsteaddb;

public class Halstead {
    int n1;
    int N1;
    int n2;
    int N2;

    int N;//Length of a program ( N = N1 + N2)
    int n;//Program vocabulary ( n = n1 + n2)
    double V;//Program volume (V = N * lg(n))
    double D;//Program difficulty (D = (n1/2)*(N2/n2))
    double L;//Program level (L = 1/D)
    double E;//Implementation effort (E = D*V)
    double T;//Implementation time (T = E/18)
    double B;//Number of bugs released (B = E^(2/3) / 3000)

    public Halstead(int n1,int N1,int n2,int N2) {//int n1,int N1,int n2,int N2
        this.n1 = n1;
        this.N1 = N1;
        this.n2 = n2;
        this.N2 = N2;
        //Calculate values...
        this.N=this.N1+this.N2;
        this.n=this.n1+this.n2;
        this.V=this.N*(Math.log(this.n)/Math.log(2));
        this.D = ((double)this.n1/2)*((double)this.N2/this.n2);
        this.L = 1/this.D;
        this.E = this.D*this.V;
        this.T = this.E/18;
        this.B = Math.pow(this.E,((double)2/3)) / 3000;
    }
    public String getValues(){
        return toString();
    }

    @Override
    public String toString() {
        return "Halstead{" +
                "n1=" + n1 +
                ", N1=" + N1 +
                ", n2=" + n2 +
                ", N2=" + N2 +
                ", N=" + N +
                ", n=" + n +
                ", V=" + V +
                ", D=" + D +
                ", L=" + L +
                ", E=" + E +
                ", T=" + T +
                ", B=" + B +
                '}';
    }
}