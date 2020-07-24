package mybatis.controller;

import mybatis.repository.model.ArticleFilter;
import mybatis.service.ArticleService.ArticleService;
import mybatis.utility.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/table")
    public String getTable(ModelMap modelMap, Paging paging, ArticleFilter articleFilter){
        System.out.println(paging);
        modelMap.addAttribute("articles",articleService.findAllFilter(articleFilter,paging));
        return "ajax/ajax-table";
    }
    @GetMapping("/index")
    public String indexAjax(ModelMap modelMap){
        modelMap.addAttribute("articles",articleService.findAll());
        return "ajax/index";
    }
}
