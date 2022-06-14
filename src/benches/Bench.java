package benches;

public abstract class Bench {
    public int amount;
    public final String ingredient;

    public Bench(String ingredient){
        this.amount = 2;
        this.ingredient = ingredient;
    }

    public synchronized void sale(){
        try{
            this.amount = this.amount -1;
            System.out.println("la mesa "+ ingredient + " vendio 1, ahora tiene: " + amount);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void add(){
        try{
            this.amount = this.amount +2;
            System.out.println("le fueron agregados 2, a la mesa "+ ingredient + ", ahora tiene: " + amount);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
