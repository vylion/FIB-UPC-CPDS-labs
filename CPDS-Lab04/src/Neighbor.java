public class Neighbor extends Thread {
    protected Flags flags;

    public Neighbor(Flags f) {
        flags = f;
    }

    public void run() {
        while (true) {
            try {
                String name = this.getName();
                System.out.println("try again, my name is: "+ name);
                Thread.sleep((int)(200*Math.random()));
                flags.set_true(name);
                flags.set_turn(name);
                while(flags.query_flag(name) && flags.query_turn(name)) {}
                enterField(); pickBerries();
                Thread.sleep((int)(200*Math.random()));
                flags.set_false(name);
            }
            catch (InterruptedException ignored) {}
        }
    }

    public void enterField() {
        System.out.println(this.getName() + " enters");
    }

    public void pickBerries() {
        System.out.println(this.getName() + " picks berries");
    }
}
