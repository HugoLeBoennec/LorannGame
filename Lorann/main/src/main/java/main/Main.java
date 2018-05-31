package main;

import java.io.IOException;

import controller.ControllerFacade;
import model.ModelFacade;
import model.Scene;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	
        final ControllerFacade controller;
        final Scene scene;

        try
        {
        	scene = new Scene();
        	
        	controller = new ControllerFacade(new ViewFacade(scene), new ModelFacade(scene));
            controller.start();
        }
        /*catch (final SQLException e)
        {
            e.printStackTrace();
        }*/
        catch (final IOException e)
        {
        	e.printStackTrace();
        }
        catch (InterruptedException e)
        {
			e.printStackTrace();
		}
    }
}
