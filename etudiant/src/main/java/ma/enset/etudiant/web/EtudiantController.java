package ma.enset.etudiant.web;

import lombok.AllArgsConstructor;
import ma.enset.etudiant.entites.Etudiant;
import ma.enset.etudiant.repositories.EtudaintRepossitory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
