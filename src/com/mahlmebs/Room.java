
package com.mahlmebs;

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

    int getLengthX() {
        return lengthX;
    }

    void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    int getLengthY() {
        return lengthY;
    }

    private void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    public int getStartPointX() {
        return startPointX;
    }

    private void setStartPointX(int startPointX) {
        this.startPointX = startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public void setStartPointY(int startPointY) {
        this.startPointY = startPointY;
    }


    Room generateRoom(int max) {
        Room room = new Room();
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
        room.setLengthX(lengthX);
        room.setLengthY(lengthY);
        room.setStartPointX(startPointX);
        room.setStartPointY(startPointY);

        return room;
    }

//    Room[] generateRooms(int max){
//        int numberOfRooms = (int)(Math.random()*10);
//        Room[] rawRooms = new Room[numberOfRooms];
//        System.out.println("Number of rooms " + numberOfRooms);
//        for(int i = 0; i < numberOfRooms; i++){
//            int lengthX = (int)(Math.random()*(max/2));
//            int lengthY = (int)(Math.random()*(max/2));
//            System.out.println(i + " x extension > " + lengthX + " y extension > " + lengthY);
//
//            int startX = (int)(Math.random()*(max/2));
//            int startY = (int)(Math.random()*(max/2));
//            System.out.println(i + " X starts at > " + startX + "  and y at > " + startY);
//
//            int sumX = lengthX + startX;
//            int sumY = lengthY + startY;
//            while(lengthX+startX > max && lengthY+startY > max){
//                System.out.println("Discarded " + sumX + " " + sumY);
//                lengthX = (int)(Math.random()*(max/2));
//                lengthY = (int)(Math.random()*(max/2));
//                startX = (int)(Math.random()*(max/2));
//                startY = (int)(Math.random()*(max/2));
//                sumX = lengthX + startX;
//                sumY = lengthY + startY;
//            }
//            sumX = lengthX + startX;
//            sumY = lengthY + startY;
//            System.out.println("Sum X > " + sumX + " Sum Y > " + sumY);
//            rawRooms[i] = new Room();
//            rawRooms[i].setStartX(startX);
//            rawRooms[i].setStartY(startY);
//            rawRooms[i].setX(lengthX);
//            rawRooms[i].setY(lengthY);
//        }
//
//        return rawRooms;
//
//    }

}
