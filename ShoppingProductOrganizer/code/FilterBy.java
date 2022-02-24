import java.util.*;


public class FilterBy {
    protected int numFilters = 0;
    protected List <String> brandList = new LinkedList<>();
    protected Double [] priceList  = new Double[2];
    protected Double [] starList = new Double[2];
    protected Integer [] numReviewsList = new Integer [2];
    protected List <String> featureQualList = new LinkedList<>();
    protected List <String[]> featureQuanList = new LinkedList<>();
    protected List <Product> productList;
    protected List <Product> resultList1 = new LinkedList<> ();
    protected List <Product> resultList2 = new LinkedList<> ();

    protected ProductList productListClass;
    protected List <String> featureListName = new LinkedList<>();

    public FilterBy (ProductList productList) {
        this.productListClass= productList;
        this.productList = productList.getProductList();
    }

    public void resetFilters () {
        numFilters = 0;
        brandList.clear();
        featureQualList.clear();
        featureQuanList.clear();
        priceList[0] = null;
        priceList[1] = null;
        starList[0] = null;
        starList[1] = null;
        numReviewsList[0] = null;
        numReviewsList[1] = null;
    }

    public void filterBrand (String brandName) {
        brandList.add(brandName);
        ++numFilters;
    }

    public void filterPrice (Double min, Double max) {
        this.priceList[0] = min;
        this.priceList[1] = max;
        ++numFilters;
    }
    public void filterStar (Double min, Double max) {
        this.starList[0] = min;
        this.starList[1] = max;
        ++numFilters;
    }
    public void filterNumReview (Integer min, Integer max) {
        this.numReviewsList[0] = min;
        this.numReviewsList[1] = max;
        ++numFilters;
    }

    public void filterQualFeature (String filterQualName) {
        featureQualList.add(filterQualName);
        ++numFilters;
    }

    // filterQuan[0] = Name filterQuan[1] = min filterQuan[2] = max
    public void filterQuanFeature (String []filterQuan) {
        featureQuanList.add(filterQuan);
        ++numFilters;
    }

