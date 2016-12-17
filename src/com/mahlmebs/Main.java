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
	static Random random = new Random();


	static Hero coolHero = new Hero();
    static int[][] gotItemsLocation = new int[21][2];
    
    
    public static void main(String[] args) throws InterruptedException {


        // Printing the rooms
        Room room = new Room();
        Space[][] level = room.generateRooms(max, gui);
		int xDoor = random.nextInt(40 - 1 + 1) + 1;
		int yDoor = random.nextInt(40 - 1 + 1) + 1;
		while(level[xDoor][yDoor].isWall()){
			xDoor = random.nextInt(40 - 1 + 1) + 1;
			yDoor = random.nextInt(40 - 1 + 1) + 1;
		}
		gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);


		gui.setVisible(true);
        int heroStartX = random.nextInt(15 - 2 + 1) + 2;
        int heroStartY = random.nextInt(10 - 1 + 1) + 1;
        int[] valid = validCoordinates(level, heroStartX, heroStartY);
        coolHero.setPositionX(valid[0]);
        coolHero.setPositionY(valid[1]);
        
        // Setting the hero in the correct place and
        // printing some values that should be visible for the user.
    
        // Printing the hero
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
    
    
        // Creating the Items
        // If there are more than one item of the same type,
        // they will be considered an array of that item.
    
        Gold[] goldCoins = new Gold[8];
        for (int i = 0; i < goldCoins.length; i++) {
            goldCoins[i] = new Gold();
            goldCoins[i].setId(1 + i); // id = 0 is avoided 'cause is the hero's one
	        
            int goldStartX = random.nextInt(10 - 5 + 1) + 5;
            int goldStartY = random.nextInt(15 - 2 + 1) + 2;
            valid = validCoordinates(level, goldStartX, goldStartY);
            goldCoins[i].setPositionX(valid[0]);
            goldCoins[i].setPositionY(valid[1]);
	        
            gui.md_addSprite(goldCoins[i].getId(), goldCoins[i].getImage(), true);
            gui.md_setSpriteVisible(goldCoins[i].getId(), true);
            gui.md_moveSprite(goldCoins[i].getId(), goldCoins[i].getPositionX(), goldCoins[i].getPositionY());
        }
    
        Potion[] potions = new Potion[3];
        for (int i = 0; i < potions.length; i++) {
            potions[i] = new Potion();
            potions[i].setId(9 + i); // id=1 to id=8 are avoided 'cause they are already in use.
            int potionStartX = random.nextInt(18 - 4 + 1) + 4;
            int potionStartY = random.nextInt(10 - 2 + 1) + 2;
            valid = validCoordinates(level, potionStartX, potionStartY);
            potions[i].setPositionX(valid[0]);
            potions[i].setPositionY(valid[1]);
            gui.md_addSprite(potions[i].getId(), potions[i].getImage(), true);
            gui.md_setSpriteVisible(potions[i].getId(), true);
            gui.md_moveSprite(potions[i].getId(), potions[i].getPositionX(), potions[i].getPositionY());
        }
    
        Apple[] apples = new Apple[5];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
            apples[i].setId(12 + i); // id=1 to id=11 are avoided 'cause they are already in use.
	        int applesStartX = random.nextInt(10 - 5 + 1) + 5;
	        int applesStartY = random.nextInt(15 - 2 + 1) + 2;
	        valid = validCoordinates(level, applesStartX, applesStartY);
	        apples[i].setPositionX(valid[0]);
	        apples[i].setPositionY(valid[1]);
            gui.md_addSprite(apples[i].getId(), apples[i].getImage(), true);
            gui.md_setSpriteVisible(apples[i].getId(), true);
            gui.md_moveSprite(apples[i].getId(), apples[i].getPositionX(), apples[i].getPositionY());
        }
    
        Heart heart = new Heart();
        heart.setId(17); // id=1 to id=16 are avoided 'cause they are already in use.
	    int heartStartX = random.nextInt(10 - 5 + 1) + 5;
	    int heartStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, heartStartX, heartStartY);
	    heart.setPositionX(valid[0]);
	    heart.setPositionY(valid[1]);
        gui.md_addSprite(heart.getId(), heart.getImage(), true);
        gui.md_setSpriteVisible(heart.getId(), true);
        gui.md_moveSprite(heart.getId(), heart.getPositionX(), heart.getPositionY());
    
        Eye eye = new Eye();
        eye.setId(18); // id=1 to id=17 are avoided 'cause they are already in use.
	    int eyeStartX = random.nextInt(10 - 5 + 1) + 5;
	    int eyeStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, eyeStartX, eyeStartY);
	    eye.setPositionX(valid[0]);
	    eye.setPositionY(valid[1]);
        gui.md_addSprite(eye.getId(), eye.getImage(), true);
        gui.md_setSpriteVisible(eye.getId(), true);
        gui.md_moveSprite(eye.getId(), eye.getPositionX(), eye.getPositionY());
    
        Sword sword = new Sword();
        sword.setId(19); // id=1 to id=18 are avoided 'cause they are already in use.
	    int swordStartX = random.nextInt(10 - 5 + 1) + 5;
	    int swordStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, swordStartX, swordStartY);
	    sword.setPositionX(valid[0]);
	    sword.setPositionY(valid[1]);
        gui.md_addSprite(sword.getId(), sword.getImage(), true);
        gui.md_setSpriteVisible(sword.getId(), true);
        gui.md_moveSprite(sword.getId(), sword.getPositionX(), sword.getPositionY());
    
	    
	    
        // Here we make our hero move when the arrow keys are pressed,
        // taking into account to reduce its food each time he moves
        // and dividing his perception and strength by two when food = 0.
        
        while(true){
            // TODO limit the max

            String lastAction = gui.md_getLastAction().trim();

            if(coolHero.getPositionX() == xDoor && coolHero.getPositionY() == yDoor){
            	break;
			}
            
            if (lastAction.length() > 0){
                int x = coolHero.getPositionX(); int y = coolHero.getPositionY();

                if (lastAction.equals("left") && !level[x-1][y].isWall()){
                        coolHero.setPositionX(x-1);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                if (lastAction.equals("right") && !level[x+1][y].isWall()) {
                    coolHero.setPositionX(x+1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                if (lastAction.equals("down") && !level[x][y+1].isWall()) {
                    coolHero.setPositionY(y+1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
                if (lastAction.equals("up") && !level[x][y-1].isWall()) {
                    coolHero.setPositionY(y-1);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
				if (lastAction.equals("new game")) {
                	main(args);
				}
				gui.md_println(lastAction);
	
	            // Checking if the user is in the same cell as an item and activating the item function if true.
	            // Brief explanation inside the code for goldCoins can be used to explain code for the rest of the items.
	
	            for (int i = 0; i < goldCoins.length; i++) {
		            // Here we check if the hero's position coincides with an item position.
		            if (coolHero.getPositionX() == goldCoins[i].getPositionX() &&
			            coolHero.getPositionY() == goldCoins[i].getPositionY()) {
			
			            // Checking if that item has not yet been achieved, using the gotItemsLocation matrix.
			            if (gotItemsLocation[goldCoins[i].getId()][0] != coolHero.getPositionX() &&
				            gotItemsLocation[goldCoins[i].getId()][1] != coolHero.getPositionY()) {
				
				            // Marking the object as achieved, using the gotItemsLocation matrix.
				            gotItemsLocation[goldCoins[i].getId()][0] = coolHero.getPositionX();
				            gotItemsLocation[goldCoins[i].getId()][1] = coolHero.getPositionY();
				
				            // Activating the function of the object.
				            coolHero.addGold();
				            // Making the already used item disappear.
				            gui.md_setSpriteVisible(goldCoins[i].getId(), false);
				            gui.md_setTextGold(coolHero.getGold());
			            }
		            }
	            }
	
	            for (int i = 0; i < apples.length; i++) {
		            if (coolHero.getPositionX() == apples[i].getPositionX() &&
			            coolHero.getPositionY() == apples[i].getPositionY()) {
			
			            if (gotItemsLocation[apples[i].getId()][0] != coolHero.getPositionX() &&
				            gotItemsLocation[apples[i].getId()][1] != coolHero.getPositionY()) {
				
				            gotItemsLocation[apples[i].getId()][0] = coolHero.getPositionX();
				            gotItemsLocation[apples[i].getId()][1] = coolHero.getPositionY();
				
				            coolHero.addApple();
				            gui.md_setSpriteVisible(apples[i].getId(), false);
				            gui.md_setTextFood(coolHero.getFood());
			            }
		            }
	            }
	
	            for (int i = 0; i < potions.length; i++) {
		            if (coolHero.getPositionX() == potions[i].getPositionX() &&
			            coolHero.getPositionY() == potions[i].getPositionY()) {
			
			            if (gotItemsLocation[potions[i].getId()][0] != coolHero.getPositionX() &&
				            gotItemsLocation[potions[i].getId()][1] != coolHero.getPositionY()) {
				
				            gotItemsLocation[potions[i].getId()][0] = coolHero.getPositionX();
				            gotItemsLocation[potions[i].getId()][1] = coolHero.getPositionY();
				
				            coolHero.addPotion();
				            gui.md_setSpriteVisible(potions[i].getId(), false);
				            gui.md_setTextHealthCurrent(coolHero.getHealth());
			            }
			
		            }
	            }
	
	            // Here we check if the hero's position coincides with the HEART item position
	            if (coolHero.getPositionX() == heart.getPositionX() &&
		            coolHero.getPositionY() == heart.getPositionY()) {
		
		            if (gotItemsLocation[heart.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[heart.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[heart.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[heart.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addHeart();
			            gui.md_setSpriteVisible(17, false);
			            gui.md_setTextHealthCurrent(coolHero.getHealth());
		            }
	            }
	
	            // Here we check if the hero's position coincides with the EYE position
	            if (coolHero.getPositionX() == eye.getPositionX() &&
		            coolHero.getPositionY() == eye.getPositionY()) {
		
		            if (gotItemsLocation[eye.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[eye.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[eye.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[eye.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addEye();
			            gui.md_setSpriteVisible(18, false);
			            gui.md_setTextPerception(coolHero.getPerception());
		            }
	            }
	
	            // Here we check if the hero's position coincides with the SWORD position
	            if (coolHero.getPositionX() == sword.getPositionX() &&
		            coolHero.getPositionY() == sword.getPositionY()) {
		
		            if (gotItemsLocation[sword.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[sword.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[sword.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[sword.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addSword();
			            gui.md_setSpriteVisible(19, false);
			            gui.md_setTextStrength(coolHero.getStrength());
		            }
	            }
	
	
	            // Reducing food after each movement (only if food is not already 0)
	            if (coolHero.getFood() > 0) {
		            coolHero.lessFood();
		            gui.md_setTextFood(coolHero.getFood());
	            }
	
	            // Reducing perception and strength if food = 0,
	            else {
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
        main(args);
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
