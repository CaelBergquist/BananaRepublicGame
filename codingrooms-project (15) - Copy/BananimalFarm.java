public class BananimalFarm extends Generator {

    private String name;
    private int level;
    
    public BananimalFarm(String name) {
        super(name);
        this.name = name;
        level = 0;

    }

    public String getFarmName(){
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void upgradeLevel() {
        level++;
    }
    

        
}