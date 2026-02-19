package com.api.barber_shop.services;

import com.api.barber_shop.dtos.BarberRequestDto;
import com.api.barber_shop.dtos.BarberResponseDto;
import com.api.barber_shop.entities.BarberEntity;
import com.api.barber_shop.mappers.BarberMapper;
import com.api.barber_shop.repositories.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BarberService {

    private final BarberRepository barberRepository;


    public BarberResponseDto createBarber(BarberRequestDto barberRequestDto){
        if (barberRequestDto.nameBarber() == null || barberRequestDto.nameBarber().isBlank()) {
            throw new RuntimeException("O nome do barbeiro é obrigatório!");
        }

        if (barberRequestDto.specialtyBarber() == null || barberRequestDto.specialtyBarber().isBlank()) {
            throw new RuntimeException("A especialidade do barbeiro é obrigatória!");
        }

        BarberEntity entity = BarberMapper.toEntity(barberRequestDto);
        BarberEntity response = barberRepository.save(entity);

        return BarberMapper.toResponse(response);
    }

    public BarberResponseDto findByIdBarber(UUID idBarber) {
        BarberEntity searchID = barberRepository.findById(idBarber).orElseThrow(
                () -> new RuntimeException("ID não encontrado...")
        );
        return BarberMapper.toResponse(searchID);
    }


    public List<BarberResponseDto> findByNameBarber(String nameBarberDto) {
        List<BarberEntity> listNameBarber = barberRepository.findByNameBarberContainingIgnoreCase(nameBarberDto);

        if (listNameBarber.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum barbeiro com esse nome encontrado");
        }

        List<BarberResponseDto> dtoList = new ArrayList<>();

        for (BarberEntity barber : listNameBarber) {
            BarberResponseDto dto = BarberMapper.toResponse(barber);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public List<BarberResponseDto> findyBySpecialtyBarber(BarberRequestDto specialtyDto){
        List<BarberEntity> listSpecialtyBarber = barberRepository.findBySpecialtyBarberContainingIgnoreCase(String.valueOf(specialtyDto));

        if(listSpecialtyBarber.isEmpty()){
            throw new RuntimeException("Barbeiro não encontrado...");
        }

        List<BarberResponseDto> dtoListSpecialty = new ArrayList<>();
        for(BarberEntity barber : listSpecialtyBarber){
            BarberResponseDto dto = BarberMapper.toResponse(barber);
            dtoListSpecialty.add(dto);
        }

        return dtoListSpecialty;
    }

    public BarberResponseDto updateBarber(UUID id, BarberRequestDto requestDto){
        BarberEntity entity = barberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );

        entity.setNameBarber(requestDto.nameBarber());
        entity.setSpecialtyBarber(requestDto.specialtyBarber());
        entity.setActiveBarber(requestDto.activeBarber());

        BarberEntity upBarber = barberRepository.save(entity);

        return BarberMapper.toResponse(upBarber);
    }


    public void deleteBarberId(UUID id){
        BarberEntity deleteIdBarber = barberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Barbeiro não encontrado.")
         );

        barberRepository.deleteById(deleteIdBarber.getId());
    }

}
