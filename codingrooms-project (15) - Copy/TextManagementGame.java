import java.util.Scanner;

import javax.sound.midi.Soundbank;

import java.util.ArrayList;
import java.util.Random;

/**
 * The TextManagementGame class represents a text-based management game where the player manages resources and resource generators.
 */
public class TextManagementGame {
    // Define game variables
    private int round;
    private int score;
    public ArrayList<Resource> resources = new ArrayList<Resource>();
    public ArrayList<Generator> generators = new ArrayList<Generator>();
    public ArrayList<Bananimals> bananimals = new ArrayList<Bananimals>();
    private int sprinklers = 0;
    private boolean isWeevils = false;
    private int weevils = 0;



    

    // Define a Scanner for user input
    private Scanner scanner;

    /**
     * Creates a new TextManagementGame instance with initial resource and time values.
     * TODO : Add starting resources
     */


    public TextManagementGame() {
        round = 1;       // Start at time 1
        scanner = new Scanner(System.in);
    }

    /**
     * Check if a method should run with a 1 in number chance.
     *
     * @return true if the method should run, false otherwise
     */
    public boolean haveEventThisTurn(int number) {
        Random random = new Random();
        int chance = random.nextInt(number); // Generates a random number between 0 (inclusive) and number (exclusive)
        return chance == 0; // Returns true with a 1 in number chance
    }

    /**
    * Prints the list of resources
    */
    public void viewResources(){
        for(Resource r : resources){
            System.out.println(r);
        }
    }
    public Bananas getPlayerBananas() {
        for (Resource resource : resources) {
            if (resource instanceof Bananas) {
                return (Bananas) resource;
            }
        }
        return null; 
    }
    public Money getPlayerMoney() {
        for (Resource resource : resources) {
            if (resource instanceof Money) {
                return (Money) resource;
            }
        }
        return null; 
    }
    public Wood getPlayerWood() {
        for (Resource resource : resources) {
            if (resource instanceof Wood) {
                return (Wood) resource;
            }
        }
        return null; 
    }
    public Bananimals getPlayerBananimals() {
        for (Resource resource : resources) {
            if (resource instanceof Bananimals) {
                return (Bananimals) resource;
            }
        }
        return null; 
    }
    public int countGeneratorType(Class<? extends Generator> type) {
        int count = 0;
        for (Generator generator : generators) {
            if (type.isInstance(generator)) {
                count++;
            }
        }
        return count;
    }
    /**
    * Prints the list of Generators
    */
    public void viewGenerators(){
        for(Generator b : generators){
            System.out.println(b);
        }
    }
    

    /**
     * Checks if a Generator can be constructed and then adds it to the list of Generators
     * TODO : ADD LOGIC
     */
    public void constructGenerator(){
        
    }

    /** 
     * Increments the time counter and then adds more resources based on what generators are present
     * TODO : Add calculations to generate resources for the next turn
     */
    public void endRound(){
        round++;
    }

    /**
     * Adds a Generator object to the ArrayList of Generators.
     *
     * @param Generator the Generator object to add
     */
    public void addGenerator(Generator generator) {
        generators.add(generator);
    }

    /**
     * Adds a Resource object to the ArrayList of resources.
     *
     * @param resource the Resource object to add
     */
    public void addResource(Resource resource) {
        resources.add(resource);
    }

