import benches.Bench;
import benches.Matches;
import benches.Paper;
import benches.Tobacco;
import sellers.Seller;
import smokers.SmokerMatches;
import smokers.SmokerPaper;
import smokers.SmokerTobacco;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Tobacco tobacco = new Tobacco();
        Matches matches = new Matches();
        Paper paper = new Paper();

        List<Bench> benches = new ArrayList<>();
        benches.add(tobacco);
        benches.add(matches);
        benches.add(paper);

        Seller seller = new Seller(benches);

        SmokerMatches smokerMatches = new SmokerMatches(benches,seller);
        SmokerPaper smokerPaper = new SmokerPaper(benches, seller);
        SmokerTobacco smokerTobacco = new SmokerTobacco(benches,seller);

        for (int i = 0; i < 200; i++){
            smokerMatches.searchIngredients();
            smokerTobacco.searchIngredients();
            smokerPaper.searchIngredients();
        }

        System.out.println(tobacco.ingredient +", amount: "+tobacco.amount);
        System.out.println(matches.ingredient +", amount: "+matches.amount);
        System.out.println(paper.ingredient +", amount: "+paper.amount);

    }
}