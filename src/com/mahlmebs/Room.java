
package com.mahlmebs;

import minidungeon.MiniDungeonGUI;

public class Room {

    /* Room is an array of Spaces */

    private int lengthX;
    private int lengthY;
    private int startPointX;


    private int startPointY;
    private Space[][] roomSpace = new Space[lengthX][lengthY];

    Room() {
    }

    Space[][] getRoomSpace() {
        return roomSpace;
    }

    public void setRoomSpace(Space[][] roomSpace) {
        this.roomSpace = roomSpace;
    }

    private int getLengthX() {
        return lengthX;
    }

    private void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    private int getLengthY() {
        return lengthY;
    }

    private void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    private int getStartPointX() {
        return startPointX;
    }

    private void setStartPointX(int startPointX) {
        this.startPointX = startPointX;
    }

    private int getStartPointY() {
        return startPointY;
    }

    private void setStartPointY(int startPointY) {
        this.startPointY = startPointY;
    }

    Room[] generateRoom(int max, MiniDungeonGUI gui) {
        int roomsGenerated = (int) (Math.random() * (max / 2));
        System.out.println("Rooms created " + roomsGenerated);
        Room[] rooms = new Room[roomsGenerated];

        for(Room item: rooms){
            item = new Room();
            /* At the moment we assume square rooms */
            int lengthX = (int) (Math.random() * (max / 2));
            int lengthY = lengthX;
            System.out.println(" x extension > " + lengthX + " y extension > " + lengthY);

            int startPointX = (int) (Math.random() * (max / 2));
            int startPointY = (int) (Math.random() * (max / 2));

            System.out.println(" Room starts at > " + startPointX + " and " + startPointY );
            Space[][] roomSpace = new Space[lengthX][lengthY];

            for( int i = startPointX; i < lengthX; i++){
                for(int u = startPointY; u < lengthY; u++){
                    roomSpace[i][u] = new Space();
                    roomSpace[i][u].setWall(false);
//                System.out.println(roomSpace[i][u].isWall());
                }
            }

            int sumX = lengthX + startPointX;
            int sumY = lengthY + startPointY;
            while (sumX > max && sumY > max) {
                System.out.println("Discarded " + sumX + " " + sumY);
                lengthX = (int) (Math.random() * (max / 2));
                lengthY = (int) (Math.random() * (max / 2));
                startPointX = (int) (Math.random() * (max / 2));
                startPointY = (int) (Math.random() * (max / 2));

                sumX = lengthX + startPointX;
                sumY = lengthY + startPointY;
            }
            sumX = lengthX + startPointX;
            sumY = lengthY + startPointY;
            System.out.println("Sum X > " + sumX + " Sum Y > " + sumY);
            item.setLengthX(lengthX);
            item.setLengthY(lengthY);
            item.setStartPointX(startPointX);
            item.setStartPointY(startPointY);

            for(int i = 0; i < max; i++){
                for(int u = 0; u < max; u++){
                    if(item.getStartPointX() == i && item.getStartPointY() == u){
                        item.printRooms(i, u, item.getLengthX(), item.getLengthY(), gui);
                    }
                }
            }
        }
        return rooms;
    }

    private void printRooms(int startX, int startY, int lengthX, int lengthY, MiniDungeonGUI gui) {
        int sumA = startX+lengthX;
        int sumB = startY+lengthY;
        for (int a = startX; a < sumA; a++) {
            for (int b = startY; b < sumB; b++) {
                gui.md_setSquareColor(a, b, 178, 255, 102);
            }
        }
    }

}
