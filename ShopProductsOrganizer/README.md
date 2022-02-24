![overwhelmedPNG](https://github.com/ljgilm/CSCI2467Project/blob/8592163351432ed34f0d6518b2eaf3618a721282/IntellijProject/src/overwhelmedPNG.png)
## ProductList Organizer

### Purpose of the program:
- When deciding to purchase something online, there are so many options to choose from and keeping track of all them can be overwhelming. For me, I always end up having lots of tabs open to the point its unmanageable. Therefore, this program allows users to insert the different versions of a product they are interested in and then filter and sort them based on their preferences. An example could be wireless earbuds. However, this program is not limited to physical items. Other examples could also include different digital art programs, streaming services, etc. In fact, this could even be used to help people make decisions for things such as job opportunities.
- The goal of this program is to make it easier for people to organize all their options so that they can make the best decision.

### Description:
- Users can create a list of a certain product (i.e. wireless earbuds). Once, the user has inputted all the different versions of the product, they can then filter their list based on brand name, price, star rating, number of reviews, features that are qualitative, or features that are quantitative. Afterwards, the user can sort their list from ascending or decending order based on brand name, prices, stars, or number of reviews. Once they have applied filterBy and sortBy to their list of products, they can see which items best suit their needs. 

***

### How to Start Program:
1. javac *.java
2. java fileName - depends if you want to create your own ProductList or not
   - if you want to create your own ProductList use: UserInputOnlyFinal.java
   - if you want to just test the FilterBy and SortBy files use: UserInputFinalWithTester.java
3. If UserInputOnlyFinal was choosen, will be prompted to create a ProductList. Afterwards, for both UserInputOnlyFinal and UserInputFinalWithTester, will be asked if you want to apply filterBy and sortBy to your ProductList
4. Once you have finished with the filtering and sorting features, a text file called ProductList will be created that contains a final version of your ProductList.

***

### Program Files:
1. UserInputFinalWithTester.java: 
   - contains premade ProductList to test FilterBy and SortBy

2. UserInputOnlyFinal.java: 
   - requires user to create the ProductList

3. Feature.java: 
   - a product feature can either be quantitative or qualitative

4. Product.java: 
   - creates the product

5. ProductList.java: 
   - a list of the different types of products

6. FilterBy.java: 
   - input is a ProductList and will output ProductList based on the features the user wants to apply

7. SortBy.java: 
   - input is a ProductList and will output ProductList based on how the user wants to sort the data

8. ProductListSerializer.java: 
   - is used to create a text file of the final result
