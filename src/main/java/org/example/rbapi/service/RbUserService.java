package org.example.rbapi.service;

import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbUserDto;

import java.util.List;

public interface RbUserService {
    public RbUserDto.RbUserAfterCreateDto create(RbUserDto.RbUserCreateDto params);
    public RbUserDto.RbUserAfterUpdateDto update(RbUserDto.RbUserUpdateDto params);
    public RbUserDto.RbUserSelectDto detail(String id);
    public List<RbUserDto.RbUserSelectDto> list(RbUserDto.RbUserListDto params);
    public List<RbUserDto.RbUserSelectDto> moreList(RbUserDto.RbUserMoreListDto params);
    public CommonAfterPagedListDto<RbUserDto.RbUserSelectDto> pagedList(RbUserDto.RbUserPagedListDto params);
}
