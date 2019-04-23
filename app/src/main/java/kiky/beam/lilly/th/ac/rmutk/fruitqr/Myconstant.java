package kiky.beam.lilly.th.ac.rmutk.fruitqr;

import java.lang.ref.SoftReference;

public class Myconstant {

    private String[] favoriteFruits = {"โปรดเลือกผลไม้","ส้ม","มะละกอ", "แตงโม","ทุเรียน", "เงาะ", "มะม่วง", "เชอร์รี่", "สับปะรด", "ลำไย"};
    private String[] units = {"กิโลกรัม","ผล","ลัง"};
    private String[] columnDetailProduct = {"id", "idRecord", "NameRecord", "TypeRecord", "idFarmer",
                                                "Name", "Detail", "Image", "Amount", "Unit", "Date", "QRcode"};
    private String[] columnDetailFramer = {"id", "idRecord", "Name", "Amount", "Unit", "Date", "Namesend"};
    private String[] columnUser = {"id", "Name", "FirstName", "SecondName", "Address", "Phone", "User", "Password", "TypeUser"};

    private String nameFileSharePreference = "Fruit";

    private String urlgetAllDataOrderByDesc = "http://www.androidthai.in.th/rmutk/getAllDataOrderByDesc.php";

//    private String urlGetUserWhereId = "https://www.androidthai.in.th/rmutk/getUserWhereId.php";
    private String urlGetFramerWhereId = "http://androidthai.in.th/rmutk/getFarmerWhereId.php";//ดึงค่าฟามเมอร์ในรายละเอียดผลิตภัณฑ์
    private String urlGetProductWhereId = "http://www.androidthai.in.th/rmutk/getProductrWhereId.php"; //
    private String urlGetAllDeatailProduct = "http://www.androidthai.in.th/rmutk/getDetailProduct.php";//รายละเอียดผลิตภัณฑ์
    private String urlAddDetailProduct = "http://www.androidthai.in.th/rmutk/addDetailProductLilly.php"; //เพิ่มผลิตภัณฑ์
    private String urlProductPic =  "https://www.androidthai.in.th/rmutk/Picture/product.png";

    private String urlAddDetailFramer = "http://www.androidthai.in.th/rmutk/addDetailFramerLilly.php"; //เพิ่มผลผลิต
    private String urlAddUser = "https://www.androidthai.in.th/rmutk/addDataLilly.php";
    private String urlGetAllData = "https://www.androidthai.in.th/rmutk/getAllDatalilly.php";
    private String urlGetDataWhereQR = "https://www.androidthai.in.th/rmutk/getDetailWhereQRmaster.php";
    private String urlGetUserWhereId = "https://www.androidthai.in.th/rmutk/getUserWhereId.php";
    private String urlGetAllDetail = "https://www.androidthai.in.th/rmutk/getDetail.php";
    private String urlGetDetailWhereIdUser = "https://www.androidthai.in.th/rmutk/getDetailWhereIdUser.php";

    private String urlGetDetailFramerWhereIdRecord = "http://www.androidthai.in.th/rmutk/getDetailFramerWhereIdRecordLilly.php"; //ดูได้แค่ผู้ผลิค
    private String urlGetAllDetailFramer = "http://www.androidthai.in.th/rmutk/getAllDetaiFramerLilly.php"; //Admin ดูได้ทั้งหมด DetailFramer

    public String getUrlgetAllDataOrderByDesc() {
        return urlgetAllDataOrderByDesc;
    }

    public String[] getColumnUser() {
        return columnUser;
    }

    private String urlGetAllFramer = "https://www.androidthai.in.th/rmutk/getAllFramerlilly.php";

    public String[] getColumnDetailFramer() {
        return columnDetailFramer;
    }

    public String getUrlGetFramerWhereId() {
        return urlGetFramerWhereId;
    }

    public String[] getColumnDetailProduct() {
        return columnDetailProduct;
    }

    public String getUrlGetProductWhereId() {
        return urlGetProductWhereId;
    }

    public String getUrlGetAllDeatailProduct() {
        return urlGetAllDeatailProduct;
    }

    public String getUrlAddDetailProduct() {
        return urlAddDetailProduct;
    }

    public String getUrlProductPic() {
        return urlProductPic;
    }

    public String getUrlGetAllFramer() {
        return urlGetAllFramer;
    }

    public String getUrlGetDetailFramerWhereIdRecord() {
        return urlGetDetailFramerWhereIdRecord;
    }

    public String getUrlGetAllDetailFramer() {
        return urlGetAllDetailFramer;
    }

    public String getUrlAddDetailFramer() {
        return urlAddDetailFramer;
    }

    public String[] getFavoriteFruits() {
        return favoriteFruits;
    }

    public String[] getUnits() {
        return units;
    }

    public String getNameFileSharePreference() {
        return nameFileSharePreference;
    }

    public String getUrlGetDetailWhereIdUser() {
        return urlGetDetailWhereIdUser;
    }

    public String getUrlGetAllDetail() {
        return urlGetAllDetail;
    }

    public String getUrlGetUserWhereId() {
        return urlGetUserWhereId;
    }

    public String getUrlGetDataWhereQR() {
        return urlGetDataWhereQR;
    }

    public String getUrlGetAllData() {
        return urlGetAllData;
    }

    public String getUrlAddUser() {
        return urlAddUser;
    }
}
