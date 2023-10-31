public class Wood extends Resource {

    public Wood(String name) {
        super(name);

    }
    public int addWood(int amount){
        quantity += amount;
        return quantity;
    }
    public int removeWood(int amount){
        quantity -= amount;
        return quantity;
    }
        public int getWood(){
        return quantity;
    }
    
}