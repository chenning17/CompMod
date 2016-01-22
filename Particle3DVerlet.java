/**
 * Computer Modelling, Exercise 3: 
 *
 * ////DESCRIPTION////
 *
 * @author R. Scott
 * @author C. Henning
 * @author M. Haughey
 * @version "11/2015"
 */

// IO package is required for file writing
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Particle3DVerlet  {

    /*
     * As we are doing file IO we need to throw and exception
     */
    public static void main (String[] argv) throws IOException {

	String fname = argv[0];

        BufferedReader file = new BufferedReader(new FileReader(fname));
        // Attach a Scanner to the file to parse the numbers
        Scanner scan = new Scanner(file);

	String outFile1 = "verlet"+ argv[1] +".data";
	String outFile2 = "energyConVerlet"+ argv[1] +".data";
	PrintWriter output1 = new PrintWriter(new FileWriter(outFile1));
	PrintWriter output2 = new PrintWriter(new FileWriter(outFile2));

	// Create a particle with given mass, and position and velocity vectors.
	Particle3D A = new Particle3D();

	// Set first token as particle mass 
	A.setMass(scan.nextDouble());
	
	// Set next 3 tokens as elements of particle's position vector.
	A.setPosition(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());

	// Set next 3 tokens a elements of particle's velocity vector.
	A.setVelocity(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());

	// Create another particle for a 2 body system (Usually stationary at origin).
	Particle3D B = new Particle3D();

	// Set first token as particle mass 
	B.setMass(scan.nextDouble());
	
	// Set next 3 tokens as elements of particle's position vector.
	B.setPosition(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());

	// Set next 3 tokens a elements of particle's velocity vector.
	B.setVelocity(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());

	// Calculate the separation between two particles
	Vector3D r = new Vector3D(Particle3D.posVector(A.getPosition(), B.getPosition()));

	// Universal gravitational constant and initial force
	double G = 1;      // 6.67408E-11;
	double F = (G * A.getMass() * B.getMass()) / Math.pow(r.magnitude(),3);
	Vector3D force = (Vector3D.multScalar(r, -F));

	// Number of timesteps
	int numstep = 100;

	// Size of timestep
	double dt = Double.parseDouble(argv[1]);    //Characteristic timestep = 2 * Math.PI

	// Initial time
	double t = 0;

       	/*
         * This is the start of the velocity Verlet algorithm
         */

        // Print the initial position to file
        output1.printf("%10.5f %10.5f\n",  A.getXPosition(), A.getYPosition());
        

        // Initialise new force and energy for use in loop
        Vector3D newForce = new Vector3D();
	Vector3D newPosition = new Vector3D();
	 

       	/*
         * The main loop
         */
        for (int i=0 ; i < numstep ; i++) {

	    // Update the position using current velocity and force

	    A.leapPosition(dt , force);

	    // Update the position vector 
	    newPosition = Particle3D.posVector(A.getPosition(), B.getPosition());

	    // Potential energy of particle
	    double U = -F / r.magnitude();
	    
	    //Kinetic energy of the particle
	    double T = A.kineticEnergy();

	    double energyCon = T + U;

	    // Print the total energy to file
	    output2.printf("%10.8f\n", energyCon);
        
	    // Update the position vector to new position
	    r = newPosition;
	    
	    // Update force constant according to new position
	    F = (G * A.getMass() * B.getMass()) / Math.pow(newPosition.magnitude(),3);

	    // Update force based on new position
	    newForce = (Vector3D.multScalar(newPosition, -F));
  
            // Update velocity based on average of initial and new forces
	    A.leapVelocity(dt, Vector3D.multScalar(Vector3D.addVector(force, newForce), 0.5));

	    // Update the force to the new force vector
	    force = newForce;
			  
	    // Increase the time 
	    t = t + dt;

	    // Print the current position to file
            output1.printf("%10.5f %10.5f\n", A.getXPosition(), A.getYPosition());
	    
	}

	    output1.close();
	    output2.close();
        

       
    }
}
