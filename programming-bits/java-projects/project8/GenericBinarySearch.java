public class GenericBinarySearch<AnyType>{

    public static <AnyType extends Comparable<AnyType>> int binarysearch(AnyType[] a, AnyType x){
    int low =0;
    int high = a.length -1;
    int mid; 
    while (low <=high){           
        mid = (low+high) /2;
        if (a[mid].compareTo(x) < 0) { 
            // x is in second half                
            low = mid +1;            
        } 
        else if(a[mid].compareTo(x) > 0) 
        { // x is in first half               
            high = mid -1;            
        } 
        else {
            return mid;            
        }        
    
    }
    return-1;    
  }
 /*   
    public static recBinarySearch<AnyType>(AnyType collec, AnyType obj){
        recBinarySearch<AnyType>(AnyType collec, AnyType obj, AnyType temp); 
    }
    
    private static recBinarySearch<AnyType>(AnyType collec, AnyType obj, AnyType temp){
        int low =0;
        int high = a.length -1;
        int mid;
        if(mid[].compareTo)
    }
  **/ 
    
    public static void main(String[] args){
        Integer[] values = {1, 2, 4, 8, 16 , 32 , 64, 128, 256, 512, 1024, 2048, 5096};
        System.out.println("Integer Position for 2048: ");
        System.out.println(binarysearch(values, 2048));
        ComparablePerson p1 = new ComparablePerson("John", "Cena");
        ComparablePerson p2 = new ComparablePerson("John", "Doe");
        ComparablePerson p3 = new ComparablePerson("John", "Wick");
        
        ComparablePerson[] cpList = {p1, p2, p3};
        int x = binarysearch(cpList, p2);
        System.out.println("\n ______\n Comparable Person: \n");
        System.out.println(x);
        
    }
}