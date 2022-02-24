import java.io.Serializable;

public class Feature implements Serializable {
    private String featureName;

    private Boolean hasFeature;
    private Double featureQuantity;

    private boolean isQuality;
    private boolean isQuantity;


    public Feature (String name, boolean isQuantity, boolean isQuality) {
        this.featureName = name;
        this.isQuantity = isQuantity;
        this.isQuality = isQuality;
    }


    public void setIsQuantity (boolean isQuantity) {
        this.isQuantity = isQuantity;
    }
    public boolean getIsQuantity () {
        return isQuantity;
    }

    public void setIsQuality (boolean isQuality) {
        this.isQuality = isQuality;
    }
    public boolean getIsQuality () {
        return isQuality;
    }

    public void setFeatureQuantity (Double featureQuantity) { this.featureQuantity = featureQuantity; }
    public Double getFeatureQuantity () { return this.featureQuantity; }

    public void setHasFeature (Boolean hasFeature) {
        this.hasFeature = hasFeature;
    }
    public Boolean getHasFeature() { return hasFeature;  }

    public String getFeatureName() { return featureName; }

    @Override
    public String toString () {
        String result = "";
        result += "Feature: " + featureName;

        if (isQuality) {
            if (hasFeature)
                result += "\n\t\t\ttrue";
            else
                result += "\n\t\t\tfalse";
        }

        if (isQuantity) {
            result += "\n\t\t\t" + featureQuantity;
        }

        return result;
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Feature) {
            Feature oAsFeature = (Feature)o;
            if(oAsFeature.getFeatureName().equals(this.featureName)) {
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }
    }

}
