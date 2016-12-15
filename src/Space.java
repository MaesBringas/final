
class Space {

    private boolean isWall = true;
    private int x, y;

    public boolean isWall() {
        return isWall;
    }

    void setWall(boolean wall) {
        isWall = wall;
    }

    int getX() {
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



}
