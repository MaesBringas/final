
class Room extends Space {

    /* Room is an array of Spaces */

    private int lengthX;
    private int lengthY;
    private int startX;
    private int startY;

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

    public int getStartX() {
        return startX;
    }

    private void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    private void setStartY(int startY) {
        this.startY = startY;
    }


    Room[] generateRooms(int max){
        int numberOfRooms = (int)(Math.random()*10);
        Room[] rawRooms = new Room[numberOfRooms];
        System.out.println("Number of rooms " + numberOfRooms);
        for(int i = 0; i < numberOfRooms; i++){
            int lengthX = (int)(Math.random()*(max/2));
            int lengthY = (int)(Math.random()*(max/2));
            System.out.println(i + " x extension > " + lengthX + " y extension > " + lengthY);

            int startX = (int)(Math.random()*(max/2));
            int startY = (int)(Math.random()*(max/2));
            System.out.println(i + " X starts at > " + startX + "  and y at > " + startY);
            int sumX = lengthX + startX;
            int sumY = lengthY + startY;
            while(lengthX+startX > max && lengthY+startY > max){
                System.out.println("Discarded " + sumX + " " + sumY);
                lengthX = (int)(Math.random()*(max/2));
                lengthY = (int)(Math.random()*(max/2));
                startX = (int)(Math.random()*(max/2));
                startY = (int)(Math.random()*(max/2));
                sumX = lengthX + startX;
                sumY = lengthY + startY;
            }
            sumX = lengthX + startX;
            sumY = lengthY + startY;
            System.out.println("Sum X > " + sumX + " Sum Y > " + sumY);
            rawRooms[i] = new Room();
            rawRooms[i].setStartX(startX);
            rawRooms[i].setStartY(startY);
            rawRooms[i].setX(lengthX);
            rawRooms[i].setY(lengthY);
        }

        return rawRooms;

    }

}
