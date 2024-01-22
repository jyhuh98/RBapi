package org.example.rbapi.mapper;

import org.example.rbapi.dto.RbUserDto;

import java.util.List;

public interface RbUserMapper {
    RbUserDto.RbUserSelectDto detail(String id);
    List<RbUserDto.RbUserSelectDto> list(RbUserDto.RbUserListDto params);
    List<RbUserDto.RbUserSelectDto> moreList(RbUserDto.RbUserMoreListDto params);
    List<RbUserDto.RbUserSelectDto> pagedList(RbUserDto.RbUserPagedListDto params);
    int pagedListCount(RbUserDto.RbUserPagedListDto params);
}
