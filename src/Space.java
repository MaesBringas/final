
class Space {

    private boolean isWall = true;
    private int x, y;

    public boolean isWall() {
        return isWall;
    }

    void setWall(boolean wall) {
        isWall = wall;
    }

    private int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    Space(){}

    Space(int x, int y){
        this.x = x;
        this.y = y;
    }

    boolean isUseful(Room room){

        /* For each Room, all the sequence between startX / startY and lengthX and lengthY as Wall = false */
        for( int i = 0; i < room.getLengthX(); i++){
            for(int u = 0; u < room.getLengthY(); u++){
                room.getRoomSpace()[i][u].setWall(false);
            }
        }
        return true;
    }


}
