package Fashion.DAO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Fashion.DAO.SupplierDAO;
import Fashion.Model.Supplier;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	HibernateTemplate hTemplate;
	
	public boolean addSupplier(Supplier supplier) {
		try {
			hTemplate.save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSupplier(int supplierId) {
		try {
			Supplier sup = hTemplate.load(Supplier.class, supplierId);
			hTemplate.delete(sup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			hTemplate.update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Supplier> listSupplier() {

		List<Supplier> list = hTemplate.loadAll(Supplier.class);
		return list;
	}

	public Supplier getSupplier(int supplierId) {

		Supplier sup = hTemplate.get(Supplier.class, supplierId);
		return sup;
	}

}