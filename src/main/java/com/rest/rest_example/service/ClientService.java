package com.rest.rest_example.service;

import com.rest.rest_example.model.Client;

import java.util.List;

public interface ClientService {

    /** matrix CRUD

    /**
    * Create new client
    */
    void create(Client client);

    /**
     * return whole list of clients
     */
    List<Client> readAll();

    /**
     * return client by ID
     */
    Client read(int id);

    /**
     * update client with given ID
     * in accordance with the passed client
     */
    boolean update(Client client, int id);

    /**
     * delete client with given ID
     */
    boolean delete(int id);

}
