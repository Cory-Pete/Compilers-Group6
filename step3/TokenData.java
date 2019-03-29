public class TokenData{
    public String name = "";
    public String type = "";
    public String data = "";
    public TokenData(String type, String name, String data){
        this.type = type;
        this.name = name;
        this.data = data;
    }
    public TokenData(String type, String name){
        this.type = type;
        this.name = name;
        this.data = "";
    }
}