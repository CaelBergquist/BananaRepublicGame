public class Money extends Resource {


    public Money(String name) {
        super(name);

    }
    public int addMoney(int amount){
        quantity += amount;
        return quantity;
    }
    public int removeMoney(int amount){
        quantity -= amount;
        return quantity;
    }
        public int getMoney(){
        return quantity;
    }
    
}