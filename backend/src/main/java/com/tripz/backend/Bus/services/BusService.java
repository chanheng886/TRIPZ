package com.tripz.backend.Bus.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tripz.backend.Bus.dto.BusCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusDTO;
import com.tripz.backend.Bus.entities.Bus;
import com.tripz.backend.Bus.entities.BusCompany;
import com.tripz.backend.Bus.entities.BusType;
import com.tripz.backend.Bus.repositories.BusCompanyRepository;
import com.tripz.backend.Bus.repositories.BusRepository;
import com.tripz.backend.Bus.repositories.BusTypeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusService {
    private final BusRepository busRepository;
    private final BusCompanyRepository busCompanyRepository;
    private final BusTypeRepository busTypeRepository;

    

    // 1 . Method one
    //✅✅ Get All Bus
    public List<BusDTO> getAllBus(){
        return busRepository.findAll().stream().map(bus -> {
            BusDTO dto = new BusDTO();
            dto.setId(bus.getId());
            dto.setCompanyName(bus.getCompany().getCompanyName());
            dto.setBusType(bus.getBusType().getBusType());
            dto.setSeatCapacity(bus.getSeatCapacity());
            dto.setPlateNumber(bus.getPlateNumber());
            dto.setImageUrl(bus.getImageUrl());

            return dto;
        }).toList();
    }

    // 2 . Method Two
    //✅✅ Get Bus By Company Name
    public List<BusDTO> getBusByCompanyName(String companyName){
        List<Bus> buses = busRepository.findByCompany_CompanyName(companyName);
        if(buses.isEmpty()){
            throw new RuntimeException("Company Is Not Found!");
        }
        List<BusDTO> busDTOs = new ArrayList<>();
        
        for(Bus bus : buses){

            BusDTO dto = new BusDTO();

            dto.setId(bus.getId());
            dto.setCompanyName(bus.getCompany().getCompanyName());
            dto.setBusType(bus.getBusType().getBusType());
            dto.setSeatCapacity(bus.getSeatCapacity());
            dto.setPlateNumber(bus.getPlateNumber());
            dto.setImageUrl(bus.getImageUrl());
            
            busDTOs.add(dto);
        }
        return busDTOs;
    }

    // 3 . Method Three
    //✅✅ Get Bus By Plate Number
    public BusDTO getBusByPlateNumber(String plateNumber){
        Bus buses = busRepository.findBusByPlateNumber(plateNumber).orElseThrow(() -> new RuntimeException("Bus Not Found"));

        if(buses == null){
            throw new RuntimeException("Bus is not found!");
        }

        BusDTO dto = new BusDTO();
       
        dto.setId(buses.getId());
        dto.setCompanyName(buses.getCompany().getCompanyName());
        dto.setBusType(buses.getBusType().getBusType());
        dto.setSeatCapacity(buses.getSeatCapacity());
        dto.setPlateNumber(buses.getPlateNumber());
        dto.setImageUrl(buses.getImageUrl());
              
        return dto;
    } 

    // 4 . Method Four
    //✅✅ Create Bus
    public BusDTO createBus(BusCreateRequestDTO request){
        BusCompany company = busCompanyRepository.getBusByCompanyName(request.getCompanyName()).orElseThrow(() -> new RuntimeException("No Comapny Found!"));
        BusType busType = busTypeRepository.getByBusType(request.getBusType()).orElseThrow(() -> new RuntimeException("No Bus Type Found"));

        Bus buses = Bus.builder()
        .company(company)
        .busType(busType)
        .seatCapacity(request.getSeatCapacity())
        .plateNumber(request.getPlateNumber())
        .imageUrl(request.getImageUrl()).build();

        Bus savedBus = busRepository.save(buses);

        return BusDTO.builder()
        .id(savedBus.getId())
        .companyName(savedBus.getCompany().getCompanyName())
        .busType(savedBus.getBusType().getBusType())
        .seatCapacity(savedBus.getSeatCapacity())
        .plateNumber(savedBus.getPlateNumber())
        .imageUrl(savedBus.getImageUrl()).build();
    }

    // 5 . Method Five
    // ✅✅ Update Bus
    public BusDTO updateBus(Integer id, BusCreateRequestDTO request){
        Bus buses = busRepository.findById(id).orElseThrow(() -> new RuntimeException("Bus Not Found"));
        BusType busType = busTypeRepository.getByBusType(request.getBusType()).orElseThrow(() -> new RuntimeException("No Bus Type Found"));
        BusCompany busCompany = busCompanyRepository.getBusByCompanyName(request.getCompanyName()).orElseThrow(() -> new RuntimeException("No Comapny Found!"));

        buses.setBusType(busType);
        buses.setCompany(busCompany);
        buses.setSeatCapacity(request.getSeatCapacity());
        buses.setPlateNumber(request.getPlateNumber());
        buses.setImageUrl(request.getImageUrl());

        Bus savedBus = busRepository.save(buses);

        BusDTO dto = new BusDTO();
        dto.setId(savedBus.getId());
        dto.setBusType(savedBus.getBusType().getBusType());
        dto.setCompanyName(savedBus.getCompany().getCompanyName());
        dto.setSeatCapacity(savedBus.getSeatCapacity());
        dto.setPlateNumber(savedBus.getPlateNumber());
        dto.setImageUrl(savedBus.getImageUrl());

        return dto;
    }


    // 6. Method Six
    // ✅✅ Delete Bus
    public void deleteBus(Integer id){
        busRepository.deleteById(id);
    }
}