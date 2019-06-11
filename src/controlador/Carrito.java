package controlador;

import vista.Pista;

import javax.swing.*;
import java.util.Random;

public class Carrito extends Thread{
    private JLabel carro;
    private int xInicial;
    private int yInicial;
    private int xAvance;
    private int yAvance;
    private int noVueltas;
    private Random random;
    private long tiempo;
    public Carrito(JLabel carro, Random random, int noVueltas)
    {
        this.carro=carro;
        xInicial = carro.getX();
        yInicial = carro.getY();
        this.random=random;
        this.noVueltas=noVueltas;
        tiempo=0;
    }
    @Override
    public void run() {
        for (int i =0; i<noVueltas;i++) {
            avanzarDerecha();
            bajarDerecha();
            bajarIzquierda();
            avanzarIzquierda();
            subirIzquierda();
            subirDerecha();
        }
    }

    public void avanzarDerecha()
    {
        for(xAvance= xInicial; xAvance <xInicial+300; xAvance++)
        {
            try
            {
                carro.setBounds(xAvance,yInicial,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }

    public void bajarDerecha()
    {
        for(yAvance = yInicial; yAvance <yInicial+25; yAvance++)
        {

            try
            {
                carro.setBounds(xAvance++, yAvance,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }

    public void bajarIzquierda()
    {
        for(yAvance=yAvance; yAvance <yInicial+50; yAvance++)
        {

            try
            {
                carro.setBounds(xAvance--, yAvance,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }
    public void avanzarIzquierda()
    {
        for(xAvance =xAvance ; xAvance >xInicial; xAvance--)
        {
            try
            {
                carro.setBounds(xAvance,yAvance,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }

    public  void subirIzquierda()
    {
        for(yAvance =yAvance; yAvance >yInicial+25; yAvance--)
        {
            try
            {
                carro.setBounds(xAvance--, yAvance,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
                sleep(tiempo);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }

    public void subirDerecha()
    {
        for(yAvance =yAvance; yAvance >yInicial; yAvance--)
        {
            try
            {
                carro.setBounds(xAvance++, yAvance,50,50);
                long dormir = random.nextInt(50);
                tiempo+=dormir;
                sleep(dormir);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }
    public JLabel getCarro()
    {
        return carro;
    }

    public long getTiempo() {
        return tiempo;
    }
}
