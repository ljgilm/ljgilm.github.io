import java.util.Arrays;
import java.util.List;

public class SortBy {
    // instance variables
    private List<Product> productsOnly;
    private ProductList productListOriginal;
    private String sortByString;

    // ProductList Data
    private String productType;
    private List <Product> list;
    private List <String> featureListName;
    private List <Feature> featureList;
    private int numFeatures;
    private int numProducts;
    private List <String> brandList;
    private List <Feature> qualFeatureList;
    private List<Feature> quanFeatureList;




    public SortBy (ProductList productList, String sortByString) {
        this.productListOriginal= productList;
        //this.productsOnly = productList.getProductList();
        this.sortByString = sortByString;

        // ProductList Original Data
        this.productType = productListOriginal.getProductType();
        this.list = productListOriginal.getProductList();
        this.featureListName = productListOriginal.getFeatureListName();
        this.featureList = productListOriginal.getFeatureList();
        this.numFeatures = productListOriginal.getNumFeatures();
        this.numProducts = productListOriginal.getNumProducts();
        this.brandList = productListOriginal.getBrandList();
        this.qualFeatureList = productListOriginal.getQualFeatureList();
        this.quanFeatureList = productListOriginal.getQuanFeatureList();

    }

    public ProductList applySortBy (String order) {
        ProductList resultProductList;
        Product [] listArray = list.toArray(new Product[list.size()]);

        if (order.compareTo("ascending") == 0) {
            if (sortByString.compareTo("Brands") == 0) {
                quickSortBrandA(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Prices") == 0) {
                quickSortPriceA(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Stars") == 0) {
                quickSortStarsA(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Reviews") == 0) {
                quickSortReviewsA(listArray, 0, listArray.length - 1);
            }
        }

        if (order.compareTo("descending") == 0) {
            if (sortByString.compareTo("Brands") == 0) {
                quickSortBrandD(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Prices") == 0) {
                quickSortPriceD(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Stars") == 0) {
                quickSortStarsD(listArray, 0, listArray.length - 1);
            }
            if (sortByString.compareTo("Reviews") == 0) {
                quickSortReviewsD(listArray, 0, listArray.length - 1);
            }
        }

        List <Product> sortedLinkedList = Arrays.asList(listArray);
        resultProductList = new ProductList (productType, sortedLinkedList, featureListName, featureList, numFeatures, numProducts, brandList, qualFeatureList, quanFeatureList);
        return  resultProductList;

    }

    // ASCENDING
    public void quickSortBrandA(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        String pivot = list[middle].getBrand();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getBrand().compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (list[j].getBrand().compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortBrandA(list, low, j);
        if (high > i)
            quickSortBrandA(list, i, high);
    }

    public void quickSortPriceA(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getPrice();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getPrice() < pivot) {
                i++;
            }
            while (list[j].getPrice() > pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortPriceA(list, low, j);
        if (high > i)
            quickSortPriceA(list, i, high);
    }

    public void quickSortStarsA(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getStar();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getStar() < pivot) {
                i++;
            }
            while (list[j].getStar() > pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortStarsA(list, low, j);
        if (high > i)
            quickSortStarsA(list, i, high);
    }

    public void quickSortReviewsA(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getNumReviews();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getNumReviews() < pivot) {
                i++;
            }
            while (list[j].getNumReviews() > pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortReviewsA(list, low, j);
        if (high > i)
            quickSortReviewsA(list, i, high);
    }

    // DESCENDING
    public void quickSortBrandD(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        String pivot = list[middle].getBrand();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getBrand().compareToIgnoreCase(pivot) > 0) {
                i++;
            }
            while (list[j].getBrand().compareToIgnoreCase(pivot) < 0) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortBrandD(list, low, j);
        if (high > i)
            quickSortBrandD(list, i, high);
    }

    public void quickSortPriceD(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getPrice();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getPrice() > pivot) {
                i++;
            }
            while (list[j].getPrice() < pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortPriceD(list, low, j);
        if (high > i)
            quickSortPriceD(list, i, high);
    }

    public void quickSortStarsD(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getStar();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getStar() > pivot) {
                i++;
            }
            while (list[j].getStar() < pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortStarsD(list, low, j);
        if (high > i)
            quickSortStarsD(list, i, high);
    }

    public void quickSortReviewsD(Product[] list, int low, int high) {
        if (list == null || list.length == 0) {
            return;
        }
        if (low>= high) {
            return;
        }

        // pick pivot
        int middle = low +(high - low)/2;
        double pivot = list[middle].getNumReviews();

        int i = low;
        int j = high;

        // make left < pivot and right > pivot
        while (i <= j) {
            while (list[i].getNumReviews() > pivot) {
                i++;
            }
            while (list[j].getNumReviews() < pivot) {
                j--;
            }
            if (i<= j) {
                Product temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortReviewsD(list, low, j);
        if (high > i)
            quickSortReviewsD(list, i, high);
    }

}
