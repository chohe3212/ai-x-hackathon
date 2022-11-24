package my.ai_x_hackathon;

public class InfoList {
    private String address;
    private String danger;
    private String Time;

    public InfoList(String address, String danger){
        this.address = address;
        this.danger = danger;}

    public  String getAddress(){return address;}

    public String getDanger(){return danger;}


    // 주소, 위험도 받아서 넣기
    public void setAddress(String address){this.address = address;}

    public void setDanger(String danger){this.danger = danger;}

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
