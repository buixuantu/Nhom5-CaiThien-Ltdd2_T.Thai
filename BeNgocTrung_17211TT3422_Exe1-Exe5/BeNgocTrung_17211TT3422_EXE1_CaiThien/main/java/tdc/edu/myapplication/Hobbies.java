package tdc.edu.myapplication;

public class Hobbies {
    int icon;
    String txtHoTen, txtBaihat, txtTheLoai;

    public Hobbies() {
    }

    public Hobbies(int icon, String txtHoTen, String txtBaihat, String txtTheLoai) {
        this.icon = icon;
        this.txtHoTen = txtHoTen;
        this.txtBaihat = txtBaihat;
        this.txtTheLoai = txtTheLoai;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTxtHoTen() {
        return txtHoTen;
    }

    public void setTxtHoTen(String txtHoTen) {
        this.txtHoTen = txtHoTen;
    }

    public String getTxtBaihat() {
        return txtBaihat;
    }

    public void setTxtBaihat(String txtBaihat) {
        this.txtBaihat = txtBaihat;
    }

    public String getTxtTheLoai() {
        return txtTheLoai;
    }

    public void setTxtTheLoai(String txtTheLoai) {
        this.txtTheLoai = txtTheLoai;
    }

    @Override
    public String toString() {
        return "Hobbies:" +"\n"+
                "Ca sỹ yêu thích: " + txtHoTen + '\n' +
                "Bài Hát yêu thích: " + txtBaihat + '\n' +
                "Thể loại nhạc: " + txtTheLoai + '\n'
                ;
    }
}
