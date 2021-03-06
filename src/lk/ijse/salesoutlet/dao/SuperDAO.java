/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.dao;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.SuperDTO;

/**
 *
 * @author user
 */
public interface SuperDAO<T extends SuperDTO> {

    public boolean add(T dto) throws Exception;

    public T search(T dto) throws Exception;

    public boolean update(T dto) throws Exception;

    public boolean delete(T dto) throws Exception;

    public ArrayList<T> getAll() throws Exception;
}
