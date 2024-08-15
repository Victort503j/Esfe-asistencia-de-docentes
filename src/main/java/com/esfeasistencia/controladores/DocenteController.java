package com.esfeasistencia.controladores;

import com.esfeasistencia.modelos.Docente;
import com.esfeasistencia.modelos.Grupo;
import com.esfeasistencia.servicios.interfaces.IDocenteService;
import com.esfeasistencia.servicios.interfaces.IGrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
    @Autowired
    private IDocenteService docenteService;
    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("id").descending());

        Page<Docente> docentes = docenteService.buscarTodosPaginados(pageable);
        model.addAttribute("docentes", docentes);

        int totalPage = docentes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);
        }
        return "docente/index";
    }
    @GetMapping("/create")
    public String create(Docente pDocente){
        return "docente/create";
    }
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute("docente") Docente pDocente, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("docente", pDocente);
            return "/docente/create";
        }


        if (pDocente.getId() != null && pDocente.getId() > 0) {
            docenteService.crearOEditar(pDocente);
            attributes.addFlashAttribute("msg", "Docente actualizado exitosamente");
        } else {
            docenteService.crearOEditar(pDocente);
            attributes.addFlashAttribute("msg", "Docente creado exitosamente");
        }

        return "redirect:/docentes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Docente docente = docenteService.buscarPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/details";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Docente docente = docenteService.buscarPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/edit";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Docente docente = docenteService.buscarPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/delete";
    }
    @PostMapping("/delete")
    public String delete(Docente docente, RedirectAttributes attributes){
        docenteService.elimanarPorId(docente.getId());
        attributes.addFlashAttribute("msg", "Docente eliminado exitosamente");
        return "redirect:/docentes";
    }

}
