/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.controller;

import java.util.ArrayList;
import lk.ijse.salesoutlet.core.dto.ProductDTO;
import lk.ijse.salesoutlet.dao.DAOFactory;
import lk.ijse.salesoutlet.dao.custom.ProductDAO;

/**
 *
 * @author user
 */
public class ManageProductController {

    public static ProductDAO productDAO = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);

    public static boolean addProduct(ProductDTO product) throws Exception {
        boolean isAdded = productDAO.add(product);
        return isAdded;
    }

    public static ProductDTO searchProduct(ProductDTO product) throws Exception {
        ProductDTO productDTO = productDAO.search(product);
        return productDTO;
    }

    public static boolean deleteProduct(ProductDTO product) throws Exception {
        boolean isDeleted = productDAO.delete(product);
        return isDeleted;
    }

    public static boolean updateProduct(ProductDTO product) throws Exception {
        boolean isUpdated = productDAO.update(product);
        return isUpdated;
    }

    public static ArrayList<ProductDTO> getAllProducts() throws Exception {
        return productDAO.getAll();
    }

    public static String getCurrentProductCode() throws Exception {

        String productCode = null;
        ArrayList<ProductDTO> getAllProducts = productDAO.getAll();
        for (ProductDTO product : getAllProducts) {
            productCode = product.getCode();
        }

        int number = Integer.parseInt(productCode.substring(1));
        productCode = "P" + (number + 1);
        return productCode;

    }
}