    /**
     * Checks if we are out of any critical resources
     *
     * @return returns true if we are out of any critical resources returns false otherwise
    */
    public boolean isCriticalResourceEmpty(){
        for(Resource r : resources){
            if(r.isCritical() && r.getQuantity() == 0){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Generator> getGenerators() {
        return generators;
    }

    public int getSprinklers(){
        return sprinklers;
    }
    



    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public void setGenerators(ArrayList<Generator> generators) {
        this.generators = generators;
    }

    public void setSprinklers(int sprinklers) {
        this.sprinklers = sprinklers;
    }

    public boolean isWeevils() {
        return isWeevils;
    }

    public void setIsWeevils(boolean isWeevils) {
        this.isWeevils = isWeevils;
    }

    public int getWeevils() {
        return weevils;
    }

    public void setWeevils(int weevils) {
        this.weevils = weevils;
    }

    public static String getMoneyString(int amount) {
        int cents = amount % 100;
        int dollars = (amount - cents) / 100;

        String camount;
        if (cents <= 9) {
            camount = 0 + "" + cents;
        } else {
            camount = "" + cents;
        }

        return "$" + dollars + "." + cents;    
    }
    public static int inputInt(){       
        Scanner sc = new Scanner(System.in);
        int choiceI = 0;
        while(true){
            try{
                choiceI = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Please dont break my code");
                sc.next();
                continue;
            }
            sc.nextLine();
            return choiceI;
        }   
    }

    /**
     * Main method to run the game
     *
     * @param args the command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        TextManagementGame game = new TextManagementGame();
        BananaPlot starterPlot = new BananaPlot("Banana Plot 1");
        game.addGenerator(starterPlot);

        Market starterMarket = new Market("Market 1");
        game.addGenerator(starterMarket);

        Money playerMoney = new Money("Your Balance");
        game.addResource(playerMoney);
        playerMoney.addMoney(8000);

        Bananas playerBananas = new Bananas("Your Bananas");
        game.addResource(playerBananas);

        Wood playerWood = new Wood("Your Wood");
        game.addResource(playerWood);

        Bananimals playerBananimals = new Bananimals("Your Bananimals");
        game.addResource(playerBananimals);

        InfoPrinter infoPrinter = new InfoPrinter();
        //game.addResource(new Bananas("Banana"));

        System.out.println("\tWelcome to Banana Republic\n--------------------"); 
        System.out.println("This is a turn based strategy game about Banana farming. You have have 49 days to harvest as many bananas as you can and make as much money as possible. By the end of the growing season you will be scored based on your total income, so dont be afraid to spend some money! Here are some tips and tricks you should be aware of!"); 
        System.out.println("  - You can do as much as you want every day, as long as you have the materials to do so. The day doesnt end till you go to bed");
        System.out.println("  - During any menu, you can exit back to the main option list by pressing '0'");
        System.out.println("  - Bananas sell for 50 cents per peice from the beginning");
        System.out.println("  - Markets can only sell so much per day, but refresh with every new sun");
        System.out.println("  - Bananas are sold from markets in the order you get them. Market 2 wont sell bananas until Market 1 is out of stock");
        System.out.println("  - There is a small chance every turn that random events can happen! these can be both beneficial and harmful");
        System.out.println("  - Around half way though banana season, it'll get real hot, and weevils will start to get hungry. Their population gets exponentially dangerous");
        System.out.println("  - You can make Bananimal farms to keep pests away from your crops,  however they can get eaten in the process");
        
        int oddsOfRandomEvent = 4; //a 25% chance of a random event occuring

        // Main game loop
        Dayloop: 
        while (!game.isCriticalResourceEmpty()) {
            //refresh markets
            for (Generator M : game.getGenerators()){
                if (M instanceof Market){
                    Market market = (Market) M;
                    market.setSold(false);
                }
            }
            infoPrinter.clearAlerts();
            infoPrinter.clearHarvest();
            infoPrinter.growBananimals(game);
            infoPrinter.calculateWeevils(game);
            
            System.out.println("\n\n\tDay " + game.getRound() + "\n~~~~~~~~~~~~~~~~~~~~~~~~~");
            //round end
            if (game.round != 1){
                infoPrinter.growAllBananas(game);
            }
            infoPrinter.printInfo(game);
                
            
            //if(haveEventThisTurn(oddsOfRandomEvent)){
                //TODO add logic for random events
                //System.out.println("A random event happened!");
            //}
            Menuloop: 
            while (1 == 1){
                

            
                System.out.println("\nOptions:");
                System.out.println("1. Buy a Generator");
                System.out.println("2. View Resources and Farms");
                System.out.println("3. Sell Bananas");
                System.out.println("4. Upgrade Farm");
                System.out.println("5. End round");
                System.out.println("6. Quit game");
                System.out.print("Choose an option: ");
                int choice = inputInt();

                switch (choice) {
                    case 1:
                    int pick1 = 0;
                        while (true){ //Purchase Gen Loop
                        int woodCost = 3 + 2*(game.countGeneratorType(BananaPlot.class));
                        System.out.println("\nOptions:");
                        System.out.println("1. Buy a Banana Plot - Requires " + woodCost + " wood");
                        System.out.println("2. Buy a Market - Requires 3 wood and $3");
                        System.out.println("3. Buy a Bananimal Farm - Requires $5");
                        pick1 = inputInt();
                        if (pick1 == 0){
                                continue Menuloop;
                            }
                            if (pick1 == 1){ //Buy Banana Plot
                                if(playerWood.getWood() >= woodCost){
                                    String newPlotName = ("Banana Plot " + (game.countGeneratorType(BananaPlot.class) + 1));
                                    System.out.println(newPlotName + " purchased!");
                                    BananaPlot newPlot = new BananaPlot(newPlotName);
                                    newPlot.setGrowth(0);
                                    
                                    game.addGenerator(newPlot);
                                    playerWood.removeWood(woodCost);
                                    break;
                                }
                                else{
                                    System.out.println("Not enought wood");
                                    break;
                                }
                            }else if (pick1 == 2) { //Buy Market
                                if(playerWood.getWood() >= 3 && playerMoney.getMoney() >= 300){
                                    String newMarketName = ("Market " + (game.countGeneratorType(Market.class) + 1));
                                    System.out.println(newMarketName + " purchased!");
                                    Market newMarket = new Market(newMarketName);
                                    game.addGenerator(newMarket);
                                    playerWood.removeWood(3);
                                    playerMoney.removeMoney(300);
                                    break;
                                }
                                else{
                                    System.out.println("Not enought resources");
                                    break;
                                }

                            }else if (pick1 == 3) { // Buy Bananimal Farm
                                if(playerMoney.getMoney() >= 500){
                                    String newBananimalFarmName = ("Bananimal Farm " + (game.countGeneratorType(BananimalFarm.class) + 1));
                                    System.out.println(newBananimalFarmName + " purchased!");
                                    BananimalFarm newBananimalFarm = new BananimalFarm(newBananimalFarmName);
                                    game.addGenerator(newBananimalFarm);
                                    playerMoney.removeMoney(500);
                                    break;
                                }
                                else{
                                    System.out.println("Not enought resources");
                                    break;
                                }
                             
                            }else{
                                System.out.println("Please select a valid option");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n\n\tDay " + game.getRound() + "\n~~~~~~~~~~~~~~~~~~~~~~~~~");
                        infoPrinter.printInfo(game);
                        break;
                    case 3: 
                    //calculate max market sales
                        int sellableBananas = 0;
                        for (Generator M : game.getGenerators()){
                            if (M instanceof Market){
                                Market market = (Market) M;
                                if(market.getSold() == false){
                                    sellableBananas += (4*(1 + market.getSize()));
                                }
                            }
                        }
                        if (sellableBananas == 0){
                            System.out.println("\nYour markets are all sold out");
                            continue Menuloop;
                        }
                        System.out.println("\nYour markets can sell up to " + sellableBananas + " bananas");
                        int toSell = 0;
                        String string2;
                        //get banans to sell, and make sure its valid
                        while (true){
                        System.out.println("Select how many bananas you would like to sell, or 'a' to sell all");
                        string2 = game.scanner.nextLine();
                            if(string2.equals("a") || string2.equals("A")){
                                toSell = sellableBananas;
                                if (toSell > playerBananas.getBananas()){
                                    toSell = playerBananas.getBananas();
                                }

                            }
                            else{
                                try {
                                    toSell = Integer.parseInt(string2);
                                    if (toSell > playerBananas.getBananas()){
                                        System.out.println("You dont have that many bananas silly!");
                                        continue;
                                    }
                                    if (toSell > sellableBananas){
                                        System.out.println("Your markets cant sell that many bananas silly!");
                                        continue;
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Invalid option selected");
                                    continue;
                                }
                            }
                        //sell bananas
                        int revenue = 0;
                        int toSell2 = toSell;
                        SellLoop:
                        for (Generator M : game.getGenerators()){
                            if (M instanceof Market){
                                Market market = (Market) M;
                                if(market.getSold() == false){
                                    if (toSell >= 4*(1 + market.getSize())){
                                        revenue += (50*(4*(1 + market.getSize())) * (1 + (.2 * market.getSalesBonus())));
                                        toSell -= 4*(1 + market.getSize());
                                        playerBananas.removeBananas(4*(1 + market.getSize()));
                                        market.setSold(true);
                                    }
                                    else if (toSell < 4*(1 + market.getSize()) && toSell != 0){
                                        revenue += (50*toSell) * (1 + (.2 * market.getSalesBonus()));
                                        playerBananas.removeBananas(toSell); 
                                        toSell = 0;
                                        market.setSold(true);
                                    }
                                    else{
                                        break SellLoop;
                                    }
                                } 
                            }
                        }
                        playerMoney.addMoney(revenue);
                        game.score += revenue;
                        System.out.println("Sold " + toSell2 + " bananas for " + getMoneyString(revenue));
                        
                        continue Menuloop;
                        }
                    case 4:
                    int pick2;
                        while(true){
                            System.out.println("\nOptions:");
                            System.out.println("1. Upgrade Banana Plots");
                            System.out.println("2. Upgrade Markets");
                            System.out.println("3. Upgrade Sprinklers " + game.getSprinklers() + "/3, ($10.00)");
                            System.out.println("4. Upgrade Bananimal Farms");
                            pick2 = inputInt();
                            if (pick2 == 0){
                                continue Menuloop;
                            }

                            if(pick2 == 1){
                                int pick3;
                                int plotCount = 0;
                                System.out.println("Select Banana Plot to upgrade : (ex. '1', '2', etc)");
                                for (Generator P : game.getGenerators()){
                                    if (P instanceof BananaPlot){
                                        plotCount += 1;
                                        BananaPlot bananaPlot = (BananaPlot) P;
                                        System.out.println(bananaPlot.getPlotName() + "\n\tTaller Trunks : " + bananaPlot.getTallTrunk() + "/3" + "\n\tMore Bananas : " + bananaPlot.getMoreBananas() + "/3");
                                    }
                                }
                                pick3 = inputInt();
                                if (pick3 == 0){
                                continue Menuloop;
                                }
                                if (plotCount < pick3 || pick3 == 0){
                                    System.out.println("Invalid Choice");
                                    continue Menuloop;
                                }
                                int maxoutPrice = 0;
                                for (Generator P : game.getGenerators()){
                                    int plotCounter2 = 0;
                                    if (P instanceof BananaPlot){
                                        plotCounter2 += 1;
                                        BananaPlot bananaPlot = (BananaPlot) P;
                                        if (plotCounter2 == pick3){
                                            maxoutPrice = 4 * (3-(bananaPlot.getTallTrunk()) + (3 - bananaPlot.getMoreBananas()));
                                        }
                                    }
                                }


                                System.out.println("Select Upgrade");
                                System.out.println("1. Taller Trunks - requires $4");
                                System.out.println("2. More Bananas - requires $4");
                                System.out.println("3. Max out farm - requires $" + maxoutPrice);
                                int pick4 = inputInt();
                                if (pick4 == 0){
                                continue Menuloop;
                                }
                                if (3 < pick4 || pick4 < 0){
                                    System.out.println("Not an option");
                                    continue Menuloop;
                                }
                                if (playerMoney.getMoney() < 400){ //check for sufficient funds
                                    System.out.println("Those funds aint gonna cut it!");
                                    continue Menuloop;
                                }
                                int plotCounter = 0;
                                for (Generator P : game.getGenerators()){
                                    if (P instanceof BananaPlot){
                                        plotCounter += 1;
                                        BananaPlot bananaPlot = (BananaPlot) P;
                                        if (plotCounter == pick3){
                                            if (pick4 == 1){
                                                if(bananaPlot.getTallTrunk() >= 3){
                                                    System.out.println("Upgrade Max Reached");
                                                    continue Menuloop;    
                                                }
                                                bananaPlot.upgradeTallTrunk();
                                                playerMoney.removeMoney(400);
                                                System.out.println("Upgrade Successful");
                                                continue Menuloop;
                                            }
                                            else if(pick4 == 2){
                                                if(bananaPlot.getMoreBananas() >= 3){
                                                    System.out.println("Upgrade Max Reached");
                                                    continue Menuloop;    
                                                }
                                                bananaPlot.upgradeMoreBananas();
                                                playerMoney.removeMoney(400);
                                                System.out.println("Upgrade Successful");
                                                continue Menuloop;
                                            }else{
                                                if (playerMoney.getMoney() < maxoutPrice * 100){ //check for sufficient funds
                                                    System.out.println("Those funds aint gonna cut it!");
                                                    continue Menuloop;
                                                }
                                                bananaPlot.setMoreBananas(3);
                                                bananaPlot.setTallTrunk(3);
                                                playerMoney.removeMoney(maxoutPrice * 10);
                                                System.out.println("Upgrade Successful");

                                            }
                                            }
                                        }
                                    }
                                
                                continue Menuloop;

                            }else if (pick2 == 2){
                                int pick5;
                                int marketCount = 0;
                                System.out.println("Select Market to upgrade : (ex. '1', '2', etc)");
                                for (Generator M : game.getGenerators()){
                                    if (M instanceof Market){
                                        marketCount += 1;
                                        Market market = (Market) M;
                                        System.out.println(market.getMarketName() + "\n\tMarket Size : " + market.getSize() + "/3" + "\n\tSales Bonus : " + market.getSalesBonus() + "/3");
                                    }
                                }
                                pick5 = inputInt();
                                if (pick5 == 0){
                                continue Menuloop;
                                }
                                if (marketCount < pick5 || pick5 == 0){
                                    System.out.println("Invalid Choice");
                                    continue Menuloop;
                                }
                                int maxoutMarketPrice = 0;
                                int maxoutMarketWood = 0;
                                for (Generator M : game.getGenerators()){
                                    int plotCounter3 = 0;
                                    if (M instanceof Market){
                                        plotCounter3 += 1;
                                        Market market = (Market) P;
                                        if (plotCounter3 == pick5){
                                            maxoutMarketPrice = 3 * (3-(market.getSize())) + 2 * (3 - market.getSalesBonus());
                                            maxoutMarketWood = 4 * (3-(market.getSize()));
                                        }
                                    }
                                }
                                System.out.println("Select Upgrade");
                                System.out.println("1. Market Size - requires $3 and 4 wood");
                                System.out.println("2. Sales Bonus - requires $2");
                                System.out.println("2. Max out Market - requires $2");
                                int pick6 = inputInt();
                                if (pick6 == 0){
                                continue Menuloop;
                                }
                                if (marketCount < pick5){
                                    System.out.println("Not an option");
                                    continue Menuloop;
                                }
                                
                                int marketCounter = 0;
                                for (Generator M : game.getGenerators()){
                                    if (M instanceof Market){
                                        marketCounter += 1;
                                        Market market = (Market) M;
                                        if (marketCounter == pick5){
                                            if (pick6 == 1){
                                                if(market.getSize() >= 3){
                                                    System.out.println("Upgrade Max Reached");
                                                    continue Menuloop;    
                                                }
                                                if (playerMoney.getMoney() < 300){ //check for sufficient funds
                                                    System.out.println("Those funds aint gonna cut it!");
                                                    continue Menuloop;
                                                }
                                                if (playerWood.getWood() < 4){ //check for sufficient funds
                                                    System.out.println("Gonna need more wood than that!");
                                                    continue Menuloop;
                                                }
                                                market.upgradeSize();
                                                playerMoney.removeMoney(300);
                                                playerWood.removeWood(4);
                                                System.out.println("Upgrade Successful");
                                                continue Menuloop;
                                            }
                                            else{
                                                if(market.getSalesBonus() >= 3){
                                                    System.out.println("Upgrade Max Reached");
                                                    continue Menuloop;    
                                                }
                                                if (playerMoney.getMoney() < 200){ //check for sufficient funds
                                                    System.out.println("Those funds aint gonna cut it!");
                                                    continue Menuloop;
                                                }
                                                market.upgradeSalesBonus();
                                                playerMoney.removeMoney(200);
                                                System.out.println("Upgrade Successful");
                                                continue Menuloop;
                                            }
                                        }
                                    }
                                }
                                continue Menuloop;

                            }else if (pick2 == 3){
                                if (game.getSprinklers() >= 3){
                                    System.out.println("Sprinklers maxed out!");
                                    continue Menuloop;
                                }
                                if (playerMoney.getMoney() < 1000){ //check for sufficient funds
                                    System.out.println("Those funds aint gonna cut it!");
                                    continue Menuloop;
                                }
                                game.sprinklers += 1;
                                playerMoney.removeMoney(1000);      
                                System.out.println("Purchase Successful\n");
                                continue Menuloop;                              
                                
                            }else if (pick2 == 4){
                                int pick7;
                                int farmCount = 0;
                                System.out.println("Select Bananimal Farm to upgrade : (ex. '1', '2', etc) - requires 8 bananas");
                                for (Generator F : game.getGenerators()){
                                    if (F instanceof BananimalFarm){
                                        farmCount += 1;
                                        BananimalFarm bananimalFarm = (BananimalFarm) F;
                                        System.out.println(bananimalFarm.getFarmName() + "\n\tLevel : " + bananimalFarm.getLevel() + "/2");
                                    }
                                }
                                pick7 = inputInt();
                                if (pick7 == 0){
                                continue Menuloop;
                                }
                                if (farmCount < pick7 || pick7 == 0){
                                    System.out.println("Invalid Choice");
                                    continue Menuloop;
                                }
                    
                                
                                int farmCounter = 0;
                                for (Generator F : game.getGenerators()){
                                    if (F instanceof BananimalFarm){
                                        farmCounter += 1;
                                        BananimalFarm bananimalFarm = (BananimalFarm) F;
                                        if (farmCounter == pick7){
                                            if(bananimalFarm.getLevel() >= 2){
                                                System.out.println("Upgrade Max Reached");
                                                continue Menuloop;    
                                            }
                                            if (playerBananas.getBananas() < 8){ //check for sufficient funds
                                                System.out.println("not enough bananers!");
                                                continue Menuloop;
                                            }
                                            bananimalFarm.upgradeLevel();
                                            playerBananas.removeBananas(8);
                                            
                                            System.out.println("Upgrade Successful");
                                            continue Menuloop;
                                            }
                                            
                                        }
                                }
                            
                                continue Menuloop;

                            }else{
                                ;
                            }

                        }
                    case 5:
                        game.endRound();
                        break Menuloop;
                    case 6:
                        System.out.println("/nAre you sure you want to quit?\n1: Keep Playing\n2: End Game");
                        int endGame = inputInt();
                        if (endGame == 2){
                            System.out.println("\nThank you for playing! In " + game.round + " Days you got a score of " + game.score);
                            System.exit(0);
                            
                        }
                        continue Menuloop;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        System.out.println("\nGrowing season has ended! Thank you for playing Banana Republic. your final score was " + game.score);
    }
    }
