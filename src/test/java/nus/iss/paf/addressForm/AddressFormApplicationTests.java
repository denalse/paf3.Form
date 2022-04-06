package nus.iss.paf.addressForm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import nus.iss.paf.addressform.model.Form;
import nus.iss.paf.addressform.repository.FormRepo;

@SpringBootTest
class AddressFormApplicationTests {

	@Autowired
	private FormRepo repo;

	@Test
	void getFormByEmailShouldBePresent() {
		Optional<Form> form = repo.getFormByEmail("fred@gmail.com");
		assertTrue(form.isPresent());
	}

	@Test
	void getFormByEmailShouldBeEmpty() {
		Optional<Form> form = repo.getFormByEmail("fred1@gmail.com");
		assertTrue(form.isEmpty());
	}

}
