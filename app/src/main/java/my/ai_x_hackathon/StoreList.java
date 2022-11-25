package my.ai_x_hackathon;

import android.graphics.drawable.Drawable;

public class StoreList {
    private String store_address;
    private String store_text1;
    private String store_text2;
    private int image1;
    private int image2;
    private int image3;
    private double la;
    private double lo;

    public StoreList(String address,String store_text1, String store_text2,int image1,int image2,int image3,double la,double lo){
        this.store_address = address;
        this.store_text1 = store_text1;
        this.store_text2 = store_text2;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.la = la;
        this.lo = lo;
    }

    public String getStore_address() {
        return store_address;
    }
    public void setStore_address(String address){this.store_address = address;}

    public String getStore_text1(){return store_text1;}

    public void setStore_text1(String store_text1){this.store_text1 = store_text1;}

    public String getStore_text2(){return store_text2;}

    public void setStore_text2(String store_text2){this.store_text2 = store_text2;}

    public int getImage1(){return image1;}

    public void setImage1(int image1){this.image1 = image1;}

    public int getImage2(){return image2;}

    public void setImage2(int image2){this.image2 = image2;}

    public int getImage3(){return image3;}

    public void setImage3(int image3){this.image3 = image3;}

    public double getLa(){return la;}

    public void setLa(double la){this.la = la;}

    public double getLo(){return lo;}

    public void setLo(double lo){this.lo = lo;}
}
