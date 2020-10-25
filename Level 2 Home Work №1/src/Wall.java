public class Wall implements Obstacles{
    private int height;

    public Wall(int height){
        this.height = height;
    }

    public void pass(Participant p){
        if(p.getHeight() > this.height) System.out.println(p.getName() + " перепрыгнул препятствие высотой " + this.height + " м");
        else{
            System.out.println(p.getName() + " не перепрыгнул препятствие высотой " + this.height + " м");
        }
    }

    public boolean breakCicle(Participant p){
        return p.getHeight() <= this.height;
    }

}
