package tn.camps.tuncamps.controller.ecomerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.camps.tuncamps.persistence.entity.ecomerce.Allocation;
import tn.camps.tuncamps.persistence.entity.ecomerce.Cart;

import tn.camps.tuncamps.persistence.entity.ecomerce.Product;
import tn.camps.tuncamps.service.ecomerce.AllocationServices;

import tn.camps.tuncamps.service.ecomerce.CartServices;
import tn.camps.tuncamps.service.ecomerce.ProductServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AllocationController {
    @Autowired
    private CartServices cs;
    @Autowired
    private ProductServices ps;
    @Autowired
    private AllocationServices as;

    @GetMapping(path = "/allocations")
    public @ResponseBody Iterable<Allocation> getAll() {
        return as.findAll();
    }

    @GetMapping(path = "/allocation/{id}")
    private String getItem(@PathVariable int id) {
        try {
            return as.findbyid(id).get().toString();

        } catch (Exception e) {
            // TODO: handle exception
            return e.toString();
        }

    }

    @PostMapping(path = "/allocation/{id}")
    public Allocation addAllocation(@RequestBody Allocation cart, @PathVariable int id) {
        if (cart != null) {

            Cart mycart = cs.findbyid(id).get();
            if (mycart == null) {
                return null;
            }

            Product p = cart.getProduct();
            if (p != null) {
                Product prod = ps.findbyid(p.getIdProduct()).get();
                cart.setPrice(prod.getPrice() * cart.getQuantity());
            }
            cart.setCart(mycart);
            return this.as.create(cart);
        }
        return null;

    }

    @PutMapping(path = { "/allocation" })
    private Cart updateAllocation(@RequestBody Cart Cart) {

        return this.cs.create(Cart);
    }

    @DeleteMapping(path = "/allocation/{id}")
    private boolean DeleteAllocation(@PathVariable int id) {
        return this.cs.Delete(id);

    }

}
