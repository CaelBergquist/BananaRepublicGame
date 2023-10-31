import java.util.Random;
import java.util.ArrayList;



public class InfoPrinter{
    private ArrayList<String> alertList = new ArrayList<String>();
    private ArrayList<String> harvestList = new ArrayList<String>();
    private int weevilCount = 0;
    private int totalBananasEaten = 0;
    private int weevilsEaten = 0;

    Random random = new Random();
    public void printInfo(TextManagementGame game){
        Bananas playerBananas = game.getPlayerBananas();
        Wood playerWood = game.getPlayerWood();
        Money playerMoney = game.getPlayerMoney();
        Bananimals playerBananimals = game.getPlayerBananimals();
        System.out.println("\nAlerts\n-------------");
        if(game.getRound() == 39){
            System.out.println("Growing season ends in 10 days!");
        }else if(game.getRound() == 44){
            System.out.println("Growing season ends in 5 days!");
        }
        
        harvestAllBananas(game);
        weevilsArrive(game); // calculate if weevils arrive
        if (game.isWeevils()){ // if they are here, calculate count. if its > 0, print count
            if (weevilCount > 0){
                System.out.println("Weevils count : " + 10 * weevilCount);
                System.out.println("They ate " + totalBananasEaten + " bananas!");
            }
        } 

        for(int i = 0; i < alertList.size(); i++){
            System.out.println(alertList.get(i));
        }
        
        System.out.println("\nHarvest\n-------------");
        for (String H : harvestList){
            System.out.println(H);
        }
        System.out.println("\nFarms and Markets\n-------------");
        printBananaPlots(game);
        printMarkets(game);
        printBananimalFarms(game);
                System.out.println("\nYour Resources\n-------------");
        System.out.println("Money : " + game.getMoneyString(playerMoney.getMoney()));
        System.out.println("Bananas : " + playerBananas.getBananas());
        System.out.println("Wood : " + playerWood.getWood());
        System.out.println("Bananimals : " + playerBananimals.getBananimals());

    }
    public void growAllBananas(TextManagementGame game){
        int growth = 0;
        for (Generator P : game.getGenerators()){
            
            if (P instanceof BananaPlot){
                
                int rand_int = random.nextInt(11);
                BananaPlot bananaPlot = (BananaPlot) P;
                growth = (20 + rand_int + 7*(game.getSprinklers()));
                bananaPlot.growBananas(growth);
                }
            }
       }
    public int harvestAllBananas(TextManagementGame game){
        int bananaYeild = 0;
        int woodYeild = 0;
        int totalBananaYeild = 0;
        int totalWoodYeild = 0;
        int totalHarvestCount = 0;
        int bananasEaten = 0;
        double weevilEffect = 0;
        totalBananasEaten = 0;
        
        for (Generator P : game.getGenerators()){
            if (P instanceof BananaPlot){
                BananaPlot bananaPlot = (BananaPlot) P;
                if (bananaPlot.getGrowth() >= 100){
                    bananaPlot.setGrowth(0);
                    int rand_int1 = random.nextInt(3);
                    bananaYeild = (4 + rand_int1 + 2*(bananaPlot.getMoreBananas()));
                    if(game.isWeevils()){
                        weevilEffect = 1 - (game.getWeevils() * game.getWeevils())/100.0;
                        if(weevilEffect < 0){
                            weevilEffect = 0;
                        }
                    
                        bananasEaten = (int) (bananaYeild- (bananaYeild * weevilEffect));
                        
                        totalBananasEaten += bananasEaten;
                        bananaYeild -= bananasEaten;
                        //System.out.println("eaten : " + totalBananasEaten);
                        //System.out.println("yeild : " + bananaYeild);
                    }
                    woodYeild = 3 + bananaPlot.getTallTrunk();
                    String message = (bananaPlot.getPlotName() + " -> " + bananaYeild + " bananas, " + woodYeild + " wood");
                    harvestList.add(message);
                    totalBananaYeild += bananaYeild;
                    totalWoodYeild += woodYeild;
                    totalHarvestCount ++;   
                }
                }
            }
            if(totalHarvestCount > 1){
                harvestList.add("\nTotal Banana Yeild -> " + totalBananaYeild);
                harvestList.add("Total Wood Yeild -> " + totalWoodYeild);
            }
            Bananas playerBananas = game.getPlayerBananas();
            playerBananas.addBananas(totalBananaYeild);
            Wood playerWood = game.getPlayerWood();
            playerWood.addWood(totalWoodYeild);
            return totalBananasEaten;
    }
    /*public void printBananaHarvest(TextManagementGame game){
        int bananaYeild = 0;
        int woodYeild = 0;
        int totalBananaYeild = 0;
        int totalWoodYeild = 0;
        int totalHarvestCount = 0;
        for (Generator P : game.getGenerators()){
            if (P instanceof BananaPlot){
                BananaPlot bananaPlot = (BananaPlot) P;
                if (bananaPlot.getGrowth() >= 100){
                    
                    int rand_int1 = random.nextInt(3);
                    bananaYeild = (4 + rand_int1 + 2*(bananaPlot.getMoreBananas()));
                    woodYeild = 3 + bananaPlot.getTallTrunk();
                    System.out.println(bananaPlot.getPlotName() + " -> " + bananaYeild + " bananas, " + woodYeild + " wood");
                    totalBananaYeild += bananaYeild;
                    totalWoodYeild += woodYeild;
                    totalHarvestCount ++;   
                }
                }
            }
            if(totalHarvestCount > 1){
                System.out.println("\nTotal Banana Yeild -> " + totalBananaYeild);
                System.out.println("Total Wood Yeild -> " + totalWoodYeild);
            }
            Bananas playerBananas = game.getPlayerBananas();
            playerBananas.addBananas(totalBananaYeild);
            Wood playerWood = game.getPlayerWood();
            playerWood.addWood(totalWoodYeild);
        }*/
    public void printBananaPlots(TextManagementGame game) {
        for (Generator P : game.getGenerators()){
            if (P instanceof BananaPlot){
                BananaPlot bananaPlot = (BananaPlot) P;
                System.out.println(bananaPlot.getPlotName() + "\n\tTaller Trunks : " + bananaPlot.getTallTrunk() + "/3" + "\n\tMore Bananas : " + bananaPlot.getMoreBananas() + "/3" + "\n\tGrowth : " + bananaPlot.getGrowth() + "%");
            }
        }

    }
    public void printMarkets(TextManagementGame game) {
        for (Generator M : game.getGenerators()){
            if (M instanceof Market){
                Market market = (Market) M;
                System.out.println(market.getMarketName() + "\n\tSize : " + market.getSize() + "/3 (" + (4*(1 + market.getSize())) + " bananas)" + "\n\tSales Bonus : " + market.getSalesBonus() + "/3 (+" + (20 * market.getSalesBonus()) + "%)");
            }
        }
    }
    public void printBananimalFarms(TextManagementGame game) {
        for (Generator F : game.getGenerators()){
            if (F instanceof BananimalFarm){
                BananimalFarm bananimalFarm = (BananimalFarm) F;
                System.out.println(bananimalFarm.getFarmName() + "\n\tLevel : " + bananimalFarm.getLevel() + "/2 (" + ((1 + bananimalFarm.getLevel())) + " bananimals)");
            }
        }
    }

