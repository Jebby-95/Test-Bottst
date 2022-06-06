package sisal.accademy.books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sisal.accademy.books.Reparto;

public interface RepartoRepository extends CrudRepository<Reparto,Integer> {

	
	List<Reparto> findByAziendaId(int azienda_id);
	
	
}
