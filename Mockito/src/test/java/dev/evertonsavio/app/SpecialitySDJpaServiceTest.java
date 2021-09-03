package dev.evertonsavio.app;

import dev.evertonsavio.app.sfgpetclinic.model.Speciality;
import dev.evertonsavio.app.sfgpetclinic.repositories.SpecialtyRepository;
import dev.evertonsavio.app.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void findByTest() {
        Speciality speciality = new Speciality();
        Mockito.when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
        Speciality foundSpeciality = service.findById(1L);
        assertThat(foundSpeciality).isNotNull();
        Mockito.verify(specialtyRepository, Mockito.times(1)).findById(1L);

    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        service.deleteById(1l);

        Mockito.verify(specialtyRepository, Mockito.times(2)).deleteById(1L);
        Mockito.verify(specialtyRepository, Mockito.atLeastOnce()).deleteById(1L);
    }

    @Test
    void delete() {
        service.delete(new Speciality());
    }

}