    package com.dan.green_energy.controller;

    import com.dan.green_energy.exceptions.BaluException;
    import com.dan.green_energy.model.dto.MainTypeDTO;
    import com.dan.green_energy.service.MainTypeService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/main-type")
    public class MainTypeController {
        private final MainTypeService mainTypeService;
        @Autowired
        public MainTypeController(MainTypeService mainTypeService) {
            this.mainTypeService=mainTypeService;
        }

        @GetMapping
        public List<MainTypeDTO> getAllMainType(){
            return mainTypeService.getAllMainTypes();
        }
        @PostMapping
        public ResponseEntity.BodyBuilder createMainType(@RequestBody MainTypeDTO mainTypeDTO) {
            try {
                MainTypeDTO createMainType = mainTypeService.createMainType(mainTypeDTO);
            } catch (BaluException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.status(HttpStatus.CREATED);

        }
        @PutMapping("/{id}")
        public ResponseEntity<MainTypeDTO> updateMainType(@PathVariable Integer id,@RequestBody MainTypeDTO mainTypeDTO){
            MainTypeDTO updateMainType=mainTypeService.updateMainType(id,mainTypeDTO);
            return ResponseEntity.ok(updateMainType);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMainType(@PathVariable Integer id){
            mainTypeService.deleteMainType(id);
            return ResponseEntity.noContent().build();
        }


    }
