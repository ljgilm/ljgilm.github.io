import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

public class UserInputFinalWithTester {

    public static void main (String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        // Pre-Made Product List
        ProductList userProductList = testerProductList(input);
        // Make a ProductList from user input
        //ProductList userProductList = userInput(input);

        ProductList finalProductList = null;
        System.out.println(userProductList);
        ProductList filterAppliedList = applyFilter(userProductList, input);
            System.out.println("\nFilter Result:");
            if (filterAppliedList.getNumProducts() == 0 ) {
                finalProductList = null;
            } else {
                System.out.println(filterAppliedList);
                finalProductList = filterAppliedList;
            }
        System.out.println("--------------------------------------------------");

        if (filterAppliedList.getNumProducts() == 0 ){
            finalProductList = null;
        } else {
            System.out.println("Do you want to sort your list? Please enter 'yes' or 'no'");
            String response = input.nextLine();
            response = checkYesNo(response, input);
            finalProductList = filterAppliedList;

            if (response.compareTo("no") == 0) {
                System.out.println("No sorting was not applied.");
                //System.out.println(" Final --------------------------------------------");
                System.out.println("-------------------------------------------- Final --------------------------------------------");
                System.out.println(finalProductList);

            } else {
                System.out.println("Sort List By: Brands, Prices, Stars, or Reviews");
                System.out.println("Please type 'Brands' or 'Prices' or 'Stars' or 'Reviews' exactly as shown.");
                response = input.nextLine();
                String sortBy = checkSort(response, input);
                System.out.println("Sorted by 'ascending' or 'descending' order? Please type one of the options:");
                response = input.nextLine();
                String order = checkAorB(response, input);

                //System.out.println("Sorted -------------------------------------------");
                System.out.println("--------------------------------- Sorted ----------------------------------");
                SortBy sortByList = new SortBy(filterAppliedList, sortBy);
                ProductList sortByResult = sortByList.applySortBy(order);
                finalProductList = sortByResult;
            }
        }

        ProductList textProductList = null;
        ProductListSerializer.serializeProductList(finalProductList);
        textProductList = ProductListSerializer.deserializeProductList();
        if (textProductList == null) {
            System.out.println("No products match. Sorry!");
            ProductListSerializer.printToString("No products match the filters and/or sorting methods that were applied. Sorry!");
        } else {
            System.out.println(textProductList);
            ProductListSerializer.printToString(textProductList.toString());
        }

    }

    public static String checkAorB (String response, Scanner input) {
        String result = response;
        boolean incorrect = true;

        while (incorrect == true) {
            int up = response.compareTo("ascending");
            int down = response.compareTo("descending");

            if (up == 0 || down == 0) {
                result = response;
                incorrect = false;
                break;
            } else {
                System.out.println("Your response did not match 'ascending' or 'descending'\nPlease enter again: ");
                response = input.nextLine();
            }
        }
        return result;
    }

    public static String checkSort (String response, Scanner input) {
        String result = response;
        boolean incorrect = true;

        while (incorrect == true) {
            int brands = response.compareTo("Brands");
            int prices = response.compareTo("Prices");
            int stars = response.compareTo("Stars");
            int reviews = response.compareTo("Reviews");

            if (brands == 0 || prices == 0 || stars == 0 || reviews == 0) {
                result = response;
                incorrect = false;
                break;
            } else {
                System.out.println("Your response did not match 'Brands' or 'Prices' or 'Stars' or 'Reviews'\nPlease enter again: ");
                response = input.nextLine();
            }
        }

        return result;
    }

