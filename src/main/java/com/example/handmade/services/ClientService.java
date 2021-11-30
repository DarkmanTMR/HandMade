//package com.example.handmade.services;
//
//
//import com.example.handmade.dao.ClientDAO;
//import com.example.handmade.helpers.ClientHelper;
//import com.example.handmade.models.Client;
//import com.example.handmade.models.Order;
//import com.example.handmade.models.WishList;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Service
//@Transactional
//public abstract class ClientService implements ClientDAO {
//
//    private ClientDAO clientDAO;
//    private ClientHelper clientHelper;
//
//    @Override
//    @Transactional
//    public Client saveClient(@RequestBody Client client) {
//        return clientDAO.save(client);
//    }
//    public Client getClient(@PathVariable int id) {
//        return clientDAO.findById(id).orElse(new Client("John", "Doe"));
//    }
//
//    @Override
//    @Transactional
//    public List<Client> allClients(HttpServletRequest httpServletRequest) {
//        String authenticationHeader = httpServletRequest.getHeader("Authentication");
//        String bearer = authenticationHeader.replace("Bearer ", "");
//        if (clientDAO.existsClientByLoginToken(bearer)){
//            return clientDAO.findAll();
//        }
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public Client editClient(@RequestBody Client clientFromRequest) {
//        Client clientFromDB = clientDAO.getById(clientFromRequest.getId());
//        return clientDAO.save(clientFromDB);
//    }
//
//    @Override
//    @Transactional
//    public void deleteClient(@PathVariable int id) {
//        clientDAO.deleteById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Order> getClientsOrders(@PathVariable int id) {
//        return clientDAO.findById(id).get().getOrders();
//    }
//
//    @Override
//    @Transactional
//    public WishList getClientsWishList(@PathVariable int id) {
//        return clientDAO.findById(id).get().getWishlist();
//    }
//
//    @Override
//    @Transactional
//    public void activate(@PathVariable String token) {
//        Client client = clientDAO.findByActivationToken(token);
//        if (!client.isActivated()) {
//            client.setActivated(true);
//            clientDAO.save(client);
//        }
//    }
//
//    @Override
//    @Transactional
//    public ResponseEntity<String> login(@RequestBody Client requestClient) {
//        Client client = clientDAO.findByNameAndPassword(requestClient.getName(), requestClient.getPassword());
//        String bubuToken = clientHelper.tokenizer(client, "bubu");
//        client.setLoginToken(bubuToken);
//        clientDAO.save(client);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("token", bubuToken);
//        ResponseEntity<String> responseEntity = new ResponseEntity<>("login in fine", httpHeaders, HttpStatus.OK);
//        return responseEntity;
//    }
//
//
//
//
//}
