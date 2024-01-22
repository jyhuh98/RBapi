package org.example.rbapi.service.impl;

import org.example.rbapi.domain.RbUser;
import org.example.rbapi.repository.RbUserRepository;
import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbUserDto;
import org.example.rbapi.exception.NoMatchingDataException;
import org.example.rbapi.mapper.RbUserMapper;
import org.example.rbapi.service.RbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RbUserServiceImpl implements RbUserService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RbUserRepository RbUserRepository;
    private final RbUserMapper RbUserMapper;
    public RbUserServiceImpl(
            RbUserRepository RbUserRepository
            ,RbUserMapper RbUserMapper
    ) {
        this.RbUserRepository = RbUserRepository;
        this.RbUserMapper = RbUserMapper;
    }

    public RbUserDto.RbUserAfterCreateDto create(RbUserDto.RbUserCreateDto params){
        return RbUserRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public RbUserDto.RbUserAfterUpdateDto update(RbUserDto.RbUserUpdateDto params){
        RbUser RbUser = RbUserRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getPw() != null){
            RbUser.setPw(params.getPw());
        }
        if(params.getNick() != null){
            RbUser.setNick(params.getNick());
        }
        if(params.getSfrom() != null){
            RbUser.setSfrom(params.getSfrom());
        }
        if(params.getDeleted() != null){
            RbUser.setDeleted(params.getDeleted());
        }
        if(params.getProcess() != null){
            RbUser.setProcess(params.getProcess());
        }
        if(params.getName() != null){
            RbUser.setName(params.getName());
        }
        if(params.getPhone() != null){
            RbUser.setPhone(params.getPhone());
        }
        if(params.getMpic() != null){
            RbUser.setMpic(params.getMpic());
        }
        RbUserRepository.save(RbUser);
        return RbUser.toAfterUpdateDto();
    }

    public RbUserDto.RbUserSelectDto detail(String id){
        return RbUserMapper.detail(id);
    }
    public List<RbUserDto.RbUserSelectDto> list(RbUserDto.RbUserListDto params){
        return RbUserMapper.list(params);
    }
    public List<RbUserDto.RbUserSelectDto> moreList(RbUserDto.RbUserMoreListDto params){
        params.afterBuild();
        return RbUserMapper.moreList(params);
    }
    public CommonAfterPagedListDto<RbUserDto.RbUserSelectDto> pagedList(RbUserDto.RbUserPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(RbUserMapper.pagedListCount(params)), RbUserMapper.pagedList(params));
    }

}
