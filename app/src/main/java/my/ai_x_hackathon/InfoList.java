package my.ai_x_hackathon;

public class InfoList {
    private String address;
    private String danger;
    private String Time;
    private int image_street;

    public InfoList(String address, String danger,int image){
        this.address = address;
        this.danger = danger;
        this.image_street = image;}




    public  String getAddress(){return address;}

    public String getDanger(){return danger;}


    // 주소, 위험도 받아서 넣기
    public void setAddress(String address){this.address = address;}

    public void setDanger(String danger){this.danger = danger;}

    public int getImage_street(){return image_street;}

    public void setImage_street(int image_street){this.image_street = image_street;}

}
