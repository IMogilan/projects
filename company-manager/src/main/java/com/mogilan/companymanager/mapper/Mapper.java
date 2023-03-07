package com.mogilan.companymanager.mapper;

import java.util.List;

public interface Mapper <F, T> {
    T mapDtoFromEntity(F object);
    F mapEntityFromDto(T object);
    List<T> mapListDtoFromListEntity(List<F> object);
    List<F> mapListEntityFromListDto(List<T> object);

}
