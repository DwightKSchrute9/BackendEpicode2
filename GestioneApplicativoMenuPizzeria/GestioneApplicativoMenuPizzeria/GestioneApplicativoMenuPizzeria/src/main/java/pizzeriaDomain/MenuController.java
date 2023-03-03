package pizzeriaDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import repository.MenuRepository;

@Controller
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public Iterable<Menu> findAll() {
        return menuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Menu findById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Menu not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Menu create(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @PutMapping("/{id}")
    public Menu update(@PathVariable Long id, @RequestBody Menu menu) {
        if (!menuRepository.existsById(id)) {
            throw new NotFoundException("Menu not found");
        }
        menu.setId(id);
        return menuRepository.save(menu);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!menuRepository.existsById(id)) {
            throw new NotFoundException("Menu not found");
        }
        menuRepository.deleteById(id);
    }

}
