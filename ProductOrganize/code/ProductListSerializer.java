import java.io.Serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class ProductListSerializer {

    private static ObjectOutputStream outputList;
    private static ObjectInputStream inputList;
    private static PrintWriter writer;

    public static void serializeProductList (ProductList productList) {
        try {
            outputList = new ObjectOutputStream( new FileOutputStream("ProductList.ser"));
            outputList.writeObject(productList);
            outputList.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static ProductList deserializeProductList() {
        ProductList productList = null;
        try {
            inputList = new ObjectInputStream( new FileInputStream("ProductList.ser"));
            productList = (ProductList) inputList.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void printToString(String stringToFile) throws FileNotFoundException {
        writer = new PrintWriter("ProductList.txt");
        writer.print(stringToFile);
        writer.close();
    }

}
