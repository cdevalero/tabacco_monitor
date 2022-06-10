package benches;

public abstract class Bench {
    public int amount;
    public final String ingredient;

    public Bench(String ingredient){
        this.amount = 2;
        ingredient = ingredient.toLowerCase();
        if (ingredient.equals("tabaco") || ingredient.equals("papel") || ingredient.equals("fosforos")){
            this.ingredient = ingredient;
        }else{
            throw new RuntimeException("The name of the ingredient is *" + ingredient +"* and only 'tabaco', 'papel' or 'fosforos' is allowed");
        }
    }

    public void sale(){
        if (this.amount == 0){
            throw new RuntimeException("there are no ingredients in the *"+this.ingredient+"* bench");
        }
        this.amount = this.amount -1;
    }

    public void add(){
        this.amount = this.amount +2;
    }
}
