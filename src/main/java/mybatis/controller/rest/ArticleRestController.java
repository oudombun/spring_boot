package mybatis.controller.rest;

import mybatis.repository.model.Article;
import mybatis.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ArticleRestController {
    @Autowired
    ArticleService articleService;

    @PostMapping("articles")
    public ResponseEntity<Map<String,Object>> insert(@RequestBody Article article){
        Map map = new HashMap();
        if(articleService.add(article)){
            map.put("status",true);
            map.put("message","Article inserted Success");
            map.put("data",articleService.findById(article.getId()));
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("status",false);
            map.put("message","Article inserted failed");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("articles")
    public ResponseEntity<Map<String,Object>> findAll(){
        Map map = new HashMap();
        List<Article> articles= articleService.findAll();
        if(articles.isEmpty()){
            map.put("status",false);
            map.put("message","Article cannot be found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }else {
            map.put("status",true);
            map.put("message","Article found");
            map.put("data",articles);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    @GetMapping("articles/{id}")
    public ResponseEntity<Map<String,Object>> findOne(@PathVariable int id){
        Map map = new HashMap();
        Article article= articleService.findById(id);
        if(article==null){
            map.put("status",false);
            map.put("message","Article cannot be found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }else {
            map.put("status",true);
            map.put("message","Article found");
            map.put("data",article);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    @DeleteMapping("articles/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable int id){
        Map map = new HashMap();
        if(articleService.delete(id)){
            map.put("status",true);
            map.put("message","Deleted success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("status",false);
            map.put("message","Deleted Failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("articles")
    public ResponseEntity<Map<String,Object>> update(@RequestBody Article article){
        Map map = new HashMap();
        if(articleService.update(article)){
            map.put("status",true);
            map.put("message","Updated success");
            map.put("data",articleService.findById(article.getId()));
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("status",false);
            map.put("message","Updated Failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
    }


}