    public boolean weevilsArrive(TextManagementGame game){
            if(game.getRound() < 24 || game.isWeevils() == true){
                return false;
            }
            int rand_int3 = random.nextInt(10);
            if (game.getRound()-20 > rand_int3){
                alertList.add("Weevils have Arrived!!!");
                game.setIsWeevils(true);
                return true;
            }
            return false;        
    }
    
    public void calculateWeevils(TextManagementGame game){
        if(game.isWeevils() == true){
            weevilCount = game.getWeevils() + game.countGeneratorType(BananaPlot.class);
            int banmals = game.getPlayerBananimals().getQuantity();
            int initialWeevils = weevilCount;
            int initialBanmals = banmals;
            
            if (banmals >= weevilCount){
                banmals -= weevilCount;
                weevilCount = 0;
            }else{
                weevilCount -= banmals;
                banmals= 0;
            }
            alertList.add( 10 * (initialWeevils - weevilCount) + " weevils were eaten by your bananimals");
            alertList.add( initialBanmals - banmals + " bananimals were defeated by the weevils");
            game.setWeevils(weevilCount);
            game.getPlayerBananimals().setBananimals(banmals);
        }
    }
    public void growBananimals(TextManagementGame game){
        int newBananimals = 0;
        for (Generator B : game.getGenerators()){
            if (B instanceof BananimalFarm){
                BananimalFarm bananimalFarm = (BananimalFarm) B;
                newBananimals += (1 + bananimalFarm.getLevel());
            }
        }
        Bananimals playerBananimals = game.getPlayerBananimals();
        playerBananimals.addBananimals(newBananimals);
    }
    public void clearAlerts(){
        alertList.clear();
    }
    public void clearHarvest(){
        harvestList.clear();
    }


}