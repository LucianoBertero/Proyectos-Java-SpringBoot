package com.stc.ec.service.impl;
import com.stc.ec.model.dao.ClienteDao;
import com.stc.ec.model.dto.ClienteDto;
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
    public ClienteDto save(ClienteDto clienteDto) {
     return   clienteDao.save(clienteDto);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteDto findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
        //sirve para mandar por si es nullo el id
    }

    @Transactional
    @Override
    public void delete(ClienteDto clienteDto) {

        clienteDao.delete(clienteDto);

    }
}
