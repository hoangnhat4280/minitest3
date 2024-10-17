import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaterialManager {
    private ArrayList<Material> materials;

    public MaterialManager() {
        materials = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void removeMaterial(Material material) {
        materials.remove(material);
    }

    public void updateMaterial(int index, Material material) {
        if (index >= 0 && index < materials.size()) {
            materials.set(index, material);
        }
    }

    // Calculate total cost without discount
    public double getTotalCost() {
        double total = 0;
        for (Material material : materials) {
            total += material.getAmount();
        }
        return total;
    }

    // Calculate total cost with discount
    public double getTotalRealCost() {
        double total = 0;
        for (Material material : materials) {
            if (material instanceof Discount) {
                total += ((Discount) material).getRealMoney();
            } else {
                total += material.getAmount();
            }
        }
        return total;
    }

    // Sort materials by price (without discount)
    public void sortMaterialsByPrice() {
        Collections.sort(materials, new Comparator<Material>() {
            @Override
            public int compare(Material m1, Material m2) {
                return Double.compare(m1.getAmount(), m2.getAmount());
            }
        });
    }

    // Calculate the difference between discounted and non-discounted total
    public double getDiscountDifference() {
        return getTotalCost() - getTotalRealCost();
    }

    public Material[] getMaterials() {
        return materials.toArray(new Material[materials.size()]);
    }
}

