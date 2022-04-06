package nus.iss.paf.addressform.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static nus.iss.paf.addressform.repository.Queries.*;

import nus.iss.paf.addressform.model.Form;

@Repository
public class FormRepo {
    private Logger logger = LoggerFactory.getLogger(FormRepo.class);

    @Autowired
    private JdbcTemplate template;

    public boolean setForms(Form form) {
        return setForms(form.getEmail(), form.getName(),
                        form.getPhone(), form.getStatus(),
                        form.getDob(), form.getPassPhrase());
    }

    public boolean setForms(String email, String name, String phone, String status, String dob, String passPhrase) {
        int added = template.update(
            SQL_INSERT_FORM , email, name, phone, status, dob, passPhrase
        );

        return added > 0;
    }

    public boolean deleteForm(String email){
        int deleted = template.update(
            SQL_INSERT_FORM, email
        );
        return deleted> 0;
    }

    public Optional<Form> getFormByEmail(String email){
        final SqlRowSet result = template.queryForRowSet(
            SQL_SELECT_FORM_BY_EMAIL, email
        );
        if (!result.next())
            return Optional.empty();

        Form c = Form.create(result);
        logger.info("Queried email >>>> " + c.getEmail());
        return Optional.of(c);
    } 

    public List<Form> getFormList(){
        List<Form> FormList = new ArrayList<>();
        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_FORM);
        while (result.next()){
            // FormList.add(getFormByEmail(result.getString("email")).get());
            Form c = Form.create(result);
            FormList.add(c);
        }
        return FormList;

    }

}
