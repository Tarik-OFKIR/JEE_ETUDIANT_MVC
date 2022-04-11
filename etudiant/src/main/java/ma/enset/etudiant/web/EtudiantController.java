package ma.enset.etudiant.web;

import lombok.AllArgsConstructor;
import javax.validation.Valid;
import ma.enset.etudiant.entites.Etudiant;
import ma.enset.etudiant.repositories.EtudaintRepossitory;
import ma.enset.etudiant.resourse.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudaintRepossitory etudaintRepossitory;

    @GetMapping(path = "/etudiant/index")
    public  String etudiants(Model model,
                             @RequestParam(name = "page",defaultValue = "0") int page,
                             @RequestParam(name = "size",defaultValue = "5") int size,
                             @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Etudiant> etudiantPage = etudaintRepossitory.findByNomeContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listEtudiant",etudiantPage.getContent());
        model.addAttribute("pages",new int[etudiantPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "etudiant";
    }

    @GetMapping("admin/delete")
    public String deletEtudiant(Model model, @RequestParam(name =  "id",defaultValue = "0")Long id,
                                @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "keyword",defaultValue = "")String keyword){
        return "redirect:/etudiant/index?page="+page+"&keyword="+keyword;
    }


    @GetMapping( "/")
    public String home(){return "home";}

    @GetMapping("/etudiant")
    @ResponseBody
    public List<Etudiant> Etudiant(){return  etudaintRepossitory.findAll();}

    @GetMapping(path="/admin/formEtudiant")
    public String formEtudiant(Model model) {

        Etudiant etudiant=new Etudiant(null,"test","test","test",new Date(), Genre.MASCULIN,false);
        model.addAttribute("etudiant",etudiant);
        //model.addAttribute("patient",p);

        return "formPatient";
    }


    @PostMapping(path="/amdin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keyword) {

        if(bindingResult.hasErrors()) {
            return "formEtudiant";
        }
        etudaintRepossitory.save(etudiant);

        return "redirect:/etudiant/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path="/admin/editEtudiant")
    public String editPatient(Model model,Long id,int page,String keyword) {
        Etudiant etudiant=etudaintRepossitory.findById(id).orElse(null);
        if(etudiant==null) {
            throw new RuntimeException("etudiant n'existe pas");
        }
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editEtudinat";
    }

}
