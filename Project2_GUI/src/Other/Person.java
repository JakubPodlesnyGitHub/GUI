package Other;

public class Person {

    private boolean infected;//flaga -zarazony
    private boolean healthy; // flaga -zdrowy

    public Person() {
        infected = false;
        healthy = false;
    }
    //------------------------------------------GETERY I SETERY---------------------------------------------------------
    public boolean isInfected() {
        return infected;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
}
