package nus.iss.paf.addressform.repository;


public class Queries {
    public static final String SQL_INSERT_FORM = 
        "insert into bff (email, name, phone, dob, status, pass_phrase) values (?, ?, ?, ?, ?, sha1(?))";
    
    public static final String SQL_SELECT_FORM = "select * from bff";

    public static final String SQL_SELECT_FORM_BY_EMAIL = "select * from bff where email like ?";

    public static final String SQL_DELETE_FORM_BY_EMAIL = "delete * from bff where email like ?";

}
