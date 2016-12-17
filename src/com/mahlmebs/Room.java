
package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import minidungeon.MiniDungeonGUI;
import java.util.Random;

public class Room extends Space{

    /* Room is an array of Spaces */

    public int lengthX;
    public int lengthY;
    public int startPointX;
    public int startPointY;

    Room() {}

    public int getLengthX() {
        return lengthX;
    }

    public void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    public int getStartPointX() {
        return startPointX;
    }

    public void setStartPointX(int startPointX) {
        this.startPointX = startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public void setStartPointY(int startPointY) {
        this.startPointY = startPointY;
    }

    Space[][] generateRooms(int max, MiniDungeonGUI gui) {

        Random random = new Random();
        int roomsGenerated = random.nextInt(30 - 7 + 1) + 7;
        System.out.println("Rooms created " + roomsGenerated);
        Room[] rooms = new Room[roomsGenerated];
        Room[] validRooms = new Room[8];
        int index= 0;

        // Before set the rooms, we generate values randomly inside the max length
        // Initializes all the space
        Space[][] level = new Space[max][max];
        for( int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                level[i][u] = new Space();
            }
        }

        // With this array, we filter and choose 5 of them with no conflicts
        // acts on each room individually
        while(index != validRooms.length-1 ){

            // goes through the raw array
            for(int r  = 0; r < rooms.length; r++){
                rooms[r] = new Room();
                // generates the random values for the room[x]
                int lengthX = random.nextInt((max/3) - 3 + 1) + 3;
                int lengthY = lengthX;
                int startPointX = random.nextInt((max- 1 + 1) + 1);
                int startPointY = random.nextInt((max - 1 + 1) + 1);
                int sumX = lengthX + startPointX;
                int sumY = lengthY + startPointY;
                // first check to adjust to the maximum dimensions
                while (sumX > max || sumY > max) {
                    System.out.println("Discarded " + sumX + " " + sumY);
                    lengthX = random.nextInt((max/4) - 3 + 1) + 3;
                    lengthY = lengthX;
                    startPointX = random.nextInt((max- 1 + 1) + 1);
                    startPointY = random.nextInt((max- 1 + 1) + 1);
                    sumX = lengthX + startPointX;
                    sumY = lengthY + startPointY;
                }
                System.out.println("Accepted " + sumX + " " + sumY);
                rooms[r].setLengthX(lengthX);
                rooms[r].setLengthY(lengthY);
                rooms[r].setStartPointX(startPointX);
                rooms[r].setStartPointY(startPointY);

                boolean add = true;

                // We modify the space to be available to walk and filter the consecutive arrays to avoid superposition
                for( int i = rooms[r].startPointX; i < sumX; i++){
                    for(int u = rooms[r].startPointY; u < sumY; u++){
                        if(!level[i][u].isWall()){
                            add = false;
                            i = sumX-1;
                            u = sumY-1;
                            // break;
                        }else {
                            level[i][u].setWall(false);
                        }
                    }
                }
                if(add){
                    validRooms[index] = new Room();
                    validRooms[index].setLengthX(rooms[r].getLengthX());
                    validRooms[index].setLengthY(rooms[r].getLengthY());
                    validRooms[index].setStartPointX(rooms[r].getStartPointX());
                    validRooms[index].setStartPointY(rooms[r].getStartPointY());
                    index++;
                }
                if(index == validRooms.length-1) break;
            }
        }

        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                if(level[i][u].isWall()){
                    gui.md_setSquareColor(i, u, 96, 96, 96);
                } else{
                    gui.md_setSquareColor(i, u, 178, 255, 102);
                }

            }
        }

        return level;
    }







}
