/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Date;

/**
 *
 * @author Stefan
 */
public class NewsData {

    public String Title;
    public String DateStr;
    public Date DateSql;
    public String TextP1;
    public String TextP2;
    public String TextP3;
    public String ImgUrl;

    public NewsData(String Title, String DateStr, String TextP1, String TextP2, String TextP3, String ImgUrl) {
        this.Title = Title;
        this.DateStr = DateStr;
        this.TextP1 = TextP1;
        this.TextP2 = TextP2;
        this.TextP3 = TextP3;
        this.ImgUrl = ImgUrl;
    }

    public NewsData(){
        this.Title = "Title";
        this.DateStr = "DateStr";
        this.TextP1 = "TextP1";
        this.TextP2 = "TextP2";
        this.TextP3 = "TextP3";
        this.ImgUrl = "ImgUrl";
    }
    
    
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDateStr() {
        return DateStr;
    }

    public void setDateStr(String DateStr) {
        this.DateStr = DateStr;
    }

    public Date getDateSql() {
        return DateSql;
    }

    public void setDateSql(Date DateSql) {
        this.DateSql = DateSql;
    }

    public String getTextP1() {
        return TextP1;
    }

    public void setTextP1(String TextP1) {
        this.TextP1 = TextP1;
    }

    public String getTextP2() {
        return TextP2;
    }

    public void setTextP2(String TextP2) {
        this.TextP2 = TextP2;
    }

    public String getTextP3() {
        return TextP3;
    }

    public void setTextP3(String TextP3) {
        this.TextP3 = TextP3;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

}
