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
    private Random random;
    public Carrito(JLabel carro, Random random)
    {
        this.carro=carro;
        xInicial = carro.getX();
        yInicial = carro.getY();
        this.random=random;
    }
    @Override
    public void run() {
        avanzarDerecha();
        bajarDerecha();
        bajarIzquierda();
        avanzarIzquierda();
        subirIzquierda();
        subirDerecha();
    }

    public void avanzarDerecha()
    {
        for(xAvance= xInicial; xAvance <xInicial+300; xAvance++)
        {
            try
            {
                carro.setBounds(xAvance,yInicial,50,50);
                sleep((long)random.nextInt(50));
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
                sleep((long)random.nextInt(50));
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
                sleep((long)random.nextInt(50));
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
                sleep((long)random.nextInt(50));
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
                long tiempo = (long)random.nextInt(50);
                //System.out.println(tiempo);
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
                sleep((long)random.nextInt(50));
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getStackTrace());
            }
        }
    }
}
