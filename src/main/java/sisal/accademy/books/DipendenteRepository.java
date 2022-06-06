package sisal.accademy.books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DipendenteRepository extends CrudRepository<Dipendente,Integer> {

	List<Dipendente> findAllByRepartoId(int repartoID);

	
}
