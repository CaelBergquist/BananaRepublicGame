public class Bananas extends Resource {
    private Bananas bananaCount;

    public Bananas(String name){
        super(name);

    }
    public int addBananas(int amount){
        quantity += amount;
        return quantity;
    }
    public int removeBananas(int amount){
        quantity -= amount;
        return quantity;
    }
    public int getBananas(){
        return quantity;
    }
    
    
}