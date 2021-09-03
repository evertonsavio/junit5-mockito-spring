package dev.evertonsavio.app;

import dev.evertonsavio.app.sfgpetclinic.model.Speciality;
import dev.evertonsavio.app.sfgpetclinic.repositories.SpecialtyRepository;
import dev.evertonsavio.app.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    void deleteByObjectTest() {
        Speciality speciality = new Speciality();

        service.delete(speciality);

        Mockito.verify(specialtyRepository).delete(ArgumentMatchers.any(Speciality.class));
    }

    @Test
    void findByIdTest() {
        Speciality speciality = new Speciality();
        Mockito.when(specialtyRepository.findById(anyLong())).thenReturn(Optional.of(speciality));
        Speciality foundSpeciality = service.findById(1L);
        assertThat(foundSpeciality).isNotNull();
        Mockito.verify(specialtyRepository, times(1)).findById(1L);

    }

    @Test
    void findByIdBddTest() {
        //given
        Speciality speciality = new Speciality();
        BDDMockito.given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

        //when
        Speciality foundSpeciality = service.findById(1L);

        //then
        assertThat(foundSpeciality).isNotNull();
        //BDDMockito.then(specialtyRepository).should().findById(anyLong());
        then(specialtyRepository).should(times(1)).findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        service.deleteById(1l);

        Mockito.verify(specialtyRepository, times(2)).deleteById(1L);
        Mockito.verify(specialtyRepository, Mockito.atLeastOnce()).deleteById(1L);
    }

    @Test
    void delete() {
        service.delete(new Speciality());
    }

}