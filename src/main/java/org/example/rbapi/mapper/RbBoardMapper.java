package org.example.rbapi.mapper;

import org.example.rbapi.dto.RbBoardDto;

import java.util.List;
import java.util.Map;

public interface RbBoardMapper {
    RbBoardDto.RbBoardSelectDto detail(String id);
    List<RbBoardDto.RbBoardSelectDto> list(RbBoardDto.RbBoardListDto params);
    List<RbBoardDto.RbBoardSelectDto> moreList(RbBoardDto.RbBoardMoreListDto params);
    List<RbBoardDto.RbBoardSelectDto> pagedList(RbBoardDto.RbBoardPagedListDto params);
    int pagedListCount(RbBoardDto.RbBoardPagedListDto params);
}
