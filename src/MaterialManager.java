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

    public double getTotalCost() {
        double total = 0;
        for (Material material : materials) {
            total += material.getAmount();
        }
        return total;
    }

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

    public void sortMaterialsByPrice() {
        Collections.sort(materials, new Comparator<Material>() {
            @Override
            public int compare(Material m1, Material m2) {
                return Double.compare(m1.getAmount(), m2.getAmount());
            }
        });
    }

    public double getDiscountDifference() {
        return getTotalCost() - getTotalRealCost();
    }

    public Material[] getMaterials() {
        return materials.toArray(new Material[materials.size()]);
    }
}

