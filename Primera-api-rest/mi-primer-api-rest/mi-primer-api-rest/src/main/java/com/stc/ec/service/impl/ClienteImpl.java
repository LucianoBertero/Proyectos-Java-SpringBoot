package com.stc.ec.service.impl;
import com.stc.ec.model.dao.ClienteDao;
import com.stc.ec.model.entity.Cliente;
import com.stc.ec.service.ICliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements ICliente {

    //el autowired es para no hacer la inyeccion de dependencias en el constructor
    @Autowired
    private ClienteDao clienteDao;

    //transtaccional hace que el metodo sea usado como transaccion
    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
     return   clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
        //sirve para mandar por si es nullo el id
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {

        clienteDao.delete(cliente);

    }
}
