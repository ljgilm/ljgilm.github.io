import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Product implements Serializable {
    private String brand;
    private String name;
    private double price;
    private double star;
    private int numReviews;
    private int numFeatures = 0;
    private List <Feature> featureList = new ArrayList<>();;
    private String notes;
    private String url;

    public Product (String brand, String name, double price, double star, int numReviews, String notes,String url) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.star = star;
        this.numReviews = numReviews;
        this.notes = notes;
        this.url = url;
    }
    public void addFeature (String name, boolean isQuantity, boolean isQuality, Double featureQuantity, Boolean hasFeature) {
        Feature addedFeature = new Feature (name, isQuantity, isQuality);
        if (isQuality) {
            addedFeature.setHasFeature(hasFeature);
        }
        if (isQuantity) {
            addedFeature.setFeatureQuantity(featureQuantity);
        }

        featureList.add(addedFeature);
        ++numFeatures;
    }

    @Override
    public String toString () {
        String result = "";
        result += "\nName: " + name;
        result += "\n\t Brand: " + brand;
        result += "\n\t Price: " + price;
        result += "\n\t Stars: " + star;
        result += "\n\t Number of Reviews: " + numReviews;
        result += "\n\t Features:";
        for(Feature feature : featureList) {
            result += "\n\t\t" + feature.toString();
        }
        result += "\n\t URL: " + url;
        result += "\n\t Notes: " + notes;

        return result;
    }

    // SETTERS and GETTERS
    public void setBrand (String brand) {
        this.brand = brand;
    }
    public String getBrand () {
        return brand;
    }

    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }

    public void setPrice (double price) {
        this.price = price;
    }
    public double getPrice () {
        return price;
    }

    public void setStar (double star) {
        this.star = star;
    }
    public double getStar () {
        return star;
    }

    public void setNumReviews (int numReviews) {
        this.numReviews = numReviews;
    }
    public int getNumReviews () {
        return numReviews;
    }

    public void setNotes (String notes) {
        this.notes = notes;
    }
    public String getNotes () {
        return notes;
    }

    public void setURL (String url) {
        this.url = url;
    }
    public String getURL () {
        return url;
    }

    public List <Feature> getFeatureList () {
        return featureList;
    }
}
