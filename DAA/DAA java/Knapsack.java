//goal is to maximize the total profit of items included in the knapsack while not exceeding its capacity.
import java.util.Scanner; 

class Knapsack 
{ 
public static void main(String[] args) 
{
Scanner sc=new Scanner(System.in); 
int object,m; //enter the total number of objects and the knapsack capacity(m).
System.out.println("Enter the Total Objects");
object=sc.nextInt();
int weight[]=new int[object];  //Arrays are created to store the 
int profit[]=new int[object];  //weights and profits of the objects.
for(int i=0;i<object;i++) 
{ //A loop is used to take input for the profit and weight of each object.
System.out.println("Enter the Profit"); 
profit[i]=sc.nextInt();
System.out.println("Enter the weight"); 
weight[i]=sc.nextInt();
}
System.out.println("Enter the Knapsack capacity");
m=sc.nextInt();
//calculates the profit-to-weight ratio for each object and stores it in an array (p_w).
double p_w[]=new double[object];
for(int i=0;i<object;i++)
{
p_w[i]=(double)profit[i]/(double)weight[i];
}
//displays the original data set, including objects, profit, weight, and profit-to-weight ratio.
System.out.println("");
System.out.println("-------------------");
System.out.println("-----Data-Set------");
System.out.print("-------------------");
System.out.println("");
System.out.print("Objects");
for(int i=1;i<=object;i++)
{
System.out.print(i+"    ");
}
System.out.println();
System.out.print("Profit ");
for(int i=0;i<object;i++)
{
System.out.print(profit[i]+"    ");
}
System.out.println();
System.out.print("Weight ");
for(int i=0;i<object;i++)
{
System.out.print(weight[i]+"    ");
}
System.out.println();
System.out.print("P/W    ");
for(int i=0;i<object;i++)
{
System.out.print(p_w[i]+"  ");
}
//Sort Objects by Profit-to-Weight Ratio (Greedy Approach)
for(int i=0;i<object-1;i++)
{
for(int j=i+1;j<object;j++)
{ // Sort objects based on profit-to-weight ratio in descending order
if(p_w[i]<p_w[j])
{// Swap elements to maintain the order-simple bubble sort algorithm.
double temp=p_w[j];
p_w[j]=p_w[i];
p_w[i]=temp;

int temp1=profit[j];
profit[j]=profit[i];
profit[i]=temp1;

int temp2=weight[j];
weight[j]=weight[i];
weight[i]=temp2;
}
}
}
// displays the data set after arranging the objects based on profit-to-weight ratio.
System.out.println("");
System.out.println("-------------------");
System.out.println("--After Arranging--");
System.out.print("-------------------");
System.out.println("");
System.out.print("Objects");
for(int i=1;i<=object;i++)
{
System.out.print(i+"    ");
}
System.out.println();
System.out.print("Profit ");
for(int i=0;i<object;i++)
{
System.out.print(profit[i]+"    ");
}
System.out.println();
System.out.print("Weight ");
for(int i=0;i<object;i++)
{
System.out.print(weight[i]+"    ");
}
System.out.println();
System.out.print("P/W    ");
for(int i=0;i<object;i++)
{
System.out.print(p_w[i]+"  ");
}
//Calculate Final Profit Using Greedy Approach:
int k=0;
double sum=0;
//k is an index variable representing the current object being considered.
//sum is a variable to accumulate the total profit.
System.out.println();
//iterate through the sorted objects until the knapsack capacity (m) is exhausted.
while(m>0)
{// Choose objects greedily until the
if(weight[k]<m)
//checks if the weight of the current object (weight[k]) is less than the remaining capacity (m). 
//If the weight of the current object is less than the remaining capacity, the program adds the entire profit of the object to the total (sum).
//It subtracts the weight of the added object from the remaining capacity (m).
{ 
sum+=1*profit[k];
m=m-weight[k];
}
// iterates through the sorted objects, 
//adding them to the knapsack until the capacity is exhausted. 
//If an object cannot be added entirely, a fraction of its profit is added.
else
//if false:calculates the fraction of profit that can be added based on the remaining capacity.
{
double x4=m*profit[k];//product of remaining capacity (m) and the profit of the current object.
double x5=weight[k];// weight of the current object.
double x6=x4/x5;//fraction of profit that can be added based on the remaining capacity.
sum=sum+x6;// fraction of profit is added to the total (sum).
m=0;//m is set to 0 since the knapsack is now full.
}
k++; // increment to next object
}
System.out.println("Final Profit is="+sum);
}
}