/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "server")
@SessionScoped
public class ServerBean implements Serializable {

    public String name;
    public String lastName;
    public String userEmail;
    public String subject;
    public String message;

    public Boolean bool;

    public String buttonClikedS;
    public Integer buttonClickedInt;

    public NewsData newsToDisp;
    public NewsData newsToDispEn;

    public NewsData[] newsArray;
    public NewsData[] newsArrayEn;

    public ServerBean() {
        newsArray = new NewsData[10];           // inicijalizacija nizova vestima iz baze
        for (int i = 0; i < 10; i++) {
            newsArray[i] = new NewsData();
        }
        newsArrayEn = new NewsData[10];
        for (int i = 0; i < 10; i++) {
            newsArrayEn[i] = new NewsData();
        }

        Connection con = DB.getInstance().getConnection();

        String get = "select * from Vesti order by DateSql desc";
        String getEn = "select * from VestiEn order by DateSql desc";

        try {
            if (con != null) {
                //srpski
                PreparedStatement ps = con.prepareStatement(get);
                ResultSet rs = ps.executeQuery();
                for (int i = 0; i < 10; i++) {              // poslednjih 10 vesti dodajem u niz
                    if (rs.next()) {
                        newsArray[i].setTitle(rs.getString(2));
                        newsArray[i].setDateStr(rs.getString(3));
                        newsArray[i].setDateSql(rs.getDate(4));
                        newsArray[i].setTextP1(rs.getString(5));
                        newsArray[i].setTextP2(rs.getString(6));
                        newsArray[i].setTextP3(rs.getString(7));
                        newsArray[i].setImgUrl(rs.getString(8));
                    } else {
                        newsArray[i].setTitle("Title");
                        newsArray[i].setDateStr("Date");
                        newsArray[i].setDateSql(new Date(1970, 1, 1));
                        newsArray[i].setTextP1("TextP1");
                        newsArray[i].setTextP2("TextP2");
                        newsArray[i].setTextP3("TextP3");
                        newsArray[i].setImgUrl("imgUrl");
                    }
                }
                //engleski
                PreparedStatement ps2 = con.prepareStatement(getEn);
                ResultSet rs2 = ps2.executeQuery();
                for (int i = 0; i < 10; i++) {
                    if (rs2.next()) {
                        newsArrayEn[i].setTitle(rs2.getString(2));
                        newsArrayEn[i].setDateStr(rs2.getString(3));
                        newsArrayEn[i].setDateSql(rs2.getDate(4));
                        newsArrayEn[i].setTextP1(rs2.getString(5));
                        newsArrayEn[i].setTextP2(rs2.getString(6));
                        newsArrayEn[i].setTextP3(rs2.getString(7));
                        newsArrayEn[i].setImgUrl(rs2.getString(8));
                    } else {
                        newsArrayEn[i].setTitle("Title");
                        newsArrayEn[i].setDateStr("Date");
                        newsArrayEn[i].setDateSql(new Date(1970, 1, 1));
                        newsArrayEn[i].setTextP1("TextP1");
                        newsArrayEn[i].setTextP2("TextP2");
                        newsArrayEn[i].setTextP3("TextP3");
                        newsArrayEn[i].setImgUrl("imgUrl");
                    }
                }

            }
        } catch (SQLException ex) {

        }

    }

    public String buttonClicked(int button) {               // kada se na glavnoj stranici odabere vest pamtim koja je to vest 
        buttonClickedInt = button;                          // da bi je posle prikazali
        buttonClikedS = Integer.toString(button);

        newsToDisp = newsArray[button];

        return "newsPage";
    }

    public String buttonClickedEn(int button) {
        buttonClickedInt = button;
        buttonClikedS = Integer.toString(button);

        newsToDispEn = newsArrayEn[button];

        return "newsPage_en";
    }

    public String sideLink(int linkNum) {           // kada se na linku sa strane klikne vest pamti se koja je vest

        newsToDisp = newsArray[linkNum];
        return "newsPage";
    }

    public String sideLinkEn(int linkNum) {

        newsToDispEn = newsArrayEn[linkNum];
        return "newsPage_en";
    }

    public String sendInfo() {              // pamcene poruke koja je upisana u Kontakt sekciji
        Connection con = DB.getInstance().getConnection();

        if (name.isEmpty() || lastName.isEmpty() || userEmail.isEmpty() || subject.isEmpty()) {
            // ne zelimo poruku ako je nesto prazno

            return "index";
        }

        String set = "insert into poruke values(?,?,?,?,?,?)";
        String get = "select max(id) from poruke";
        int id = 1;
        try {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(get);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {                        // auto id
                    id = rs.getInt(1) + 1;
                }

                PreparedStatement ps1 = con.prepareStatement(set);
                ps1.setInt(1, id);
                ps1.setString(2, name);
                ps1.setString(3, lastName);
                ps1.setString(4, userEmail);
                ps1.setString(5, subject);
                ps1.setString(6, message);

                ps1.executeQuery();

            }

            return "index";

        } catch (SQLException ex) {
            return "index";
        }
    }

    public String sendInfoEn() {
        Connection con = DB.getInstance().getConnection();

        if (name.isEmpty() || lastName.isEmpty() || userEmail.isEmpty() || subject.isEmpty()) {
            // ne zelimo poruku ako je nesto prazno
            
            return "index_en";
        }

        String set = "insert into poruke values(?,?,?,?,?,?)";
        String get = "select max(id) from poruke";
        int id = 1;
        try {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(get);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {                    //auto id
                    id = rs.getInt(1) + 1;
                }

                PreparedStatement ps1 = con.prepareStatement(set);
                ps1.setInt(1, id);
                ps1.setString(2, name);
                ps1.setString(3, lastName);
                ps1.setString(4, userEmail);
                ps1.setString(5, subject);
                ps1.setString(6, message);

                ps1.executeQuery();

            }

            return "index_en";

        } catch (SQLException ex) {
            return "index_en";
        }
    }

    // GETERI I SETERI
    public NewsData getNewsToDisp() {
        return newsToDisp;
    }

    public void setNewsToDisp(NewsData newsToDisp) {
        this.newsToDisp = newsToDisp;
    }

    public NewsData[] getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(NewsData[] newsArray) {
        this.newsArray = newsArray;
    }

    public String getButtonClikedS() {
        return buttonClikedS;
    }

    public void setButtonClikedS(String buttonClikedS) {
        this.buttonClikedS = buttonClikedS;
    }

    public Integer getButtonClickedInt() {
        return buttonClickedInt;
    }

    public void setButtonClickedInt(Integer buttonClickedInt) {
        this.buttonClickedInt = buttonClickedInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public NewsData getNewsToDispEn() {
        return newsToDispEn;
    }

    public void setNewsToDispEn(NewsData newsToDispEn) {
        this.newsToDispEn = newsToDispEn;
    }

    public NewsData[] getNewsArrayEn() {
        return newsArrayEn;
    }

    public void setNewsArrayEn(NewsData[] newsArrayEn) {
        this.newsArrayEn = newsArrayEn;
    }

}
