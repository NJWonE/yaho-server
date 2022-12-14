package com.noh.yaho.member.query.controller;

import com.noh.yaho.common.dto.ResponseDTO;
import com.noh.yaho.member.query.dto.FindWorkTimeDataDTO;
import com.noh.yaho.member.query.service.CommutingManagementQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/commutingManagement")
@RequiredArgsConstructor
public class CommutingManagementQueryController {

    private final CommutingManagementQueryService commutingManagementQueryService;

    @GetMapping("/number")
    public ResponseDTO selectCommutingManagementNo(@RequestParam("memberNo") int memberNo) throws ParseException {
        return new ResponseDTO(HttpStatus.OK, "출근관리넘버조회성공", commutingManagementQueryService.selectCommutingManagementNo(memberNo));
    }

    @GetMapping
    public ResponseDTO selectCommutingManagement(@RequestParam(name="memberNo")int memberNo) throws ParseException {
        return new ResponseDTO(HttpStatus.OK, "업무시간조회성공", commutingManagementQueryService.selectCommutingManagement(memberNo));
    }

}
