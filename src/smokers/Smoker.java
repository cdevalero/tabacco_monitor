package smokers;

import benches.Bench;
import sellers.Seller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Smoker {

    private int attempt;

    private final Seller seller;
    private final List<Bench> benches;
    private final String ownIngredient;
    public final List<String> ingredients = new ArrayList<>();

    public Smoker(String ingredient, List<Bench> benches, Seller seller){
        this.seller = seller;
        this.benches = benches;
        this.attempt = 2;
        ingredient = ingredient.toLowerCase();
        if (ingredient.equals("tabaco") || ingredient.equals("papel") || ingredient.equals("fosforos")){
            this.ownIngredient = ingredient;
            this.ingredients.add(this.ownIngredient);
        }else{
            throw new RuntimeException("The name of the ingredient is *" + ingredient +"* and only 'tabaco', 'papel' or 'fosforos' is allowed");
        }
    }


    public void addIngredient(String ingredient){
        ingredient = ingredient.toLowerCase();
        if (new HashSet<>(this.ingredients).contains(ingredient)){
            throw new RuntimeException("Ingredient: *" + ingredient +"* repeated");
        } else if (!(new HashSet<>(this.completeCigar()).contains(ingredient))) {
            throw new RuntimeException("The name of the ingredient is *" + ingredient +"* and only 'tabaco', 'papel' or 'fosforos' is allowed");
        } else{
            this.ingredients.add(ingredient);
        }
    }

    public void toSmoke() throws InterruptedException {
        if (new HashSet<>(this.ingredients).containsAll(this.completeCigar())){
            this.ingredients.clear();
            this.ingredients.add(this.ownIngredient);
            System.out.println("Fumando un cigarro...");
            Thread.sleep(200); // cambiar por wait ➡ https://es.stackoverflow.com/questions/1374/cu%C3%A1l-es-la-diferencia-entre-wait-y-sleep-en-java
            System.out.println("Termine de fumar, a por otro.");
        }
    }

    private List<String> completeCigar(){
        List<String> fullCigar = new ArrayList<>();
        fullCigar.add("tabaco");
        fullCigar.add(("papel"));
        fullCigar.add(("fosforos"));

        return fullCigar;
    }

    public void searchIngredients() throws InterruptedException {
        List<String> missingIngredients = new ArrayList<>(this.completeCigar());
        missingIngredients.removeAll(this.ingredients);

        if (missingIngredients.size() == 0){
            this.toSmoke();
        }

        else if (this.attempt <= 0){
            System.out.println("No hay ingredientes, vendedor dame mas");
            this.seller.placeIngredients();
            this.attempt = 2;
        }
        else{
            System.out.println("Buscando ingrediente");
            for (Bench bench : this.benches) {
                if (missingIngredients.get(0).equals(bench.ingredient)) {
                    if (bench.amount > 0) {
                        bench.sale();
                        this.addIngredient(bench.ingredient);
                    } else {
                        this.attempt = this.attempt - 1;
                    }
                }
            }
        }
    }

}

