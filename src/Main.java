import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager(10);

        manager.addMaterial(new DiscountCrispyFlour("CF01", "Crispy Flour 1", LocalDate.now(), 5000, 10));
        manager.addMaterial(new DiscountCrispyFlour("CF02", "Crispy Flour 2", LocalDate.now(), 6000, 8));
        manager.addMaterial(new DiscountCrispyFlour("CF03", "Crispy Flour 3", LocalDate.now(), 7000, 6));
        manager.addMaterial(new DiscountCrispyFlour("CF04", "Crispy Flour 4", LocalDate.now(), 5500, 12));
        manager.addMaterial(new DiscountCrispyFlour("CF05", "Crispy Flour 5", LocalDate.now(), 5800, 9));

        manager.addMaterial(new DiscountMeat("M01", "Meat 1", LocalDate.now(), 100000, 2.5));
        manager.addMaterial(new DiscountMeat("M02", "Meat 2", LocalDate.now(), 120000, 1.8));
        manager.addMaterial(new DiscountMeat("M03", "Meat 3", LocalDate.now(), 110000, 3.0));
        manager.addMaterial(new DiscountMeat("M04", "Meat 4", LocalDate.now(), 115000, 2.0));
        manager.addMaterial(new DiscountMeat("M05", "Meat 5", LocalDate.now(), 130000, 2.2));

        System.out.println("Total cost without discount: " + manager.getTotalCost());
        System.out.println("Total cost with discount: " + manager.getTotalRealCost());
        System.out.println("Discount difference: " + manager.getDiscountDifference());

        manager.sortMaterialsByPrice();
        System.out.println("Materials sorted by price:");
        for (Material material : manager.getMaterials()) {
            System.out.println(material.getName() + " , Price: " + material.getAmount());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter material ID to edit: ");
        String editId = scanner.nextLine();
        manager.editMaterial(editId);

        System.out.print("Enter material ID to remove: ");
        String removeId = scanner.nextLine();
        manager.removeMaterial(removeId);

        System.out.println("Materials after editing and removing:");
        manager.displayMaterials();

        scanner.close();
    }
}
