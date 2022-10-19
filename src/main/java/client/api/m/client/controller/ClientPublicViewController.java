package client.api.m.client.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import client.api.m.client.entity.ClientPublicViewEntity;
import client.api.m.client.service.ClientPublicViewService;

@RestController
@RequestMapping("api/m/clientpublic/")
public class ClientPublicViewController {

	public static final Logger logger = LoggerFactory.getLogger(ClientPublicViewController.class);
	
	@Inject
	private ClientPublicViewService clientPublicViewService;
	
	@RequestMapping(value = "/findByClientNumber", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<ClientPublicViewEntity> findByClientNumber(@RequestParam("clientNumber") String clientNumber) {
    	return clientPublicViewService.findByClientNumber(clientNumber);    	
    }
	
	@GetMapping("/findAllNonIndividuals")
	public ResponseEntity<Page<ClientPublicViewEntity>> findByNumber(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "CLIENT_NUMBER") String sortBy) {
		try {
			Page<ClientPublicViewEntity> clientData = clientPublicViewService.findAllNonIndividualClients(pageNo, pageSize, sortBy);

			return new ResponseEntity<Page<ClientPublicViewEntity>>(clientData, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
