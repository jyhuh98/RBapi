package org.example.rbapi.service.impl;

import org.example.rbapi.domain.RbBoard;
import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbBoardDto;
import org.example.rbapi.exception.NoMatchingDataException;
import org.example.rbapi.mapper.RbBoardMapper;
import org.example.rbapi.repository.RbBoardRepository;
import org.example.rbapi.service.RbBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RbBoardServiceImpl implements RbBoardService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RbBoardRepository RbBoardRepository;
    private final RbBoardMapper RbBoardMapper;

    public RbBoardServiceImpl(
            RbBoardRepository RbBoardRepository,
            RbBoardMapper RbBoardMapper
    ) {
        this.RbBoardRepository = RbBoardRepository;
        this.RbBoardMapper = RbBoardMapper;
    }

    public RbBoardDto.RbBoardAfterCreateDto create(RbBoardDto.RbBoardCreateDto params){
        return RbBoardRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public RbBoardDto.RbBoardAfterUpdateDto update(RbBoardDto.RbBoardUpdateDto params){
        RbBoard RbBoard = RbBoardRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getTitle() != null){
            RbBoard.setTitle(params.getTitle());
        }
        if(params.getContent() != null){
            RbBoard.setContent(params.getContent());
        }
        if(params.getDeleted() != null){
            RbBoard.setDeleted(params.getDeleted());
        }
        RbBoardRepository.save(RbBoard);
        return RbBoard.toAfterUpdateDto();
    }

    public RbBoardDto.RbBoardSelectDto detail(String id){
        return RbBoardMapper.detail(id);
    }
    public List<RbBoardDto.RbBoardSelectDto> list(RbBoardDto.RbBoardListDto params){
        return RbBoardMapper.list(params);
    }
    public List<RbBoardDto.RbBoardSelectDto> moreList(RbBoardDto.RbBoardMoreListDto params){
        params.afterBuild();
        return RbBoardMapper.moreList(params);
    }
    public CommonAfterPagedListDto<RbBoardDto.RbBoardSelectDto> pagedList(RbBoardDto.RbBoardPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(RbBoardMapper.pagedListCount(params)), RbBoardMapper.pagedList(params));
    }

}
