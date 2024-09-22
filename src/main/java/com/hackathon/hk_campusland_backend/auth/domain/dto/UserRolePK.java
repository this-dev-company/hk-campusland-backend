package com.hackathon.hk_campusland_backend.auth.domain.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserRolePK {

    @Column(name = "usuario_id")
    private String userId;
    
    @Column(name = "rol_id")
    private String rolId;

}
