import java.util.List;
import java.util.*;
import java.io.Serializable;

public class ProductList implements Serializable{
    private String productType;
    private List <Product> list;
    private List <String> featureListName;
    private List <Feature> featureList;
    private List <Feature> qualFeatureList;
    private List<Feature> quanFeatureList;
    private List <String> brandList;

    private int numFeatures;
    private int numProducts;


    public ProductList (String productType, List <Product> list, List <String> featureListName, List <Feature> featureList, int numFeatures, int numProducts, List <String> brandList, List <Feature> qualFeatureList, List <Feature> quanFeatureList) {
        this.productType = productType;
        this.list = list;
        this.featureListName = featureListName;
        this.featureList = featureList;
        this.brandList = brandList;
        this.qualFeatureList = qualFeatureList;
        this.quanFeatureList = quanFeatureList;
        this.numFeatures = numFeatures;
        this.numProducts = numProducts;
    }

    @Override
    public String toString () {
        String result = "";
        result += "\nProduct Type: " + productType + "\n";
        for (Product product : list){
            result += product.toString();
        }

        return result;
    }

    public List <Product> getProductList() {
        return this.list;
    }
    public List <String> getFeatureListName() { return this.featureListName; }
    public List <Feature> getFeatureList() { return this.featureList; }
    public int getNumFeatures() { return this.numFeatures; }
    public int getNumProducts() { return this.numProducts; }
    public String getProductType () {return this.productType;}
    public List<String> getBrandList () {return this.brandList;}
    public List <Feature> getQualFeatureList () {return this.qualFeatureList; }
    public List <Feature> getQuanFeatureList () {return this.quanFeatureList; }
}
