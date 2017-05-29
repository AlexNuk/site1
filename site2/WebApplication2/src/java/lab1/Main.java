package lab1;
import java.util.Date;
import static java.lang.Math.*;
import java.util.Scanner;

public class Main {
    
  double x_start,x_finish,delta,a1;   
  public double ser,sum,arr1_min,arr1_max,arr2_min,arr2_max,y1,y2,y3;
  public int i_min,i_max;
  public double[] array, array2;  
    
    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();      
    }

    public double form1(double x, double a) {
        return x*sqrt(x-a);
    }

    public double form2(double x, double a) {
        return x*sin(a)*x;
    }
    
    public double form3(double x, double a) {
        return exp(-a*x)*cos(a)*x;
    }

    private void print(double sum, double ser, int i_min, int i_max) {
        System.out.println("y[0] = " + array[0]);
        System.out.println("y[140] = " + array[139]);
        System.out.println("y[400] = " + array[399]);     
        System.out.println("y-min = " + array[i_min]+"; x = " + array2[i_min] + "; i = " + i_min);
        System.out.println("y-max = " + array[i_max]+"; x = " + array2[i_max] + "; i = " + i_max);      
        System.out.println("Middle = "+ser);
        System.out.println("Sum = "+sum);  
       
    }
    
    public void arr(int m){       
          ser = ser(m);
          sum = sum(m);
          arr1_min = array[i_min_elem(m)];
          arr2_min = array2[i_min_elem(m)];
          arr1_max = array[i_max_elem(m)];
          arr2_max = array2[i_max_elem(m)];
          i_min = i_min_elem(m);
          i_max = i_max_elem(m);  
          y1 = array[0];
          y2 = array[139];
          y3 = array[399];
    }
     
    public void input (){
    Scanner in = new Scanner(System.in);
        System.out.print("Input x start:");
        x_start = in.nextDouble();
        System.out.print("Input x finish:");
        x_finish = in.nextDouble();
        System.out.print("Input delta:");
        delta = in.nextDouble();
        System.out.print("Input a:");
        a1 = in.nextDouble();
        
    }
        
    public double array_len(double a,double b,double h){
        return (b-a)/h;
    }
    
    public void fill_array(double x, double a, int m, double d){     
        int k = 0;
        double y = 0;
        int n = m;
        for (int j = 0 ; j < n; j++){
            if (x>a) {
                y = form1(x,a);
            }
            if (x==a) {
                y = form2(x,a);
            }
            if (x<a) {
                y = form3(x,a);
            }
            array[j] = y; 
            array2[j] = x; 
            x=x+d; 
        }      
    }
    
    public int i_min_elem(int m){
        int i_min_elem = 0;
        double ij = 0;
            for (int n = 0; n < m; n++) {
                if(ij > array[n]){
                    i_min_elem = n;
                }
             }
        return i_min_elem;
    }
    
    public int i_max_elem(int m){
        int i_max_elem = 0;   
        double ij = 0;
            for (int n = 0; n < m-1; n++) {
                 if(ij < array[n]){
                    i_max_elem = n;
                }
             }
        return i_max_elem;
    }
    
    public double sum(int n){
        double suma = 0;
            for (int i = 0; i < n; i++) {
                   suma += array[i] ;               
             }
        return suma;
    }
    
    public double ser(int m){   
        return sum(m)/m;
    }
    
    public void init_arr(int len){
        int arr_len = len;
        array = new double[arr_len];
        array2 = new double[arr_len];
    }
        
    public void run(){
        input();
        
        fill_array(x_start, a1,(int)array_len(x_start,x_finish,delta), delta);
        
        print(sum((int)array_len(x_start,x_finish,delta)), ser((int)array_len(x_start,x_finish,delta)),
                i_min_elem((int)array_len(x_start,x_finish,delta)),i_max_elem((int)array_len(x_start,x_finish,delta)));
        arr((int)array_len(x_start,x_finish,delta));
        Date d = new Date();
        System.out.printf( "%tr " , d);
    }
}

