package com.backend.apptive.DTO;

import com.backend.apptive.domain.ASRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ASRequestResponseDTO {
    private Long id;
    private String status;
    private String date;

    @Builder
    public ASRequestResponseDTO(Long id, String status, String date) {
        this.id = id;
        this.status = status;
        this.date = date;
    }

    public static ASRequestResponseDTO fromEntity(ASRequest asRequest) {
        return ASRequestResponseDTO.builder()
            .id(asRequest.getId())
            .status(asRequest.getStatus())
            .date(asRequest.getDate())
            .build();
    }

    public ASRequest toEntity() {
        return ASRequest.builder()
            .id(this.id)
            .status(this.status)
            .date(this.date)
            .build();
    }


}
