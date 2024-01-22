package org.example.rbapi.controller;

import org.example.rbapi.dto.CommonAfterPagedListDto;
import org.example.rbapi.dto.RbBoardDto;
import org.example.rbapi.service.RbBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. 게시판 API 안내",
        description = "게시판 관련 기능 정의한 RestController.")
@RequestMapping("/api/rbboard")
@RestController
public class RbBoardRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RbBoardService RbBoardService;
    public RbBoardRestController(RbBoardService RbBoardService) {
        this.RbBoardService = RbBoardService;
    }
    @Operation(summary = "게시판 글 등록",
            description = "게시판 신규 글 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbBoardCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<RbBoardAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<RbBoardDto.RbBoardAfterCreateDto> save(@Valid @RequestBody RbBoardDto.RbBoardCreateDto params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RbBoardService.create(params));
    }
    @Operation(summary = "게시판 글 수정",
            description = "게시판 기존 글 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbBoardUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbBoardAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<RbBoardDto.RbBoardAfterUpdateDto> update(@Valid @RequestBody RbBoardDto.RbBoardUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbBoardService.update(params));
    }

    @Operation(summary = "게시판 글 정보 조회",
            description = "게시판 글 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbBoardSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<RbBoardDto.RbBoardSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(RbBoardService.detail(id));
    }
    @Operation(summary = "게시판 글 정보 목록 조회(검색 기능 포함)",
            description = "게시판 글 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<RbBoardSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<RbBoardDto.RbBoardSelectDto>> list(@Valid @RequestBody RbBoardDto.RbBoardListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbBoardService.list(params));
    }
    @Operation(summary = "게시판 글 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "게시판 추가 조회한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbBoardSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<RbBoardDto.RbBoardSelectDto>> moreList(@Valid @RequestBody RbBoardDto.RbBoardMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbBoardService.moreList(params));
    }

    @Operation(summary = "게시판 글 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "게시판 페이징 처리 한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param RbBoardSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<RbBoardDto.RbBoardSelectDto>> pagedList(@Valid @RequestBody RbBoardDto.RbBoardPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(RbBoardService.pagedList(params));
    }
}
