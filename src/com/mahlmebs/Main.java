package com.mahlmebs;

/* Cool main program
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;

public class Main {
    
    static int max = 40;
    static MiniDungeonGUI gui = new MiniDungeonGUI(max,max);
    static Hero coolHero = new Hero();
    static int[][] gotItemsLocation = new int[11][2];
    
    public static void main(String[] args) throws InterruptedException{
        
        Room room = new Room ();
        Space[][] level = room.generateRooms(max, gui);
        gui.setVisible(true);
        Random random = new Random();
        int heroStartX = random.nextInt(15 - 2 + 1) + 2;
        int heroStartY = random.nextInt(10 - 1 + 1) + 1;
        int[] valid = validCoordinates(level, heroStartX, heroStartY);
        coolHero.setPositionX(valid[0]);
        coolHero.setPositionY(valid[1]);
        // In the following lines we set the hero in the correct place
        // and print some values that should be visible for the user.
    
        // Printing our cool hero
        gui.md_addSprite(coolHero.getId(), "cool.png", true);
        gui.md_setSpriteVisible(coolHero.getId(), true);
        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
        // Printing important info about the hero
        gui.md_setTextGold(coolHero.getGold());
        gui.md_setTextFood(coolHero.getFood());
        gui.md_setTextHealthCurrent(coolHero.getHealth());
        gui.md_setTextHealthMax(coolHero.getMaxHealth());
        gui.md_setTextStrength(coolHero.getStrength());
        gui.md_setTextPerception(coolHero.getPerception());
        gui.md_setTextPlayerName(coolHero.getName());
        gui.md_setPortraitPlayer("herohd.png");
        
        //testing gold
        
        Gold [] goldCoins = new Gold [8];
        for (int i = 0; i < goldCoins.length; i++){
            goldCoins[i] = new Gold();
            int goldStartX = random.nextInt(10 - 5 + 1) + 5;
            int goldStartY = random.nextInt(15 - 2 + 1) + 2;
            valid = validCoordinates(level, goldStartX, goldStartY);

            goldCoins[i].setPositionX(valid[0]);
            goldCoins[i].setPositionY(valid[1]);
            goldCoins[i].setId(2+i); // id = 1 is avoided 'cause is the hero's one
            gui.md_addSprite(goldCoins[i].getId(), goldCoins[i].getImage(), true);
            gui.md_setSpriteVisible(goldCoins[i].getId(), true);
            gui.md_moveSprite(goldCoins[i].getId(), goldCoins[i].getPositionX(), goldCoins[i].getPositionY());
        }
        
        Potion [] potions = new Potion[3];
        for (int i = 0; i < potions.length; i++){
            potions[i] = new Potion();
            int potionStartX = random.nextInt(18 - 4 + 1) + 4;
            int potionStartY = random.nextInt(10 - 2 + 1) + 2;
            valid = validCoordinates(level, potionStartX, potionStartY);
            potions[i].setPositionX(valid[0]);
            potions[i].setPositionY(valid[1]);
            potions[i].setId(10+i); // id=1 to id=9 are avoided 'cause they are already in use.
            gui.md_addSprite(potions[i].getId(), potions[i].getImage(), true);
            gui.md_setSpriteVisible(potions[i].getId(), true);
            gui.md_moveSprite(potions[i].getId(), potions[i].getPositionX(), potions[i].getPositionY());
        }
        
        
        
        // Here we make our hero move when the arrow keys are pressed,
        // taking into account to reduce its food each time he moves
        // and dividing his perception and strength by two when food = 0.
        
        while(true){
            // TODO limit the max
            // TODO control move if it's wall or not
            
            String lastAction = gui.md_getLastAction().trim();
            
            if (lastAction.length() > 0){
                int x = coolHero.getPositionX(); int y = coolHero.getPositionY();

                if (lastAction.equals("left") && !level[x-1][y].isWall()){
                    coolHero.setPositionX(x-1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());

                }
                if (lastAction.equals("right") && !level[x+1][y].isWall()) {
//                    int x = coolHero.getPositionX(); int y = coolHero.getPositionY();
                    coolHero.setPositionX(x+1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                if (lastAction.equals("down") && !level[x][y+1].isWall()) {
//                    int x = coolHero.getPositionX(); int y = coolHero.getPositionY();
                    coolHero.setPositionY(y+1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                if (lastAction.equals("up") && !level[x][y-1].isWall()) {
//                    int x = coolHero.getPositionX(); int y = coolHero.getPositionY();
                    coolHero.setPositionY(y-1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                gui.md_println(lastAction);
                
                for (int i=0; i < goldCoins.length + potions.length + 1; i++) {
                    if (i < 8) {
    
                        // Here we check if the hero's position coincides with an item position.
                        if (coolHero.getPositionX() == goldCoins[i].getPositionX() &&
                            coolHero.getPositionY() == goldCoins[i].getPositionY()) {
    
                            // Here we check if that item has not yet been achieved.
                            if (gotItemsLocation[i][0] != coolHero.getPositionX() &&
                                gotItemsLocation[i][1] != coolHero.getPositionY()) {
    
                                // We mark the the object as achieved.
                                gotItemsLocation[i][0] = coolHero.getPositionX();
                                gotItemsLocation[i][1] = coolHero.getPositionY();
    
                                // We activate the function of the object and hide it from the player.
                                coolHero.addGold();
                                gui.md_setSpriteVisible(i+2, false);
                                gui.md_setTextGold(coolHero.getGold());
                            }
                        }
                    }
                    
                    if (i < 3) {
    
                        if (coolHero.getPositionX() == potions[i].getPositionX() &&
                            coolHero.getPositionY() == potions[i].getPositionY()) {
        
                            // Here we check if that item has not yet been achieved.
                            if (gotItemsLocation[i][0] != coolHero.getPositionX() &&
                                gotItemsLocation[i][1] != coolHero.getPositionY()) {
            
                                // We mark the the object as achieved.
                                gotItemsLocation[i][0] = coolHero.getPositionX();
                                gotItemsLocation[i][1] = coolHero.getPositionY();
            
                                // We activate the function of the object and hide it from the player.
                                coolHero.addHealth();
                                gui.md_setSpriteVisible(i+10, false);
                                gui.md_setTextHealthCurrent(coolHero.getHealth());
                            }
        
                        }
                    }
                }
                
                
                // Reducing food after each movement (only if food is not already 0)
                if (coolHero.getFood() > 0) {
                    coolHero.lessFood();
                    gui.md_setTextFood(coolHero.getFood());
                }
                
                // Checking if food = 0, and reducing perception and strength if true
                if (coolHero.getFood() == 0){
                    if (coolHero.getPerception() > 1) {
                        coolHero.setPerception(coolHero.getPerception() / 2);
                        gui.md_setTextPerception(coolHero.getPerception());
                    }
                    if (coolHero.getStrength() > 1) {
                        coolHero.setStrength(coolHero.getStrength() / 2);
                        gui.md_setTextStrength(coolHero.getStrength());
                    }
                }
            }
            Thread.sleep(5);
        }
    }

    static int[] validCoordinates(Space[][]level, int x, int y){
        Random random = new Random();
        int[] validated = new int[2];
        if(x+1 == max || y+1 == max){
            x = random.nextInt(30 - 5 + 1) + 5;
            y = random.nextInt(25 - 2 + 1) + 2;
        }
        while(level[x][y].isWall()){
            if(x+1 == max || y+1 == max){
                x = random.nextInt(30 - 5 + 1) + 5;
                y = random.nextInt(25 - 2 + 1) + 2;
            } else{
                x++;
                y++;
            }
        }
        validated[0] = x;
        validated[1] = y;
        return validated;
    }

}
