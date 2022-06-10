import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Smoker {
    private final String ownIngredient;
    private final List<String> ingredients = new ArrayList<>();

    public Smoker(String ingredient){
        ingredient = ingredient.toLowerCase();
        if (ingredient.equals("tabaco") || ingredient.equals("papel") || ingredient.equals("fosforos")){
            this.ownIngredient = ingredient;
            this.ingredients.add(this.ownIngredient);
        }else{
            throw new RuntimeException("The name of the ingredient is *" + ingredient +"* and only 'tabaco', 'papel' or 'fosforos' is allowed");
        }
    }

    public void seeIngredients(){
        System.out.println(this.ingredients);
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

    public boolean toSmoke() throws InterruptedException {
        if (new HashSet<>(this.ingredients).containsAll(this.completeCigar())){
            this.ingredients.clear();
            this.ingredients.add(this.ownIngredient);
            System.out.println("Fumando un cigarro...");
            Thread.sleep(2000); // cambiar por wait ➡ https://es.stackoverflow.com/questions/1374/cu%C3%A1l-es-la-diferencia-entre-wait-y-sleep-en-java
            System.out.println("Termine de fumar, a por otro. \n");
            return true;
        }
        return false;
    }

    private List<String> completeCigar(){
        List<String> fullCigar = new ArrayList<>();
        fullCigar.add("tabaco");
        fullCigar.add(("papel"));
        fullCigar.add(("fosforos"));

        return fullCigar;
    }

}

