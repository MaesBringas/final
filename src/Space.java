
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

    boolean isUseful(Room[] rooms){

        /* For each Room, all the sequence between startX / startY and lengthX and lengthY as Wall = false */
        for( int i = 0; i < rooms.length; i++){
            rooms[i].;
        }
        return true;
    }


}
