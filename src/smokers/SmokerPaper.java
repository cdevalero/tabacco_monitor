package smokers;

import benches.Bench;
import sellers.Seller;

import java.util.List;

public class SmokerPaper extends Smoker{
    public SmokerPaper(List<Bench> benches, Seller seller) {
        super("papel", benches, seller);
    }
}
