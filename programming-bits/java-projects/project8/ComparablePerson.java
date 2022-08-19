public class ComparablePerson implements Comparable<ComparablePerson>{  
    public String firstName;   public String lastName;   
    public ComparablePerson(String first, String last){    
        firstName = first;     lastName = last;  }  
    public int compareTo(ComparablePerson other) {    
        int last_comparison = lastName.compareTo(other.lastName);    
        if (last_comparison == 0) { 
            // now compare first name      
            return firstName.compareTo(other.firstName);
        } 
        else {      
            return last_comparison;     
        }   
    }  
    public boolean equals(Object other){    
        if (!(other instanceof ComparablePerson)){      
            return false;
        }    
        ComparablePerson other_comparableperson  = (ComparablePerson) other;     
        return (other_comparableperson.firstName == firstName && other_comparableperson.lastName == lastName);  
    }  
    
    public static void main(String[] args) {    
        ComparablePerson p1 = new ComparablePerson("John","Doe");    
        ComparablePerson p2 = new ComparablePerson("John","Doe");    
        System.out.println(p2.equals(p1));    
          
      }
}
