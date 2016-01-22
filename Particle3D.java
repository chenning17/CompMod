//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

/**
 * Computer Modelling, Exercise 3: Particle3D class.
 *
 * @author C. Henning
 * @author M. Haughey
 * @author R. Scott
 * @version "16/11/2015"
 *
 */
 
public class Particle3D{

    /********************************************
     * Properties
     ********************************************/
    private double mass;
    private Vector3D position;
    private Vector3D velocity;
   
   
   
    /********************************************
     * Constructors
     ********************************************/
    
    /** Default constructor. 
     *  Sets all properties to zero
     */
    public Particle3D() {
        this.setMass(0.0);
        position = new Vector3D(0.0, 0.0, 0.0);
        velocity = new Vector3D(0.0, 0.0, 0.0);
    }

    /** Explicit constructor. Constructs a new Particle3D with
     * explicitly given position, velocity, and mass.
     *
     * @param m a double that defines the mass.
     * @param p a vector3D that defines the position.
     * @param v a vector3D that defines the velocity.
     */
    public Particle3D(double m, Vector3D p, Vector3D v) {
        this.setMass(m);
        this.setPosition(p.getX(), p.getY(), p.getZ());
        this.setVelocity(v.getX(), v.getY(), v.getZ());
    }
   //-------------------------------------------------------------------------------------------------------
    /** Copy constructor. Constructs a new vector by copying the components of another vector instance.
     *
     * @param original the Particle3D to be copied
     */
   public Particle3D(Particle3D original) {
        this.setMass(original.getMass());
        this.setPosition(original.getXPosition(), original.getYPosition(),original.getZPosition());
        this.setVelocity(original.getXVelocity(), original.getYVelocity(),original.getZVelocity());
    }
    //_________________________________________________________________________________________________________
     /** Explicit constructor. Constructs a new Particle3D from explicitly
     *  given components.
     *
     * @param m a double giving the mass of the new Particle3D
     * @param xp a double giving the x component for the position of the new Particle3D
     * @param yp a double giving the y component for the position of the new Particle3D
     * @param zp a double giving the z component for the position of the new Particle3D
     * @param xv a double giving the x component for the velocity of the new Particle3D
     * @param yv a double giving the y component for the velocity of the new Particle3D
     * @param zv a double giving the z component for the velocity of the new Particle3D
     */
    
    public Particle3D(double m, double xp,double yp, double zp, double xv, double yv, double zv) {
        this.setPosition(xp, yp, zp);
        this.setVelocity(xv, yv, zv);
        this.setMass(m);
    }

    //-----------------------------------------------------------------------------------------------------
   
    // Setters and Getters
    
    /** Gets the x-component of the position of a Particle3D.
     *
     * @return a double instance representing the x-component of the position.
     */
    public double getXPosition() { return position.getX(); }
	
	
    /** Gets the y-component of the position of a Particle3D.
     *
     * @return a double instance representing the y-component of the position.
     */
    public double getYPosition() { return position.getY(); }
	
	
    /** Gets the z-component of the position of a Particle3D.
     *
     * @return a double instance representing the z-component of the position.
     */
    public double getZPosition() { return position.getZ(); }
	
    
    /** Gets the x-component of the velocity of a Particle3D.
     *
     * @return a double instance representing the x-component of the velocity.
     */
    public double getXVelocity() { return velocity.getX(); }
	
	
    /** Gets the y-component of the velocity of a Particle3D.
     *
     * @return a double instance representing the y-component of the velocity.
     */
    public double getYVelocity() { return velocity.getY(); }
	
	
    /** Gets the z-component of the velocity of a Particle3D.
     *
     * @return a double instance representing the z-component of the velocity.
     */
    public double getZVelocity() { return velocity.getZ(); }
	
	
    /** Gets the mass of a Particle3D.
     *
     * @return a double representing the mass.
     */
    public double getMass()     { return mass; }
	
	
    /** Gets the position of a Particle3D.
     *
     * @return a Vector3D representing the position of the velocity.
     */
    public Vector3D getPosition() 
   {
       return position;
   }
   
   /** Gets the velocity of a Particle3D.
     *
     * @return a Vector3D representing the velocity of the velocity.
     */
    public Vector3D getVelocity() 
   {
       return velocity;
   }
   
   

    

    /** Sets the x-component of the position of a Particle3D.
     *
     * @param x a double representing the x-component of the position.
     */
    public void setXPosition(double x) {
        this.position.setX(x);
    }
	
    /** Sets the y-component of the position of a Particle3D.
     *
     * @param y a double representing the y-component of the position.
     */
    public void setYPosition(double y) {
        this.position.setY(y);
    }
	
