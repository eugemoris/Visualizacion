
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eugem
 */
public class Poligono {
    Vertice v1;
    Vertice v2;
    Vertice v3;

    public Poligono() {
       
    }

    public Poligono(Vertice v1, Vertice v2, Vertice v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    public void serVertices(Vertice v1, Vertice v2, Vertice v3)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Vertice getV1() {
        return v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public Vertice getV3() {
        return v3;
    }

    @Override
    public String toString() {
        return "Poligono{" + "v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + '}';
    }

    
}
