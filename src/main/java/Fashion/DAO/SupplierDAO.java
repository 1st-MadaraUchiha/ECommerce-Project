package Fashion.DAO;

import java.util.List;

import Fashion.Model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);
	public boolean updateSupplier(Supplier supplier);
	
	public List<Supplier> listSupplier();
	public Supplier getSupplier(int supplierId);
	
}
