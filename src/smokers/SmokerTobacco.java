package smokers;

import benches.Bench;
import sellers.Seller;

import java.util.List;

public class SmokerTobacco extends Smoker{
    public SmokerTobacco(List<Bench> benches, Seller seller) {
        super("tabaco", benches, seller);
    }
}
