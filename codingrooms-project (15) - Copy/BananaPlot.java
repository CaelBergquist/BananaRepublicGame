

public class BananaPlot extends Generator {

    private String name;
    private int tallTrunk;
    private int moreBananas;
    private int growth;

    /**
     * Creates a new Resource with the given name and initializes the quantity to 0.
     *
     * @param name the name of the resource
     */
    public BananaPlot(String name) {
        super(name);
        this.name = name;
        tallTrunk = 0;
        moreBananas = 0;
        growth = 0;
    }
public void sayPlotName(){
    System.out.print(name);
}

    public String getPlotName(){
        return name;
    }
    public void growBananas(int amount){
        growth += amount;
    }

    public int getTallTrunk() {
        return tallTrunk;
    }

    public void setTallTrunk(int tallTrunk) {
        this.tallTrunk = tallTrunk;
    }

    public int getMoreBananas() {
        return moreBananas;
    }

    public void setMoreBananas(int moreBananas) {
        this.moreBananas = moreBananas;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int grow) {
        growth = grow;
    }
    public void upgradeTallTrunk() {
        tallTrunk ++;
    }
    public void upgradeMoreBananas() {
        moreBananas ++;
    }
        

    
}