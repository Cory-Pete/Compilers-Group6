//TokenData class created to store data on variable assignments and declarations
public class TokenData{
    public String name = "";
    public String type = "";
    public String data = "";

    //First constructor that includes data (assignment)
    public TokenData(String type, String name, String data){
        this.type = type;
        this.name = name;
        this.data = data;
    }

    //Second constructor,that doesn't include data (declaration)
    public TokenData(String type, String name){
        this.type = type;
        this.name = name;
        this.data = "";
    }
}