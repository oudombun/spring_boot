package mybatis.controller.rest;

import mybatis.repository.model.Customer;
import mybatis.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CustomerrRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping("customer/signup")
    public ResponseEntity<Map<String,Object>> signup(@RequestParam String name,@RequestParam String password,@RequestParam String mobile,@RequestParam String address){
        Map map = new HashMap();
        if(customerService.addCustomer(name,password,mobile,address)){
            map.put("STATUS",true);
            map.put("MESSAGE","Customer inserted Success");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else {
            map.put("STATUS",false);
            map.put("MESSAGE","Customer inserted failed");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("customer/signin")
    public ResponseEntity<Map<String,Object>> signin(@RequestParam String mobile,@RequestParam String password){
        Map map = new HashMap();
        if(customerService.checklogin(mobile,password)!=null){
            map.put("STATUS",true);
            map.put("MESSAGE","Customer login Success");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else {
            map.put("STATUS",false);
            map.put("MESSAGE","Customer login failed");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
