public class GreedyField {
    public static void main(String args[]) {
        Flags flags = new Flags();
        Thread a = new GreedyNeighbor(flags);
        Thread b = new GreedyNeighbor(flags);
        a.setName("alice");
        b.setName("bob");

        a.start();
        b.start();
    }
}
