
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Car{
    
protected String type;
protected String model;
protected int id;
protected int price;
abstract Double resaleValue();
}

final class Hyundai extends Car{
Hyundai(String model,int carId,int price){
    
    type="Hyundai";
this.model=model;
this.id=carId;
this.price=price;

}
    @Override
    Double resaleValue() {
       return price*0.4;   
    }
}
final class Maruti extends Car{
Maruti(String model,int carId,int price){
this.model=model;
type="Maruti";
this.id=carId;
this.price=price;

}
    @Override
    Double resaleValue() {
       return price*0.6;   
    }
}
final class Toyota extends Car{
Toyota(String model,int carId,int price){
this.model=model;
this.id=carId;
this.price=price;
type="toyota";

}
    @Override
    Double resaleValue() {
       return price*0.8;   
    }
}
final class Admin {
     private static final ArrayList<Customer> CUSTOMERS=new ArrayList<>();
     static int carId=0;
     //Adding new customer to the list
void addNewCustomer() throws IOException{
    ArrayList<Car> CARS=new ArrayList<>();
    String custName;
    int custId;
    
    System.out.println("Enter customer name");
    do{custName=new Scanner(System.in).next();
    if(custName.matches("[a-zA-Z_]+")){break;}
    else System.out.println("ENTER A VALID NAME USING ALBHABETS");
    }while(true);
            custId=CUSTOMERS.size()+1;
    
    CARS=addCARS();
    
    CUSTOMERS.add(new Customer(custId,custName, CARS));
    
    }

ArrayList<Car> addCARS() throws InputMismatchException{

String  carName,carModel;
int price;
ArrayList<Car> CARS=new ArrayList<>();
    String flag;
    while(true){
    System.out.println("Enter car type and model and price (1.Toyota 2.Maruti 3.Hyundai)");
    int invalidCar=0;
     carName=new Scanner(System.in).next();
    
  
    carModel=new Scanner(System.in).next();
    
 try{     
 price=new Scanner(System.in).nextInt();           
 }
 catch(InputMismatchException e){
     System.out.println("INVALID PRICE");
     continue;
 }
 
    
    switch (carName.toLowerCase())
    {case "toyota":
       carId++;
        CARS.add(new Toyota(carModel,carId,price));
        break;
    case "maruti":
        carId++;
        CARS.add(new Maruti(carModel,carId,price));
        break;    
    case "hyundai":
        carId++;
        CARS.add(new Hyundai(carModel,carId,price));
        break;
     default:
         System.out.println("enter a valid car type");
         invalidCar=1;
    }
    if(invalidCar==1)continue;
     System.out.println("add more CARS ??  (toyota,hyundai,maruti)");   
    //validation for typing 
    do{System.out.println("type y/n");
    
       
        flag=new Scanner(System.in).next().toLowerCase();
       
        if(flag.equals("y")||flag.equals("n"))
                break;
    }while(true);   

    if(flag.equals("n"))break;
    }
    return CARS;
}
//to add Cars to existing customer
void addToExistingCust() throws IOException{
    int custId=0;
    System.out.println("ENTER THE ID OF CUSTOMER");
while(custId==0){
    try{     
 custId=new Scanner(System.in).nextInt();           
 }
 catch(InputMismatchException e){
     custId=0;
     System.out.println("INVALID ID");
    }
}
    if(custId>CUSTOMERS.size()){
        System.out.println("NO CUSTOMER FOUND WITH ID " + custId);return;}
    Customer customer=CUSTOMERS.get(custId-1);
    customer.CARS.addAll(addCARS());
}
//general method for showing the  customers
void showCUSTOMERS(ArrayList<Customer> duplicateCustomer){
    
    duplicateCustomer.stream().map((cust) -> {
        System.out.println("................................");
        System.out.println("Name :"+cust.name+"\nCustomer ID:"+cust.id+"\nCARS:\n");
             return cust;
         }).forEachOrdered((cust) -> {
             cust.CARS.forEach((car) -> {
                 System.out.print("Car Type:"+car.type+"\n" +"Car Model:"+car.model + "\nPRICE : " + car.price+"\nRESALE VALUE: "+car.resaleValue());
            
             });System.out.println("................................");  
         });
    
}
//To show customers sorted by name
void showSortedCUSTOMERS(){
    //Duplicate list to avoid changes in original customers list
    ArrayList<Customer> duplicateList=(ArrayList<Customer>)CUSTOMERS.clone();
    Collections.sort(duplicateList);
    showCUSTOMERS(duplicateList);
}
//To Find Customer By ID
void findCustomer() throws IOException,InputMismatchException{
    System.out.println("enter customer id of customer");
    int custId;//System.in.read();
    custId=new Scanner(System.in).nextInt();
    if(custId>CUSTOMERS.size()){
        System.out.println("NO CUSTOMER FOUND"); 
        return;}
    CUSTOMERS.stream().map((cust) -> {
        if(custId==cust.id){
            System.out.println("................................");
        System.out.println("Name :"+cust.name+"\nCustomer ID:"+cust.id+"\nCARS:\n");
        }        return cust;
      
         }).forEachOrdered((cust) -> {
             cust.CARS.forEach((car) -> {
                 System.out.print("Car Type:"+car.type+"\n" +"Car Model:"+car.model + "\nPRICE : " + car.price+"\nRESALE VALUE: "+car.resaleValue());
                System.out.println("................................"); 
             });
         });

    
}


void generatePrize() throws InputMismatchException{//ethe v shi krna
    
int upperBound=0;
ArrayList<Integer> randomCust=new ArrayList<>();
   while(upperBound<CUSTOMERS.size()){
       
   randomCust.add((int) (1 + Math.random() * CUSTOMERS.size()));
   upperBound++;
   }
    System.out.println("ENTER ANY 3 CUSTOMER IDS");
    ArrayList<Integer> winners=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    int adminChoice;
    
    if(  randomCust.contains(adminChoice=scanner.nextInt())){   //first input
      winners.add(adminChoice);} 
    if(  randomCust.contains(adminChoice=scanner.nextInt())){   //second input
        winners.add(adminChoice);
    } 
    if(  randomCust.contains(adminChoice=scanner.nextInt())){   //third input
        winners.add(adminChoice);
    } if(winners.isEmpty()){System.out.println("SORRY...NO WINNERS");
    return;
    }
    System.out.println("...HERE ARE THE WINNERS..." + winners);
    
}
void userInterface() throws IOException{
        System.out.println("...Enter the respective number for the required action...");
        

        String addCustFlag;
        
         OUTER:
         while (true) {
             System.out.println("1. ADD NEW CUSTOMER \n" + "2. ADD NEW CAR TO AN EXISTING CUSTOMER\n"+ "3. SHOW ALL CUSTOMERS SORTED BY NAME\n"+
                "4.FIND CUSTOMER BY ID\n"+ "5.GENERATE PRIZE\n"+"6.EXIT");
        int userInput;
             try {
 userInput=new Scanner(System.in).nextInt();                
             } catch (InputMismatchException e) {
                 System.out.println("PLEASE ENTER A VALID INPUT!!");
             continue;
             }

        
             switch (userInput) {
                 case 1:
                     outer:do{
                         this.addNewCustomer();
                         System.out.println("DO YOU WANT TO ADD NEW CUSTOMER?? y/n");
                         while(true){addCustFlag=new Scanner(System.in).next().toLowerCase();
                         if(addCustFlag.equals("y"))break;
                         else if(addCustFlag.equals("n")){break outer;}
                         else
                         {System.out.println("enter valid input (y or n)");}
                         }
                         //adding contingency
                     }while(true);
                     break;
                 case 2:
                     this.addToExistingCust();
                     break;
                 case 3:
                     this.showSortedCUSTOMERS();
                     break;
                 case 4:
                    try{ this.findCustomer();}catch(InputMismatchException e){System.out.println("invalid id\n");}
                     break;
                 case 5:
                     while(true){
                     try{this.generatePrize();break;
                     }catch(InputMismatchException e) {System.out.println("INVALID INPUT");}
                     }
                     break;
                 case 6:
                     break OUTER;
                 default:
                     System.out.println("ENTER A VALID INPUT");
                     break;
             }
         }
        
        System.out.println("ponch gya");
        
        this.showCUSTOMERS(CUSTOMERS);
    }
    
public static void main(String[] args) throws IOException {
    new Admin().userInterface();
    }
}