    public static ProductList testerProductList (Scanner input) {
        String productType = "Wireless Earbuds";

        Feature siri = new Feature("Siri", false, true);
        Feature batteryLife = new Feature("Battery", true, false);
        Feature transparency = new Feature("Transparency", false, true);
        Feature wirelessRange = new Feature("Wireless Range(ft)", true, false);
        Feature noiseCancel = new Feature("Noise Cancelling", false, true);

        List <Feature> featureList = new LinkedList<>();
        featureList.add(siri);
        featureList.add(batteryLife);
        featureList.add(transparency);
        featureList.add(wirelessRange);
        featureList.add(noiseCancel);

        List<String> featureListName = new LinkedList<>();
        featureListName.add(siri.getFeatureName());
        featureListName.add(batteryLife.getFeatureName());
        featureListName.add(transparency.getFeatureName());
        featureListName.add(wirelessRange.getFeatureName());
        featureListName.add(noiseCancel.getFeatureName());

        List<Feature> quanFeatureList = new LinkedList<>();
        quanFeatureList.add(batteryLife);
        quanFeatureList.add(wirelessRange);

        List<Feature> qualFeatureList = new LinkedList<>();
        qualFeatureList.add(siri);
        qualFeatureList.add(transparency);
        qualFeatureList.add(noiseCancel);

        Product airpods = new Product("Apple", "AirPods Pro", 200.00, 5.0, 185271, "none", "https://www.amazon.com/Apple-MWP22AM-A-AirPods-Pro/dp/B07ZPC9QD4");
        airpods.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, true);
        airpods.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 5.0, null);
        airpods.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        airpods.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 40.0, null);
        airpods.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);

        Product elite85t = new Product("Jabra", "Elite 85t", 180.00, 4.6, 1548, "There are fewer reviews because they are new.", "https://www.amazon.com/Jabra-Wireless-Bluetooth-Earbuds-Titanium/dp/B08HR78C46");
        elite85t.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, false);
        elite85t.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 8.0, null);
        elite85t.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        elite85t.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 33.0, null);
        elite85t.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, false);

        Product powerBeats = new Product("Beats", "PowerBeats Pro", 199.00, 4.8, 51988, "none", "https://www.amazon.com/Powerbeats-Pro-Totally-Wireless-Earphones/dp/B07R5QD598");
        powerBeats.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, true);
        powerBeats.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 9.0, null);
        powerBeats.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        powerBeats.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 33.0, null);
        powerBeats.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, false);

        Product bose = new Product("Bose", "QuietComfort", 280.00, 4.5, 7823, "none", "https://www.amazon.com/Bose-QuietComfort-Noise-Cancelling-Earbuds/dp/B08C4KWM9T");
        bose.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, false);
        bose.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 2.0, null);
        bose.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        bose.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 30.0, null);
        bose.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);

        Product jLab = new Product("JLab", "JBuds Air", 30.00, 4.0, 8380, "none", "https://www.amazon.com/Wireless-Signature-Bluetooth-Earbuds-Charging/dp/B07HGL3J31");
        jLab.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, false);
        jLab.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 4.0, null);
        jLab.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, false);
        jLab.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 30.0, null);
        jLab.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, false);

        Product samsung = new Product("Samsung", "Galaxy Buds", 179.00, 4.5, 3733, "none", "https://www.amazon.com/Bluetooth-Wireless-Cancelling-Charging-Resistant/dp/B08MWZHHKP");
        samsung.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, false);
        samsung.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 8.0, null);
        samsung.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        samsung.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 35.0, null);
        samsung.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);

        Product klipsch = new Product("Klipsch", "T5 True", 69.9, 3.5, 2783, "none", "https://www.amazon.com/Klipsch-T5-True-Wireless-Headphones/dp/B07QXLQT34");
        klipsch.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, true);
        klipsch.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 8.0, null);
        klipsch.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        klipsch.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 33.0, null);
        klipsch.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);

        Product sony = new Product("Sony", "WF-1000xM3 True", 178.00, 4.0, 9468, "none", "https://www.amazon.com/Sony-WF-1000XM3-Industry-Canceling-Wireless/dp/B07T81554H");
        sony.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, true);
        sony.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 6.0, null);
        sony.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        sony.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 30.0, null);
        sony.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);


        Product anker = new Product("Anker", "Soundcore Liberty Air", 99.00, 4.5, 990, "none", "https://www.amazon.com/Soundcore-Cancelling-Technology-Personalized-Bluetooth/dp/B08G4K8CY8");
        anker.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, false);
        anker.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 5.0, null);
        anker.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, true);
        anker.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 30.0, null);
        anker.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);

        Product earfun = new Product("EarFun", "Air Pro True", 79.99, 4.5, 990, "none", "https://www.amazon.com/EarFun-Cancelling-Bluetooth-Detection-Headphones/dp/B08J3XYKFW");
        earfun.addFeature(siri.getFeatureName(), siri.getIsQuantity(), siri.getIsQuality(), null, true);
        earfun.addFeature(batteryLife.getFeatureName(), batteryLife.getIsQuantity(), batteryLife.getIsQuality(), 9.0, null);
        earfun.addFeature(transparency.getFeatureName(), transparency.getIsQuantity(), transparency.getIsQuality(), null, false);
        earfun.addFeature(wirelessRange.getFeatureName(), wirelessRange.getIsQuantity(), wirelessRange.getIsQuality(), 32.0, null);
        earfun.addFeature(noiseCancel.getFeatureName(), noiseCancel.getIsQuantity(), noiseCancel.getIsQuality(), null, true);


        List<Product> productList = new LinkedList<>();
        productList.add(airpods);
        productList.add(elite85t);
        productList.add(powerBeats);
        productList.add(bose);
        productList.add(jLab);
        productList.add(samsung);
        productList.add(klipsch);
        productList.add(sony);
        productList.add(anker);
        productList.add(earfun);

        List<String> brandList = new LinkedList<>();
        brandList.add(airpods.getBrand());
        brandList.add(elite85t.getBrand());
        brandList.add(powerBeats.getBrand());
        brandList.add(bose.getBrand());
        brandList.add(jLab.getBrand());
        brandList.add(samsung.getBrand());
        brandList.add(klipsch.getBrand());
        brandList.add(sony.getBrand());
        brandList.add(anker.getBrand());
        brandList.add(earfun.getBrand());

        int numFeatures = 5;
        int numProducts = 10;

        ProductList userProductList = new ProductList(productType, productList, featureListName, featureList, numFeatures, numProducts, brandList,qualFeatureList, quanFeatureList);

        return userProductList;
    }

   public static ProductList applyFilter (ProductList productList, Scanner input) {
        ProductList resultList = productList;
        System.out.println("______________________________________________________");
        System.out.println("Do you want to apply filters? Enter yes or no");
        String response = input.nextLine();
        response = checkYesNo(response, input);
        List <String> brandList = productList.getBrandList();

        if (response.compareTo("yes") == 0) {
            FilterBy filterby = new FilterBy(productList);
            Iterator iterator;
            // Filter Brand
            System.out.println("Do you want to apply filter base on brand name? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            if (response.compareTo("yes") == 0) {

                iterator = brandList.iterator();
                String stringList = "";
                while (iterator.hasNext()) {
                    stringList += iterator.next() + ", ";
                }
                System.out.println("Brands: " + stringList);

                System.out.println("Type in the brands you want to include and click enter after each one and type 'done' when finished:");
                boolean adding = true;
                while (adding) {
                    response = input.nextLine();
                    if (response.compareTo("done") == 0)
                        adding = false;
                    else
                        filterby.filterBrand(response);
                }
            }

            // Filter Price
            System.out.println("Do you want to apply filter base on price? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            boolean needResponse = false;

            if (response.compareTo("yes") == 0) {
                Double min = 0.0;
                Double max = 0.0;
                System.out.println("Please enter the minimum price:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        min = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                System.out.println("Please enter the maximum price:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        max = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                filterby.filterPrice(min,max);
            }

            // Filter Star
            System.out.println("Do you want to apply filter base on star value? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            if (response.compareTo("yes") == 0) {
                Double min = 0.0;
                Double max = 0.0;
                System.out.println("Please enter the minimum star:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        min = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                System.out.println("Please enter the maximum star:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        max = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                filterby.filterStar(min,max);
            }

            // Filter NumReviews
            System.out.println("Do you want to apply filter base on Number of Reviews? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            if (response.compareTo("yes") == 0) {
                Integer min = 0;
                Integer max = 0;
                System.out.println("Please enter the minimum number of reviews:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        min = Integer.parseInt(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter an integer number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                System.out.println("Please enter the maximum number of reviews:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        max = Integer.parseInt(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter an integer number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }

                filterby.filterNumReview(min,max);
            }

            // Filter by QualFilter
            System.out.println("Do you want to apply filter base on features that are based on qualities? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            List<Feature> qualFeatureList= productList.getQualFeatureList();

            if (response.compareTo("yes") == 0) {

                iterator = qualFeatureList.iterator();
                String stringList = "";
                while (iterator.hasNext()) {
                    Feature temp = (Feature)iterator.next();
                    stringList += temp.getFeatureName() + ", ";
                }
                System.out.println("Features: " + stringList);

                System.out.println("Type in the features you want to include and click enter after each one and type 'done' when finished:");
                boolean adding = true;
                while (adding) {
                    response = input.nextLine();
                    if (response.compareTo("done") == 0)
                        adding = false;
                    else
                        filterby.filterQualFeature(response);
                }
            }

            // Filter by QuanFilter
            System.out.println("Do you want to apply filter base on features that are based on quantity? Enter yes or no:");
            response = input.nextLine();
            response = checkYesNo(response, input);
            List<Feature> quanFeatureList = productList.getQuanFeatureList();

            if (response.compareTo("yes") == 0) {

                iterator = quanFeatureList.iterator();
                String stringList = "";
                while (iterator.hasNext()) {
                    Feature temp = (Feature)iterator.next();
                    stringList += temp.getFeatureName() + ", ";
                }

                System.out.println("Features: " + stringList);

                System.out.println("Type in the features you want to include and click enter after each one and type 'done' when finished:");
                boolean adding = true;
                List <String> featureFilterListName = new LinkedList<String>();
                int featureAddedNum = 0;
                while (adding) {
                    response = input.nextLine();
                    if (response.compareTo("done") == 0)
                        adding = false;
                    else {
                        featureFilterListName.add(response);
                        featureAddedNum += 1;
                    }
                }

                List <String> quanFeatureAdd = new LinkedList <>();
                int counter = featureAddedNum;
                String [] quanArray;

                while (counter > 0) {
                    iterator = featureFilterListName.iterator();
                    while (iterator.hasNext()) {
                        String tempName = (String) iterator.next();
                        quanArray = new String[3];
                        quanArray[0] = tempName;

                        System.out.println(tempName + ": ");
                        Double min = 0.0;
                        Double max = 0.0;

                        System.out.println("Please enter the minimum value:");
                        response = input.nextLine();
                        needResponse = true;
                        while(needResponse) {
                            try {
                                min = Double.parseDouble(response);
                                needResponse = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Incorrect input. Please enter a number:\n");
                                response = input.nextLine();
                                needResponse = true;
                            }
                        }

                        System.out.println("Please enter the maximum value:");
                        response = input.nextLine();
                        needResponse = true;
                        while(needResponse) {
                            try {
                                max = Double.parseDouble(response);
                                needResponse = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Incorrect input. Please enter a number:\n");
                                response = input.nextLine();
                                needResponse = true;
                            }
                        }
                        String minS = "" + min;
                        String maxS = "" +max;
                        quanArray[1] = minS;
                        quanArray[2] = maxS;
                        filterby.filterQuanFeature(quanArray);
                        counter -=1; // ADDED this and now jumps to print list after filter
                    }
                }
            }

            resultList = filterby.applyFilters();
        } else {
            System.out.println("No Filters will be applied");
        }

        return resultList;
    }

    public static String quanORqual (Scanner inputScanner, String featureName ) {
        System.out.printf("%n%s%s%s", "Is this feature, ", featureName, ", based on quantity or quality? \nType 'quantity' or 'quality' (be sure to type it exactly as it appears):\n" );
        String response = inputScanner.nextLine();
        return response;
    }

    public static String checkYesNo (String response, Scanner input) {
        while (response.compareTo("yes") != 0 & response.compareTo("no") != 0) {
            System.out.println("\nPlease make sure to enter 'yes' or 'no'");
            response = input.nextLine();
        }

        return response;
    }

    public static String checkResponseNum (String response, Scanner input) {
        String regex = "\\d+";
        while (response.matches(regex) == false) {
            System.out.println("Please make sure to enter a number:\n");
            response = input.nextLine();
        }
        return response;
    }

    public static ProductList userInput(Scanner input) {
        String productType;
        List <Product> list = new LinkedList<>();
        List <String> featureListName = new LinkedList<>();
        List <Feature> featureList = new LinkedList<>();
        HashSet <String> brandList = new HashSet<String>();
        List <Feature> qualFeatureList = new LinkedList<>();
        List <Feature> quanFeatureList = new LinkedList<>();

        int numFeatures = 0;
        int numProducts = 0;

        boolean quantityResponse;
        boolean qualityResponse;
        boolean inputProduct;

        String response;
        String brand;
        String name;
        double price = 0.0;
        double star = 0.0;
        int numReviews = 0;
        String url;
        String notes;
        Product product;

        System.out.println("What type of product are you looking to purchase? (e.g. Wireless Earbuds)");
        response = input.nextLine();
        productType = response;
        System.out.printf("%n%s%s%s", "How many features are looking for in your ", productType, "?\n");
        response = input.nextLine();

        boolean needResponse = true;
        while(needResponse) {
            try {
                numFeatures = Integer.parseInt(response);
                needResponse = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Please enter an integer:\n");
                response = input.nextLine();
                needResponse = true;
            }
        }
        System.out.printf("%n%s%s%s%s", "What features are looking for in your ", productType, "?", "\nClick enter after each new feature\n");
        for (int i = 0; i < numFeatures; i++) {
            response = input.nextLine();
            featureListName.add(response);
        }
        for (String feature : featureListName) {
            response = quanORqual(input, feature);
            while (response.compareTo("quantity") != 0 && response.compareTo("quality") != 0) {
                System.out.println("Misspelling. Try Again.");
                response = quanORqual(input, feature);
            }
            if (response.compareTo("quantity") == 0) {
                quantityResponse = true;
                qualityResponse = false;
                Feature newFeature = new Feature (feature, true, false);
                featureList.add(newFeature);
                quanFeatureList.add(newFeature);
            } else {
                quantityResponse = false;
                qualityResponse = true;
                Feature newFeature = new Feature (feature, false, true);
                featureList.add(newFeature);
                qualFeatureList.add(newFeature);
            }
        }
        inputProduct = true;
        while (inputProduct) {
            System.out.println("\nDo you want to add a product to the list?\nEnter 'yes' or 'no'");
            response = input.nextLine();
            while (response.compareTo("yes") != 0 & response.compareTo("no") != 0) {
                System.out.println("\nPlease make sure to enter 'yes' or 'no'");
                response = input.nextLine();
            }
            if (response.compareTo("yes") == 0) {
                inputProduct = true;

                System.out.println("\nEnter product brand:");
                response = input.nextLine();
                brand = response;
                brandList.add(brand);
                System.out.println("\nEnter product name:");
                response = input.nextLine();
                name = response;
                System.out.println("\nEnter price (can have decimals):");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        price = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }
                System.out.println("\nEnter star (can have decimals):");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        star = Double.parseDouble(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter a number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }
                System.out.println("\nEnter number of reviews:");
                response = input.nextLine();
                needResponse = true;
                while(needResponse) {
                    try {
                        numReviews = Integer.parseInt(response);
                        needResponse = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input. Please enter an integer number:\n");
                        response = input.nextLine();
                        needResponse = true;
                    }
                }
                System.out.println("\nEnter url:");
                response = input.nextLine();
                url = response;

                System.out.println("\nEnter notes:");
                response = input.nextLine();
                notes = response;

                product = new Product ( brand, name, price, star, numReviews, notes, url);

                for (Feature feature : featureList) {
                    quantityResponse = feature.getIsQuantity();
                    qualityResponse = feature.getIsQuality();
                    if (quantityResponse) {
                        System.out.printf("%n%s%s%s", "Quantity input for this feature: ", feature.getFeatureName(), "\nEnter number (can have decimals):\n");
                        response = input.nextLine();
                        Double featureQuantity = 0.0;

                        needResponse = true;
                        while(needResponse) {
                            try {
                                featureQuantity = Double.parseDouble(response);
                                needResponse = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Incorrect input. Please enter a number:\n");
                                response = input.nextLine();
                                needResponse = true;
                            }
                        }
                        product.addFeature(feature.getFeatureName(), quantityResponse, qualityResponse, featureQuantity, null);
                    }

                    if (qualityResponse) {
                        System.out.printf("%n%s%s%s%s", name, " has this feature: ", feature.getFeatureName(), "\nEnter 'true' or 'false:\n");
                        response = input.nextLine();
                        while (response.compareTo("true") != 0 & response.compareTo("false") != 0) {
                            System.out.println("Misspelling. Try again.\nEnter 'true' or 'false:\n");
                            response = input.nextLine();
                        }
                        boolean hasFeature = Boolean.parseBoolean(response);
                        product.addFeature(feature.getFeatureName(), quantityResponse, qualityResponse, null, hasFeature);
                    }
                }
                ++numProducts;
                list.add(product);

            } else {
                inputProduct = false;
            }
        }

        LinkedList <String> brandLinked = new LinkedList<>();
        ArrayList <String> brandArray = new ArrayList<>(brandList);
        for (String brandTemp: brandArray) {
            brandLinked.add(brandTemp);
        }
        ProductList userProductlist = new ProductList(productType, list, featureListName, featureList, numFeatures, numProducts, brandLinked, qualFeatureList, quanFeatureList);
        String productListString = userProductlist.toString();
        System.out.printf("%n%n%n%s", productListString);

        return userProductlist;
    }


}
