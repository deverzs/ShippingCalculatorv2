/**
 * Zsuzsanna Dianovics
 * ShipItem.java
 * for Shipping Calculator
 */
package cs134.miracosta.edu;

/**
 *  A ShipItem object is created to calculate
 *  shipping cost of item. Weight in ounces is used.
 *
 *  PRECONDITION:
 *  User enters a reasonable amount of ounces
 *  No error checking for length of string entered
 *  No error checking for user entered incorrect unit of measurement
 */
public class ShipItem {

    /**
     * Static and Instance variables
     */
    static final double BASE = 3.00;        //base amount of all objects
    static final double ADDED = 0.50;       //added cost of over Base_oz
    static final int BASE_OZ = 16;          //base weight
    static final int PER_COST = 4;          //cost divided among

    private double mBaseCost ;              //base cost of all objects
    private double mAddedCost ;             //added cost incurred
    private double mTotal ;                 //total of shipping
    private int mWeight ;                   //weight of object, in ounces


    /**
     *Creates a ShipItem with default attributes.
     */

    public ShipItem(){
        mBaseCost = BASE;
        mAddedCost = 0.0;
        mTotal = 0.0;
        mWeight = 0;
    }

    /**
     * Set Weight - sets weight entered by user
     * and calls @calculateTotal()
     * @param w user entered weight of ship item, in ounces
     */
    public void setWeight(int w)
    {
        mWeight = w;
        calculateTotal();
    }

    /**
     * Called by setWeight() to calculate the shipping cost.
     * @return the total of the shipping
     */
    private double calculateTotal()
    {
        //Setting added cost and base cost to default
        //in case new watcher
        mAddedCost = 0.0;
        mBaseCost = BASE;

        //calculating overage of ounces
        int diff = mWeight - BASE_OZ;

        //if ounce is zero, technically a reset
        if (mWeight <= 0) { mBaseCost = 0.0; }
        //else calculate if additional ounces detected
        else if (diff > 0)
        {
            //calculate increment to multiply
            double incr = (double) diff / PER_COST;
            mAddedCost = Math.ceil(incr)  * ADDED;
        }
        //calculate total
        mTotal = mAddedCost + mBaseCost;
        return mTotal;
    }

    /**
     * getWeight
     * @return weight of object
     */
    public int getWeight() { return mWeight; }


    /**
     * getbaseCost
     * @return cost of the base amount
     */
    public double getBaseCost() { return mBaseCost; }

    /**
     * getAddedCost
     * @return additional cost incurred by weight over base_oz
     */
    public double getAddedCost() { return mAddedCost; }


    /**
     * getTotal
     * @return total cost of shipping of item
     */
    public double getTotal() {return mTotal;}


}
