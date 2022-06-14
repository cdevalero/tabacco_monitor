package sellers;

import benches.Bench;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seller {
    private final List<Bench> benches;
    private final List<String> ingredients = new ArrayList<>();
    private final int size;

    public Seller(List<Bench> benches){
        this.ingredients.add("tabaco");
        this.ingredients.add("papel");
        this.ingredients.add("fosforos");
        this.size = this.ingredients.size() -1;
        this.benches = benches;
    }

    private List<String> toDecide(){
        List<String> ingredientsToSell = new ArrayList<>();
        List<String> totalIngredients = new ArrayList<>(this.ingredients);

        for (int i = 0; i < this.size; i++){
            int rnd = new Random().nextInt(this.size);
            ingredientsToSell.add(totalIngredients.get(rnd));
            totalIngredients.remove(rnd);
        }
        return ingredientsToSell;
    }

    public void placeIngredients(){
        List<String> ingredientsToSell = this.toDecide();
        for (Bench bench : this.benches) {
            for (String ingredient : ingredientsToSell) {
                if (ingredient.equals(bench.ingredient)) {
                    System.out.println("Voy a agregar "+ ingredient);
                    bench.add();
                }
            }
        }
    }
}
