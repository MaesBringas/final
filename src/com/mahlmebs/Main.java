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

	    
	    
        // Printing the rooms.
	    
        Room room = new Room();
        Space[][] level = room.generateRooms(max, gui);
		int xDoor = random.nextInt((max-1) - 1 + 1) + 1;
		int yDoor = random.nextInt((max-1) - 1 + 1) + 1;
		while(level[xDoor][yDoor].isWall()){
			xDoor = random.nextInt((max-1) - 1 + 1) + 1;
			yDoor = random.nextInt((max-1) - 1 + 1) + 1;
		}
//		gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);

		gui.setVisible(true);
        int heroStartX = random.nextInt(15 - 2 + 1) + 2;
        int heroStartY = random.nextInt(10 - 1 + 1) + 1;
        int[] valid = validCoordinates(level, heroStartX, heroStartY);
        coolHero.setPositionX(valid[0]);
        coolHero.setPositionY(valid[1]);
        
	    
	    
        // Printing the hero
	    
	    coolHero.setImage("cool.png");
        gui.md_addSprite(coolHero.getId(), coolHero.getImage(), true);
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
        // TODO: unified creation



	    // Creating the gold.
	    
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
            gui.md_setSpriteVisible(goldCoins[i].getId(), false);
            gui.md_moveSprite(goldCoins[i].getId(), goldCoins[i].getPositionX(), goldCoins[i].getPositionY());
        }
    
        
        
        // Creating the potions.
	    
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
//            gui.md_setSpriteVisible(potions[i].getId(), true);
            gui.md_moveSprite(potions[i].getId(), potions[i].getPositionX(), potions[i].getPositionY());
        }
    
        
        
        // Creating the apples.
	    
        Apple[] apples = new Apple[5];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
            apples[i].setId(12 + i); // id=1 to id=11 are avoided 'cause they are already in use.
	        int applesStartX = random.nextInt(35 - 2 + 1) + 2;
	        int applesStartY = random.nextInt(35 - 2 + 1) + 2;
	        valid = validCoordinates(level, applesStartX, applesStartY);
	        apples[i].setPositionX(valid[0]);
	        apples[i].setPositionY(valid[1]);
            gui.md_addSprite(apples[i].getId(), apples[i].getImage(), true);
//            gui.md_setSpriteVisible(apples[i].getId(), true);
            gui.md_moveSprite(apples[i].getId(), apples[i].getPositionX(), apples[i].getPositionY()); }
    
        
        
        // Creating the hearts.
	    
        Heart heart = new Heart();
        heart.setId(17); // id=1 to id=16 are avoided 'cause they are already in use.
	    int heartStartX = random.nextInt(10 - 5 + 1) + 5;
	    int heartStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, heartStartX, heartStartY);
	    heart.setPositionX(valid[0]);
	    heart.setPositionY(valid[1]);
        gui.md_addSprite(heart.getId(), heart.getImage(), true);
//        gui.md_setSpriteVisible(heart.getId(), true);
        gui.md_moveSprite(heart.getId(), heart.getPositionX(), heart.getPositionY());
    
	    
	    
	    // Creating the eyes.
	    
        Eye eye = new Eye();
        eye.setId(18); // id=1 to id=17 are avoided 'cause they are already in use.
	    int eyeStartX = random.nextInt(10 - 5 + 1) + 5;
	    int eyeStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, eyeStartX, eyeStartY);
	    eye.setPositionX(valid[0]);
	    eye.setPositionY(valid[1]);
        gui.md_addSprite(eye.getId(), eye.getImage(), true);
//        gui.md_setSpriteVisible(eye.getId(), true);
        gui.md_moveSprite(eye.getId(), eye.getPositionX(), eye.getPositionY());
    
	    
	    
	    // Creating the swords.
	    
        Sword sword = new Sword();
        sword.setId(19); // id=1 to id=18 are avoided 'cause they are already in use.
	    int swordStartX = random.nextInt(10 - 5 + 1) + 5;
	    int swordStartY = random.nextInt(15 - 2 + 1) + 2;
	    valid = validCoordinates(level, swordStartX, swordStartY);
	    sword.setPositionX(valid[0]);
	    sword.setPositionY(valid[1]);
        gui.md_addSprite(sword.getId(), sword.getImage(), true);
