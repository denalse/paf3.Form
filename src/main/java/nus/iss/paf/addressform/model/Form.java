package nus.iss.paf.addressform.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.MultiValueMap;

public class Form {
    
    private String email;
    private String name;
    private String phone;
    private String status;
    private String dob;
    private String passPhrase;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }

    // A MultiValueMap decorates another map, 
    // allowing it to have more than one value for a key.
    // A MultiMap is a Map with slightly different semantics. 
    // Putting a value into the map will add the value to a Collection at that key.
    public static Form create(MultiValueMap<String, String> body) {
        Form f = new Form();
        f.setEmail(body.getFirst("email"));
        f.setName(body.getFirst("name"));
        f.setPhone(body.getFirst("phone"));
        f.setStatus(body.getFirst("status"));
        f.setDob(body.getFirst("dob"));
        System.out.println(">>>>>>> DOB: " + f.getDob());
        f.setPassPhrase(body.getFirst("passPhrase"));
        return f;
    }
    //what is sqlrowset
    public static Form create(SqlRowSet result) {
        Form f = new Form();
        f.setEmail(result.getString("email"));
        f.setName(result.getString("name"));
        f.setPhone(result.getString("phone"));
        f.setStatus(result.getString("status"));
        f.setDob(result.getString("dob"));
        System.out.println(">>>>>>> DOB: " + f.getDob());
        f.setPassPhrase(result.getString("pass_phrase"));
        return f;
    }
    
}
