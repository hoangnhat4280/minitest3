import java.time.LocalDate;

public interface Discount {
    double getRealMoney();
}
  class DiscountCrispyFlour extends CrispyFlour implements Discount {
    public DiscountCrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost, quantity);
    }


    @Override
    public double getRealMoney() {
        return getAmount() * 0.94;
    }
}

 class DiscountMeat extends Meat implements Discount {
    public DiscountMeat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost, weight);
    }

    @Override
    public double getRealMoney() {
        return getAmount() * 0.97;
    }
}
