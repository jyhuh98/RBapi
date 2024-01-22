package org.example.rbapi.service;

import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbBoardDto;

import java.util.List;

public interface RbBoardService {
    public RbBoardDto.RbBoardAfterCreateDto create(RbBoardDto.RbBoardCreateDto params);
    public RbBoardDto.RbBoardAfterUpdateDto update(RbBoardDto.RbBoardUpdateDto params);
    public RbBoardDto.RbBoardSelectDto detail(String id);
    public List<RbBoardDto.RbBoardSelectDto> list(RbBoardDto.RbBoardListDto params);
    public List<RbBoardDto.RbBoardSelectDto> moreList(RbBoardDto.RbBoardMoreListDto params);
    public CommonAfterPagedListDto<RbBoardDto.RbBoardSelectDto> pagedList(RbBoardDto.RbBoardPagedListDto params);
    
}
