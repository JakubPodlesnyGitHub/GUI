package GUI5.Zadanie2;

public class StringTask implements Runnable {
    String napis;
    int powielony;
    Thread thread;
    TaskState taskState;
    String napisMOD = "";
    public StringTask(String napis, int powielony) {
        this.napis = napis;
        this.powielony = powielony;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < powielony; i++) {
            napisMOD += napis;
        }
    }


    public String getResult() {
        return napisMOD;
    }

    public TaskState getState() {
        if (thread.getState().equals(Thread.State.NEW)) {
            taskState = TaskState.CREATED;
        } else if (thread.getState().equals(Thread.State.RUNNABLE)) {
            taskState = TaskState.RUNNING;
        } else if (thread.getState().equals(Thread.State.TERMINATED)) {
            taskState = TaskState.READY;
        }
        return taskState;
    }


    public void start() {
        thread.start();
    }

    public void abort() {
        thread.interrupt();
        taskState = TaskState.ABORTED;
    }

    public boolean isDone() {
        if (taskState == TaskState.READY || taskState == TaskState.ABORTED)
            return true;
        else
            return false;
    }
}
