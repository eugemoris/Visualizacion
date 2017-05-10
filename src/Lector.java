
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eugem
 */
public class Lector {
    private ArrayList<Vertice> vertices;
    private ArrayList<Poligono> poligonos;
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    private double zMin;
    private double zMax;
    private double cX;
    private double cY;
    private double cZ;
    private String nombreArchivo;

    public Lector(String nombre)
    {
        this.vertices = new ArrayList<>();
        this.poligonos = new ArrayList<>();
        this.xMin = Double.MAX_VALUE;
        this.xMax = Double.MIN_VALUE;
        this.yMin = Double.MAX_VALUE;
        this.yMax = Double.MIN_VALUE;
        this.zMin = Double.MAX_VALUE;
        this.zMax = Double.MIN_VALUE;
        this.cX = 0;//VER
        this.cY = 0;//VER
        this.cZ = 0;//VER
        nombreArchivo = nombre;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public ArrayList<Poligono> getPoligonos() {
        return poligonos;
    }

    public double getxMin() {
        return xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public double getzMin() {
        return zMin;
    }

    public double getzMax() {
        return zMax;
    }

    public double getcX() {
        return cX;
    }

    public double getcY() {
        return cY;
    }

    public double getcZ() {
        return cZ;
    }

    public double getObjHeight()
    {
        return (Math.abs(yMax-yMin));
    }
    
    public double getObjWidth()
    {
        return (Math.abs(xMax-xMin));
    }
    
    @Override
    public String toString() {
        return "Lector{" +  ", xMin=" + xMin + ", xMax=" + xMax + ", yMin=" + yMin + ", yMax=" + yMax + ", zMin=" + zMin + ", zMax=" + zMax + ", cX=" + cX + ", cY=" + cY + ", cZ=" + cZ + '}';
    }
    
    public void cargarObj()
    {
        FileReader fileReader=null;
        try
        {
            fileReader = new FileReader(nombreArchivo);
            System.out.println(nombreArchivo);
            BufferedReader lector = new BufferedReader(fileReader);
            String linea;
            String[] elem;
            double x,y,z;
            while ((linea = lector.readLine())!=null)
            {
                elem=linea.split(" ");
                if (elem[0].equals("v"))
                {
                    x=Double.parseDouble(elem[1]);
                    y=Double.parseDouble(elem[2]);
                    z=Double.parseDouble(elem[3]);
                    Vertice v=new Vertice(x, y, z);
                    vertices.add(v);
                    if (x < xMin) 
                    {
                        xMin = x;
                    }
                    if (x > xMax)
                    {
                        xMax = x;
                    }
                    if (y < yMin)
                    {
                        yMin = y;
                    }
                    if (y > yMax)
                    {
                        yMax = y;
                    }
                    if (z < zMin) 
                    {
                        zMin = z;
                    }
                    if (z > zMax)
                    {
                        zMax = z;
                    }
                }
                else if(elem[0].equals("f"))
                {
                    int v1Pos= Integer.parseInt(elem[1])-1;
                    int v2Pos= Integer.parseInt(elem[2])-1;
                    int v3Pos= Integer.parseInt(elem[3])-1;
                    Vertice v1= vertices.get(v1Pos);
                    Vertice v2 = vertices.get(v2Pos);
                    Vertice v3= vertices.get(v3Pos);
                    Poligono p= new Poligono(v1, v2, v3);
                    poligonos.add(p);   
                }
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { 
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cX = ((xMax - xMin) / 2.0);
        cY = ((yMax - yMin) / 2.0);
        cZ = ((zMax - zMin) / 2.0);
       // System.out.println("Lector.cargarObj()"+ poligonos);
    }
            
       
    
    
}
