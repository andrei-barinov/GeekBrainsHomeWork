public class GermanShepherd extends Dog {

        private String name;
        private int run;
        private int swim;
        private float jump;

        public GermanShepherd(String name, int run, int swim, float jump) {
            this.name = name;
            this.run = run;
            this.swim = swim;
            this.jump = jump;
        }


        @Override
        public void run() {
            if (this.run <= 800){
                System.out.println(this.name + " может пробежать " + this.run + " метров");
            }
            else {
                System.out.println(this.name + " не может пробежать " + this.run + " метров");
            }
        }

        @Override
        public void swim() {
            if (this.swim <= 30){
                System.out.println(this.name + " может проплыть " + this.swim + " метров");
            }
            else {
                System.out.println(this.name + " не может проплыть " + this.swim + " метров");
            }
        }

        @Override
        public void jump() {
            if (this.jump <= 2F){
                System.out.println(this.name + " может подпрыгнуть на " + this.jump + " метров");
            }
            else {
                System.out.println(this.name + " не может подпрыгнуть на " + this.jump + " метров");
            }
        }
}
