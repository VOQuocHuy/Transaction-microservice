package fr.dauphine.miageif.msa.exemple;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class TransactionController {
	

	    @Autowired
	    private TransactionRepository repository;


	    @GetMapping("transactions/history")
	    public List<Transaction> retrouveTousLesComptes() {

	        List<Transaction> transaction = repository.findAll();
	        return transaction;
	    }
	    
	    @RequestMapping(value="transactions/date/" , method=RequestMethod.GET)
	    public Transaction chercherpardate(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
	    	Transaction dateoper = repository.findByDate(date);
	        return dateoper;
	    }
	    
	    @GetMapping("/transactions/type/{type}")
	    public Transaction chercherpartype (@PathVariable String type) {
	    	Transaction typeoperation = repository.findByType(type);
	        return typeoperation;
	    }
	    
	    
	    @GetMapping("/source/{ibansour}/dest/{ibandest}")
	    public Transaction operationParIbanSourceAndDest (@PathVariable String ibansour, @PathVariable String ibandest) {
	    	Transaction transaction = repository.findByIbansourAndIbandest(ibansour, ibandest);
	        return transaction;
	    }  
	    
	    
	    @DeleteMapping("/transactions/delete/{id}")
	    public void supprimerTransaction(@PathVariable long id) {
	        repository.deleteById(id);
	    }
	    
	    @PostMapping("/transactions/new")
	    public ResponseEntity<Object> creerOperation(@RequestBody Transaction transaction) {
	    	Transaction newtransaction = repository.save(transaction);

	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(newtransaction.getId()).toUri();

	        return ResponseEntity.created(location).build();

	    }	    
	    
	    @PutMapping("/transactions/update/{id}")
	    public ResponseEntity<Object> majOperation(@RequestBody Transaction transaction, @PathVariable long id) {

	       Optional<Transaction> updatetrans = repository.findById(id);

	        if (!updatetrans.isPresent())
	            return ResponseEntity.notFound().build();

	        transaction.setId(id);

	        repository.save(transaction);

	        return ResponseEntity.noContent().build();
	    }	     
	   
	    @RequestMapping(value="/virement")
	    public static void faireUnVirement(@RequestParam("montant") Double montant,@RequestParam long idsour, @RequestParam long iddest){

	        final String uri = "http://localhost:8000/comptes/virement/"+idsour+"/"+iddest;

	        RestTemplate template = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
	        map.add("montant", montant.toString());
	        HttpEntity<MultiValueMap<String, String>> requestEntity= new HttpEntity<MultiValueMap<String, String>>(map, headers);

	        template.put(uri, requestEntity,  HashMap.class);

	    }


    


}
