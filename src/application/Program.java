package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println("=================================");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("================================= 2 ");
		list = sellerDao.findAll();
		for(Seller obj : list) {
		}
		System.out.println("================================= 4 ");
		Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller + " " + newSeller.getId());
		
		System.out.println("================================= 5 ");
		seller = sellerDao.findById(1);
		seller.setName("Marth waine");
		sellerDao.update(seller);
		System.out.println("update");
	}

}
