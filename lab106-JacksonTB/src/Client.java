/**
 * @version 3/4/2026
 * @author Taylor B. Schaefer-Jackson
 */
public class Client {
    
    public static void main(String[] args){
        
        //Create an empty linkedPositional_list.
        LuckyNumberList luckynumberlist = new LuckyNumberList();
        
        // Create ten instances of lucky number.
        LuckyNumber n1 = new LuckyNumber("Anastasiia");
        LuckyNumber n2 = new LuckyNumber("Belissarius");
        LuckyNumber n3 = new LuckyNumber("Constantine");
        LuckyNumber n4 = new LuckyNumber("Dashulya");
        LuckyNumber n5 = new LuckyNumber("Evdokim");
        LuckyNumber n6 = new LuckyNumber("Francis");
        LuckyNumber n7 = new LuckyNumber("Gregory");
        LuckyNumber n8 = new LuckyNumber("Han Solo");
        LuckyNumber n9 = new LuckyNumber("Indaian Jones");
        LuckyNumber n10 = new LuckyNumber("Kim");
        
        LuckyNumber n11 = new LuckyNumber("Larry");
        LuckyNumber n12 = new LuckyNumber("Michelangelo");
        LuckyNumber n13 = new LuckyNumber("Norry");
        LuckyNumber n14 = new LuckyNumber("Ophilia");
        LuckyNumber n15 = new LuckyNumber("Pedro");
        LuckyNumber n16 = new LuckyNumber("Quintin");
        LuckyNumber n17 = new LuckyNumber("Raphael");
        LuckyNumber n18 = new LuckyNumber("Sebastian");
        LuckyNumber n19 = new LuckyNumber("Titania");
        LuckyNumber n20 = new LuckyNumber("Ureil");
        
        //Add ten instances of lucky number to luckynumber list.
        luckynumberlist.addLuckyNumber(n1);
        luckynumberlist.addLuckyNumber(n2);
        luckynumberlist.addLuckyNumber(n3);
        luckynumberlist.addLuckyNumber(n4);
        luckynumberlist.addLuckyNumber(n5);
        luckynumberlist.addLuckyNumber(n6);
        luckynumberlist.addLuckyNumber(n7);
        luckynumberlist.addLuckyNumber(n8);
        luckynumberlist.addLuckyNumber(n9);
        luckynumberlist.addLuckyNumber(n10);
        
        luckynumberlist.addLuckyNumber(n11);
        luckynumberlist.addLuckyNumber(n12);
        luckynumberlist.addLuckyNumber(n13);
        luckynumberlist.addLuckyNumber(n14);
        luckynumberlist.addLuckyNumber(n15);
        luckynumberlist.addLuckyNumber(n16);
        luckynumberlist.addLuckyNumber(n17);
        luckynumberlist.addLuckyNumber(n18);
        luckynumberlist.addLuckyNumber(n19);
        luckynumberlist.addLuckyNumber(n20);
        
        //All lucky numbers
        System.out.println("DEFAULT");
        System.out.println(luckynumberlist+"\n");
        
        //Prime Numbers Only
        Iterator<Position<LuckyNumber>> primeLucky_numberItarator = luckynumberlist.primePositions().iterator();
        System.out.println("Using PrimePositionIterable luckynumberlist = ");
        while (primeLucky_numberItarator.hasNext()){
            System.out.print(primeLucky_numberItarator.next().getElement().toString() + " ");
            System.out.print("\n\n");
        }
        
        //Even Numbers Only
        Iterator<Position<LuckyNumber>> evenLucky_numberitarator = luckynumberlist.evenPositions().iterator();
        System.out.println("Using EvenPositionIterable luckynumberlist = ");
        while(evenLucky_numberitarator.hasNext()){
            System.out.print(evenLucky_numberitarator.next().getElement().toString() + " ");
            System.out.print("\n\n");
        }
    }
    
}
