/** 
 * A class for representing 3D vectors complete with constructors;
 * setters and getters; instance methods to calculate magnitude
 * squared and magnitude of a vector, to add or subtract two vectors; a toString() instance 
 * method to print out vector in a useful format for use in e.g. printf(); instance methods to perform scalar multiplication
 * and scalar division by a double, and static methods perform vector addition, subtraction, 
 * cross product, and dot product operations on two Vector3D instances.
 *
 *
 * @author C. Henning
 * @author M. Haughey
 * @author R. Scott
 * @version "20/10/2015"
 *
 */



public class Vector3D {

    /*
     * Properties
     * Note the "private" keyword used to protect the variables
     */

    private double xElement;
    private double yElement;
    private double zElement;

    /*
     *  Constructors
     */

    /** Default constructor. Constructs an empty vector, with uninitialised components.
     * @param x a double used to set the x component of the Vector3D
     * @param y a double used to set the x component of the Vector3D
     * @param z a double used to set the x component of the Vector3D
     */
    
    public void setVector3D(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }



     public Vector3D() {
        // Set elements to "not-a-number" to indicate uninitialised
        this.setVector3D(Double.NaN, Double.NaN ,Double.NaN);
    }


    /** Copy constructor. Constructs a new vector by copying the components of another vector instance.
     *
     * @param original the Vector to be copied
     */
    public Vector3D(Vector3D original) {
        this.setVector3D(original.getX(), original.getY(),original.getZ());
    }

    /** Explicit constructor. Constructs a new Vector3D from explicitly
     *  given components.
     *
     * @param x a double giving the x component of the new Vector3D
     * @param y a double giving the y component of the new Vector3D
     * @param z a double giving the z component of the new Vector3D
     */
    public Vector3D(double x,double y, double z) {
        this.setVector3D(x, y, z);
    }

    /*
     * Setters and getters
     */
 // Setters provide the internal variables
 
 
    /** Convenient set method to set the x component of the vector.
     * @param x a double to set the x-component
     */
    public void setX(double x) { this.xElement = x; }
    
    /** Convenient set method to set the y component of the vector.
     * @param y a double to set the y-component
     */
    public void setY(double y) { this.yElement = y; }
    
    
    /** Convenient set method to set the z component of the vector.
     * @param z a double to set the z-component
     */
    public void setZ(double z) { this.zElement = z; }

 
    
    // Getters provide access to private internal variables
 
    /** Gets the x-component of the vector.
     * @return a double instance representing the x-component.
     */
    public double getX() { return this.xElement; }

    /** Gets the y-component of the vector.
     * @return a double instance representing the y-component.
     */
    public double getY() { return this.yElement; }

    /** Gets the z-component of the vector.
     * @return a double instance representing the z-component.
     */
    public double getZ() { return this.zElement; }
  
    
   
    /* Instance methods
     *
     * These operate on a particular instance of an object
     */

    /** Calculates the magnitude squared of the vector A.
     * 
     * @return a double representing the vector's magnitude squared.
     */ 
   
    public double magnitudeSquared() { return  (this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());  }

    /** Calculates the magnitude of the vector A.
     *
     * @return a double representing the vector's magnitude.
     */

    public double magnitude() { return Math.sqrt(this.magnitudeSquared());  }

   /** Returns a String representation of the vector. Methods 
     * called 'toString' are automatically called when an object
     * is printed.<br>
     *
     * @return a string representation of the vector instance.
     */


    public String toString() {
    	double x = this.getX();
        double y = this.getY();
        double z = this.getZ();	

        return x + " " + y + " " + z;
    }
    


    /* 
     * Static methods 
     */
    
    /** Adds two 3-dimensional vectors.
     *
     * @param a the first vector to be added
     * @param b the second vector to be added
     * @return the vector sum of a and b, a + b.
     */
    public static Vector3D addVector(Vector3D a, Vector3D b) { 
        return new Vector3D(a.getX() + b.getX(),
                                a.getY() + b.getY(), a.getZ() + b.getZ());
    }
    
    /** Subtracts two 3-dimensional vectors.
     *
     * @param a the first vector, minuend
     * @param b the vector to be subtract from the first, the subtrahend
     * @return the vector subtraction of a and b: a - b.
     */
    public static Vector3D subVector(Vector3D a, Vector3D b) { 
        return new Vector3D(a.getX() - b.getX(),
                                a.getY() - b.getY(), a.getZ() - b.getZ());
    }
    
    /** Calculates the scalar product of vectors a and b as: (Xa * Xb + Ya * Yb + Za * Zb).
     *
     * @param a the first 3-dimensional vector.
     * @param b the second 3-dimensional vector.
     * @return the scalar product of a and b, a.b .
     */
     public static double dotVector(Vector3D a, Vector3D b) { 
        return ( (a.getX() * b.getX()) + (a.getY() * b.getY()) + (a.getZ() * b.getZ()) );
    }
    
    
    /** Multiplies vector a=(x,y,z) with a double b as: a*b = (x*b,y*b,z*b).
     *
     * @param a a 3-dimensional vector
     * @param b the scalar factor
     * @return the vector a scaled by the real number b.
     */
    public static Vector3D multScalar(Vector3D a, double b) {
        return new Vector3D(a.getX()*b, a.getY()*b, a.getZ()*b);
    }

    //
    // Note how we try to build more complicated operations
    // out of the existing and working simple ones instead
    // of relying on new and untested code.
    
    /** Divides vector a=(x,y,z) by double b as: a/b = (x/b,y/b,z/b).
     *
     * @param a a 3-dimensional vector 
     * @param b the scalar divisor
     * @return the vector divided by a scalar
     */
      public static Vector3D divScalar(Vector3D a, double b) {
        return new Vector3D(a.getX()/b, a.getY()/b, a.getZ()/b);
    }

    
    /** Calculates the vector product of two vectors a and b as: a x b = (Za*Yb -Ya*Zb, Za*Xb - Xa*Zb, Xa*Yb - Ya*Xb).
     *
     * @param a a 3-dimensional vector
     * @param b a 3-dimensional vector
     * @return the vector product of a and b, a x b.
     */
    public static Vector3D crossVector(Vector3D a, Vector3D b) { 
        return new Vector3D( (a.getY() * b.getZ()) - (a.getZ() * b.getY()), -(a.getX() * b.getZ()) + (a.getZ() * b.getX()), (a.getX() * b.getY()) - (b.getX() * a.getY()) );
    }
    
    
    /** Compares vector a with vector b and returns true if a = b
     * @param a a 3-dimensional vector
     * @param b a 3-dimensional vector
     * @return true if a = b, else false
     */
    public static boolean equalVector(Vector3D a, Vector3D b) {
        if(a.getX() == b.getX() && a.getY() == b.getY() && a.getZ() == b.getZ()){
        return true;
        }    
        else return false;
    }

    
    

}

