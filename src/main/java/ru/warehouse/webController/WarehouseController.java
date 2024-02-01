package ru.warehouse.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.warehouse.logic.WorkingOnProducts;



@Controller
public class WarehouseController {

    @RequestMapping("/warehouse")
    public String showWarehouseForm(Model model) {
    	model.addAttribute("foundProducts", WorkingOnProducts.getList());
        return "warehouse";
    }

    @PostMapping("/searchWarehouse")
    public String searchWarehouse(Model model, String searchByName, String searchByType) {

         model.addAttribute("foundProducts", WorkingOnProducts.getSortList(searchByType));

    		        return "warehouse";
    }
}
