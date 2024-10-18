import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaterialManager {
    private Material[] materials;
    private int materialCount;

    public MaterialManager(int capacity) {
        materials = new Material[capacity];
        materialCount = 0;
    }

    public void addMaterial(Material newMaterial) {
        if (materialCount < materials.length) {
            materials[materialCount++] = newMaterial;
        } else {
            System.out.println("Cannot add more materials, array is full.");
        }
    }
    public void displayMaterial() {
        for (Material m : materials) {
            if (m != null) {
                System.out.println(m.getId() +
                        " - " + m.getName() +
                        " - " + m.getAmount() +
                        " ------ " + m.getManufacturingDate());
            }
        }
    }
    public void editMaterial(String materialId) {
        for (int i = 0; i < materialCount; i++) {
            if (materials[i].getId().equals(materialId)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new Name: ");
                materials[i].setName(scanner.nextLine());
                System.out.print("Enter new Cost: ");
                try {
                    materials[i].setCost(scanner.nextInt());
                    System.out.println("Material updated successfully.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for cost.");
                    scanner.next();
                }
                return;
            }
        }
        System.out.println("Material with ID " + materialId + " not found.");
    }

    public void removeMaterial(String materialId) {
        for (int i = 0; i < materialCount; i++) {
            if (materials[i].getId().equals(materialId)) {
                for (int j = i; j < materialCount - 1; j++) {
                    materials[j] = materials[j + 1];
                }
                materials[--materialCount] = null;
                System.out.println("Material with ID " + materialId + " has been removed.");
                return;
            }
        }
        System.out.println("Material with ID " + materialId + " not found.");
    }

    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < materialCount; i++) {
            total += materials[i].getAmount();
        }
        return total;
    }

    public double getTotalRealCost() {
        double total = 0;
        for (int i = 0; i < materialCount; i++) {
            if (materials[i] instanceof Discount) {
                total += ((Discount) materials[i]).getRealMoney();
            } else {
                total += materials[i].getAmount();
            }
        }
        return total;
    }

    public void sortMaterialsByPrice() {
        Arrays.sort(materials, 0, materialCount, Comparator.comparingDouble(Material::getAmount));
    }

    public double getDiscountDifference() {
        return getTotalCost() - getTotalRealCost();
    }

    public Material[] getMaterials() {
        return Arrays.copyOf(materials, materialCount);
    }

    public void displayMaterials() {
        System.out.println("List of Materials:");
        for (int i = 0; i < materialCount; i++) {
            System.out.println(materials[i]);
        }
    }


}
