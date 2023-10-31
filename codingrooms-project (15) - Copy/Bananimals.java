public class Bananimals extends Resource {
    private Bananimals bananimalCount ;

    public Bananimals(String name){
        super(name);

    }
    public int addBananimals(int amount){
        quantity += amount;
        return quantity;
    }
    public int removeBananimals(int amount){
        quantity -= amount;
        return quantity;
    }
    public int getBananimals(){
        return quantity;
    }
    public void setBananimals(int amount){
        quantity = amount;
    }
    
    
}