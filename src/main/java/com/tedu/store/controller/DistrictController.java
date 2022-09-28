package com.tedu.store.controller;

import com.tedu.store.entity.District;
import com.tedu.store.service.IDistrictService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService iDistrictService;

    @PostMapping("/list/{parent}")
    public ResponseResult<List<District>> getListByParent(@PathVariable ("parent") String parent) {
        List<District> list = iDistrictService.getListByParent(parent);
        return new ResponseResult<>(SUCCESS, list);
    }
}
