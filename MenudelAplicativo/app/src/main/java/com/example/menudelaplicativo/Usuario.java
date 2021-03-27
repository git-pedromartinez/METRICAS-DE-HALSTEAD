package com.example.menudelaplicativo;

public class Usuario {
    public  String Id;
    public  String N1;
    public  String N2;
    public  String pn1;
    public  String pn2;
    public  String N;
    public  String pn;
    public  String V;
    public  String D;
    public  String L;
    public  String T;
    public  String E;
    public  String B;

    public String getId() {
        return Id;
    }

    public String getN1() {
        return N1;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setN1(String n1) {
        N1 = n1;
    }

    public void setN2(String n2) {
        N2 = n2;
    }

    public void setPn1(String pn1) {
        this.pn1 = pn1;
    }

    public void setPn2(String pn2) {
        this.pn2 = pn2;
    }

    public void setN(String n) {
        N = n;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public void setV(String v) {
        V = v;
    }

    public void setD(String d) {
        D = d;
    }

    public void setL(String l) {
        L = l;
    }

    public void setT(String t) {
        T = t;
    }

    public void setE(String e) {
        E = e;
    }

    public void setB(String b) {
        B = b;
    }

    public String getN2() {
        return N2;
    }

    public String getPn1() {
        return pn1;
    }

    public String getPn2() {
        return pn2;
    }

    public String getN() {
        return N;
    }

    public String getPn() {
        return pn;
    }

    public String getV() {
        return V;
    }

    public String getD() {
        return D;
    }

    public String getL() {
        return L;
    }

    public String getT() {
        return T;
    }

    public String getE() {
        return E;
    }

    public String getB() {
        return B;
    }

    public Usuario(String id, String n1, String n2, String pn1, String pn2, String n, String pn, String v, String d, String l, String t, String e, String b) {
        Id = id;
        N1 = n1;
        N2 = n2;
        this.pn1 = pn1;
        this.pn2 = pn2;
        N = n;
        this.pn = pn;
        V = v;
        D = d;
        L = l;
        T = t;
        E = e;
        B = b;
    }
}
