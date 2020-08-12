import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Flags {
    private boolean flag_alice;
    private boolean flag_bob;
    private int turn;

    public Flags() {
        turn = 0;
    }

    public synchronized boolean query_flag(String s) {
    //no condition synchronization is needed
        if (s.equals("alice")) return flag_bob;
        else return flag_alice;
    }

    public synchronized boolean query_turn(String s) {
        if(s.equals("alice")) return turn == 2;
        else return turn == 1;
    }

    public synchronized void set_turn(String s) {
        if(s.equals("alice")) turn = 2;
        else turn = 1;
    }

    public synchronized void set_true(String s) {
    //no condition synchronization is needed
        if (s.equals("alice")) { flag_alice = true;}
        else { flag_bob = true; }
    }

    public synchronized void set_false(String s) {
        //no condition synchronization is needed
        if (s.equals("alice")) { flag_alice = false;}
        else { flag_bob = false; }
    }
}
