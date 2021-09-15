package dev.evertonsavio.app;

import dev.evertonsavio.app.sfgpetclinic.model.Speciality;
import dev.evertonsavio.app.sfgpetclinic.repositories.SpecialtyRepository;
import dev.evertonsavio.app.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class LambdaTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void saveLambdaTest() {

        //BDD Style
        //GIVEN
        final String MATCH_ME = "MATCH_ME";
        Speciality speciality = new Speciality();
        speciality.setDescription(MATCH_ME);

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);
        //Mock to only on math MATCH_ME
        given(specialtyRepository.save(argThat(specialityToSave -> specialityToSave.getDescription().equals(MATCH_ME))))
                .willReturn(savedSpeciality);

        //WHEN
        Speciality returnedSpeciality = service.save(speciality);

        //THEN
        assertThat(returnedSpeciality.getId()).isEqualTo(1L);
    }
}
