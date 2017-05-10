/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eugem
 */
public class Vertice {
    double x;
    double y;
    double z;

    public Vertice(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX()
    {
        return x;
    }

    @Override
    public String toString() {
        return "Vertice{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    public double getY()
    {
        return y;
    }
    public double getZ()
    {
        return z;
    }
}