    /** Sets the z-component of the position of a Particle3D.
     *
     * @param z a double representing the z-component of the position.
     */	
    public void setZPosition(double z) {
        this.position.setZ(z);
    }
    
	
	/** Sets the x-component of the velocity of a Particle3D.
	 *
     * @param x a double representing the x-component of the velocity.
     */	
    public void setXVelocity(double x) {
        this.velocity.setX(x);
    }
	
    /** Sets the y-component of the velocity of a Particle3D.
     *
     * @param y a double representing the y-component of the velocity.
     */	
    public void setYVelocity(double y) {
        this.velocity.setY(y);
    }
	
    /** Sets the z-component of the velocity of a Particle3D.
     *
     * @param z a double representing the z-component of the velocity.
     */	
    public void setZVelocity(double z) {
        this.velocity.setZ(z);
    }
	
	
    /** Set the mass of a Particle3D.
     *
     * @param m a double representing the mass.
     */
    public void setMass(double m)     { this.mass = m; }

    /** Sets the position of a Particle3D.
     *
     * @param a Vector3D representing the position.
     */	
    public void setPosition(Vector3D a) {
	this.position.setX(a.getX());
	this.position.setY(a.getY());
	this.position.setZ(a.getZ());
    }
	
    /** Sets the velocity of a Particle3D.
     *
     * @param a Vector3D representing the velocity.
     */	
    public void setVelocity(Vector3D a) {
	this.velocity.setX(a.getX());
	this.velocity.setY(a.getY());
	this.velocity.setZ(a.getZ());
    }

	
   
    /* Additional methods to set position and velocity of particle, taking 
     * doubles for each spacial component.
     */

    /** Sets the position of a Particle3D.
     *
     * @param x a double representing the x-component of the position.
     * @param y a double representing the y-component of the position.
     * @param z a double representing the z-component of the position.
     */	
    public void setPosition(double x, double y, double z) {
        this.position.setX(x);   
        this.position.setY(y);
        this.position.setZ(z);
    }

    /** Sets the velocity of a Particle3D.
     *
     * @param x a double representing the x-component of the velocity.
     * @param y a double representing the y-component of the velocity.
     * @param z a double representing the z-component of the velocity.
     */	    
	 public void setVelocity(double x, double y, double z) {
        this.velocity.setX(x);   
        this.velocity.setY(y);
        this.velocity.setZ(z);
    }
    
    
    
   

    /* ******************************************
     * toString Method
     ********************************************/
    
    /** Returns a String representation of Particle3D.
     * Used to print a Particle3D instance using the "%s"
     * format identifier.
     */
    public String toString() {
        return ("xp =" + this.position.getX() + "yp =" + this.position.getY() + "zp =" + this.position.getZ() 
                + "xv=" + this.velocity.getX() + "yv=" + this.velocity.getY() + "zv=" + this.velocity.getZ() +
                "m=" + this.getMass());
    }
	

     /* ******************************************
     * Static Methods
     ********************************************/
	 
    /** Returns a vector representing the separation between two particles
     *
     * @param A a vector representing position of particle A
     * @param B a vector representing the position of particle B
     * @return a vector representing the position of particle A with respect to particle B
     */

    public static Vector3D posVector(Vector3D A, Vector3D B) {
	return new Vector3D(Vector3D.subVector(A, B));
    }
	
	
    /* ******************************************
     * Instance Methods
     ********************************************/

    
    /** Returns the kinetic energy of a Particle1D,
     * calculated as 1/2*m*v^2.
     *
     * @return a double that is the kinetic energy.
     */
          
    public double kineticEnergy() { return (this.mass)*(0.5)*(this.getVelocity().magnitudeSquared()); }

    /** Time integration support: evolve the velocity
     * according to dv = f/m * dt.
     *
     * @param dt a double that is the timestep.
     * @param force a double that is the current force on the particle.
     */

    public void leapVelocity(double dt, Vector3D force) {

	Vector3D newVelocity = Vector3D.multScalar(force , dt / this.mass);
	this.setVelocity(Vector3D.addVector(this.getVelocity() , newVelocity));
    }
    
    /** Time integration support: evolve the position
     * according to dx = v * dt.
     *
     * @param dt a double that is the timestep.
     */

    public void leapPosition(double dt) {

	Vector3D eulerPos = Vector3D.multScalar(this.getVelocity() , dt);
	this.setPosition(Vector3D.addVector(this.getPosition() , eulerPos)) ;
    }

    /** Time integration support: evolve the position
     * according to dx = v * dt + 0.5 * a * dt**2.
     *
     * @param dt a double that is the timestep.
     * @param force a double that is the current force.
     */

    public void leapPosition(double dt, Vector3D force) {
                    
	Vector3D verletPos = Vector3D.addVector(Vector3D.multScalar(this.getVelocity() , dt) , Vector3D.multScalar(force , 0.5 * dt*dt / this.mass)) ;
	this.setPosition(Vector3D.addVector(this.getPosition() , verletPos)) ;

    }
  
}
