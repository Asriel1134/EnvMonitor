package com.envmonitor.Controller;

import com.envmonitor.Entity.Province;
import com.envmonitor.Service.ProvinceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Asriel
 * @date 2023 02 16 14 02
 */

@RestController
@CrossOrigin
public class ProvinceController {

    ProvinceService provinceService = new ProvinceService();
    @GetMapping("/Province")
    public List<Province> getProvinceList(){
        List<Province> result = provinceService.selectAllProvince();
        return result;
    }
}
