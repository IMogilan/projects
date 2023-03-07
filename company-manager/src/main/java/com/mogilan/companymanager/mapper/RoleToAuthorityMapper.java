package com.mogilan.companymanager.mapper;

import com.mogilan.companymanager.dao.entity.user.RoleEntity;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component("RolesMapper")
@Scope("singleton")
@NoArgsConstructor
public class RoleToAuthorityMapper {

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roleEntityCollection){
        List<SimpleGrantedAuthority> authorityList = roleEntityCollection.stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                .collect(Collectors.toList());
        return authorityList;
    }
}
