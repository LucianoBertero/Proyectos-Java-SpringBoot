package com.stc.ec.service;

import com.stc.ec.model.dto.ClienteDto;

public interface ICliente {
    ClienteDto save(ClienteDto clienteDto);
    ClienteDto findById(Integer id);
    void delete(ClienteDto clienteDto);
}
