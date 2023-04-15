import com.kodlama.io.starbucks.business.abstracts.CustomerService;
import com.kodlama.io.starbucks.business.dto.requests.CreateCustomerRequest;
import com.kodlama.io.starbucks.business.dto.responses.create.CreateCustomerResponse;
import com.kodlama.io.starbucks.business.dto.responses.get.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return service.getAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request) throws Exception {
        return service.add(request);
    }



}