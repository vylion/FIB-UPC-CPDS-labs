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
                if ( !flags.query_flag(name) ) {
                    System.out.println(name + " enter");
                    Thread.sleep(400);
                    System.out.println(name + " exits");
                }
                Thread.sleep((int)(200*Math.random()));
                flags.set_false(name);
            }
            catch (InterruptedException ignored) {}
        }
    }
}
