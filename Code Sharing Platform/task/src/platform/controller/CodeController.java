package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.entities.Code;
import platform.service.CodeService;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CodeController {

    @Autowired
    CodeService codeService;

    public CodeController(){
    }

    @GetMapping(value = "/code/{N}", produces = "text/html")
    public ModelAndView getCodeHtml(@PathVariable String N){
        ModelAndView model = new ModelAndView();
        try {
            Code IdCode = codeService.findCodeById(N);
            if(IdCode.isViewsRestrict() || IdCode.isTimeRestrict()){
                codeService.update(IdCode);
                IdCode = codeService.findCodeById(N);
                model.addObject("IdCode", IdCode);
                model.setViewName("code");
                return model;
            }
            else{
                model.addObject("IdCode", IdCode);
                model.setViewName("code");
                return model;
            }
        }
        catch (Exception e){
            model.addObject("notFound", e.getMessage());
            model.setViewName("404NotFound");
            model.setStatus(HttpStatus.NOT_FOUND);
            return model;
        }

    }

    @GetMapping(value = "/api/code/{N}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Object> getJSONCode(@PathVariable String N) throws Exception {

        if(codeService.IdExists(N)){
            Code IdCode = codeService.findCodeById(N);
            if(IdCode.isViewsRestrict() || IdCode.isTimeRestrict()){
                codeService.update(IdCode);
                if(codeService.IdExists(N)){
                    return new ResponseEntity<>(IdCode, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            else{
                return new ResponseEntity<>(IdCode, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/api/code/new", produces ="application/json")
    @ResponseBody
    public ResponseEntity postCode(@RequestBody Code code){
        code.setDate();
        code.setId(UUID.randomUUID().toString());
        code.setTimeRestrict();
        code.setViewsRestrict();
        code.setOriginalTime();
        codeService.save(code);

        return new ResponseEntity("{ \"id\" : \""+ code.getId() + "\" }", HttpStatus.OK);
    }

    @GetMapping(value = "/code/new", produces = "text/html")
    public ModelAndView getNewCode(HttpServletResponse response){
        response.addHeader("Content-Type", "text/html");

        ModelAndView model = new ModelAndView();
        model.setViewName("newcode");
        return model;
    }

    @GetMapping(value = "/api/code/latest", produces = "application/json")
    @ResponseBody
    public List<Code> getLatestJson(){
        List<Code> latestCodes = codeService.getLatestCodes();
        return latestCodes;
    }

    @GetMapping(value = "/code/latest", produces = "text/html")
    public String getLatestHtml(Model model){
        List<Code> codeslist = codeService.getLatestCodes();
        model.addAttribute("codeslist", codeslist);
        return "latestCodes";
    }

}