//        gui.md_setSpriteVisible(sword.getId(), true);
        gui.md_moveSprite(sword.getId(), sword.getPositionX(), sword.getPositionY());
	    
	    
	    
	    
	    // Declaring enemies. Three pawns and one of each for the rest of the pieces.
	    
	    Enemy[] enemies = new Enemy[9];
	    enemies[0] = new Enemy("pawn");
	    enemies[1] = new Enemy("pawn");
	    enemies[2] = new Enemy("pawn");
	    enemies[3] = new Enemy("bishop");
	    enemies[4] = new Enemy("knight");
	    enemies[5] = new Enemy("king");
	    enemies[6] = new Enemy("queen");
	    enemies[7] = new Enemy("rook");
	    enemies[8] = new Enemy("secretenemy");
	    for(int i = 0; i < 9; i++){
		    enemies[i].setId(20+i); // id=1 to id=19 are avoided 'cause they are already in use.
		    int enemyStartX = random.nextInt(10 - 5 + 1) + 5;
		    int enemyStartY = random.nextInt(15 - 2 + 1) + 2;
		    valid = validCoordinates(level, enemyStartX, enemyStartY);
		    enemies[i].setPositionX(valid[0]);
		    enemies[i].setPositionY(valid[1]);
		    gui.md_addSprite(enemies[i].getId(), enemies[i].getImage(), true);
		    gui.md_setSpriteVisible(enemies[i].getId(), true);
		    gui.md_moveSprite(enemies[i].getId(), enemies[i].getPositionX(), enemies[i].getPositionY()); }
	    
	    
	    
	    // Creating a list of killed enemies, to ease the process of making them disappear when their health gets 0.
	    
	    boolean[] killedEnemies = new boolean[9];
	    
        
	    
	    
	    
        while(true){
	        
	        // Killing the player if health < 1
	        
	        if (coolHero.getHealth() < 1) {
		        gui.md_showMessageDialog("Sad news... " + coolHero.getName() + " was murdered!");
		        int newHealth = coolHero.getMaxHealth();
		        coolHero.setFood(500);
		        coolHero.setHealth(newHealth);
		        main(args);
	        }
	        
	        
	        
	        // Killing the player if food = 0
	        
	       if (coolHero.getFood() == 0) {
		       gui.md_showMessageDialog(coolHero.getName() + " starved!");
		       int newHealth = coolHero.getMaxHealth();
		       coolHero.setFood(500);
		       coolHero.setHealth(newHealth);
		       main(args);
	       }
		
	       
	       
	        String lastAction = gui.md_getLastAction();

	        
	        
	        // Checking if the player has arrived to a trapdoor.
	        
            if(coolHero.getPositionX() == xDoor && coolHero.getPositionY() == yDoor){
            	break;
			}
			
			
			
			// Parkour easter egg!!
	        // Hero and enemies are suddenly free-running masters and are allowed to run on the roof.
	        
			if (lastAction.equals("command parkour")){
				gui.md_showMessageDialog("Omg! You have just entered the parkour mode!");
				for(int i = 0; i < level.length; i++){
					for(int u = 0; u < level[0].length; u++){
							level[i][u].setWall(false);
                    }
				}
            }

            if (lastAction.equals("command floo")){
                gui.md_showMessageDialog("(Floo Podwers) > 'Diagonally!'");
                int magic = random.nextInt(25-7+1)+7;
                if(!level[magic][magic+5].isWall()){
                    coolHero.setPositionX(magic);
                    coolHero.setPositionY(magic+5);
                    gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                }
            }

            if (lastAction.equals("command god")){
                coolHero.setHealth(999);
            }

            if (lastAction.equals("command legolas")){
                gui.md_showMessageDialog(coolHero.getName() + "! What do your elf eyes see?");
                coolHero.setPerception(3);
            }
            if (lastAction.equals("command map")){

                for(int i = 0; i < max; i++){
                    for(int u = 0; u < max; u++){
                        if(level[i][u].isWall()){
                            gui.md_setSquareColor(i, u, 70, 70, 70);
                        } else{
                        gui.md_setSquareColor(i, u, 150, 133, 102);
                        }
                        gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);
                    }
                }
            }







	        /*
	        
	        Here we make our hero move when the arrow keys are pressed
	        and the next cell is not a wall or an enemy.
	        If it is a enemy, damage will be caused to the enemy,
	        which will die if his health gets 0.
	        Hero's food field is reduced each time he moves,
	        
		    */
            
	        
            if (lastAction.length() > 0){
                int x = coolHero.getPositionX(); int y = coolHero.getPositionY();

                try{
                    moveLeft:
                    if (lastAction.equals("left") && !level[x-1][y].isWall()){

                        for (int i = 0; i < enemies.length; i++){
                            if (coolHero.getPositionX()-1 == enemies[i].getPositionX() &&
                                    coolHero.getPositionY() == enemies[i].getPositionY()) {
                                if (!killedEnemies[i]) {
                                    int enemyHealth = enemies[i].getHealth();
                                    int damage = coolHero.getStrength();
                                    enemies[i].setHealth(enemyHealth - damage);
                                    if (enemyHealth == 0) {
                                        if (enemies[i].getId() == enemies[8].getId())
                                            gui.md_showMessageDialog(enemies[8].getSecretMessage());
                                        gui.md_setSpriteVisible(enemies[i].getId(), false);
                                        killedEnemies[i] = true;
                                    }
                                    break moveLeft;
                                }
                            }
                        }
                        coolHero.setPositionX(x-1);
                        movePerception(level,coolHero.getPerception(), x,y, xDoor, yDoor);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                    }

                    moveRight:
                    if (lastAction.equals("right") && !level[x+1][y].isWall()) {
                        movePerception(level,coolHero.getPerception(), x,y, xDoor, yDoor);
//                        gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);
                        for (int i = 0; i < enemies.length; i++){
                            if (coolHero.getPositionX()+1 == enemies[i].getPositionX() &&
                                    coolHero.getPositionY() == enemies[i].getPositionY()) {
                                if (!killedEnemies[i]) {
                                    int enemyHealth = enemies[i].getHealth();
                                    int damage = coolHero.getStrength();
                                    enemies[i].setHealth(enemyHealth - damage);
                                    if (enemyHealth == 0) {
                                        if (enemies[i].getId() == enemies[8].getId())
                                            gui.md_showMessageDialog(enemies[8].getSecretMessage());
                                        gui.md_setSpriteVisible(enemies[i].getId(), false);
                                        killedEnemies[i] = true;
                                    }
                                    break moveRight;
                                }
                            }
                        }
                        coolHero.setPositionX(x+1);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                    }

                    moveDown:
                    if (lastAction.equals("down") && !level[x][y+1].isWall() ) {
                        movePerception(level,coolHero.getPerception(), x,y, xDoor, yDoor);

                        for (int i = 0; i < enemies.length; i++){
                            if (coolHero.getPositionX() == enemies[i].getPositionX() &&
                                    coolHero.getPositionY()+1 == enemies[i].getPositionY()) {
                                if (!killedEnemies[i]) {
                                    int enemyHealth = enemies[i].getHealth();
                                    int damage = coolHero.getStrength();
                                    enemies[i].setHealth(enemyHealth - damage);
                                    if (enemyHealth == 0) {
                                        if (enemies[i].getId() == enemies[8].getId())
                                            gui.md_showMessageDialog(enemies[8].getSecretMessage());
                                        gui.md_setSpriteVisible(enemies[i].getId(), false);
                                        killedEnemies[i] = true;
                                    }
                                    break moveDown;
                                }
                            }
                        }
                        coolHero.setPositionY(y+1);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                    }

                    moveUp:
                    if (lastAction.equals("up") && !level[x][y-1].isWall()) {
                        movePerception(level,coolHero.getPerception(), x,y, xDoor, yDoor);
//                        gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);

                        for (int i = 0; i < enemies.length; i++){
                            if (coolHero.getPositionX() == enemies[i].getPositionX() &&
                                    coolHero.getPositionY()-1 == enemies[i].getPositionY()) {
                                if (!killedEnemies[i]) {
                                    int enemyHealth = enemies[i].getHealth();
                                    int damage = coolHero.getStrength();
                                    enemies[i].setHealth(enemyHealth - damage);
                                    if (enemyHealth == 0) {
                                        if (enemies[i].getId() == enemies[8].getId())
                                            gui.md_showMessageDialog(enemies[8].getSecretMessage());
                                        gui.md_setSpriteVisible(enemies[i].getId(), false);
                                        killedEnemies[i] = true;
                                    }
                                    break moveUp;
                                }
                            }
                        }
                        coolHero.setPositionY(y-1);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    int magic = random.nextInt(25-7+1)+7;
                    if(!level[magic][magic+5].isWall()){
                        coolHero.setPositionX(magic);
                        coolHero.setPositionY(magic+5);
                        gui.md_moveSprite(coolHero.getId(), coolHero.getPositionX(), coolHero.getPositionY());
                    }
                }
                
                
                
                // Creating new game if player introduces the command.
	            
				if (lastAction.equals("new game")) {
                	// Forcing loop exit to reassign objects in the new map generated
					break;
				}


                if (lastAction.equals("command kebab")) {
                    gui.md_showMessageDialog("Lucky you! You get a 2x1 offer! :) ");
                    int offer = coolHero.getFood()*2;
                    coolHero.setFood(offer);
                }
				
				
				// Printing last action.
	            
				gui.md_println(lastAction);
	
	            
	            
	            /*
	            
	            Checking if the user is in the same cell as an item,
	            and activating the item function if true.
	            Brief explanation inside the code for goldCoins.
	            It can be used to explain code for the rest of the items too.
	            
	            */
	
	            
	            for (int i = 0; i < goldCoins.length; i++) {

                    int j = coolHero.getPositionX();
                    int k = coolHero.getPositionY();

                    if(j == goldCoins[i].getPositionX() && k == goldCoins[i].getPositionY() ||
                            j+1 == goldCoins[i].getPositionX() && k == goldCoins[i].getPositionY() ||
                            j == goldCoins[i].getPositionX() && k+1 == goldCoins[i].getPositionY() ||
                            j-1 == goldCoins[i].getPositionX() && k == goldCoins[i].getPositionY() ||
                            j == goldCoins[i].getPositionX() && k-1 == goldCoins[i].getPositionY() ||
                            j+1 == goldCoins[i].getPositionX() && k+1 == goldCoins[i].getPositionY() ||
                            j+1 == goldCoins[i].getPositionX() && k-1 == goldCoins[i].getPositionY() ||
                            j-1 == goldCoins[i].getPositionX() && k+1 == goldCoins[i].getPositionY() ||
                            j-1 == goldCoins[i].getPositionX() && k-1 == goldCoins[i].getPositionY()) {
                        if (!goldCoins[i].isTaken()) {
                            gui.md_setSpriteVisible(goldCoins[i].getId(), true);
                        }
                    }
		            
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
				            goldCoins[i].setTaken(true);
				            gui.md_setTextGold(coolHero.getGold());
			            }
                    }
	            }
	
	            
	            
	            // Code for activating APPLES.
	            
	            for (int i = 0; i < apples.length; i++) {
                    int j = coolHero.getPositionX();
                    int k = coolHero.getPositionY();

                    if(j == apples[i].getPositionX() && k == apples[i].getPositionY() ||
                            j+1 == apples[i].getPositionX() && k == apples[i].getPositionY() ||
                            j == apples[i].getPositionX() && k+1 == apples[i].getPositionY() ||
                            j-1 == apples[i].getPositionX() && k == apples[i].getPositionY() ||
                            j == apples[i].getPositionX() && k-1 == apples[i].getPositionY() ||
                            j+1 == apples[i].getPositionX() && k+1 == apples[i].getPositionY() ||
                            j+1 == apples[i].getPositionX() && k-1 == apples[i].getPositionY() ||
                            j-1 == apples[i].getPositionX() && k+1 == apples[i].getPositionY() ||
                            j-1 == apples[i].getPositionX() && k-1 == apples[i].getPositionY()) {
                        if (!apples[i].isTaken()) {
                            gui.md_setSpriteVisible(apples[i].getId(), true);
                        }
                    }
		            if (coolHero.getPositionX() == apples[i].getPositionX() &&
			            coolHero.getPositionY() == apples[i].getPositionY()) {
			
			            if (gotItemsLocation[apples[i].getId()][0] != coolHero.getPositionX() &&
				            gotItemsLocation[apples[i].getId()][1] != coolHero.getPositionY()) {
				
				            gotItemsLocation[apples[i].getId()][0] = coolHero.getPositionX();
				            gotItemsLocation[apples[i].getId()][1] = coolHero.getPositionY();
				
				            coolHero.addApple();
				            gui.md_setSpriteVisible(apples[i].getId(), false);
				            apples[i].setTaken(true);
				            gui.md_setTextFood(coolHero.getFood());
			            }
		            }
	            }
	
	            
	            
	            // Code for activating POTIONS.
	            
	            for (int i = 0; i < potions.length; i++) {
                    int j = coolHero.getPositionX();
                    int k = coolHero.getPositionY();

                    if(j == potions[i].getPositionX() && k == potions[i].getPositionY() ||
                            j+1 == potions[i].getPositionX() && k == potions[i].getPositionY() ||
                            j == potions[i].getPositionX() && k+1 == potions[i].getPositionY() ||
                            j-1 == potions[i].getPositionX() && k == potions[i].getPositionY() ||
                            j == potions[i].getPositionX() && k-1 == potions[i].getPositionY() ||
                            j+1 == potions[i].getPositionX() && k+1 == potions[i].getPositionY() ||
                            j+1 == potions[i].getPositionX() && k-1 == potions[i].getPositionY() ||
                            j-1 == potions[i].getPositionX() && k+1 == potions[i].getPositionY() ||
                            j-1 == potions[i].getPositionX() && k-1 == potions[i].getPositionY()) {
                        if (!potions[i].isTaken()) {
                            gui.md_setSpriteVisible(potions[i].getId(), true);
                        }
                    }


		            if (coolHero.getPositionX() == potions[i].getPositionX() &&
			            coolHero.getPositionY() == potions[i].getPositionY()) {
			
			            if (gotItemsLocation[potions[i].getId()][0] != coolHero.getPositionX() &&
				            gotItemsLocation[potions[i].getId()][1] != coolHero.getPositionY()) {
				
				            gotItemsLocation[potions[i].getId()][0] = coolHero.getPositionX();
				            gotItemsLocation[potions[i].getId()][1] = coolHero.getPositionY();
				
				            coolHero.addPotion();
				            gui.md_setSpriteVisible(potions[i].getId(), false);
                            potions[i].setTaken(true);
				            gui.md_setTextHealthCurrent(coolHero.getHealth());
			            }
			
		            }
	            }
	
	            
	            
	            // Code for activating HEARTS.


                int j = coolHero.getPositionX();
                int k = coolHero.getPositionY();

                if(j == heart.getPositionX() && k == heart.getPositionY() ||
                        j+1 == heart.getPositionX() && k == heart.getPositionY() ||
                        j == heart.getPositionX() && k+1 == heart.getPositionY() ||
                        j-1 == heart.getPositionX() && k == heart.getPositionY() ||
                        j == heart.getPositionX() && k-1 == heart.getPositionY() ||
                        j+1 == heart.getPositionX() && k+1 == heart.getPositionY() ||
                        j+1 == heart.getPositionX() && k-1 == heart.getPositionY() ||
                        j-1 == heart.getPositionX() && k+1 == heart.getPositionY() ||
                        j-1 == heart.getPositionX() && k-1 == heart.getPositionY()) {
                    if (!heart.isTaken()) {
                        gui.md_setSpriteVisible(heart.getId(), true);
                    }
                }
	            if (coolHero.getPositionX() == heart.getPositionX() &&
		            coolHero.getPositionY() == heart.getPositionY()) {
		
		            if (gotItemsLocation[heart.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[heart.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[heart.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[heart.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addHeart();
			            gui.md_setSpriteVisible(17, false);
			            heart.setTaken(true);
			            gui.md_setTextHealthCurrent(coolHero.getHealth());
		            }
	            }
	
	
	
	            // Code for activating EYES.

                if(j == eye.getPositionX() && k == eye.getPositionY() ||
                        j+1 == eye.getPositionX() && k == eye.getPositionY() ||
                        j == eye.getPositionX() && k+1 == eye.getPositionY() ||
                        j-1 == eye.getPositionX() && k == eye.getPositionY() ||
                        j == eye.getPositionX() && k-1 == eye.getPositionY() ||
                        j+1 == eye.getPositionX() && k+1 == eye.getPositionY() ||
                        j+1 == eye.getPositionX() && k-1 == eye.getPositionY() ||
                        j-1 == eye.getPositionX() && k+1 == eye.getPositionY() ||
                        j-1 == eye.getPositionX() && k-1 == eye.getPositionY()) {
                    if (!eye.isTaken()) {
                        gui.md_setSpriteVisible(eye.getId(), true);
                    }
                }
	            
	            if (coolHero.getPositionX() == eye.getPositionX() &&
		            coolHero.getPositionY() == eye.getPositionY()) {
		
		            if (gotItemsLocation[eye.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[eye.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[eye.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[eye.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addEye();
			            gui.md_setSpriteVisible(18, false);
			            eye.setTaken(true);
			            gui.md_setTextPerception(coolHero.getPerception());
		            }
	            }
	
	
	
	            // Code for activating SWORDS.

                if(j == sword.getPositionX() && k == sword.getPositionY() ||
                        j+1 == sword.getPositionX() && k == sword.getPositionY() ||
                        j == sword.getPositionX() && k+1 == sword.getPositionY() ||
                        j-1 == sword.getPositionX() && k == sword.getPositionY() ||
                        j == sword.getPositionX() && k-1 == sword.getPositionY() ||
                        j+1 == sword.getPositionX() && k+1 == sword.getPositionY() ||
                        j+1 == sword.getPositionX() && k-1 == sword.getPositionY() ||
                        j-1 == sword.getPositionX() && k+1 == sword.getPositionY() ||
                        j-1 == sword.getPositionX() && k-1 == sword.getPositionY()) {
                    if (!sword.isTaken()) {
                        gui.md_setSpriteVisible(sword.getId(), true);
                    }
                }
	            
	            if (coolHero.getPositionX() == sword.getPositionX() &&
		            coolHero.getPositionY() == sword.getPositionY()) {
		
		            if (gotItemsLocation[sword.getId()][0] != coolHero.getPositionX() &&
			            gotItemsLocation[sword.getId()][1] != coolHero.getPositionY()) {
			
			            gotItemsLocation[sword.getId()][0] = coolHero.getPositionX();
			            gotItemsLocation[sword.getId()][1] = coolHero.getPositionY();
			
			            coolHero.addSword();
			            gui.md_setSpriteVisible(19, false);
			            sword.setTaken(true);
			            gui.md_setTextStrength(coolHero.getStrength());
		            }
	            }
	
	
	            
	            // Reducing food after each movement (only if food is not already 0).
	            
	            if (coolHero.getFood() > 0) {
		            coolHero.lessFood();
		            gui.md_setTextFood(coolHero.getFood());
	            }
	
	            
	            
	            // Reducing perception and strength if food = 0
	            
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
	        
	        
	        
	        // Moving enemies, randomly.
	        
	        for(int i = 0; i < 9; i++){
		        Random ran = new Random();
		        int ranNum = ran.nextInt(4);
		        
		        // Randomly choosing between moving right, left, down or up, and checking if possible.
			        
		        if (ranNum == 0) {
			        if (!level[enemies[i].getPositionX() + 1][enemies[i].getPositionY()].isWall()) {
				        if (coolHero.getPositionX() == enemies[i].getPositionX() + 1 &&
					        coolHero.getPositionY() == enemies[i].getPositionY()) {
					        if (!killedEnemies[i]) {
						        enemies[i].attack(coolHero);
						        gui.md_setTextHealthCurrent(coolHero.getHealth());
					        }
				        }
				        else {
					        enemies[i].moveRight();
					        gui.md_moveSprite(enemies[i].getId(), enemies[i].getPositionX(), enemies[i].getPositionY());
				        }
			        }
		        }
		        if (ranNum == 1){
			        if (!level[enemies[i].getPositionX()-1][enemies[i].getPositionY()].isWall()){
				        if (coolHero.getPositionX() == enemies[i].getPositionX() - 1 &&
					        coolHero.getPositionY() == enemies[i].getPositionY()) {
					        if (!killedEnemies[i]) {
						        enemies[i].attack(coolHero);
						        gui.md_setTextHealthCurrent(coolHero.getHealth());
					        }
				        }
				        else {
					        enemies[i].moveLeft();
					        gui.md_moveSprite(enemies[i].getId(), enemies[i].getPositionX(), enemies[i].getPositionY());
				        }
			        }
		        }
		        if (ranNum == 2){
			        if (!level[enemies[i].getPositionX()][enemies[i].getPositionY()+1].isWall()){
				        if (coolHero.getPositionX() == enemies[i].getPositionX() &&
					        coolHero.getPositionY() == enemies[i].getPositionY()+1) {
					        if (!killedEnemies[i]) {
						        enemies[i].attack(coolHero);
						        gui.md_setTextHealthCurrent(coolHero.getHealth());
					        }
				        }
				        else {
					        enemies[i].moveDown();
					        gui.md_moveSprite(enemies[i].getId(), enemies[i].getPositionX(), enemies[i].getPositionY());
				        }
			        }
		        }
		        if (ranNum == 3) {
			        if (!level[enemies[i].getPositionX()][enemies[i].getPositionY() - 1].isWall()) {
				        if (coolHero.getPositionX() == enemies[i].getPositionX() &&
					        coolHero.getPositionY() == enemies[i].getPositionY() - 1) {
					        if (!killedEnemies[i]) {
						        enemies[i].attack(coolHero);
						        gui.md_setTextHealthCurrent(coolHero.getHealth());
					        }
				        }
				        else {
					        enemies[i].moveUp();
					        gui.md_moveSprite(enemies[i].getId(), enemies[i].getPositionX(), enemies[i].getPositionY());
				        }
			        }
		        }
	        }
        }
        main(args);
    }
    
    
    
    // Code for validating positions of items and characters.
	
	static int[] validCoordinates(Space[][]level, int x, int y){
		Random random = new Random();
		int[] validated = new int[2];
		do{
            x = random.nextInt(35 - 2 + 1) + 2;
            y = random.nextInt(35 - 2 + 1) + 2;
        } while(level[x][y].isWall());
		validated[0] = x;
		validated[1] = y;
		return validated;
	}

	static void movePerception(Space[][] level, int p, int x, int y, int xDoor, int yDoor){
	    while(p >= 1){

            if(x == xDoor && y == yDoor || x+p == xDoor && y == yDoor || x == xDoor && y+p == yDoor ||
                    x-p == xDoor && y == yDoor || x == xDoor && y-p == yDoor || x+p == xDoor &&
                    y + p == yDoor || x+p == xDoor && y+-p == yDoor || x-p == xDoor &&
                    y + p== yDoor ||  x-p == xDoor && y-p == yDoor ){
                gui.md_setSquareColor(xDoor, yDoor, 153, 76, 0);
            }
	        if (!level[x][y].isWall()) {
                gui.md_setSquareColor(x, y, 150, 133, 102);
            }
            if(!level[x+p][y].isWall()) {
                gui.md_setSquareColor(x + p, y, 150, 133, 102);
            }
            if(!level[x][y+p].isWall()) {
                gui.md_setSquareColor(x, y + p, 150, 133, 102);
            }
            if(!level[x - p][y].isWall()) {
                gui.md_setSquareColor(x - p, y, 150, 133, 102);
            }
            if(!level[x][y-p].isWall()) {
                gui.md_setSquareColor(x, y - p, 150, 133, 102);
            }
            if(!level[x+p][y+p].isWall()) {
                gui.md_setSquareColor(x + p, y + p, 150, 133, 102);
            }
            if(!level[x+p][y-p].isWall()) {
                gui.md_setSquareColor(x + p, y -p, 150, 133, 102);
            }
            if(!level[x-p][y+p].isWall()) {
                gui.md_setSquareColor(x + p, y + p, 150, 133, 102);
            }
            if(!level[x-p][y-p].isWall()) {
                gui.md_setSquareColor(x - p, y -p, 150, 133, 102);
            }
//            if(!level[x-p][y-p].isWall()) {
//                gui.md_setSquareColor(x - p, y -p, 150, 133, 102);
//            }
            p = p-1;
//            movePerception(level,perception,x,y);
        }

    }
}
