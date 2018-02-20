
package cernypetr;

/**
 *
 * @author jan1h
 */
public class Register {
    String name;
    String psw;
    String pswRepeat;
    String outMssg = "";


    public Register(String NameRegister, String PswRegister, String PswRepeatRegister) {
        name = NameRegister;
        psw = PswRegister;
        pswRepeat = PswRepeatRegister;
    }
    
    
    People people = new People();
    //Scanner sc = new Scanner(System.in, "Windows-1250");
    
    public void doRegister() {
        boolean success = false;
        do {
            System.out.println("Zadejte uzivatelske jmeno:");
            //String name = sc.nextLine();
            if (people.doesUserExist(name)) {
                //System.out.println("Omlouvame se, ale uzivatelske jmeno je jiz obsazeno. ");
                outMssg = "Omlouvame se, ale uzivatelske jmeno je jiz obsazeno. ";
            }
            else {
                do {
                    System.out.println("Zadejte heslo:");
                    //String psw = sc.nextLine();

                    System.out.println("Zopakujte heslo:");
                    //String pswRepeat = sc.nextLine();

                    if (psw.equals(pswRepeat)) {
                        people.insertUser(name, psw);
                        success = true;
                        outMssg = "Registrace proběhla úspěšně. ";
                    } else {
                        System.out.println("Zadana hesla se neshoduji. ");
                        outMssg = "Zadana hesla se neshoduji. ";
                    }
                } while (!(success));    
            }
        } while (!(success));
        
    
    }
    
    public String getMssg () {
        return(outMssg);
    }
}
