package smokers;

import benches.Bench;
import sellers.Seller;

import java.util.List;

public class SmokerMatches extends Smoker{
    public SmokerMatches(List<Bench> benches, Seller seller) {
        super("fosforos", benches, seller);
    }
}
