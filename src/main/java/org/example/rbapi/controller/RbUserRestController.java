package org.example.rbapi.controller;

import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbUserDto;
import org.example.rbapi.service.RbUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. 회원 API 안내",
        description = "회원 관련 기능 정의한 RestController.")
@RequestMapping("/api/rbuser")
@RestController
public class RbUserRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RbUserService RbUserService;

    public RbUserRestController(RbUserService RbUserService) {
        this.RbUserService = RbUserService;
    }

    @Operation(summary = "회원 정보 등록",
            description = "회원 신규 정보 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbUserCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<RbUserAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<RbUserDto.RbUserAfterCreateDto> save(@Valid @RequestBody RbUserDto.RbUserCreateDto params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RbUserService.create(params));
    }
    @Operation(summary = "회원 정보 수정",
            description = "회원 기존 정보 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbUserUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbUserAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<RbUserDto.RbUserAfterUpdateDto> update(@Valid @RequestBody RbUserDto.RbUserUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbUserService.update(params));
    }

    @Operation(summary = "회원 정보 조회",
            description = "회원 정보 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbUserSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<RbUserDto.RbUserSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(RbUserService.detail(id));
    }
    @Operation(summary = "회원 정보 목록 조회(검색 기능 포함)",
            description = "회원 정보 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbUserSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<RbUserDto.RbUserSelectDto>> list(@Valid @RequestBody RbUserDto.RbUserListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbUserService.list(params));
    }
    @Operation(summary = "회원 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "회원 추가 조회한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbUserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<RbUserDto.RbUserSelectDto>> moreList(@Valid @RequestBody RbUserDto.RbUserMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbUserService.moreList(params));
    }

    @Operation(summary = "회원 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "회원 페이징 처리 한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbUserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<RbUserDto.RbUserSelectDto>> pagedList(@Valid @RequestBody RbUserDto.RbUserPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbUserService.pagedList(params));
    }

}