    public ProductList applyFilters() {
        resultList1.clear();
        resultList2.clear();

        if (numFilters == 0) {
            return productListClass;

        } else {
            while (numFilters > 0) {
                Iterator<Product> iteratorP;

                // Filter By: Brand
                resultList1 = productList;
                if (brandList.size() > 0) {
                    iteratorP = resultList1.iterator();
                    while (iteratorP.hasNext()) {
                        Product appliedBrandProduct = iteratorP.next();
                        if (brandList.contains(appliedBrandProduct.getBrand())) {
                            resultList2.add(appliedBrandProduct);
                        }
                    }
                    numFilters -= brandList.size();
                    resultList1.clear();
                    resultList1 = new LinkedList<>(resultList2);
                    resultList2.clear();
                }

                // FIXED
                // Filter By: Feature-Quality
                if (featureQualList.size() > 0) {

                    for (int searchF = 0; searchF < featureQualList.size(); searchF++) {
                        String checkFeatureQualName = featureQualList.get(searchF);

                        for (int p = 0; p < resultList1.size(); p++) {
                            Product appliedFeatureProduct = resultList1.get(p);
                            List<Feature> appliedFeatureList = appliedFeatureProduct.getFeatureList();
                            int appliedFeatureSize = appliedFeatureList.size();

                            for (int f = 0; f < appliedFeatureSize; f++) {
                                Feature qualFeature = appliedFeatureList.get(f);
                                String qualFeatureName = qualFeature.getFeatureName();
                                if (checkFeatureQualName.compareTo(qualFeatureName) == 0 && qualFeature.getHasFeature()) {
                                    resultList2.add(appliedFeatureProduct);
                                    break;
                                }
                            }

                        }

                        numFilters = numFilters - 1;
                        resultList1.clear();
                        resultList1 = new LinkedList<>(resultList2);
                        resultList2.clear();
                    }
                }

                // Filter By: Filter-Quantity

                if (featureQuanList.size() > 0) {

                    for (int searchF = 0; searchF < featureQuanList.size(); searchF++) {
                        String[] checkFeatureQuan = featureQuanList.get(searchF);

                        String checkFeatureName = checkFeatureQuan[0];
                        double checkFeatureMin = Double.parseDouble(checkFeatureQuan[1]);
                        double checkFeatureMax = Double.parseDouble(checkFeatureQuan[2]);

                        for (int p = 0; p < resultList1.size(); p++) {
                            Product appliedFeatureProduct = resultList1.get(p);
                            List<Feature> appliedFeatureList = appliedFeatureProduct.getFeatureList();
                            int appliedFeatureSize = appliedFeatureList.size();

                            for (int f = 0; f < appliedFeatureSize; f++) {
                                Feature quanFeature = appliedFeatureList.get(f);
                                String quanFeatureName = quanFeature.getFeatureName();
                                Double quanFeatureNum = quanFeature.getFeatureQuantity();

                                if (quanFeatureName.compareTo(checkFeatureName) == 0 && quanFeatureNum >= checkFeatureMin && quanFeatureNum <= checkFeatureMax) {
                                    resultList2.add(appliedFeatureProduct);
                                    break;
                                }
                            }

                        }

                        numFilters = numFilters - 1;
                        resultList1.clear();
                        resultList1 = new LinkedList<>(resultList2);
                        resultList2.clear();
                    }
                }

                // Filter By: Price
                if (priceList[0] != null & priceList[1] != null) {
                    iteratorP = resultList1.iterator();
                    resultList2.clear();

                    while (iteratorP.hasNext()) {
                        Product appliedPriceProduct = iteratorP.next();
                        double priceProduct = appliedPriceProduct.getPrice();
                        double min = priceList[0];
                        double max = priceList[1];

                        if (priceProduct >= min & priceProduct <= max) {
                            resultList2.add(appliedPriceProduct);
                            numFilters = numFilters - 1;
                        } else {
                            numFilters -= 1;
                        }
                    }
                    resultList1.clear();
                    resultList1 = new LinkedList<>(resultList2);
                    resultList2.clear();
                }

                // Filter By: Star
                if (starList[0] != null & starList[1] != null) {
                    iteratorP = resultList1.iterator();
                    resultList2.clear();

                    while (iteratorP.hasNext()) {
                        Product appliedStarProduct = iteratorP.next();
                        double starProduct = appliedStarProduct.getStar();
                        double min = starList[0];
                        double max = starList[1];

                        if (starProduct >= min & starProduct <= max) {
                            resultList2.add(appliedStarProduct);
                            numFilters = numFilters - 1;
                        } else {
                            numFilters -= 1;
                        }
                    }
                    resultList1.clear();
                    resultList1 = new LinkedList<>(resultList2);
                    resultList2.clear();
                }

                // Filter By: NumReviews
                if (numReviewsList[0] != null & numReviewsList[1] != null) {
                    iteratorP = resultList1.iterator();
                    resultList2.clear();

                    while (iteratorP.hasNext()) {
                        Product appliedNumReviewsProduct = iteratorP.next();
                        int numReviewsProduct = appliedNumReviewsProduct.getNumReviews();
                        int min = numReviewsList[0];
                        int max = numReviewsList[1];

                        if (numReviewsProduct >= min & numReviewsProduct <= max) {
                            resultList2.add(appliedNumReviewsProduct);
                            numFilters = numFilters - 1;
                        } else {
                            numFilters -= 1;
                        }
                    }

                    resultList1.clear();
                    resultList1 = new LinkedList<>(resultList2);
                    resultList2.clear();
                }
            }

            HashSet <Feature> featureHashListF = new HashSet<Feature>();
            List <Feature> featureListF = new LinkedList<>();
            List <String> featureListNameF = new LinkedList<>();
            int numFeaturesF = 0;
            int numProductsF = 0;
            HashSet <String> brandHashListF = new HashSet<String>();
            List <Feature> qualFeatureListF = new LinkedList<>();
            List <Feature> quanFeatureListF = new LinkedList<>();
            String productTypeF = productListClass.getProductType();
            Iterator iterator = resultList1.iterator();

            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (obj instanceof Product ) {
                    Product current = (Product) obj;
                    numProductsF += 1;

                    // New Feature List and Feature List Name
                    for(Feature feature:current.getFeatureList()) {
                        featureHashListF.add(feature);
                    }
                    ArrayList <Feature> featureArray = new ArrayList<>(featureHashListF);
                    for (Feature feature: featureArray) {
                        featureListF.add(feature);
                        featureListNameF.add(feature.getFeatureName());
                        numFeaturesF += 1;
                    }

                    // New Brand List Name
                        brandHashListF.add(current.getBrand());

                    // New Quan/Qual Feature
                    for(Feature quanqualFeature: featureListF) {
                        if (quanqualFeature.getIsQuantity()) {
                            quanFeatureListF.add(quanqualFeature);
                        }
                        if (quanqualFeature.getIsQuality()) {
                            qualFeatureListF.add(quanqualFeature);
                        }
                    }


                }

            }

            LinkedList <String> brandLinked = new LinkedList<>();
            ArrayList <String> brandArray = new ArrayList<>(brandHashListF);
            for (String brandTemp: brandArray) {
                brandLinked.add(brandTemp);
            }

            ProductList result = new ProductList(productTypeF, resultList1, featureListNameF, featureListF, numFeaturesF, numProductsF, brandLinked, qualFeatureListF, quanFeatureListF);
            return result;

        }
    }
}


