/**
 * The Resource class represents a generic resource in the game.
 * Resources have a name, a quantity, and a status of critical or not critical.
 */
public class Resource {
    protected String name;
    protected int quantity;
    protected boolean isCritical;

    /**
     * Creates a new Resource with the given name and initializes the quantity to 0.
     *
     * @param name the name of the resource
     */
    public Resource(String name) {
        this.name = name;
        this.quantity = 0;
        this.isCritical = false;
    }

    /**
     * Gets the name of the resource.
     *
     * @return the name of the resource
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the quantity of the resource.
     *
     * @return the quantity of the resource
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Reports if a resource is critical. If a rsource is critical, reaching 0 ends the game.
     *
     * @return if the resource is critical
     */
    public boolean isCritical(){
        return isCritical;
    }

    /**
     * Sets if a given resource is critical.
     * 
     * @param boolean value for isCritical
     */
    public void setIsCrticial(boolean isCritical){
        this.isCritical = isCritical;
    }




}