import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();

        // Create 5 CrispyFlour objects
        manager.addMaterial(new CrispyFlour("CF01", "Crispy Flour 1", LocalDate.now(), 5000, 10));
        manager.addMaterial(new CrispyFlour("CF02", "Crispy Flour 2", LocalDate.now(), 6000, 8));
        manager.addMaterial(new CrispyFlour("CF03", "Crispy Flour 3", LocalDate.now(), 7000, 6));
        manager.addMaterial(new CrispyFlour("CF04", "Crispy Flour 4", LocalDate.now(), 5500, 12));
        manager.addMaterial(new CrispyFlour("CF05", "Crispy Flour 5", LocalDate.now(), 5800, 9));

        // Create 5 Meat objects
        manager.addMaterial(new Meat("M01", "Meat 1", LocalDate.now(), 100000, 2.5));
        manager.addMaterial(new Meat("M02", "Meat 2", LocalDate.now(), 120000, 1.8));
        manager.addMaterial(new Meat("M03", "Meat 3", LocalDate.now(), 110000, 3.0));
        manager.addMaterial(new Meat("M04", "Meat 4", LocalDate.now(), 115000, 2.0));
        manager.addMaterial(new Meat("M05", "Meat 5", LocalDate.now(), 130000, 2.2));

        // Print total cost without discount
        System.out.println("Total cost without discount: " + manager.getTotalCost());

        // Print total cost with discount
        System.out.println("Total cost with discount: " + manager.getTotalRealCost());

        // Print the discount difference
        System.out.println("Discount difference: " + manager.getDiscountDifference());

        // Sort materials by price and print the sorted list
        manager.sortMaterialsByPrice();
        System.out.println("Materials sorted by price:");
        for (Material material : manager.getMaterials()) {
            System.out.println(material.getName() + " - Price: " + material.getAmount());
        }
    }
}
