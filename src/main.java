public class main {
    public static void main(String[] args) throws InterruptedException {
        Smoker smoker = new Smoker("papel");
        smoker.addIngredient("tabaco");
        smoker.addIngredient("fosforos");
        smoker.seeIngredients();
        System.out.println(smoker.toSmoke());
        smoker.seeIngredients();
    }
}