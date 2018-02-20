
package cernypetr;

/**
 *
 * @author jan1h
 */
public class Login {
    String name;
    String psw;
    String outMssg = "";
    
    
    public Login(String NameLogin, String PswLogin) {
        name = NameLogin;
        psw = PswLogin;
    }
     
    
    People people = new People();
    
    public void doLogin () {
        String id = people.nameToId(name);
        if (psw.equals(people.idToPsw(id))) {
            outMssg = "Prihlaseni probehlo uspesne.";   
        }
        else {
            outMssg = "Omlouvame se, nelze se momentalne prihlasit. Zkuste zkontrolovat prihlasovaci udaje. ";
        }
    }
    
    public String getMssg () {
        return(outMssg);
    }
 
}
