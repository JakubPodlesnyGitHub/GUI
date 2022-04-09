package GUI5.Zadanie2;

public class NowyWatek extends Thread {
    StringTask stringTask;
    public NowyWatek(StringTask task){
        this.stringTask = task;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            stringTask.abort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
