public class Market extends Generator {
    private int size;
    private int salesBonus;
    private boolean sold;

    public Market(String name) {
        super(name);
        size = 0;
        salesBonus = 0;
    }
    public String getMarketName(){
        return name;
    }    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSalesBonus() {
        return salesBonus;
    }

    public void setSalesBonus(int salesBonus) {
        this.salesBonus = salesBonus;
    }
    public boolean getSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
    public void upgradeSize() {
        size++;
    }
    public void upgradeSalesBonus() {
        salesBonus++;
    }
    
    
        
    
}
